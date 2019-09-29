package com.excel.demo;

import com.excel.demo.excel.ExcelParseResult;
import com.excel.demo.excel.SheetInfo;
import com.excel.demo.excel.TableInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelCollectionParams;
import org.jeecgframework.poi.excel.entity.params.ExcelImportEntity;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.jeecgframework.poi.excel.entity.result.ExcelVerifyHanlderResult;
import org.jeecgframework.poi.excel.imports.CellValueServer;
import org.jeecgframework.poi.excel.imports.ExcelImportServer;
import org.jeecgframework.poi.excel.imports.base.ImportBaseService;
import org.jeecgframework.poi.excel.imports.verifys.VerifyHandlerServer;
import org.jeecgframework.poi.exception.excel.ExcelImportException;
import org.jeecgframework.poi.exception.excel.enums.ExcelImportEnum;
import org.jeecgframework.poi.util.ExcelUtil;
import org.jeecgframework.poi.util.PoiPublicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2515:13
 */
public class PmanageExcelImportServer extends ImportBaseService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExcelImportServer.class);

    private CellValueServer cellValueServer;

    private VerifyHandlerServer verifyHandlerServer;

    private boolean verfiyFail = false;


    /**
     * 异常数据styler
     */
    private CellStyle errorCellStyle;

    public PmanageExcelImportServer() {
        this.cellValueServer = new CellValueServer();
        this.verifyHandlerServer = new VerifyHandlerServer();
    }

    /***
     * 向List里面继续添加元素
     *
     * @param object
     * @param param
     * @param row
     * @param titlemap
     * @param targetId
     * @param params
     */
    private void addListContinue(Object object, ExcelCollectionParams param, Row row, Map<Integer, String> titlemap, String targetId, TableInfo params) throws Exception {
        Collection collection = (Collection) PoiPublicUtil.getMethod(param.getName(), object.getClass()).invoke(object, new Object[]{});
        Object entity = PoiPublicUtil.createObject(param.getType(), targetId);
        boolean isUsed = false;// 是否需要加上这个对象
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            String titleString = (String) titlemap.get(i);
            if (param.getExcelParams().containsKey(titleString)) {
                //排除图片
                if (param.getExcelParams().get(titleString).getType() == 2) {
//                    picId = row.getRowNum() + "_" + i;
//                    saveImage(object, picId, param.getExcelParams(), titleString, pictures, params);
                } else {
                    saveFieldValue(params, entity, cell, param.getExcelParams(), titleString, row);
                }
                isUsed = true;
            }
        }
        if (isUsed) {
            collection.add(entity);
        }
    }

    /**
     * 获取key的值,针对不同类型获取不同的值
     *
     * @param cell
     * @return
     * @Author JEECG
     * @date 2013-11-21
     */
    private String getKeyValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                obj = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                obj = cell.getCellFormula();
                break;
        }
        return obj == null ? null : obj.toString().trim();
    }

    /**
     * 获取保存的真实路径
     *
     * @param excelImportEntity
     * @param object
     * @return
     * @throws Exception
     */
    private String getSaveUrl(ExcelImportEntity excelImportEntity, Object object) throws Exception {
        String url = "";
        if (excelImportEntity.getSaveUrl().equals("upload")) {
            if (excelImportEntity.getMethods() != null && excelImportEntity.getMethods().size() > 0) {
                object = getFieldBySomeMethod(excelImportEntity.getMethods(), object);
            }
            url = object.getClass().getName().split("\\.")[object.getClass().getName().split("\\.").length - 1];
            return excelImportEntity.getSaveUrl() + "/" + url.substring(0, url.lastIndexOf("Entity"));
        }
        return excelImportEntity.getSaveUrl();
    }

    private Map<String, Object> importExcel(Workbook book, SheetInfo sheetInfo) throws Exception {
        //获取sheet页
        Sheet sheet = book.getSheetAt(sheetInfo.getNum());
        //存放最终返回数据
        Map<String, Object> resultMap = new LinkedHashMap<>();

        Map<String, Object> currentOpConditionResult = null;
        //递归处理数据 handel
        currentOpConditionResult = handleRow(sheet, sheetInfo.getTableMap());
        resultMap.put(sheetInfo.getName(), currentOpConditionResult);

        return resultMap;
    }

    private Map<String, Object> handleRow(Sheet sheet, LinkedHashMap<String, TableInfo> tableMap) throws Exception {
        //未处理的表集合
        LinkedHashMap wait = new LinkedHashMap();
        TableInfo tb = null;
        for (String key : tableMap.keySet()) {
            tb = tableMap.get(key);
            wait.put(tb.getCName(), tb.getName());
        }
        //存放最终sheet 结果集
        Map<String, Object> sheetMap = new LinkedHashMap<>();
        List collection = new ArrayList();
        //导入
        Map<String, ExcelImportEntity> excelParams = new HashMap<String, ExcelImportEntity>();
        //table  结果集
        List<ExcelCollectionParams> excelCollection = new ArrayList<ExcelCollectionParams>();
        for (String key : tableMap.keySet()) {
            TableInfo tableInfo = tableMap.get(key);
            String className = tableInfo.getPackageName() + "." + key;
            Class<?> pojoClass = Class.forName(className);
            String targetId = null;
            if (!Map.class.equals(pojoClass)) {
                Field fileds[] = PoiPublicUtil.getClassFields(pojoClass);
                ExcelTarget etarget = pojoClass.getAnnotation(ExcelTarget.class);
                if (etarget != null) {
                    targetId = etarget.value();
                }
                getAllExcelField(targetId, fileds, excelParams, excelCollection, pojoClass, null);
            }
            Iterator<Row> rows = sheet.rowIterator();
            Map<Integer, String> titlemap = getTitleMap(sheet, rows, tableInfo);
            Row row = null;
            //跳过表头和标题行
            for (int j = 0; j < tableInfo.getTitleRows() + tableInfo.getHeadRows(); j++) {
                row = rows.next();
            }
            Object object;
            boolean rowBreak = false;
            while (!rowBreak && rows.hasNext() && (row == null || sheet.getLastRowNum() - row.getRowNum() > tableInfo.getLastOfInvalidRow())) {
                row = rows.next();
                object = PoiPublicUtil.createObject(pojoClass, targetId);
                try {
                    for (int i = row.getFirstCellNum(), le = row.getLastCellNum(); i < le; i++) {
                        Cell cell = row.getCell(i);
                        //单个表结束
                        String str = cell.getStringCellValue();
                        if (!"".equals(str) && null != str && wait.containsKey(str.replaceAll("\\pP", ""))) {
                            rowBreak = true;
                            break;
                        }
                        String titleString = (String) titlemap.get(i);
                        if (excelParams.containsKey(titleString) || Map.class.equals(pojoClass)) {
                            //图片
                            if (excelParams.get(titleString) != null && excelParams.get(titleString).getType() == 2) {
                            } else {
                                saveFieldValue(tableInfo, object, cell, excelParams, titleString, row);
                            }
                        }
                    }

                    for (ExcelCollectionParams param : excelCollection) {
                        addListContinue(object, param, row, titlemap, targetId, tableInfo);
                    }
                    if (object != null) {
                        collection.add(object);
                    }
                } catch (ExcelImportException e) {
                    if (!e.getType().equals(ExcelImportEnum.VERIFY_ERROR)) {
                        throw new ExcelImportException(e.getType(), e);
                    }
                }
            }
            sheetMap.put(key, collection);
        }

        return sheetMap;
    }

    /**
     * 获取表格字段列名对应信息
     *
     * @param rows
     * @param tableInfo
     * @return
     */
    private Map<Integer, String> getTitleMap(Sheet sheet, Iterator<Row> rows, TableInfo tableInfo) {
        Map<Integer, String> titlemap = new HashMap<Integer, String>();
        Iterator<Cell> cellTitle = null;
        String collectionName = null;
        ExcelCollectionParams collectionParams = null;
        Row headRow = null;
        int headBegin = tableInfo.getTitleRows();
        //找到首行表头，每个sheet都必须至少有一行表头
        while (headRow == null) {
            headRow = sheet.getRow(headBegin++);
        }
        //设置表头行数
        if (ExcelUtil.isMergedRegion(sheet, headRow.getRowNum(), 0)) {
            tableInfo.setHeadRows(2);
        } else {
            tableInfo.setHeadRows(1);
        }
        cellTitle = headRow.cellIterator();
        while (cellTitle.hasNext()) {
            Cell cell = cellTitle.next();
            String value = getKeyValue(cell);
            if (StringUtils.isNotEmpty(value)) {
                titlemap.put(cell.getColumnIndex(), value);//加入表头列表
            }
        }

        //多行表头
        for (int j = headBegin; j < headBegin + tableInfo.getHeadRows() - 1; j++) {
            headRow = sheet.getRow(j);
            cellTitle = headRow.cellIterator();
            while (cellTitle.hasNext()) {
                Cell cell = cellTitle.next();
                String value = getKeyValue(cell);
                if (StringUtils.isNotEmpty(value)) {
                    int columnIndex = cell.getColumnIndex();
                    //当前cell的上一行是否为合并单元格
                    if (ExcelUtil.isMergedRegion(sheet, cell.getRowIndex() - 1, columnIndex)) {
                        collectionName = ExcelUtil.getMergedRegionValue(sheet, cell.getRowIndex() - 1, columnIndex);
                        titlemap.put(cell.getColumnIndex(), collectionName + "_" + value);
                    } else {
                        titlemap.put(cell.getColumnIndex(), value);
                    }
					/*int i = cell.getColumnIndex();
					// 用以支持重名导入
					if (titlemap.containsKey(i)) {
						collectionName = titlemap.get(i);
						collectionParams = getCollectionParams(excelCollection, collectionName);
						titlemap.put(i, collectionName + "_" + value);
					} else if (StringUtils.isNotEmpty(collectionName) && collectionParams.getExcelParams().containsKey(collectionName + "_" + value)) {
						titlemap.put(i, collectionName + "_" + value);
					} else {
						collectionName = null;
						collectionParams = null;
					}
					if (StringUtils.isEmpty(collectionName)) {
						titlemap.put(i, value);
					}*/
                }
            }
        }
        return titlemap;
    }
    //update-end--Author:xuelin  Date:20171205 for：TASK #2098 【excel问题】 Online 一对多导入失败--------------------

    /**
     * 获取这个名称对应的集合信息
     *
     * @param excelCollection
     * @param collectionName
     * @return
     */
    private ExcelCollectionParams getCollectionParams(List<ExcelCollectionParams> excelCollection, String collectionName) {
        for (ExcelCollectionParams excelCollectionParams : excelCollection) {
            if (collectionName.equals(excelCollectionParams.getExcelName())) {
                return excelCollectionParams;
            }
        }
        return null;
    }

    /**
     * Excel 导入 field 字段类型 Integer,Long,Double,Date,String,Boolean
     *
     * @param inputstream
     * @return
     * @throws Exception
     */
    public ExcelParseResult importExcelByIs(InputStream inputstream, LinkedHashMap dataInfo) throws Exception {
        Map result = new HashMap<>();
        Workbook book = null;
        boolean isXSSFWorkbook = true;
        if (!(inputstream.markSupported())) {
            inputstream = new PushbackInputStream(inputstream, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(inputstream)) {
            book = new HSSFWorkbook(inputstream);
            isXSSFWorkbook = false;
        } else if (POIXMLDocument.hasOOXMLHeader(inputstream)) {
            book = new XSSFWorkbook(OPCPackage.open(inputstream));
        }
        createErrorCellStyle(book);
        Map<String, PictureData> pictures;
//        for (int i = 0; i < params.getSheetNum(); i++) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(" start to read excel by is ,startTime is {}", new Date().getTime());
        }
        if (isXSSFWorkbook) {
            pictures = PoiPublicUtil.getSheetPictrues07((XSSFSheet) book.getSheetAt(1), (XSSFWorkbook) book);
        } else {
            pictures = PoiPublicUtil.getSheetPictrues03((HSSFSheet) book.getSheetAt(1), (HSSFWorkbook) book);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(" end to read excel by is ,endTime is {}", new Date().getTime());
        }
        //处理总公司经营月报总表
        SheetInfo companyOpMonthTotal = (SheetInfo) dataInfo.get("companyOpMonthTotal");
        result.putAll(importExcel(book, companyOpMonthTotal));
//        importExcel(book.getSheetAt(companyOpMonthTotal.getNum()), dataInfo);
//        result.addAll();
//        result.addAll(importExcel(result, book.getSheetAt(1), titleMap, params, pictures));
        //处理分公司经营月报总表-分产品
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(" end to read excel list by pos ,endTime is {}", new Date().getTime());
        }
//        }
//        if (params.isNeedSave()) {
//            saveThisExcel(params, pojoClass, isXSSFWorkbook, book);
//        }
        return new ExcelParseResult(result, verfiyFail, book);
    }

    /**
     * 保存字段值(获取值,校验值,追加错误信息)
     *
     * @param params
     * @param object
     * @param cell
     * @param excelParams
     * @param titleString
     * @param row
     * @throws Exception
     */
    private void saveFieldValue(TableInfo params, Object object, Cell cell, Map<String, ExcelImportEntity> excelParams, String titleString, Row row) throws Exception {
        Object value = cellValueServer.getValue(params.getDataHanlder(), object, cell, excelParams, titleString);
        if (object instanceof Map) {
            if (params.getDataHanlder() != null) {
                params.getDataHanlder().setMapValue((Map) object, titleString, value);
            } else {
                ((Map) object).put(titleString, value);
            }
        } else {
            ExcelVerifyHanlderResult verifyResult = verifyHandlerServer.verifyData(object, value, titleString, excelParams.get(titleString).getVerify(), params.getVerifyHanlder());
            if (verifyResult.isSuccess()) {
                setValues(excelParams.get(titleString), object, value);
            } else {
                Cell errorCell = row.createCell(row.getLastCellNum());
                errorCell.setCellValue(verifyResult.getMsg());
                errorCell.setCellStyle(errorCellStyle);
                verfiyFail = true;
                throw new ExcelImportException(ExcelImportEnum.VERIFY_ERROR);
            }
        }
    }

    /**
     * @param object
     * @param picId
     * @param excelParams
     * @param titleString
     * @param pictures
     * @param params
     * @throws Exception
     */
    private void saveImage(Object object, String picId, Map<String, ExcelImportEntity> excelParams, String titleString, Map<String, PictureData> pictures, ImportParams params) throws Exception {
        if (pictures == null) {
            return;
        }
        PictureData image = pictures.get(picId);
        byte[] data = image.getData();
        String fileName = "pic" + Math.round(Math.random() * 100000000000L);
        fileName += "." + PoiPublicUtil.getFileExtendName(data);
        if (excelParams.get(titleString).getSaveType() == 1) {
            String path = PoiPublicUtil.getWebRootPath(getSaveUrl(excelParams.get(titleString), object));
            File savefile = new File(path);
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            savefile = new File(path + "/" + fileName);
            FileOutputStream fos = new FileOutputStream(savefile);
            fos.write(data);
            fos.close();
            setValues(excelParams.get(titleString), object, getSaveUrl(excelParams.get(titleString), object) + "/" + fileName);
        } else {
            setValues(excelParams.get(titleString), object, data);
        }
    }

    private void createErrorCellStyle(Workbook workbook) {
        errorCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        errorCellStyle.setFont(font);
    }

}

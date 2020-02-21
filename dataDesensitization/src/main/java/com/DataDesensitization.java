package com;

import com.bom.Apply;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
//@Slf4j
public class DataDesensitization {
    public static final String PASS = "核保通过";
    public static final String FAIL = "核保不通过";
    public static final String TOMANUL = "转人工";

    public  static  final Map<String,String> fileMap = new LinkedHashMap<>(13);
    static  {
//        fileMap.put("D:\\data\\04广东.xlsx","D:\\data\\04" + ".xls");
        fileMap.put("D:\\data\\08浙江.xlsx","D:\\data\\08" + ".xls");
        fileMap.put("D:\\data\\09山东.xlsx","D:\\data\\09" + ".xls");
        fileMap.put("D:\\data\\11辽宁.xlsx","D:\\data\\11" + ".xls");
        fileMap.put("D:\\data\\15云南.xlsx","D:\\data\\15" + ".xls");
        fileMap.put("D:\\data\\20天津.xlsx","D:\\data\\20" + ".xls");
        fileMap.put("D:\\data\\21青岛.xlsx","D:\\data\\21" + ".xls");
        fileMap.put("D:\\data\\24江西.xlsx","D:\\data\\24" + ".xls");
        fileMap.put("D:\\data\\25广西.xlsx","D:\\data\\25" + ".xls");
        fileMap.put("D:\\data\\29青海.xlsx","D:\\data\\29" + ".xls");
        fileMap.put("D:\\data\\30海南.xlsx","D:\\data\\30" + ".xls");
        fileMap.put("D:\\data\\33贵州.xlsx","D:\\data\\33" + ".xls");
        fileMap.put("D:\\data\\35吉林.xlsx","D:\\data\\35" + ".xls");
    }
    /**
     * 数据脱敏
     */
    public static void main(String args[]) throws Exception {
        int index = 1;
        for (String key : fileMap.keySet()) {
            List<Data> results = getResultList(key);
            test2(index++, results,fileMap.get(key));
        }

    }

    public static void test2(int count, List<Data> results,String outFile) throws Exception {
        try {
            List<Apply> insertList = new ArrayList<>(results.size());
            for (int i = 0; i < results.size(); i++) {
                Data result = results.get(i);
                String request = result.getRequest().replace("<ruleRequestData>", " ");
                request = request.replace("<data>", " ");
                request = request.replace("</data>", " ");
                request = request.replace("<rulesetCode>car</rulesetCode>", " ");
                request = request.replace("</ruleRequestData>", " ");
                JAXBContext context = JAXBContext.newInstance(Apply.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Apply bom = (Apply) unmarshaller.unmarshal(new StringReader(
                        request));
                //数据脱敏
                //投保联系人
                if (bom.getAppApplicant() != null && bom.getAppApplicant().getcAppNme() != null) {
                    bom.getAppApplicant().setcAppNme(
                            String.valueOf(bom.getAppApplicant().getcAppNme().hashCode()));
                }
                //店长名称
                if (bom.getAppBase() != null && bom.getAppBase().getSupervisorName() != null) {
                    bom.getAppBase().setSupervisorName(
                            String.valueOf(bom.getAppBase().getSupervisorName().hashCode()));
                }
                //被保险人
                if (bom.getAppInsured() != null && bom.getAppInsured().getcInsureDnme() != null) {
                    bom.getAppInsured().setcInsureDnme(
                            String.valueOf(bom.getAppInsured().getcInsureDnme().hashCode()));
                }
                //受益人
                if (bom.getAppInsured() != null && bom.getAppInsured().getBnefName() != null) {
                    bom.getAppInsured().setBnefName(
                            String.valueOf(bom.getAppInsured().getBnefName().hashCode()));
                }
                //车牌号
                if (bom.getAppVhl() != null && bom.getAppVhl().getcPlateNo() != null) {
                    bom.getAppVhl().setcPlateNo(
                            String.valueOf(bom.getAppVhl().getcPlateNo().hashCode()));
                }
                //行驶证车主
                if (bom.getAppVhlowner() != null && bom.getAppVhlowner().getcOwnerNme() != null) {
                    bom.getAppVhlowner().setcOwnerNme(
                            String.valueOf(bom.getAppVhlowner().getcOwnerNme().hashCode()));
                }
                //将java对象转换为json对象
//                JSONObject json = JSONObject.fromObject(bom);
//                Data desensitizationData = new Data();
//                desensitizationData.setRequest(json.toString()));
                String judgeResult = result.getResult();
                if (judgeResult.contains(PASS)) {
                    bom.setResult(PASS);
                } else if (judgeResult.contains(FAIL)) {
                    bom.setResult(FAIL);
                } else if (judgeResult.contains(TOMANUL)) {
                    bom.setResult(TOMANUL);
                } else {
                    bom.setResult(judgeResult);
                }
                System.out.println("第" +count + "个文件,第" + i + "条数据");
                insertList.add(bom);
//                writeExcel(bom,outFile);
            }
            writeExcel(insertList,outFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 向Excel中写数据
     */
    public static void writeExcel(List<Apply> insertList, String filePath) throws Exception {
        //判断文件是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            createExcel(filePath);
        }
        //获取d://test.xls,建立数据的输入通道
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //使用POI提供的方法得到excel的信息
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fileInputStream);
        //得到文档对象
        HSSFWorkbook Workbook = new HSSFWorkbook(poifsFileSystem);
        //根据name获取sheet表
        HSSFSheet sheet = Workbook.getSheetAt(0);
        //获取第一行
        HSSFRow row = sheet.getRow(0);
        if (row.getRowNum() == 0) {
            row = sheet.createRow(0);
            Apply data = new Apply();
            Field[] fields = data.getClass().getDeclaredFields();
            //获取所有属性
            List allFieldList = getBomFields1(new ArrayList(), fields);
//            row.createCell(0).setCellValue("Result");
            for (int i = 0; i <allFieldList.size(); i++) {
                List<Field> list = (List) allFieldList.get(i);
                Field field;
                if (list.size() > 1) {
                    field = list.get(list.size() - 1);
                } else {
                    field = list.get(0);
                }
                String name = field.getName();
                String type = field.getType().toString();
                if (type.contains("class")) {
                    type = type.substring(type.lastIndexOf(".") + 1);
                }
                String attr = field.getDeclaringClass().getName();
                attr = attr.substring(attr.lastIndexOf(".") + 1);
                String temp = type + "_" + attr + "_" + name;
                row.createCell(i).setCellValue(temp);
            }
            //json设置
//            Set<String> set = new HashSet<String>();
//            jsonObjParseRecur(set, data.getRequest()));
//            row.createCell(0).setCellValue("request");
//            row.createCell(1).setCellValue("result");
        }
        for (Apply data: insertList) {
            // 追加开始行
            HSSFRow startRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));
            //分别得到最后一行的行号，和一条记录的最后一个单元格
            System.out.println(sheet.getLastRowNum() + " " + row.getLastCellNum());
            setValue(data, startRow);
        }
        //向d://test.xls中写数据
        FileOutputStream out = new FileOutputStream(filePath);
        out.flush();
        Workbook.write(out);
        out.close();
    }

    public static String value(Object object) {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        if(object instanceof java.util.Date && object!=null){
            return sdf.format(object);
        }
        return object == null ? null : object.toString();
    }

    private static void setValue(Apply apply, HSSFRow startRow) {
        int i = 0;
        startRow.createCell(i++).setCellValue(value(apply.getResult()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcAppNme()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcAppContacts()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcStkMrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcClntMrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcCertfCls()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getcCertfNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getComerSex()));
        startRow.createCell(i++).setCellValue(value(apply.getAppApplicant().getComerDate()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getBranCompany()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getThirdDpt()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getDetailDpt()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getFeeRiskCode()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getChannelType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCooperateBsnsTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getHaveCarDameType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getDameTimes()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getPreTaxTotalDiscount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getAfterTaxTotalDiscount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getExceptionTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getThreeOfNamt()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getBasePrmNoTax()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettOprName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getVip()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCWeRisk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcAppNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcBrkrCde()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcBsnsTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcDptCDE()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getWeChatDept()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getRenewalFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcProdNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcRatioTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCircleFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getnRatioCoef()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettInsrncBgnTm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettInsrncEndTm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettOprTm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getFixSpec()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getTaskType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcBrkrName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getTotalNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettInsrncDay()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getArgueDel()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().gettSignDate()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcNewBsnsTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getnCommProp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getAppType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getEndrFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getPremiumVar()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getEndrReason()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getDataSystem()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getSupervisorCode()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getSupervisorName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getSupervisorCDNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getFalseCountFlagS()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsDiscountCut()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsFyEng()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsFyFrm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsOnlyTaxChange()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsOnlyPlateNoChange()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getOldCEngNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getOldCFrmNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getAttachCount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getIsBlacklist()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getSubmitUdwrTime()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcRecordCnm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getSpecCustomer()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCvrgComb()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getcBusType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getnBasePrm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCslsId()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getCslsName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppBase().getbCustPartner()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getTotalDiscount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getcAppDrv()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAppYear()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getClaimRecord()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAverageMile()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAbateCoef()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getTransgressCoef()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getInsNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAnClaimCoef()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getDriverAge()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getDriverSex()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getDrivedAge()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getDriveArea()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getRiskInsPre()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getLastcompTimes()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getCterLoyalty()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getRecDiscount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getCostDiscount()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getChannelAdjust()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAutoUdrAdjust()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getcAbateProp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getAutoRepairFactor()));
        startRow.createCell(i++).setCellValue(value(apply.getAppCvrgPrmCoef().getnSafeDev()));


        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getcInsureDnme()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getcClnTmrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getcCertFcls()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getcCertfNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getcStkMrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getInsuSex()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getInsuDate()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getBnefName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getBnefTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getBnefNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getBnefSex()));
        startRow.createCell(i++).setCellValue(value(apply.getAppInsured().getBnefDate()));


        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFamilyTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getVchLicence()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcBrand()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcBrandId()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcVehicleId()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcVehicleName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcModelCode()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFamilyName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFamilyCde()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcEcdemicMrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFrmNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFstRegYm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcMfgYear()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcNewMrk()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcPlateNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcVhlcategoryCde()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnVhlTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnDisplacement()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnNewPurchaseValue()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnPriceFloat()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnSeatNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getNpassengerNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getNton()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getTransferFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getBelongType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getPlateNoType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getCarChecked()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getnActualValue()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getvPurchaseValueJy()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getvVhlPrnName()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getCarAge()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcRiskCate()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getGlassType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getDomescImports()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getIsMort()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getDrvLiscneTyp()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getIsTeam()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getCarDameType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcPlatVhlId()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcPremiumFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getCheckFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getIsEnclosure()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcEngNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcProdPlace()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getVhlConsultValue()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().gettTransferDate()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getcFuelType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getmVehicleType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getmSeatNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getmCountCode()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getUsefulLifeSection()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getNewPurchaseSection()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhl().getVhlConsultSection()));


        startRow.createCell(i++).setCellValue(value(apply.getAppVsTax().getcPayType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVsTax().getcTaxVhlType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVsTax().getcTaxNum()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVsTax().getcTaxType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVsTax().getcTaxTime()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhlowner().getcOwnerNme()));
        startRow.createCell(i++).setCellValue(value(apply.getAppVhlowner().getcCertfNo()));

        /**
         * 险别列表
         */
        if (apply.getAppCvrgs() != null && apply.getAppCvrgs().size() > 0) {
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getcCvrgNo()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getcCvrgCode()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getNamt()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getDeductibles()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getIsDeduct()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getPsonNum()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgs().get(0).getClaimDays()));
        } else {
            i++;
            i++;
            i++;
            i++;
            i++;
            i++;
            i++;
        }
        /**
         * 返回的可投保险别
         */
        if (apply.getAppCvrgBacks() != null && apply.getAppCvrgBacks().size() > 0) {
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgBacks().get(0).getaCvrgCode()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgBacks().get(0).getaCvrgNo()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgBacks().get(0).getMinAmount()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgBacks().get(0).getMaxAmount()));
            startRow.createCell(i++).setCellValue(value(apply.getAppCvrgBacks().get(0).getIsMust()));
        } else {
            i++;
            i++;
            i++;
            i++;
            i++;
        }
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastRenewalModel()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastBsnsType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastDptCde()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastProdNo()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastCircleFlag()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastNewBsnsType()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastBgnTm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastEndTm()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastCOwnerNme()));
        startRow.createCell(i++).setCellValue(value(apply.getAppLastPolicy().getLastClaimAmount()));
        /**
         * 上年险别列表
         */
        if (apply.getAppLastCvrgs() != null && apply.getAppLastCvrgs().size() > 0) {
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getcCvrgNo()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getcCvrgCode()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getNamt()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getDeductibles()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getIsDeduct()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getPsonNum()));
            startRow.createCell(i++).setCellValue(value(apply.getAppLastCvrgs().get(0).getClaimDays()));
        } else {
            i++;
            i++;
            i++;
            i++;
            i++;
            i++;
        }
        startRow.createCell(i++).setCellValue(value(apply.getTotalFee()));
        startRow.createCell(i++).setCellValue(value(apply.getCommissionFee()));
        startRow.createCell(i++).setCellValue(value(apply.getPerformanceFee()));
        startRow.createCell(i++).setCellValue(value(apply.getOuterTeamFee()));
        startRow.createCell(i++).setCellValue(value(apply.getInnerTeamFee()));
        startRow.createCell(i++).setCellValue(value(apply.getManageFee()));
        startRow.createCell(i++).setCellValue(value(apply.getPolicyFee()));
        startRow.createCell(i++).setCellValue(value(apply.getEncourageFee()));
        startRow.createCell(i++).setCellValue(value(apply.getSpreadFee()));
        startRow.createCell(i++).setCellValue(value(apply.getTax()));
    }

    private static List<Data> getResultList(String fileName) {
        List<Data> result = new ArrayList<>();
        Workbook workBook = null;
        try {
            workBook = WorkbookFactory.create(new File(fileName));
            List<Object> headers = getExcelHeadData(workBook);
            Sheet sheet = workBook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            int index = 1;
            for (int i = 0; i <= lastRowNum / 1000; i++) {
                List<Map<String, Object>> dataList = getApartOfExcelData(sheet,
                        headers, index);
                for (Map<String, Object> tempMap : dataList) {
                    String request = String.valueOf(tempMap.get("C_REQ_CONTENT"));
                    String judge = String.valueOf(tempMap.get("C_RES_CONTENT"));
                    Data data = new Data();
                    data.setRequest(request);
                    data.setResult(judge);
                    result.add(data);
                }
                index = (i + 1) * 1000 + 1;
            }
        } catch (Exception ex) {
//			log.error("获取excel数据发生错误", ex);
        } finally {
            if (workBook != null) {
                try {
                    workBook.close();
                } catch (IOException e) {
//					logger.error("关闭excel工作簿失败", e);
                }
            }
        }
        return result;
    }


    //创建Excel文件
    public static void createExcel(String path) throws Exception {
        //创建Excel文件对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //用文件对象创建sheet对象  
        HSSFSheet sheet = wb.createSheet();
        //用sheet对象创建行对象  
        HSSFRow row = sheet.createRow(0);
        //创建单元格样式     
//        CellStyle cellStyle = wb.createCellStyle();
        //用行对象创建单元格对象Cell 
//        Cell cell = row.createCell(0);
        //用cell对象读写。设置Excel工作表的值
//        cell.setCellValue(1);
        //输出Excel文件
        FileOutputStream output = new FileOutputStream(path);
        wb.write(output);
        output.flush();
    }

    public static List<Object> getExcelHeadData(Workbook workBook) throws Exception {
        List<Object> headerData = new ArrayList<Object>();
        // 获取第一个工作薄 下标从0开始
        Sheet sheet = workBook.getSheetAt(0);
        if (sheet == null) {
            return headerData;
        }
        // 第0行就是 header行
        Row row = sheet.getRow(0);
        if (row == null) {
            throw new Exception("文件格式不正确");
        }
        // 循环header行
        for (int i = 0; ; i++) {
            Cell cell = row.getCell(i);
            if (cell == null) {
                break;
            }
            headerData.add(getValue(cell));
        }
        return headerData;
    }

    /**
     * 解决excel类型问题，获得数值
     *
     * @param cell 单元格对象
     * @return 单元格中的对应格式的数据
     */
    private static Object getValue(Cell cell) {
        Object value = null;
        if (null == cell) {
            return value;
        }
        switch (cell.getCellType()) {
            // 数值型
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是date类型则 ，获取该cell的date值
                    value = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                } else {// 纯数字，直接返回object，不能转换成string返回
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big;
                }
                break;
            // 字符串类型
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().trim();
                break;
            // 公式类型
            case Cell.CELL_TYPE_FORMULA:
                try {
                    // 读公式计算值
                    value = String.valueOf(cell.getNumericCellValue());
                    // 如果获取的数据值为非法值,则转换为获取字符串
                    if (value.equals("NaN")) {
                        value = cell.getStringCellValue();
                    }
                } catch (Exception e) {// 获取异常,则转换为获取字符串
                    value = cell.getStringCellValue();
                }
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            // 故障
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        return value;
    }

    /**
     * 从workBook中获得 Excel信息
     *
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getApartOfExcelData(Sheet sheet,
                                                                List<Object> header, int index) throws Exception {
        List<Map<String, Object>> excelData = new ArrayList<Map<String, Object>>();
        int headerSize = header.size();
        int lastRowNum = sheet.getLastRowNum();
        int size = lastRowNum - index;
        if (size > 1000) {
            size = index + 1000;
        } else {
            size = lastRowNum + 1;
        }
        // 循环工作薄，将数据进行封装
        for (int i = index; i < size; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            // 判断这行的cell 是否有数据
            boolean isAllEmpty = true;
            Map<String, Object> rowData = new HashMap<String, Object>();
            for (int j = 0; j < headerSize; j++) {
                Cell cell = row.getCell(j);
                Object cellValue = getValue(cell);
                if (!(cellValue == null || "".equals(cellValue))) {
                    rowData.put(header.get(j).toString(), cellValue);
                    isAllEmpty = false;
                }
            }
            if (!isAllEmpty) { // 这行数据不为空，才进行导入
                excelData.add(rowData);
            }
        }
        return excelData;
    }


    /***
     * JSON 遍历
     */

    public static void jsonObjParseRecur(Set<String> set, String jsonText) {
        try {
            JSONObject jsonObj = JSONObject.fromObject(jsonText);
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                set.add(key);
//                System.out.println(key+": " + jsonObj.get(key).toString()));
                if (jsonObj.optJSONArray(key) instanceof JSONArray) {
                    JSONArray jsonArray = jsonObj.getJSONArray(key);
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonArrayObj = jsonArray.getJSONObject(i);
                        String jsonArrayObjString = jsonArrayObj.toString();
                        jsonObjParseRecur(set, jsonArrayObjString);
                    }
                }
                if (jsonObj.optJSONObject(key) instanceof JSONObject) {
                    jsonObjParseRecur(set, jsonObj.optJSONObject(key).toString());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(set);
    }


    /**
     * 反射遍历
     *
     * @param chain
     * @param fields
     * @return
     */

    public static List getBomFields1(List chain,
                                     Field[] fields) {
        List result = new ArrayList();
        for (Field field : fields) {
            Class<?> fieldClass = field.getType();
            //得到属性
            field.setAccessible(true);
            //获取属性
            String name = field.getName();
            //获取属性值
//			Object value = field.get(obj);
            if (fieldClass.isPrimitive()
                    || fieldClass.getName().startsWith("java.lang")
                    || fieldClass.getName().startsWith("java.util.Date")
                    || fieldClass.getName().startsWith("javax")
                    || fieldClass.getName().startsWith("com.sun")
                    || fieldClass.getName().startsWith("sun")
                    || fieldClass.getName().startsWith("boolean")
                    || fieldClass.getName().startsWith("double")
                    || fieldClass.getName().startsWith("int")) {
                List endChain = new ArrayList(chain);
                endChain.add(field);
                result.add(endChain);
                continue;
            } else {
                if (fieldClass.isAssignableFrom(List.class)) {
                    // 关键的地方，如果是List类型，得到其Generic的类型
                    Type fc = field.getGenericType();
                    // 【3】如果是泛型参数的类型
                    if (fc instanceof ParameterizedType) {
                        ParameterizedType pt = (ParameterizedType) fc;
                        // 【4】
                        Class genericClazz = (Class) pt.getActualTypeArguments()[0];
                        //设置list的终止类型
                        if (genericClazz.getName().startsWith("java.lang")
                                || genericClazz.getName().startsWith("java.util.Date")
                                || genericClazz.getName().startsWith("javax")
                                || genericClazz.getName().startsWith("com.sun")
                                || genericClazz.getName().startsWith("sun")
                                || genericClazz.getName().startsWith("boolean")
                                || genericClazz.getName().startsWith("double")
                                || genericClazz.getName().startsWith("int")) {
                            continue;
                        }
                        // 得到泛型里的class类型对象。
                        List thisChain = new ArrayList(chain);
                        thisChain.add(field);
                        result.addAll(getBomFields1(new ArrayList(thisChain), genericClazz.getDeclaredFields()));
                    }
                } else {
                    List thisChain = new ArrayList(chain);
                    thisChain.add(field);
                    result.addAll(getBomFields1(new ArrayList(thisChain),
                            fieldClass.getDeclaredFields()));
                }

            }
        }
        return result;
    }
}
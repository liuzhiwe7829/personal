package com.excel.demo.export;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhiwei.liu003
 * @date 2019/11/2720:05
 */
public class ExportDemo {

    public final static String[] YEAR_LIST = new String[]{"2010年度", "2011年度", "2012年度", "2013年度", "2014年度", "2015年度",
            "2016年度", "2017年度", "2018年度", "2019年度", "2020年度",
            "2021年度", "2022年度", "2023年度", "2024年度", "2025年度",
            "2026年度", "2027年度", "2028年度", "2029年度", "2030年度"};
    public final static int EXCEL_MAX_ROW = 5000;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String filePath = "D:\\statItemTargetTemplate.xls";
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(in);
        String hiddenName = "hidden";
        String hiddenCol = "A";
        HSSFSheet hidden = workbook.createSheet(hiddenName);
        HSSFSheet realSheet = workbook.getSheetAt(0);

        for (
                int i = 0, length = YEAR_LIST.length;
                i < length; i++) {
            String name = YEAR_LIST[i];
            HSSFRow row = hidden.createRow(i);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(name);
        }

        Name namedCell = workbook.createName();
        namedCell.setNameName(hiddenName);
        StringBuffer sb = new StringBuffer();
        sb.append(hiddenName);
        sb.append("!");
        sb.append(hiddenCol);
        sb.append("1:");
        sb.append(hiddenCol);
        sb.append(YEAR_LIST.length);
        // namedCell.setRefersToFormula("hidden!A1:A" + dataString.length);
        namedCell.setRefersToFormula(sb.toString());
//        namedCell.setRefersToFormula("hidden!A1:A" + YEAR_LIST.length);
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(hiddenName);
        CellRangeAddressList addressList = new CellRangeAddressList(1, 100, 0, 0);
        HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);
        workbook.setSheetHidden(1, true);
        realSheet.addValidationData(validation);
        FileOutputStream stream = new FileOutputStream("D:\\range1.xls");
        workbook.write(stream);
        stream.close();

    }
}

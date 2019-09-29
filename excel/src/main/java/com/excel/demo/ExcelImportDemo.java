package com.excel.demo;

import com.alibaba.fastjson.JSON;
import com.excel.demo.excel.ExcelParseResult;
import com.excel.demo.excel.SheetInfo;
import com.excel.demo.excel.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author zhiwei.liu003
 * @date 2019/9/259:14
 */
public class ExcelImportDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelImportDemo.class);


    private static LinkedHashMap<String, Object> dateInfo = new LinkedHashMap<>();
    static
        {
            SheetInfo companyOpMonthTotal = new SheetInfo(1, "CompanyOpMonthTotal", "1总公司经营月报总表");
            LinkedList<TableInfo> tableInfos = new LinkedList<TableInfo>();
            tableInfos.add(new TableInfo(1, "CurrentOpCondition", "当前经营情况", 4, 1, 0,"com.excel.demo.company"));
            tableInfos.add(new TableInfo(2, "RollingForTwelveMonths", "滚动12个月经营情况", 21, 1, 0,"com.excel.demo.company"));
            tableInfos.add(new TableInfo(3, "RollingForFiveYear", "滚动5年经营情况", 38, 1, 0,"com.excel.demo.company"));
            tableInfos.add(new TableInfo(4, "MonthOpConditionByCurrentYear", "当年逐月经营情况", 55, 2, 0,"com.excel.demo.company"));
            companyOpMonthTotal.setTableList(tableInfos);
            LinkedHashMap<String,TableInfo> tableInfoMap = new LinkedHashMap<>();
            for (TableInfo tableInfo:tableInfos) {
                tableInfoMap.put(tableInfo.getName(),tableInfo);
            }
            companyOpMonthTotal.setTableMap(tableInfoMap);
            dateInfo.put("companyOpMonthTotal", companyOpMonthTotal);

        }

    public static void main(String[] args) throws ClassNotFoundException {
        String str = "com.excel.demo.company.CurrentOpCondition";
//        Class<?> pojoClass = ClassLoader.getSystemClassLoader().loadClass(str);
        String filePath = "D:\\work1.xlsx";
        File file = new File(filePath);
        ExcelParseResult excelParseResult = ExcelImportDemo.importExcelVerify(file, dateInfo);
//        System.out.println(JSON.toJSONString(excelParseResult.getMap()));

//        System.out.println(str.replaceAll("\\pP",""));
    }


    public static ExcelParseResult importExcelVerify(File file, LinkedHashMap dateInfo) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            return new PmanageExcelImportServer().importExcelByIs(in, dateInfo);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return null;
    }
}

package com.excel.demo.excel;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2522:16
 */
@Data
public class SheetInfo {

    /**
     * sheet序号,第几页
     */
    private  int num;
    /**
     * sheet名称
     */
    private String name;

    /**
     * sheet名称
     */
    private  String cName;

    @Override
    public String toString() {
        return "SheetInfo{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", cName='" + cName + '\'' +
                ", tableList=" + tableList +
                ", tableMap=" + tableMap +
                '}';
    }

    /**
     *表list
     */
    private LinkedList<TableInfo> tableList;


    /**
     * 表名  cName:name  当前经营情况:CurrentOpCondition
     */
    private LinkedHashMap<String,TableInfo> tableMap;
    /**
     * @param num
     * @param name
     * @param cName
     */

    public SheetInfo(int num, String name, String cName) {
        this.num = num;
        this.name = name;
        this.cName = cName;
    }

    public LinkedHashMap<String, TableInfo> getTableMap() {
        return tableMap;
    }

    public void setTableMap(LinkedHashMap<String, TableInfo> tableMap) {
        this.tableMap = tableMap;
    }
}

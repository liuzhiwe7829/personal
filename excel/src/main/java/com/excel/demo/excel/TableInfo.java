package com.excel.demo.excel;

import lombok.Data;
import org.jeecgframework.poi.excel.entity.ExcelBaseParams;
import org.jeecgframework.poi.handler.inter.IExcelVerifyHandler;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2522:20
 */
@Data
public class TableInfo extends ExcelBaseParams {

    /**
     * 序号
     */
    private int num;

    /**
     * 表格名称
     */
    private String name;

    /**
     * 表格中文名称
     */
    private  String cName;

    /**
     * 表格标题行数,默认0
     */
    private int titleRows = 0;
    /**
     * 表头行数,默认1
     */
    private int headRows = 1;
    /**
     * 字段真正值和列标题之间的距离 默认0
     */
    private int startRows = 0;

    /**
     * 最后的无效行数
     */
    private int lastOfInvalidRow = 0;

    /**
     * 校验处理接口
     */
    private IExcelVerifyHandler verifyHanlder;

    /**
     * 对应实体包名
     */
    private String packageName;
    /**
     *
     * @param num 表序号
     * @param name 表名
     * @param cName 表中文名
     * @param titleRows 标题行数
     * @param headRows  表头行数
     * @param startRows 字段真正值和列标题之间的距离 默认0
     */
    public TableInfo(int num, String name, String cName,int titleRows ,int headRows ,int startRows,String packageName) {
        this.num = num;
        this.name = name;
        this.cName = cName;
        this.titleRows = titleRows;
        this.headRows = headRows;
        this.startRows = startRows;
        this.packageName = packageName;
    }
}

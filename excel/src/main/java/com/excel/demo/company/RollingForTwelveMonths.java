package com.excel.demo.company;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author zhiwei.liu003
 * @date 2019/9/2516:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RollingForTwelveMonths {
    private static final long serialVersionUID = 1L;
    /**
     * 指标名称
     */
    @Excel(name = "指标名称", width = 30)
    private String indicatorName;
    /**
     * 时间1
     */
    @Excel(name = "时间1", width = 30)
    private String date1;
    /**
     * 时间2
     */
    @Excel(name = "时间2", width = 30)
    private String date2;
    /**
     * 时间3
     */
    @Excel(name = "时间3", width = 30)
    private String date3;
    /**
     * 时间4
     */
    @Excel(name = "时间4", width = 30)
    private String date4;
    /**
     * 时间4
     */
    @Excel(name = "时间5", width = 30)
    private String date5;
    /**
     * 时间6
     */
    @Excel(name = "时间6", width = 30)
    private String date6;
    /**
     * 时间7
     */
    @Excel(name = "时间7", width = 30)
    private String date7;
    /**
     * 时间8
     */
    @Excel(name = "时间8", width = 30)
    private String date8;
    /**
     * 时间9
     */
    @Excel(name = "时间9", width = 30)
    private String date9;
    /**
     * 时间10
     */
    @Excel(name = "时间1", width = 30)
    private String date10;
    /**
     * 时间11
     */
    @Excel(name = "时间11", width = 30)
    private String date11;
    /**
     * 时间12
     */
    @Excel(name = "时间12", width = 30)
    private String date12;

}

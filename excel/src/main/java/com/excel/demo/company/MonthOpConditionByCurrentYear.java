package com.excel.demo.company;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MonthOpConditionByCurrentYear implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 指标名称
     */
    @Excel(name = "指标名称", width = 30)
    private String indicatorName;
    /**
     * 类型
     */
    @Excel(name = "类型", width = 30)
    private String type;
    /**
     * 1月
     */
    @Excel(name = "1月", width = 25)
    private String January;
    /**
     * 2月
     **/
    @Excel(name = "2月", width = 25)
    private String February ;
    /**
     * 3月
     **/
    @Excel(name = "3月", width = 25)
    private String March;
    /**
     * 4月
     **/
    @Excel(name = "4月", width = 25)
    private String April;
    /**
     * 5月
     **/
    @Excel(name = "5月", width = 25)
    private String May;
    /**
     * 6月
     **/
    @Excel(name = "6月", width = 25)
    private String June;
    /**
     * 7月
     **/
    @Excel(name = "7月", width = 25)
    private String July;
    /**
     * 8月
     **/
    @Excel(name = "8月", width = 25)
    private String August;
    /**
     * 9月
     **/
    @Excel(name = "9月", width = 25)
    private String September;
    /**
     * 10月
     **/
    @Excel(name = "10月", width = 25)
    private String October;
    /**
     * 11月
     **/
    @Excel(name = "11月", width = 25)
    private String November;
    /**
     * 12月
     **/
    @Excel(name = "12月", width = 25)
    private String December;


}

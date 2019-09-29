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
public class RollingForFiveYear {
    private static final long serialVersionUID = 1L;
    /**
     * 指标名称
     */
    @Excel(name = "指标名称", width = 30)
    private String indicatorName;
    /**
     * 年度1
     */
    @Excel(name = "年度1", width = 30)
    private String year1;
    /**
     * 年度2
     */
    @Excel(name = "年度2", width = 30)
    private String year2;
    /**
     * 年度3
     */
    @Excel(name = "年度3", width = 30)
    private String year3;
    /**
     * 年度4
     */
    @Excel(name = "年度4", width = 30)
    private String year4;
    /**
     * 年度5
     */
    @Excel(name = "年度5", width = 30)
    private String year5;

}

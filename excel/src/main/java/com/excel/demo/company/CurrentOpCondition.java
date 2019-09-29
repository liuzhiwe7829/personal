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
public class CurrentOpCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 指标名称
     */
    @Excel(name = "指标名称", width = 30)
    private String indicatorName;
    /**
     * 达成值
     */
    @Excel(name = "达成值", width = 25)
    private String achieve;
    /**
     * 目标值
     **/
    @Excel(name = "目标值", width = 25)
    private String goal ;
    /**
     * 目标达成率
     **/
    @Excel(name = "目标达成率", width = 25)
    private String goalAchievementRate;
    /**
     * 评价等级
     **/
    @Excel(name = "评价等级", width = 25)
    private String evaluationLevel;
    /**
     * 去年同期
     **/
    @Excel(name = "去年同期", width = 25)
    private String correspondingPeriodOfLastYear;
    /**
     * 行业最新
     **/
    @Excel(name = "行业最新", width = 25)
    private String latestIndustry;

}

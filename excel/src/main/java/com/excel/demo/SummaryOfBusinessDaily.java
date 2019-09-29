package com.excel.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: jeecg 测试demo
 * @Author: jeecg-boot
 * @Date: 2018-12-29
 * @Version:V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SummaryOfBusinessDaily implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 经营大类
     */
    @Excel(name = "经营大类", width = 25)
    private String businessClassification;
    /**
     * 经营细类
     */
    @Excel(name = "经营细类", width = 25)
    private String businessDetail;
    /**
     * 保费收入-天-实际值
     **/
    @Excel(name = "实际值C", width = 15)
    private String premiumIncomeDayActualValue;
    /**
     * 保费收入-天-目标值
     **/
    @Excel(name = "目标值D", width = 15)
    private String premiumIncomeDayTargetValue;
    /**
     * 保费收入-天-达成率
     **/
    @Excel(name = "达成率E", width = 15)
    private String premiumIncomeDayRateOfAchievement;
    /**
     * 保费收入-月-实际值
     **/
    @Excel(name = "实际值F", width = 15)
    private String premiumIncomeMonthActualValue;
    /**
     * 保费收入-月目标值
     **/
    @Excel(name = "目标值G", width = 15)
    private String premiumIncomeMonthTargetValue;
    /**
     * 保费收入-月达成率
     **/
    @Excel(name = "达成率H", width = 15)
    private String premiumIncomeMonthRateOfAchievement;
	/**
	 * 保费收入-年-实际值
	 **/
	@Excel(name = "实际值I", width = 15)
	private String premiumIncomeYearActualValue;
	/**
	 * 保费收入-年目标值
	 **/
	@Excel(name = "目标值J", width = 15)
	private String premiumIncomeYearTargetValue;
	/**
	 * 保费收入-年达成率
	 **/
	@Excel(name = "达成率K", width = 15)
	private String premiumIncomeYearRateOfAchievement;

    /**
     * 新业务价值-天-实际值
     **/
    @Excel(name = "实际值L", width = 15)
    private String newBusinessDayActualValue;
    /**
     * 新业务价值-天-目标值
     **/
    @Excel(name = "目标值M", width = 15)
    private String newBusinessDayTargetValue;
    /**
     * 新业务价值-天-达成率
     **/
    @Excel(name = "达成率N", width = 15)
    private String newBusinessDayRateOfAchievement;
    /**
     * 新业务价值-月-实际值
     **/
    @Excel(name = "实际值O", width = 15)
    private String newBusinessMonthActualValue;
    /**
     * 新业务价值-月目标值
     **/
    @Excel(name = "目标值P", width = 15)
    private String newBusinessMonthTargetValue;
    /**
     * 新业务价值-月达成率
     **/
    @Excel(name = "达成率Q", width = 15)
    private String newBusinessMonthRateOfAchievement;

	/**
	 * 新业务价值-年-价值率
	 **/
	@Excel(name = "新业务价值率R", width = 15)
	private String newBusinessMonthRateOfValue;
	/**
	 * 新业务价值-年-实际值
	 **/
	@Excel(name = "实际值S", width = 15)
	private String newBusinessYearActualValue;
	/**
	 * 新业务价值-年目标值
	 **/
	@Excel(name = "目标值T", width = 15)
	private String newBusinessYearTargetValue;
	/**
	 * 新业务价值-年达成率
	 **/
	@Excel(name = "达成率U", width = 15)
	private String newBusinessYearRateOfAchievement;

	/**
	 * 新业务价值-年-价值率
	 **/
	@Excel(name = "新业务价值率V", width = 15)
	private String newBusinessYearRateOfValue;
    /**
     * 签单保费-日
     **/
    @Excel(name = "当日W", width = 15)
    private String signPremiumDay;
    /**
     * 签单保费-月
     **/
    @Excel(name = "当月X", width = 15)
    private String signPremiumMonth;
    /**
     * 签单保费-年
     **/
    @Excel(name = "当年Y", width = 15)
    private String signPremiumYear;

//	/** 打卡时间 */
//	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@Excel(name="打卡时间",width=20,format="yyyy-MM-dd HH:mm:ss")
//	private java.util.Date punchTime;
//	/** 工资 */
//	@Excel(name="工资",width=15)
//	private java.math.BigDecimal salaryMoney;
//	/** 奖金 */
//	@Excel(name="奖金",width=15)
//	private Double bonusMoney;
//	/** 性别 {男:1,女:2} */
//	@Excel(name = "性别", width = 15, dicCode = "sex")
//	private String sex;
//	/** 年龄 */
//	@Excel(name="年龄",width=15)
//	private Integer age;
//	/** 生日 */
//	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Excel(name="生日",format="yyyy-MM-dd")
//	private java.util.Date birthday;
//	/** 邮箱 */
//	@Excel(name="邮箱",width=30)
//	private String email;
//	/** 个人简介 */
//	private String content;
}

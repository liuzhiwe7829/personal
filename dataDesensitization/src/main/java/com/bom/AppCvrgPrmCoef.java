/**
 * @(#) AppCvrgPrmCoefDto.java
 * Copyright(c) 2006-2013 深圳市麦亚信科技资讯有限公司  版权扄1�7�1�7�1�7�1�7
 * Shenzhen MEYACOM, LTD. All rights reserved.
 * This software is the confidential and proprietary
 * information of Shenzhen MEYACOM, LTD.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with Shenzhen MEYACOM, LTD.
 */
package com.bom;

import java.io.Serializable;

/**
 * 
 *系数
 * @author chenjp
 */
//@Bom(name = "系数信息")
public class AppCvrgPrmCoef implements Serializable{
//private static final long serialVersionUID = 1L;
	
	/**
	 * 总体折扣
	 */
	private Double totalDiscount; 
	
	/**
	 * 指定驾驶员
	 */
	private String cAppDrv;
	
	/**
	 * 投保年度
	 */
	private String appYear;

	/**
	 * 车险以往索赔记录
	 */
//	@BomCodes(code = "以往保险年度索赔记录")
	private String claimRecord;
	
	/**
	 * 平均行驶里程
	 */
	private Double averageMile;
	
	/**
	 * 无赔系数 费率-平台返回无赔折扣系数
	 */
//	@BomCodes(code = "平台返回无赔折扣系数")
	private Double abateCoef;
	
	/**
	 * 交通违法系数
	 */
	private String transgressCoef;
	
/*	*//**
	 * 指定省内特约系数
	 *//*
	private String inProCoef;*/
	
	/**
	 * 承保数量
	 */
	private String insNum;
	
	/**
	 * 经验/预期赔付率
	 */
	private Double anClaimCoef;
	
	/**
	 * 驾驶人年龄
	 */
	private String driverAge;
	
	/**
	 * 驾驶人性别
	 */
	private String driverSex;
	
	/**
	 * 驾驶人驾龄
	 */
	private String drivedAge;
	
	/**
	 * 行驶区域
	 */
	private String driveArea;
	
	/**
	 * 多险别投保优惠
	 */
	private String riskInsPre;
	
	/**
	 * 上年赔付次数
	 */
	private Double lastcompTimes;	
	
	/**
	 * 客户忠诚度系数.
	 */
	private Double cterLoyalty;
	
	/**
	 * 建议折扣.
	 */
	private Double recDiscount;
	
	/**
	 * 成本折扣.
	 */
	private Double costDiscount;
	
	/**
	 * 渠道系数
	 */
//	@BomCodes(code = "自主渠道系数")
	private Double channelAdjust;

	/**
	 * 核保系数
	 */
//	@BomCodes(code = "自主核保系数")
	private Double autoUdrAdjust;
	
	/**
	 * 减免比例
	 */
	private Double cAbateProp;
	
	/**
	 * 指定修理厂险费率
	 */
	private Double autoRepairFactor;
	
	/**
	 * 交通违法调整系数
	 */
	private Double nSafeDev;
	

	public Double getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public String getcAppDrv() {
		return cAppDrv;
	}


	public void setcAppDrv(String cAppDrv) {
		this.cAppDrv = cAppDrv;
	}


	public String getAppYear() {
		return appYear;
	}


	public void setAppYear(String appYear) {
		this.appYear = appYear;
	}

	public String getClaimRecord() {
		return claimRecord;
	}


	public void setClaimRecord(String claimRecord) {
		this.claimRecord = claimRecord;
	}


	public Double getAverageMile() {
		return averageMile;
	}


	public void setAverageMile(Double averageMile) {
		this.averageMile = averageMile;
	}

	public Double getAbateCoef() {
		return abateCoef;
	}


	public void setAbateCoef(Double abateCoef) {
		this.abateCoef = abateCoef;
	}

	/*public String getInProCoef() {
		return inProCoef;
	}


	public void setInProCoef(String inProCoef) {
		this.inProCoef = inProCoef;
	}*/


	public Double getAnClaimCoef() {
		return anClaimCoef;
	}
	
	public void setAnClaimCoef(Double anClaimCoef) {
		this.anClaimCoef = anClaimCoef;
	}

	public String getDriverSex() {
		return driverSex;
	}


	public void setDriverSex(String driverSex) {
		this.driverSex = driverSex;
	}


	public String getDriveArea() {
		return driveArea;
	}

	public void setDriveArea(String driveArea) {
		this.driveArea = driveArea;
	}


	public String getRiskInsPre() {
		return riskInsPre;
	}


	public void setRiskInsPre(String riskInsPre) {
		this.riskInsPre = riskInsPre;
	}

	public String getTransgressCoef() {
		return transgressCoef;
	}


	public void setTransgressCoef(String transgressCoef) {
		this.transgressCoef = transgressCoef;
	}


	public String getInsNum() {
		return insNum;
	}


	public void setInsNum(String insNum) {
		this.insNum = insNum;
	}


	public String getDriverAge() {
		return driverAge;
	}


	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}


	public String getDrivedAge() {
		return drivedAge;
	}


	public void setDrivedAge(String drivedAge) {
		this.drivedAge = drivedAge;
	}


	public Double getLastcompTimes() {
		return lastcompTimes;
	}


	public void setLastcompTimes(Double lastcompTimes) {
		this.lastcompTimes = lastcompTimes;
	}

	public Double getCterLoyalty() {
		return cterLoyalty;
	}

	public void setCterLoyalty(Double cterLoyalty) {
		this.cterLoyalty = cterLoyalty;
	}
	
	public Double getRecDiscount() {
		return recDiscount;
	}

	public void setRecDiscount(Double recDiscount) {
		this.recDiscount = recDiscount;
	}


	public Double getCostDiscount() {
		return costDiscount;
	}


	public void setCostDiscount(Double costDiscount) {
		this.costDiscount = costDiscount;
	}


	public Double getChannelAdjust() {
		return channelAdjust;
	}


	public void setChannelAdjust(Double channelAdjust) {
		this.channelAdjust = channelAdjust;
	}


	public Double getAutoUdrAdjust() {
		return autoUdrAdjust;
	}


	public void setAutoUdrAdjust(Double autoUdrAdjust) {
		this.autoUdrAdjust = autoUdrAdjust;
	}

	public Double getcAbateProp() {
		return cAbateProp;
	}


	public void setcAbateProp(Double cAbateProp) {
		this.cAbateProp = cAbateProp;
	}


	public Double getAutoRepairFactor() {
		return autoRepairFactor;
	}


	public void setAutoRepairFactor(Double autoRepairFactor) {
		this.autoRepairFactor = autoRepairFactor;
	}


	public Double getnSafeDev() {
		return nSafeDev;
	}


	public void setnSafeDev(Double nSafeDev) {
		this.nSafeDev = nSafeDev;
	}


	@Override
	public String toString() {
		return "AppCvrgPrmCoef [totalDiscount=" + totalDiscount + ", cAppDrv="
				+ cAppDrv + ", appYear=" + appYear + ", claimRecord="
				+ claimRecord + ", averageMile=" + averageMile + ", abateCoef="
				+ abateCoef + ", transgressCoef=" + transgressCoef
				+ ", insNum=" + insNum + ", anClaimCoef=" + anClaimCoef
				+ ", driverAge=" + driverAge + ", driverSex=" + driverSex
				+ ", drivedAge=" + drivedAge + ", driveArea=" + driveArea
				+ ", riskInsPre=" + riskInsPre + ", lastcompTimes="
				+ lastcompTimes + ", cterLoyalty=" + cterLoyalty
				+ ", recDiscount=" + recDiscount + ", costDiscount="
				+ costDiscount + ", channelAdjust=" + channelAdjust
				+ ", autoUdrAdjust=" + autoUdrAdjust + ", cAbateProp="
				+ cAbateProp + ", autoRepairFactor=" + autoRepairFactor
				+ ", nSafeDev=" + nSafeDev + "]";
	}


	public AppCvrgPrmCoef() {
		super();
	}





	
}

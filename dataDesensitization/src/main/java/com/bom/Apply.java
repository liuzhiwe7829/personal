/**
 * @(#) Apply.java
 * Copyright(c) 2006-2013 深圳市麦亚信科技资讯有限公司  版权所有
 * Shenzhen MEYACOM, LTD. All rights reserved.
 * This software is the confidential and proprietary
 * information of Shenzhen MEYACOM, LTD.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with Shenzhen MEYACOM, LTD.
 */

package com.bom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 保单
 */
@XmlRootElement
//@Bom(name = "主BOM - 永诚车险投保单",primary=true)
public class Apply implements Serializable {

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	//	private static final long serialVersionUID = 1L;
	private  String result;
	/**
	 * 投保人
	 */
	private AppApplicant appApplicant;

	/**
	 * 基本信息
	 */
	private AppBase appBase;

	/**
	 * 系数
	 */
	private AppCvrgPrmCoef appCvrgPrmCoef;

	/**
	 * 被保险人
	 */
	private AppInsured appInsured;

	/**
	 * 投保车辆
	 */
	private AppVhl appVhl;

	/**
	 * 车船税
	 */
	private AppVsTax appVsTax;

	/**
	 * 行驶证车主
	 */
	private AppVhlowner appVhlowner;

	/**
	 * 险别列表
	 */
	
	private List<AppCvrg> appCvrgs = new ArrayList<AppCvrg>();
	
	/**
	 * 返回的可投保险别
	 */
	private List<AppCvrgsBack> appCvrgBacks = new ArrayList<AppCvrgsBack>();
	
	/**
	 * 上年保单信息
	 */
	private AppLastPolicy appLastPolicy;
	
	/**
	 * 上年险别列表
	 */
	private List<AppCvrg> appLastCvrgs = new ArrayList<AppCvrg>();
	
	
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public double getCommissionFee() {
		return commissionFee;
	}
	public void setCommissionFee(double commissionFee) {
		this.commissionFee = commissionFee;
	}
	public double getPerformanceFee() {
		return performanceFee;
	}
	public void setPerformanceFee(double performanceFee) {
		this.performanceFee = performanceFee;
	}
	public double getManageFee() {
		return manageFee;
	}
	public void setManageFee(double manageFee) {
		this.manageFee = manageFee;
	}
	public double getPolicyFee() {
		return policyFee;
	}
	public void setPolicyFee(double policyFee) {
		this.policyFee = policyFee;
	}
	public double getEncourageFee() {
		return encourageFee;
	}
	public void setEncourageFee(double encourageFee) {
		this.encourageFee = encourageFee;
	}
	//总费用
	private double totalFee;  
	// 手续费用
	private double commissionFee;
	// 绩效费用
	private double performanceFee;
	// 外部团队费用
	private double outerTeamFee;
	// 内部团队费用
	private double innerTeamFee;
	// 管理日常费用
	private double manageFee;
	// 保单费用
	private double policyFee;
	// 激励费用
	private double encourageFee;
	// 地推费
	private double spreadFee;
	//税金
	private double tax;

	public AppApplicant getAppApplicant() {
		return appApplicant;
	}
	@XmlElementWrapper(name = "appCvrgs")
	@XmlElement(name = "appCvrg") 
	public List<AppCvrg> getAppCvrgs() {
		return appCvrgs;
	}

	public void setAppCvrgs(List<AppCvrg> appCvrgs) {
		this.appCvrgs = appCvrgs;
	}

	public void setAppApplicant(AppApplicant appApplicant) {
		this.appApplicant = appApplicant;
	}

	public AppBase getAppBase() {
		return appBase;
	}

	public void setAppBase(AppBase appBase) {
		this.appBase = appBase;
	}

	public AppCvrgPrmCoef getAppCvrgPrmCoef() {
		return appCvrgPrmCoef;
	}

	public void setAppCvrgPrmCoef(AppCvrgPrmCoef appCvrgPrmCoef) {
		this.appCvrgPrmCoef = appCvrgPrmCoef;
	}

	public AppInsured getAppInsured() {
		return appInsured;
	}

	public void setAppInsured(AppInsured appInsured) {
		this.appInsured = appInsured;
	}

	public AppVhl getAppVhl() {
		return appVhl;
	}

	public void setAppVhl(AppVhl appVhl) {
		this.appVhl = appVhl;
	}

	public AppVsTax getAppVsTax() {
		return appVsTax;
	}

	public void setAppVsTax(AppVsTax appVsTax) {
		this.appVsTax = appVsTax;
	}

	public AppVhlowner getAppVhlowner() {
		return appVhlowner;
	}

	public void setAppVhlowner(AppVhlowner appVhlowner) {
		this.appVhlowner = appVhlowner;
	}

	@XmlElementWrapper(name = "appLastCvrgs")
	@XmlElement(name = "appCvrg") 
	public List<AppCvrg> getAppLastCvrgs() {
		return appLastCvrgs;
	}

	public void setAppLastCvrgs(List<AppCvrg> appLastCvrgs) {
		this.appLastCvrgs = appLastCvrgs;
	}

	public AppLastPolicy getAppLastPolicy() {
		return appLastPolicy;
	}

	public void setAppLastPolicy(AppLastPolicy appLastPolicy) {
		this.appLastPolicy = appLastPolicy;
	}
	
	/**
	 * @return appCvrgBack
	 */
	public List<AppCvrgsBack> getAppCvrgBacks() {
		return appCvrgBacks;
	}

	/**
	 * @param appCvrgBacks 要设置的 appCvrgBack
	 */
	public void setAppCvrgBacks(List<AppCvrgsBack> appCvrgBacks) {
		this.appCvrgBacks = appCvrgBacks;
	}


	@Override
	public String toString() {
		return "Apply [appApplicant=" + appApplicant + ", appBase=" + appBase
				+ ", appCvrgPrmCoef=" + appCvrgPrmCoef + ", appInsured="
				+ appInsured + ", appVhl=" + appVhl + ", appVsTax=" + appVsTax
				+ ", appVhlowner=" + appVhlowner + ", appCvrgs=" + appCvrgs
				+ ", appCvrgBacks=" + appCvrgBacks + ", appLastPolicy="
				+ appLastPolicy + ", appLastCvrgs=" + appLastCvrgs
				+ ", totalFee=" + totalFee + ", commissionFee=" + commissionFee
				+ ", performanceFee=" + performanceFee + ", outerTeamFee="
				+ outerTeamFee + ", innerTeamFee=" + innerTeamFee
				+ ", manageFee=" + manageFee + ", policyFee=" + policyFee
				+ ", encourageFee=" + encourageFee + ", spreadFee=" + spreadFee
				+ ", tax=" + tax + "]";
	}
	public Apply() {
		super();
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getSpreadFee() {
		return spreadFee;
	}
	public void setSpreadFee(double spreadFee) {
		this.spreadFee = spreadFee;
	}
	public double getInnerTeamFee() {
		return innerTeamFee;
	}
	public void setInnerTeamFee(double innerTeamFee) {
		this.innerTeamFee = innerTeamFee;
	}
	public double getOuterTeamFee() {
		return outerTeamFee;
	}
	public void setOuterTeamFee(double outerTeamFee) {
		this.outerTeamFee = outerTeamFee;
	}
}

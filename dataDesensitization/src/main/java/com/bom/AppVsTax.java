/**
 * @(#) AppVsTax.java
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 *车船税
 * @author chenjp
 */
//@Bom(name = "车船税")
public class AppVsTax implements Serializable{

//	private static final long serialVersionUID = 1L;
	
	/**
	 * 缴费方式
	 */
	private String cPayType;
	
	/**
	 * 缴费车辆类型
	 */
	private String cTaxVhlType;
	
	/**
	 * 车船税金额
	 */
	private Double cTaxNum;
	
	/**
	 * 计算类型
	 */
	private String cTaxType;
	
	/**
	 * 缴费期限
	 */
	private Date cTaxTime;
	
	

	public String getcPayType() {
		return cPayType;
	}

	public void setcPayType(String cPayType) {
		this.cPayType = cPayType;
	}

	public String getcTaxVhlType() {
		return cTaxVhlType;
	}

	public void setcTaxVhlType(String cTaxVhlType) {
		this.cTaxVhlType = cTaxVhlType;
	}

	public Double getcTaxNum() {
		return cTaxNum;
	}

	public void setcTaxNum(Double cTaxNum) {
		this.cTaxNum = cTaxNum;
	}

	public String getcTaxType() {
		return cTaxType;
	}
	@XmlElement(name = "cTaxTime", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getcTaxTime() {
		return cTaxTime;
	}

	public void setcTaxTime(Date cTaxTime) {
		this.cTaxTime = cTaxTime;
	}
	
	public void setcTaxType(String cTaxType) {
		this.cTaxType = cTaxType;
	}

	@Override
	public String toString() {
		return "AppVsTax [cPayType=" + cPayType + ", cTaxVhlType="
				+ cTaxVhlType + ", cTaxNum=" + cTaxNum + ", cTaxType="
				+ cTaxType + ", cTaxTime=" + cTaxTime + "]";
	}

	public AppVsTax() {
		super();
	}
	
	
}

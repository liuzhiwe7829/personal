/**
 * @(#) AppInsured.java
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
 * 被保险人
 *
 * @author chenjp
 */
//@Bom(name = "被保险人信息")
public class AppInsured implements Serializable{
	
//	private static final long serialVersionUID = 1L;
	
	/**
	 * 被保险人
	 */
//	@BomCodes(code = "被保险人")
	private String cInsureDnme;
	
	/**
	 * 性质
	 */
	private String cClnTmrk;
	
	/**
	 * 证件类型
	 */
	private String cCertFcls;
	
	/**
	 * 证件号码
	 */
	private String cCertfNo;
	
	/**
	 * 股东客户标识
	 */
	private String cStkMrk;
	
	/**
	 * 被保险人性别
	 */
	private String insuSex;
	
	
	/**
	 * 被保险人出生日期.
	 */
	private Date   insuDate; 
	
	/**
	 * 受益人名称.
	 */
//	@BomCodes(code = "受益人名称")
	private String bnefName;
	
	/**
	 * 受益人证件类型.
	 */
	private String bnefTyp;
	
	/**
	 * 受益人证件号码.
	 */
	private String bnefNum;
		
	/**
	 * 受益人性别
	 */
	private String bnefSex;
	
	/**
	 * 受益人出生日期.
	 */
	private Date  bnefDate;

	public String getcInsureDnme() {
		return cInsureDnme;
	}

	public void setcInsureDnme(String cInsureDnme) {
		this.cInsureDnme = cInsureDnme;
	}

	public String getcClnTmrk() {
		return cClnTmrk;
	}

	public void setcClnTmrk(String cClnTmrk) {
		this.cClnTmrk = cClnTmrk;
	}

	public String getcCertFcls() {
		return cCertFcls;
	}

	public void setcCertFcls(String cCertFcls) {
		this.cCertFcls = cCertFcls;
	}

	public String getcStkMrk() {
		return cStkMrk;
	}

	public void setcStkMrk(String cStkMrk) {
		this.cStkMrk = cStkMrk;
	}
	
	public String getInsuSex() {
		return insuSex;
	}

	public void setInsuSex(String insuSex) {
		this.insuSex = insuSex;
	}
	@XmlElement(name = "insuDate", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getInsuDate() {
		return insuDate;
	}

	public void setInsuDate(Date insuDate) {
		this.insuDate = insuDate;
	}

	public String getBnefName() {
		return bnefName;
	}

	public void setBnefName(String bnefName) {
		this.bnefName = bnefName;
	}

	public String getBnefTyp() {
		return bnefTyp;
	}

	public void setBnefTyp(String bnefTyp) {
		this.bnefTyp = bnefTyp;
	}

	public String getBnefNum() {
		return bnefNum;
	}

	public void setBnefNum(String bnefNum) {
		this.bnefNum = bnefNum;
	}

	public String getBnefSex() {
		return bnefSex;
	}

	public void setBnefSex(String bnefSex) {
		this.bnefSex = bnefSex;
	}
	@XmlElement(name = "bnefDate", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getBnefDate() {
		return bnefDate;
	}

	public void setBnefDate(Date bnefDate) {
		this.bnefDate = bnefDate;
	}

	public String getcCertfNo() {
		return cCertfNo;
	}

	public void setcCertfNo(String cCertfNo) {
		this.cCertfNo = cCertfNo;
	}

	@Override
	public String toString() {
		return "AppInsured [cInsureDnme=" + cInsureDnme + ", cClnTmrk="
				+ cClnTmrk + ", cCertFcls=" + cCertFcls + ", cCertfNo="
				+ cCertfNo + ", cStkMrk=" + cStkMrk + ", insuSex=" + insuSex
				+ ", insuDate=" + insuDate + ", bnefName=" + bnefName
				+ ", bnefTyp=" + bnefTyp + ", bnefNum=" + bnefNum
				+ ", bnefSex=" + bnefSex + ", bnefDate=" + bnefDate + "]";
	}

	public AppInsured() {
		super();
	}


	
	
	
}

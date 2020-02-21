/**
 * @(#) AppApplicantDto.java
 * Copyright(c) 2006-2013 深圳市麦亚信科技资讯有限公司  版权扄1�7朄1�7
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
 * 投保人信息
 * @author chenjp
 */
//@Bom(name = "投保人信息")
public class AppApplicant implements Serializable {
	public String getcAppContacts() {
		return cAppContacts;
	}

	public void setcAppContacts(String cAppContacts) {
		this.cAppContacts = cAppContacts;
	}

//	private static final long serialVersionUID = 1L;

	/**
	 * 姓名
	 */
//	@BomCodes(code = "投保人")
	private String cAppNme;

	/**
	 * 投保联系人
	 */
//	@BomCodes(code = "投保联系人")
	private String cAppContacts;
	/**
	 * 股东客户标志
	 */
	private String cStkMrk;

	/**
	 * 性质
	 */
	private String cClntMrk;

	/**
	 * 证件类型
	 */
	private String cCertfCls;
	
	/**
	 * 证件号码
	 */
	private String cCertfNo;
	
	/**
	 * 性别.
	 */
	private String comerSex;
	
	/**
	 * 出生日期.
	 */
	private Date  comerDate;
	

	public String getcAppNme() {
		return cAppNme;
	}

	public void setcAppNme(String cAppNme) {
		this.cAppNme = cAppNme;
	}

	public String getcStkMrk() {
		return cStkMrk;
	}

	public void setcStkMrk(String cStkMrk) {
		this.cStkMrk = cStkMrk;
	}

	public String getcClntMrk() {
		return cClntMrk;
	}

	public void setcClntMrk(String cClntMrk) {
		this.cClntMrk = cClntMrk;
	}

	public String getcCertfCls() {
		return cCertfCls;
	}

	public void setcCertfCls(String cCertfCls) {
		this.cCertfCls = cCertfCls;
	}

	public String getComerSex() {
		return comerSex;
	}

	public void setComerSex(String comerSex) {
		this.comerSex = comerSex;
	}

	@XmlElement(name = "comerDate", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getComerDate() {
		return comerDate;
	}

	public void setComerDate(Date comerDate) {
		this.comerDate = comerDate;
	}

	public String getcCertfNo() {
		return cCertfNo;
	}

	public void setcCertfNo(String cCertfNo) {
		this.cCertfNo = cCertfNo;
	}

	@Override
	public String toString() {
		return "AppApplicant [cAppNme=" + cAppNme + ", cAppContacts="
				+ cAppContacts + ", cStkMrk=" + cStkMrk + ", cClntMrk="
				+ cClntMrk + ", cCertfCls=" + cCertfCls + ", cCertfNo="
				+ cCertfNo + ", comerSex=" + comerSex + ", comerDate="
				+ comerDate + "]";
	}

	public AppApplicant() {
		super();
	}


}
/**
 * @(#) AppVhlowner.java
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
 *行驶证车主
 * @author chenjp
 */
//@Bom(name = "行驶证车主")
public class AppVhlowner implements Serializable{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -2299096788657395506L;

	/**
	 * 姓名
	 */
	private String cOwnerNme;
	
	/**
	 * 证件号码
	 */
	private String cCertfNo;

	
	public String getcOwnerNme() {
		return cOwnerNme;
	}

	public void setcOwnerNme(String cOwnerNme) {
		this.cOwnerNme = cOwnerNme;
	}

	public String getcCertfNo() {
		return cCertfNo;
	}

	public void setcCertfNo(String cCertfNo) {
		this.cCertfNo = cCertfNo;
	}


	@Override
	public String toString() {
		return "AppVhlowner [cOwnerNme=" + cOwnerNme + ", cCertfNo=" + cCertfNo
				+ "]";
	}

	public AppVhlowner() {
		super();
	}
	
}

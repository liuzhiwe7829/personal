/**
 * @(#) AppCvrg.java
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
 *险别 
 *
 * @author chenjp
 */
//@Bom(name = "险别信息")
public class AppCvrg implements Serializable{

//	private static final long serialVersionUID = 1L;
	
	/**
	 * 险别名称
	 */
	private String cCvrgNo;
	
	/**
	 * 险别代码
	 */
	private String cCvrgCode;
	
	/**
	 * 保额
	 */
	private Double namt;
	
	/**
	 * 免赔额
	 * 
	 */
	private Double deductibles;
	
	/**
	 * 是否不计免赔.
	 */
	private String  isDeduct;
	
	/**
	 * 人数.
	 */
	private Double  psonNum;
	
	/**
	 * 赔偿天数.
	 */
	private int  claimDays;	
	
	
	public Double getDeductibles() {
		return deductibles;
	}

	public void setDeductibles(Double deductibles) {
		this.deductibles = deductibles;
	}



	public String getcCvrgNo() {
		return cCvrgNo;
	}

	public void setcCvrgNo(String cCvrgNo) {
		this.cCvrgNo = cCvrgNo;
	}

	public String getcCvrgCode() {
		return cCvrgCode;
	}

	public void setcCvrgCode(String cCvrgCode) {
		this.cCvrgCode = cCvrgCode;
	}

	public Double getNamt() {
		return namt;
	}

	public void setNamt(Double namt) {
		this.namt = namt;
	}

/*	public Double getnDisCoef() {
		return nDisCoef;
	}

	public void setnDisCoef(Double nDisCoef) {
		this.nDisCoef = nDisCoef;
	}
*/
	
	public String getIsDeduct() {
		return isDeduct;
	}

	public void setIsDeduct(String isDeduct) {
		this.isDeduct = isDeduct;
	}

	public Double getPsonNum() {
		return psonNum;
	}

	public void setPsonNum(Double psonNum) {
		this.psonNum = psonNum;
	}

	public int getClaimDays() {
		return claimDays;
	}

	public void setClaimDays(int claimDays) {
		this.claimDays = claimDays;
	}

	@Override
	public String toString() {
		return "AppCvrg [cCvrgNo=" + cCvrgNo + ", cCvrgCode=" + cCvrgCode
				+ ", namt=" + namt + ", deductibles=" + deductibles
				+ ", isDeduct=" + isDeduct + ", psonNum=" + psonNum
				+ ", claimDays=" + claimDays + "]";
	}

	public AppCvrg() {
		super();
	}

	

}

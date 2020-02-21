package com.bom;

import java.io.Serializable;

/**
 * @author zhanglh
 * 设置要返回的险别信息
 */
//@Bom(name = "返回的可投保险别")
public class AppCvrgsBack implements Serializable {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8169890429849947167L;

	/**
	 * 险别代码
	 */
	private String aCvrgCode;
	
	/**
	 * 险别名称
	 */
	private String aCvrgNo;

	/**
	 * 最小投保金额
	 */
	private Double minAmount;
	
	/**
	 * 最大投保金额
	 */
	private Double maxAmount;
	
	/**
	 * 是否必保（0-否，1是）险别信息不为空时候，必须传
	 */
	private String isMust;

	/**
	 * @return aCvrgCode
	 */
	public String getaCvrgCode() {
		return aCvrgCode;
	}

	/**
	 * @param aCvrgCode 要设置的 aCvrgCode
	 */
	public void setaCvrgCode(String aCvrgCode) {
		this.aCvrgCode = aCvrgCode;
	}

	
	/**
	 * @return the aCvrgNo
	 */
	public String getaCvrgNo() {
		return aCvrgNo;
	}

	/**
	 * @param aCvrgNo the aCvrgNo to set
	 */
	public void setaCvrgNo(String aCvrgNo) {
		this.aCvrgNo = aCvrgNo;
	}

	/**
	 * @return minAmount
	 */
	public Double getMinAmount() {
		return minAmount;
	}

	/**
	 * @param minAmount 要设置的 minAmount
	 */
	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	/**
	 * @return maxAmount
	 */
	public Double getMaxAmount() {
		return maxAmount;
	}

	/**
	 * @param maxAmount 要设置的 maxAmount
	 */
	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	/**
	 * @return isMust
	 */
	public String getIsMust() {
		return isMust;
	}

	/**
	 * @param isMust 要设置的 isMust
	 */
	public void setIsMust(String isMust) {
		this.isMust = isMust;
	}

	@Override
	public String toString() {
		return "AppCvrgsBack [aCvrgCode=" + aCvrgCode + ", aCvrgNo=" + aCvrgNo
				+ ", minAmount=" + minAmount + ", maxAmount=" + maxAmount
				+ ", isMust=" + isMust + "]";
	}
}


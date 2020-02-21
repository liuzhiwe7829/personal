package com.bom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

//@Bom(name = "上年保单信息")
public class AppLastPolicy implements Serializable {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	/**
	 * 上年续保模式
	 */
//	@BomCodes(code = "上年续保模式")
	private String lastRenewalModel;
	public String getLastRenewalModel() {
		return lastRenewalModel;
	}

	public void setLastRenewalModel(String lastRenewalModel) {
		this.lastRenewalModel = lastRenewalModel;
	}

	/**
	 * 渠道
	 */
	private String lastBsnsType;
	
	/**
	 * 机构代码
	 */
	private String lastDptCde;
	
	/**
	 * 产品代码
	 */
	private String lastProdNo;
	
	/**
	 * 是否闭环
	 */
	private Boolean lastCircleFlag;
	
	/**
	 * 新渠道来源.
	 */
	private String lastNewBsnsType;
	
	/**
	 * 保险起期
	 */
	private Date lastBgnTm;
	
	/**
	 * 保险止期
	 */
	private Date lastEndTm;
	
	/**
	 * 上年车主名称
	 */
	private String lastCOwnerNme;
	
	/**
	 * 上年赔偿金额
	 */
	private Double lastClaimAmount;

	public String getLastBsnsType() {
		return lastBsnsType;
	}

	public void setLastBsnsType(String lastBsnsType) {
		this.lastBsnsType = lastBsnsType;
	}

	public String getLastDptCde() {
		return lastDptCde;
	}

	public void setLastDptCde(String lastDptCde) {
		this.lastDptCde = lastDptCde;
	}

	public String getLastProdNo() {
		return lastProdNo;
	}

	public void setLastProdNo(String lastProdNo) {
		this.lastProdNo = lastProdNo;
	}

	public Boolean getLastCircleFlag() {
		return lastCircleFlag;
	}

	public void setLastCircleFlag(Boolean lastCircleFlag) {
		this.lastCircleFlag = lastCircleFlag;
	}

	public String getLastNewBsnsType() {
		return lastNewBsnsType;
	}

	public void setLastNewBsnsType(String lastNewBsnsType) {
		this.lastNewBsnsType = lastNewBsnsType;
	}

	@XmlElement(name = "lastBgnTm", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getLastBgnTm() {
		return lastBgnTm;
	}

	public void setLastBgnTm(Date lastBgnTm) {
		this.lastBgnTm = lastBgnTm;
	}
	
	@XmlElement(name = "lastEndTm", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class) 
	public Date getLastEndTm() {
		return lastEndTm;
	}

	public void setLastEndTm(Date lastEndTm) {
		this.lastEndTm = lastEndTm;
	}

	public String getLastCOwnerNme() {
		return lastCOwnerNme;
	}

	public void setLastCOwnerNme(String lastCOwnerNme) {
		this.lastCOwnerNme = lastCOwnerNme;
	}

	public Double getLastClaimAmount() {
		return lastClaimAmount;
	}

	public void setLastClaimAmount(Double lastClaimAmount) {
		this.lastClaimAmount = lastClaimAmount;
	}

	@Override
	public String toString() {
		return "AppLastPolicy [lastRenewalModel=" + lastRenewalModel
				+ ", lastBsnsType=" + lastBsnsType + ", lastDptCde="
				+ lastDptCde + ", lastProdNo=" + lastProdNo
				+ ", lastCircleFlag=" + lastCircleFlag + ", lastNewBsnsType="
				+ lastNewBsnsType + ", lastBgnTm=" + lastBgnTm + ", lastEndTm="
				+ lastEndTm + ", lastCOwnerNme=" + lastCOwnerNme
				+ ", lastClaimAmount=" + lastClaimAmount + "]";
	}

	public AppLastPolicy() {
		super();
	}

	

	
}

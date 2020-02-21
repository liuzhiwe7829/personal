/**
 * @(#) AppBaseDto.java
 * Copyright(c) 2006-2013 深圳市麦亚信科技资讯有限公司  版权扄1?7朄1?7
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
 *基本信息
 * @author chenjp
 */
//@Bom(name = "基本信息")
public class AppBase implements Serializable{


//	private static final long serialVersionUID = 1L;
	
	/**费率添加 */
	/**
	 * 分公司
	 */
//	@BomCodes(code="分公司")
	private String branCompany;
	/**
	 * 三级机构
	 */
//	@BomCodes(code="三级机构")
	private String thirdDpt;
	
	/**
	 * 明细机构
	 */
//	@BomCodes(code="明细机构")
	private String detailDpt;
	
	/**
	 * 险种
	 */
//	@BomCodes(code = "费率险种")
	private String feeRiskCode;
	/**
	 * 渠道类别
	 */
//	@BomCodes(code="渠道类别")
	private String channelType;
	/**
	 * 业务合作来源
	 */
//	@BomCodes(code = "业务合作来源")
	private String cooperateBsnsTyp;
	/**
	 * 是否含车损
	 */
//	@BomCodes(code = "是否含车损")
	private Boolean haveCarDameType;
	/**
	 * 出险次数
	 */
//	@BomCodes(code = "出险次数(平台次数)")
	private Integer dameTimes;
	
	/**
	 * 总体折扣(税前)
	 */
//	@BomCodes(code = "总体折扣(税前)")
	private Double preTaxTotalDiscount;
	/**
	 * 总体折扣(税后)
	 */
//	@BomCodes(code = "总体折扣(税后)")
	private Double afterTaxTotalDiscount;
	/**
	 * 通融类型
	 */
//	@BomCodes(code = "通融类型")
	private String exceptionTyp;
	
	/**
	 * 三者保额
	 */
//	 @BomCodes(code="三者保额")
	 private String threeOfNamt;
	 
	/**
	 * 不含税保费
	 */
//	@BomCodes(code = "不含税保费")
	private Double basePrmNoTax;
	/**
	 * 录单人员
	 */
//	@BomCodes(code = "录单人员")
	private String tOprName;
	/**
	 * 是否VIP
	 */
//	@BomCodes(code = "是否VIP")
	private Boolean vip;
	/**
	 * 微营销光博业务分类
	 */
//	@BomCodes(code = "光博业务分类")
	private String CWeRisk;
	
	/**
	 * 保单号
	 */
//	@BomBizkey(isBizkey = true)
	private String cAppNo;
	
	/**
	 * 代理人编码
	 */
//	@BomCodes(code="代理人")
	private String cBrkrCde;
	
	/**
	 * 代理渠道 --费率 业务来源
	 */
//	@BomCodes(code="业务来源")
	private String cBsnsTyp;
	
	/**
	 * 机构代码
	 */
//	@BomCodes(code = "机构代码")
//	@BomHierarchy(isHierarchical = true)
	private String cDptCDE;
	
	/**
	 * 微营销机构代码
	 */
//	@BomCodes(code = "微营销机构")
//	@BomHierarchy(isHierarchical = true)
	private String weChatDept;
	
	/**
	 * 是否续保标志
	 */
//	@BomCodes(code = "是否续保")
	private Boolean renewalFlag;
	
	/**
	 * 产品代码
	 */
//	@BomCodes(code="产品代码")
	private String cProdNo;
	
	/**
	 * 短期费率类型
	 */
	private String cRatioTyp;
	
	/**
	 * 是否闭环
	 */
//	@BomCodes(code="是否闭环")
	private Boolean circleFlag;
	
	/**
	 * 短期费率
	 */
	private Double nRatioCoef;
	
	/**
	 * 保险起期
	 */
//	@BomCodes(code = "保险起期")
	private Date tInsrncBgnTm;
	
	/**
	 * 保险止期
	 */
//	@BomCodes(code = "保险止期")
	private Date tInsrncEndTm;
	
	/**
	 * 录单日期
	 */
	private Date tOprTm;
	
	/**
	 * 特别约定
	 */
	private String fixSpec;
	
	/**
	 * 业务类型
	 */
	private String taskType;
	
	/**
	 * 代理人名称
	 */
//	@BomCodes(code = "代理人名称")
	private String cBrkrName;

	
	/**
	 * 总保险金预
	 */
	private Double totalNum;
	
	/**
	 * 保险期限
	 * @return
	 */
	private Integer tInsrncDay;
	
	/**
	 * 争议解决方式
	 * @return
	 */
	private String argueDel;
	
	/**
	 * 签单日期. 费率维度-签单日期
	 */
//	@BomCodes(code = "签单日期")
	private Date tSignDate;
	
	/**
	 * 新渠道来源.
	 */
	private String cNewBsnsTyp;
	
	/**
	 * 手续费比例.
	 */
	private Double nCommProp;
	
	/**
	 * 投保方式
	 */
	private String appType;
	
	/**
	 * 是否批改
	 */
	private Boolean endrFlag;
	
	/**
	 * 保费变化
	 */
	private Double premiumVar;
	
	/**
	 * 批改原因
	 */
	private String endrReason;
	
	/**
	 * 出单系统
	 */
//	@BomCodes(code="数据来源")
	private String dataSystem;
	
	/**
	 * 店长纬度
	 */
//	@BomCodes(code="店长")
	private String supervisorCode;
	
	/**
	 * 店长名称
	 */
	private String supervisorName;
	
	/**
	 * 店长身份证号
	 */
	private String supervisorCDNo;
	
	/**
	 * 虚拟计算标志
	 */
	private String falseCountFlagS;
	
	/**
	 * 期望折扣是否低于广博折扣(0-否，1-是)
	 */
	private String isDiscountCut;
	
	/**
	 * 往年是否批改发动机号（0:没批改 1:批改过）
	 */
	private String isFyEng;
	
	/**
	 * 往年是否批改车架号（0:没批改 1:批改过） 
	 */
	private String isFyFrm;
	
	/**
	 * 是否仅税务信息变化（0:否 1:是）
	 */
	private String isOnlyTaxChange;
	
	/**
	 * 是否仅涉及车牌号变化（0:否 1:是） 
	 */
	private String isOnlyPlateNoChange;
	
	/**
	 * 原发动机号
	 */
	private String oldCEngNo;
	
	/**
	 * 原车架号 
	 */
	private String oldCFrmNo;
	
	/**
	 * 影像列表中附件张数
	 */
	private int attachCount;
	
	/**
	 * 黑名单标志（0-否，1-是）
	 */
	private String isBlacklist;
	
	/**
	 * 提交核保时间
	 */
	private Date submitUdwrTime;
	
	/**
	 * 出单人名称
	 */
	private String cRecordCnm;
	
	/**
	 * 特殊客户类型
	 */
//	@BomCodes(code="特殊客户")
	private String specCustomer;
	
	/**
	 * 险别组合
	 */
//	@BomCodes(code="险别组合")
	private String cvrgComb;
	
	/**
	 * 投保类型(0：新车；1：续保；2：转保)
	 */
//	@BomCodes(code="投保类型")
	private String cBusType;
	
	/**
	 * 本年度签单保费
	 */
	private Double nBasePrm;
	
	/**
	 * 业务员代码
	 */
//	@BomCodes(code="业务员代码")
	private String cslsId;
	
	/**
	 * 业务员名称
	 */
//	@BomCodes(code="业务员名称")
	private String cslsName;
	
	/**
	 * 业务合作来源
	 */
	private String bCustPartner;
	
	
	public String getBranCompany() {
		return branCompany;
	}


	public void setBranCompany(String branCompany) {
		this.branCompany = branCompany;
	}


	public String getThirdDpt() {
		return thirdDpt;
	}


	public void setThirdDpt(String thirdDpt) {
		this.thirdDpt = thirdDpt;
	}


	public String getDetailDpt() {
		return detailDpt;
	}


	public void setDetailDpt(String detailDpt) {
		this.detailDpt = detailDpt;
	}


	public String getFeeRiskCode() {
		return feeRiskCode;
	}


	public void setFeeRiskCode(String feeRiskCode) {
		this.feeRiskCode = feeRiskCode;
	}


	public String getChannelType() {
		return channelType;
	}


	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}


	public String getCooperateBsnsTyp() {
		return cooperateBsnsTyp;
	}


	public void setCooperateBsnsTyp(String cooperateBsnsTyp) {
		this.cooperateBsnsTyp = cooperateBsnsTyp;
	}


	public Boolean getHaveCarDameType() {
		return haveCarDameType;
	}


	public void setHaveCarDameType(Boolean haveCarDameType) {
		this.haveCarDameType = haveCarDameType;
	}


	public Integer getDameTimes() {
		return dameTimes;
	}


	public void setDameTimes(Integer dameTimes) {
		this.dameTimes = dameTimes;
	}


	public Double getPreTaxTotalDiscount() {
		return preTaxTotalDiscount;
	}


	public void setPreTaxTotalDiscount(Double preTaxTotalDiscount) {
		this.preTaxTotalDiscount = preTaxTotalDiscount;
	}


	public Double getAfterTaxTotalDiscount() {
		return afterTaxTotalDiscount;
	}


	public void setAfterTaxTotalDiscount(Double afterTaxTotalDiscount) {
		this.afterTaxTotalDiscount = afterTaxTotalDiscount;
	}


	public String getExceptionTyp() {
		return exceptionTyp;
	}


	public void setExceptionTyp(String exceptionTyp) {
		this.exceptionTyp = exceptionTyp;
	}


	public String getThreeOfNamt() {
		return threeOfNamt;
	}


	public void setThreeOfNamt(String threeOfNamt) {
		this.threeOfNamt = threeOfNamt;
	}


	public Double getBasePrmNoTax() {
		return basePrmNoTax;
	}


	public void setBasePrmNoTax(Double basePrmNoTax) {
		this.basePrmNoTax = basePrmNoTax;
	}


	public String gettOprName() {
		return tOprName;
	}


	public void settOprName(String tOprName) {
		this.tOprName = tOprName;
	}


	public Boolean getVip() {
		return vip;
	}


	public void setVip(Boolean vip) {
		this.vip = vip;
	}


	public String getCWeRisk() {
		return CWeRisk;
	}


	public void setCWeRisk(String cWeRisk) {
		CWeRisk = cWeRisk;
	}


	public String getcAppNo() {
		return cAppNo;
	}


	public void setcAppNo(String cAppNo) {
		this.cAppNo = cAppNo;
	}


	public String getcBrkrCde() {
		return cBrkrCde;
	}


	public void setcBrkrCde(String cBrkrCde) {
		this.cBrkrCde = cBrkrCde;
	}


	public String getcBsnsTyp() {
		return cBsnsTyp;
	}


	public void setcBsnsTyp(String cBsnsTyp) {
		this.cBsnsTyp = cBsnsTyp;
	}


	public String getcDptCDE() {
		return cDptCDE;
	}


	public void setcDptCDE(String cDptCDE) {
		this.cDptCDE = cDptCDE;
	}


	public String getWeChatDept() {
		return weChatDept;
	}


	public void setWeChatDept(String weChatDept) {
		this.weChatDept = weChatDept;
	}


	public Boolean getRenewalFlag() {
		return renewalFlag;
	}


	public void setRenewalFlag(Boolean renewalFlag) {
		this.renewalFlag = renewalFlag;
	}


	public String getcProdNo() {
		return cProdNo;
	}


	public void setcProdNo(String cProdNo) {
		this.cProdNo = cProdNo;
	}


	public String getcRatioTyp() {
		return cRatioTyp;
	}


	public void setcRatioTyp(String cRatioTyp) {
		this.cRatioTyp = cRatioTyp;
	}


	public Boolean getCircleFlag() {
		return circleFlag;
	}


	public void setCircleFlag(Boolean circleFlag) {
		this.circleFlag = circleFlag;
	}


	public Double getnRatioCoef() {
		return nRatioCoef;
	}


	public void setnRatioCoef(Double nRatioCoef) {
		this.nRatioCoef = nRatioCoef;
	}

	@XmlElement(name = "tInsrncBgnTm", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date gettInsrncBgnTm() {
		return tInsrncBgnTm;
	}


	public void settInsrncBgnTm(Date tInsrncBgnTm) {
		this.tInsrncBgnTm = tInsrncBgnTm;
	}

	@XmlElement(name = "tInsrncEndTm", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date gettInsrncEndTm() {
		return tInsrncEndTm;
	}


	public void settInsrncEndTm(Date tInsrncEndTm) {
		this.tInsrncEndTm = tInsrncEndTm;
	}

	@XmlElement(name = "tOprTm", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date gettOprTm() {
		return tOprTm;
	}


	public void settOprTm(Date tOprTm) {
		this.tOprTm = tOprTm;
	}


	public String getFixSpec() {
		return fixSpec;
	}


	public void setFixSpec(String fixSpec) {
		this.fixSpec = fixSpec;
	}


	public String getTaskType() {
		return taskType;
	}


	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


	public String getcBrkrName() {
		return cBrkrName;
	}


	public void setcBrkrName(String cBrkrName) {
		this.cBrkrName = cBrkrName;
	}


	public Double getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(Double totalNum) {
		this.totalNum = totalNum;
	}


	public Integer gettInsrncDay() {
		return tInsrncDay;
	}


	public void settInsrncDay(Integer tInsrncDay) {
		this.tInsrncDay = tInsrncDay;
	}


	public String getArgueDel() {
		return argueDel;
	}


	public void setArgueDel(String argueDel) {
		this.argueDel = argueDel;
	}

	@XmlElement(name = "tSignDate", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date gettSignDate() {
		return tSignDate;
	}


	public void settSignDate(Date tSignDate) {
		this.tSignDate = tSignDate;
	}


	public String getcNewBsnsTyp() {
		return cNewBsnsTyp;
	}


	public void setcNewBsnsTyp(String cNewBsnsTyp) {
		this.cNewBsnsTyp = cNewBsnsTyp;
	}


	public Double getnCommProp() {
		return nCommProp;
	}


	public void setnCommProp(Double nCommProp) {
		this.nCommProp = nCommProp;
	}


	public String getAppType() {
		return appType;
	}


	public void setAppType(String appType) {
		this.appType = appType;
	}


	public Boolean getEndrFlag() {
		return endrFlag;
	}


	public void setEndrFlag(Boolean endrFlag) {
		this.endrFlag = endrFlag;
	}


	public Double getPremiumVar() {
		return premiumVar;
	}


	public void setPremiumVar(Double premiumVar) {
		this.premiumVar = premiumVar;
	}


	public String getEndrReason() {
		return endrReason;
	}


	public void setEndrReason(String endrReason) {
		this.endrReason = endrReason;
	}


	public String getDataSystem() {
		return dataSystem;
	}


	public void setDataSystem(String dataSystem) {
		this.dataSystem = dataSystem;
	}


	public String getSupervisorCode() {
		return supervisorCode;
	}


	public void setSupervisorCode(String supervisorCode) {
		this.supervisorCode = supervisorCode;
	}


	public String getSupervisorName() {
		return supervisorName;
	}


	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}


	public String getSupervisorCDNo() {
		return supervisorCDNo;
	}


	public void setSupervisorCDNo(String supervisorCDNo) {
		this.supervisorCDNo = supervisorCDNo;
	}


	public String getFalseCountFlagS() {
		return falseCountFlagS;
	}


	public void setFalseCountFlagS(String falseCountFlagS) {
		this.falseCountFlagS = falseCountFlagS;
	}


	public String getIsDiscountCut() {
		return isDiscountCut;
	}


	public void setIsDiscountCut(String isDiscountCut) {
		this.isDiscountCut = isDiscountCut;
	}


	public String getIsFyEng() {
		return isFyEng;
	}


	public void setIsFyEng(String isFyEng) {
		this.isFyEng = isFyEng;
	}


	public String getIsFyFrm() {
		return isFyFrm;
	}


	public void setIsFyFrm(String isFyFrm) {
		this.isFyFrm = isFyFrm;
	}


	public String getIsOnlyTaxChange() {
		return isOnlyTaxChange;
	}


	public void setIsOnlyTaxChange(String isOnlyTaxChange) {
		this.isOnlyTaxChange = isOnlyTaxChange;
	}


	public String getIsOnlyPlateNoChange() {
		return isOnlyPlateNoChange;
	}


	public void setIsOnlyPlateNoChange(String isOnlyPlateNoChange) {
		this.isOnlyPlateNoChange = isOnlyPlateNoChange;
	}


	public String getOldCEngNo() {
		return oldCEngNo;
	}


	public void setOldCEngNo(String oldCEngNo) {
		this.oldCEngNo = oldCEngNo;
	}


	public String getOldCFrmNo() {
		return oldCFrmNo;
	}


	public void setOldCFrmNo(String oldCFrmNo) {
		this.oldCFrmNo = oldCFrmNo;
	}


	public int getAttachCount() {
		return attachCount;
	}


	public void setAttachCount(int attachCount) {
		this.attachCount = attachCount;
	}


	public String getIsBlacklist() {
		return isBlacklist;
	}


	public void setIsBlacklist(String isBlacklist) {
		this.isBlacklist = isBlacklist;
	}

	@XmlElement(name = "submitUdwrTime", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getSubmitUdwrTime() {
		return submitUdwrTime;
	}


	public void setSubmitUdwrTime(Date submitUdwrTime) {
		this.submitUdwrTime = submitUdwrTime;
	}


	public String getcRecordCnm() {
		return cRecordCnm;
	}


	public void setcRecordCnm(String cRecordCnm) {
		this.cRecordCnm = cRecordCnm;
	}


	public String getSpecCustomer() {
		return specCustomer;
	}


	public void setSpecCustomer(String specCustomer) {
		this.specCustomer = specCustomer;
	}


	public String getCvrgComb() {
		return cvrgComb;
	}


	public void setCvrgComb(String cvrgComb) {
		this.cvrgComb = cvrgComb;
	}


	public String getcBusType() {
		return cBusType;
	}


	public void setcBusType(String cBusType) {
		this.cBusType = cBusType;
	}


	public Double getnBasePrm() {
		return nBasePrm;
	}


	public void setnBasePrm(Double nBasePrm) {
		this.nBasePrm = nBasePrm;
	}


	public String getCslsId() {
		return cslsId;
	}


	public void setCslsId(String cslsId) {
		this.cslsId = cslsId;
	}


	public String getCslsName() {
		return cslsName;
	}


	public void setCslsName(String cslsName) {
		this.cslsName = cslsName;
	}


	public String getbCustPartner() {
		return bCustPartner;
	}


	public void setbCustPartner(String bCustPartner) {
		this.bCustPartner = bCustPartner;
	}

	@Override
	public String toString() {
		return "AppBase [branCompany=" + branCompany + ", thirdDpt=" + thirdDpt
				+ ", detailDpt=" + detailDpt + ", feeRiskCode=" + feeRiskCode
				+ ", channelType=" + channelType + ", cooperateBsnsTyp="
				+ cooperateBsnsTyp + ", haveCarDameType=" + haveCarDameType
				+ ", dameTimes=" + dameTimes + ", preTaxTotalDiscount="
				+ preTaxTotalDiscount + ", afterTaxTotalDiscount="
				+ afterTaxTotalDiscount + ", exceptionTyp=" + exceptionTyp
				+ ", threeOfNamt=" + threeOfNamt + ", basePrmNoTax="
				+ basePrmNoTax + ", tOprName=" + tOprName + ", vip=" + vip
				+ ", CWeRisk=" + CWeRisk + ", cAppNo=" + cAppNo + ", cBrkrCde="
				+ cBrkrCde + ", cBsnsTyp=" + cBsnsTyp + ", cDptCDE=" + cDptCDE
				+ ", weChatDept=" + weChatDept + ", renewalFlag=" + renewalFlag
				+ ", cProdNo=" + cProdNo + ", cRatioTyp=" + cRatioTyp
				+ ", circleFlag=" + circleFlag + ", nRatioCoef=" + nRatioCoef
				+ ", tInsrncBgnTm=" + tInsrncBgnTm + ", tInsrncEndTm="
				+ tInsrncEndTm + ", tOprTm=" + tOprTm + ", fixSpec=" + fixSpec
				+ ", taskType=" + taskType + ", cBrkrName=" + cBrkrName
				+ ", totalNum=" + totalNum + ", tInsrncDay=" + tInsrncDay
				+ ", argueDel=" + argueDel + ", tSignDate=" + tSignDate
				+ ", cNewBsnsTyp=" + cNewBsnsTyp + ", nCommProp=" + nCommProp
				+ ", appType=" + appType + ", endrFlag=" + endrFlag
				+ ", premiumVar=" + premiumVar + ", endrReason=" + endrReason
				+ ", dataSystem=" + dataSystem + ", supervisorCode="
				+ supervisorCode + ", supervisorName=" + supervisorName
				+ ", supervisorCDNo=" + supervisorCDNo + ", falseCountFlagS="
				+ falseCountFlagS + ", isDiscountCut=" + isDiscountCut
				+ ", isFyEng=" + isFyEng + ", isFyFrm=" + isFyFrm
				+ ", isOnlyTaxChange=" + isOnlyTaxChange
				+ ", isOnlyPlateNoChange=" + isOnlyPlateNoChange
				+ ", oldCEngNo=" + oldCEngNo + ", oldCFrmNo=" + oldCFrmNo
				+ ", attachCount=" + attachCount + ", isBlacklist="
				+ isBlacklist + ", submitUdwrTime=" + submitUdwrTime
				+ ", cRecordCnm=" + cRecordCnm + ", specCustomer="
				+ specCustomer + ", cvrgComb=" + cvrgComb + ", cBusType="
				+ cBusType + ", nBasePrm=" + nBasePrm + ", cslsId=" + cslsId
				+ ", cslsName=" + cslsName + ", bCustPartner=" + bCustPartner
				+ "]";
	}


	public AppBase() {
		super();
	}
	
}
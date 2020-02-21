/**
 * @(#) AppVhl.java
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
import java.util.List;

/**
 * 
 *投保车辆
 * @author chenjp
 */
//@Bom(name = "投保车辆")
public class AppVhl implements Serializable{


//	private static final long serialVersionUID = 1L;
	/** 费率新增 */
	/**
	 * 车系类别
	 */
//	@BomCodes(code = "(行业平台)车系类别")
	private String cFamilyTyp;
	/**
	 * 车辆牌照
	 */
//	@BomCodes(code="车辆牌照")
	private String vchLicence;
	
	/**
	 * 车辆品牌
	 */
//	@BomCodes(code="品牌")
	private String cBrand;
	
	/**
	 * 品牌ID
	 */
	private String cBrandId;
	
	/**
	 * 厂牌车型代码
	 */
	private String cVehicleId;
	
	/**
	 * 厂牌车型名称
	 */
//	@BomCodes(code="厂牌车型")
	private String cVehicleName;
	
	/**
	 * 型号编码
	 */
	private String cModelCode;
	
	/**
	 * 车系名称
	 */
//	@BomCodes(code="车系")
	private String cFamilyName;
	
	/**
	 * 车系代码
	 */
	private String cFamilyCde;
	
	/**
	 * 外地车标志
	 */
	private Boolean cEcdemicMrk;
	
	/**
	 * 车架号
	 */
	private String cFrmNo;
	
	/**
	 * 初登日期
	 */
	private Date cFstRegYm;
	
	/**
	 * 制造年份
	 */
	private Date cMfgYear;
	
	/**
	 * 新车标识
	 */
//	@BomCodes(code="新旧车标识")
	private String cNewMrk;
	
	/**
	 * 车牌号
	 */
	private String cPlateNo;

	/**
	 * 使用性质
	 */
//	@BomCodes(code="使用性质")
	private String cVhlcategoryCde;
	
	
	/**
	 * 车辆类型
	 */
//	@BomCodes(code="车辆类型")
	private String nVhlTyp;
	
	/**
	 * 排气量
	 */
	private Double nDisplacement;
	
	/**
	 * 新车购置价
	 */
	private Double nNewPurchaseValue;
	
	
	private Double nPriceFloat;
	
	/**
	 * 核定座位数
	 */
	private Double nSeatNum;
	
	/**
	 * 乘客数
	 */
	private Double npassengerNum;
	
	/**
	 * 吨位
	 */
//	@BomCodes(code="吨位数")
	private Double nton;
	
	/**
	 * 过户车标志
	 */
//	@BomCodes(code="过户车标识")
	private String transferFlag;
	
	/**
	 * 所属性质
	 */
//	@BomCodes(code="所属性质")
	private String belongType;
	
	/**
	 * 号牌种类
	 */
	private String plateNoType;	
	
	/**
	 * 验车情况
	 */
	private String carChecked;
	
	/**
	 * 折旧价格
	 */
	private Double nActualValue;
	
	/**
	 * 新车购置价
	 */
	private Double vPurchaseValueJy;
	
	/**
	 * 打印车型名称
	 */
	private String vVhlPrnName;
	
	/**
	 * 车龄 费用跟单维度
	 */
	private Double carAge;
	
	/**
	 * 车型风险类别
	 */
	private String cRiskCate;
	
	/**
	 * 玻璃类型
	 */
	private String glassType;
	
	
	/**
	 * 车辆国产进口标识
	 */
	private String domescImports;
	
	/**
	 * 是否按揭
	 */
	private String isMort;
	
	/**
	 * 行驶证车辆类型.
	 */
	private String drvLiscneTyp;
	
	/**
	 * 是否团车业务.
	 */
	private String isTeam;
	
	/**
	 * 车损确定方式.
	 */
	private String carDameType;
	
	/**
	 * 平台车型代码
	 */
	private String cPlatVhlId;
	
	/**
	 * 风险保费类型
	 */
	private String cPremiumFlag;

	/**
	 * 验车标志（0否，1是）
	 */
	private String checkFlag;
	
	/**
	 * 是否提供验车照（0否，1是）
	 */
	private String isEnclosure;
	
	/**
	 * 发动机号
	 */
	private String cEngNo;
	
	/**
	 * 国产/进口标志（国产0，进口1）
	 */
	private String cProdPlace;
	
	/**
	 * 车型包代码
	 */
	private List<String> vhlPakageId;
	
	/**
	 * 协商价格
	 */
	private Double vhlConsultValue;
	
	/**
	 * 过户时间
	 */
	private Date tTransferDate;
	
	/**
	 * 车辆能源类型
	 */
	private String cFuelType;
	
	/**
	 * 精友车辆类型
	 */
	private String mVehicleType;
	
	/**
	 * 精友核定载客数
	 */
	private Double mSeatNum;
	
	/**
	 * 精友吨位数
	 */
	private Double mCountCode;
	
	/**
	 * 使用年限(年)区间
	 */
//	@BomCodes(code = "使用年限(年)")
	private String usefulLifeSection;
	
	/**
	 * 车价区间(新车购置价)
	 */
//	@BomCodes(code="车价区间(新车购置价)")
	private String newPurchaseSection;
	
	/**
	 * 车价区间(协商价)
	 */
//	@BomCodes(code = "车价区间(协商价)")
	private String vhlConsultSection;
	

	/**
	 * @return the usefulLifeSection
	 */
	public String getUsefulLifeSection() {
		return usefulLifeSection;
	}

	/**
	 * @param usefulLifeSection the usefulLifeSection to set
	 */
	public void setUsefulLifeSection(String usefulLifeSection) {
		this.usefulLifeSection = usefulLifeSection;
	}

	/**
	 * @return the newPurchaseSection
	 */
	public String getNewPurchaseSection() {
		return newPurchaseSection;
	}

	/**
	 * @param newPurchaseSection the newPurchaseSection to set
	 */
	public void setNewPurchaseSection(String newPurchaseSection) {
		this.newPurchaseSection = newPurchaseSection;
	}

	/**
	 * @return the vhlConsultSection
	 */
	public String getVhlConsultSection() {
		return vhlConsultSection;
	}

	/**
	 * @param vhlConsultSection the vhlConsultSection to set
	 */
	public void setVhlConsultSection(String vhlConsultSection) {
		this.vhlConsultSection = vhlConsultSection;
	}

	public Double getnActualValue() {
		return nActualValue;
	}

	public void setnActualValue(Double nActualValue) {
		this.nActualValue = nActualValue;
	}
	
	
	
	public String getVhlPrnName() {
		return vVhlPrnName;
	}

	public void setVhlPrnName(String vhlPrnName) {
		vVhlPrnName = vhlPrnName;
	}
	
	public Double getvPurchaseValueJy() {
		return vPurchaseValueJy;
	}

	public void setvPurchaseValueJy(Double vPurchaseValueJy) {
		this.vPurchaseValueJy = vPurchaseValueJy;
	}
	
	public String getcFamilyTyp() {
		return cFamilyTyp;
	}

	public void setcFamilyTyp(String cFamilyTyp) {
		this.cFamilyTyp = cFamilyTyp;
	}

	public String getVchLicence() {
		return vchLicence;
	}

	public void setVchLicence(String vchLicence) {
		this.vchLicence = vchLicence;
	}
	

	public String getcBrand() {
		return cBrand;
	}

	public void setcBrand(String cBrand) {
		this.cBrand = cBrand;
	}

	public String getcBrandId() {
		return cBrandId;
	}

	public void setcBrandId(String cBrandId) {
		this.cBrandId = cBrandId;
	}

	public String getcVehicleId() {
		return cVehicleId;
	}

	public void setcVehicleId(String cVehicleId) {
		this.cVehicleId = cVehicleId;
	}

	public String getcVehicleName() {
		return cVehicleName;
	}

	public void setcVehicleName(String cVehicleName) {
		this.cVehicleName = cVehicleName;
	}

	public String getcModelCode() {
		return cModelCode;
	}

	public void setcModelCode(String cModelCode) {
		this.cModelCode = cModelCode;
	}

	public String getcFamilyName() {
		return cFamilyName;
	}

	public void setcFamilyName(String cFamilyName) {
		this.cFamilyName = cFamilyName;
	}

	public String getcFamilyCde() {
		return cFamilyCde;
	}

	public void setcFamilyCde(String cFamilyCde) {
		this.cFamilyCde = cFamilyCde;
	}

	public Boolean getcEcdemicMrk() {
		return cEcdemicMrk;
	}

	public void setcEcdemicMrk(Boolean cEcdemicMrk) {
		this.cEcdemicMrk = cEcdemicMrk;
	}

	public String getcFrmNo() {
		return cFrmNo;
	}

	public void setcFrmNo(String cFrmNo) {
		this.cFrmNo = cFrmNo;
	}
	public Date getcFstRegYm() {
		return cFstRegYm;
	}

	public void setcFstRegYm(Date cFstRegYm) {
		this.cFstRegYm = cFstRegYm;
	}
	@XmlElement(name = "cMfgYear", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getcMfgYear() {
		return cMfgYear;
	}

	public void setcMfgYear(Date cMfgYear) {
		this.cMfgYear = cMfgYear;
	}

	public String getcNewMrk() {
		return cNewMrk;
	}

	public void setcNewMrk(String cNewMrk) {
		this.cNewMrk = cNewMrk;
	}

	public String getcPlateNo() {
		return cPlateNo;
	}

	public void setcPlateNo(String cPlateNo) {
		this.cPlateNo = cPlateNo;
	}

	public String getcVhlcategoryCde() {
		return cVhlcategoryCde;
	}

	public void setcVhlcategoryCde(String cVhlcategoryCde) {
		this.cVhlcategoryCde = cVhlcategoryCde;
	}

	public String getnVhlTyp() {
		return nVhlTyp;
	}

	public void setnVhlTyp(String nVhlTyp) {
		this.nVhlTyp = nVhlTyp;
	}

	public Double getnDisplacement() {
		return nDisplacement;
	}

	public void setnDisplacement(Double nDisplacement) {
		this.nDisplacement = nDisplacement;
	}

	public Double getnNewPurchaseValue() {
		return nNewPurchaseValue;
	}

	public void setnNewPurchaseValue(Double nNewPurchaseValue) {
		this.nNewPurchaseValue = nNewPurchaseValue;
	}

	public Double getnPriceFloat() {
		return nPriceFloat;
	}

	public void setnPriceFloat(Double nPriceFloat) {
		this.nPriceFloat = nPriceFloat;
	}

	public Double getnSeatNum() {
		return nSeatNum;
	}

	public void setnSeatNum(Double nSeatNum) {
		this.nSeatNum = nSeatNum;
	}

	public Double getNpassengerNum() {
		return npassengerNum;
	}

	public void setNpassengerNum(Double npassengerNum) {
		this.npassengerNum = npassengerNum;
	}

	public Double getNton() {
		return nton;
	}

	public void setNton(Double nton) {
		this.nton = nton;
	}

	public String getTransferFlag() {
		return transferFlag;
	}

	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getPlateNoType() {
		return plateNoType;
	}

	public void setPlateNoType(String plateNoType) {
		this.plateNoType = plateNoType;
	}

	public String getCarChecked() {
		return carChecked;
	}

	public void setCarChecked(String carChecked) {
		this.carChecked = carChecked;
	}

	public String getvVhlPrnName() {
		return vVhlPrnName;
	}

	public void setvVhlPrnName(String vVhlPrnName) {
		this.vVhlPrnName = vVhlPrnName;
	}

	public Double getCarAge() {
		return carAge;
	}

	public void setCarAge(Double carAge) {
		this.carAge = carAge;
	}

	public String getcRiskCate() {
		return cRiskCate;
	}

	public void setcRiskCate(String cRiskCate) {
		this.cRiskCate = cRiskCate;
	}

	public String getGlassType() {
		return glassType;
	}

	public void setGlassType(String glassType) {
		this.glassType = glassType;
	}

	public String getDomescImports() {
		return domescImports;
	}

	public void setDomescImports(String domescImports) {
		this.domescImports = domescImports;
	}

	public String getIsMort() {
		return isMort;
	}

	public void setIsMort(String isMort) {
		this.isMort = isMort;
	}

	public String getDrvLiscneTyp() {
		return drvLiscneTyp;
	}

	public void setDrvLiscneTyp(String drvLiscneTyp) {
		this.drvLiscneTyp = drvLiscneTyp;
	}

	public String getIsTeam() {
		return isTeam;
	}

	public void setIsTeam(String isTeam) {
		this.isTeam = isTeam;
	}

	public String getCarDameType() {
		return carDameType;
	}

	public void setCarDameType(String carDameType) {
		this.carDameType = carDameType;
	}

	public String getcPlatVhlId() {
		return cPlatVhlId;
	}

	public void setcPlatVhlId(String cPlatVhlId) {
		this.cPlatVhlId = cPlatVhlId;
	}

	public String getcPremiumFlag() {
		return cPremiumFlag;
	}

	public void setcPremiumFlag(String cPremiumFlag) {
		this.cPremiumFlag = cPremiumFlag;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getIsEnclosure() {
		return isEnclosure;
	}

	public void setIsEnclosure(String isEnclosure) {
		this.isEnclosure = isEnclosure;
	}

	public String getcEngNo() {
		return cEngNo;
	}

	public void setcEngNo(String cEngNo) {
		this.cEngNo = cEngNo;
	}

	public String getcProdPlace() {
		return cProdPlace;
	}

	public void setcProdPlace(String cProdPlace) {
		this.cProdPlace = cProdPlace;
	}

	public List<String> getVhlPakageId() {
		return vhlPakageId;
	}

	public void setVhlPakageId(List<String> vhlPakageId) {
		this.vhlPakageId = vhlPakageId;
	}

	public Double getVhlConsultValue() {
		return vhlConsultValue;
	}

	public void setVhlConsultValue(Double vhlConsultValue) {
		this.vhlConsultValue = vhlConsultValue;
	}
	@XmlElement(name = "tTransferDate", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date gettTransferDate() {
		return tTransferDate;
	}

	public void settTransferDate(Date tTransferDate) {
		this.tTransferDate = tTransferDate;
	}

	public String getcFuelType() {
		return cFuelType;
	}

	public void setcFuelType(String cFuelType) {
		this.cFuelType = cFuelType;
	}

	public String getmVehicleType() {
		return mVehicleType;
	}

	public void setmVehicleType(String mVehicleType) {
		this.mVehicleType = mVehicleType;
	}

	public Double getmSeatNum() {
		return mSeatNum;
	}

	public void setmSeatNum(Double mSeatNum) {
		this.mSeatNum = mSeatNum;
	}

	public Double getmCountCode() {
		return mCountCode;
	}

	public void setmCountCode(Double mCountCode) {
		this.mCountCode = mCountCode;
	}


	public AppVhl() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppVhl [cFamilyTyp=" + cFamilyTyp + ", vchLicence="
				+ vchLicence + ", cBrand=" + cBrand + ", cBrandId=" + cBrandId
				+ ", cVehicleId=" + cVehicleId + ", cVehicleName="
				+ cVehicleName + ", cModelCode=" + cModelCode
				+ ", cFamilyName=" + cFamilyName + ", cFamilyCde=" + cFamilyCde
				+ ", cEcdemicMrk=" + cEcdemicMrk + ", cFrmNo=" + cFrmNo
				+ ", cFstRegYm=" + cFstRegYm + ", cMfgYear=" + cMfgYear
				+ ", cNewMrk=" + cNewMrk + ", cPlateNo=" + cPlateNo
				+ ", cVhlcategoryCde=" + cVhlcategoryCde + ", nVhlTyp="
				+ nVhlTyp + ", nDisplacement=" + nDisplacement
				+ ", nNewPurchaseValue=" + nNewPurchaseValue + ", nPriceFloat="
				+ nPriceFloat + ", nSeatNum=" + nSeatNum + ", npassengerNum="
				+ npassengerNum + ", nton=" + nton + ", transferFlag="
				+ transferFlag + ", belongType=" + belongType
				+ ", plateNoType=" + plateNoType + ", carChecked=" + carChecked
				+ ", nActualValue=" + nActualValue + ", vPurchaseValueJy="
				+ vPurchaseValueJy + ", vVhlPrnName=" + vVhlPrnName
				+ ", carAge=" + carAge + ", cRiskCate=" + cRiskCate
				+ ", glassType=" + glassType + ", domescImports="
				+ domescImports + ", isMort=" + isMort + ", drvLiscneTyp="
				+ drvLiscneTyp + ", isTeam=" + isTeam + ", carDameType="
				+ carDameType + ", cPlatVhlId=" + cPlatVhlId
				+ ", cPremiumFlag=" + cPremiumFlag + ", checkFlag=" + checkFlag
				+ ", isEnclosure=" + isEnclosure + ", cEngNo=" + cEngNo
				+ ", cProdPlace=" + cProdPlace + ", vhlPakageId=" + vhlPakageId
				+ ", vhlConsultValue=" + vhlConsultValue + ", tTransferDate="
				+ tTransferDate + ", cFuelType=" + cFuelType
				+ ", mVehicleType=" + mVehicleType + ", mSeatNum=" + mSeatNum
				+ ", mCountCode=" + mCountCode + ", usefulLifeSection="
				+ usefulLifeSection + ", newPurchaseSection="
				+ newPurchaseSection + ", vhlConsultSection="
				+ vhlConsultSection + "]";
	}

}

﻿﻿<%@ include file="/WEB-INF/views/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="/WEB-INF/views/commons/head.jsp"%>
	</head>
	<script type="text/javascript">
	var checkCarUserNatureFlag=true;
	var checkCarUserNatureMsg="";
	var checkCarUseTypeFlag=true;
	var checkCarUseTypeMsg="";
    	<%--页面加载触发--%>
	$(document).ready(function(){
		// setReadonlyOfElement(document.getElementById("quMotorDomainUseNatureShow"));
		// setReadonlyOfElement(document.getElementById("quMotorDomainAttachNature"));
		// setReadonlyOfElement(document.getElementById("quMotorDomainActualValue"));//实际价值
		// setReadonlyOfElement(document.getElementById("quMotorDomainCarUseType1"));
		 //setReadonlyOfElement(document.getElementById("quMotorDomainBrandName"));
		  initChgOwnerFlag2();//初始化过户标志
		  initLicenseNoFlag();//暂未上牌标志初始化
		  initCarUseType();//车辆用途
		 // getModelcarByCode();//获取平台车型
		  initModelPurchasePrice();
		  initOuterFlag();
		  initRenewFrameNo();//续保不允许修改车架号
		  //initCarCheck();//初始化验车标识
		  // initCarCheckNew();//初始化验车标识 新
		  initIsSendEPolicy();//初始化 是否发送电子保单
		  initIsSendEProposal();//初始化 是否发送电子投保单
		  initLoanVehicleFlag();//初始化 是否车贷投保多年标志
		  checkJsJGbutton();
		  checkSCJGbutton();
		  checkGdJGbutton();
		  checkOrganizationCode();//根据证件类型校验证件号码
		  takeOutLicenseNoArea();//带出新车地区
		  getPowerTypeForPurchasePrice();//能源类型包含“电”时可以向下调整新车购置价。
		  var modelCode= $("#quMotorDomainModelCode").val();
		  if(modelCode != ""){
			queryVehicle();//带出平台车型代码
		  }
		  window.parent.document.getElementById('quMainDomainCompanyCode').value = $("#quMainDomainCompanyCode").val();
		 
		  initRelatedParty($("#insuredType1")[0]);//初始化 页面 深圳展示 双录业务员展示  联系电话，身份证号码
		  lockApplyNo();//锁住微信报批号,不能修改
		//初始化录入域
		initInputDomain();
		initProductCombination();
		getPowerTypeForPurchasePrice();
    }); 
	//车辆能源类型包含“电”时可以向下调整新车购置价
	function getPowerTypeForPurchasePrice(){
		var powerType = $("#quMotorDomainPowerType").val();
		if(powerType.indexOf("电")> -1){
			$("#quMotorDomainPurchasePrice").removeAttr("readonly");
			$("#quMotorDomainPurchasePrice").attr("class","easyui-validatebox");
		}else{
			$("#quMotorDomainPurchasePrice").attr("readonly","readonly");
			$("#quMotorDomainPurchasePrice").attr("class","easyui-validatebox readonly");
		}
	}
	function initProductCombination(){
		var risk = window.parent.document.getElementById('risk').value;
		var quoteType = window.parent.document.getElementById('quoteType').value;
		var productCombination = $("input[name='quMotorDomainProductCombination'][checked]").val();
		switch(risk){
			case "1363":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "1364":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "1365":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "1383":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "1384":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "1385":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true); 
				productCombination='3';
			break;
			case "0801":
				if(productCombination == undefined || productCombination == "" || productCombination == "2"){
					$("input[name='quMotorDomainProductCombination'][value='1']").attr("checked",true);
					productCombination='1';
				}
			break;
			case "0812":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			case "0813":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			case "0814":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			case "0822":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			case "0823":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			case "0824":
				if(productCombination == undefined || productCombination == "" || productCombination == "1"){
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					productCombination='2';
				}
			break;
			default:
				$.messager.alert('提示信息','risk Error!',"info");
		}
		
		var insuredHabit = $("input[name='quMotorDomainInsuredHabit'][checked]").val();
		if(productCombination=="1" && insuredHabit !="1"){
			$("input[name='quMotorDomainInsuredHabit'][value='1']").attr("checked",true);
		}else if(productCombination=="2" && insuredHabit !="4" && insuredHabit !="5"){
			$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
		}else if(productCombination=="3" && insuredHabit !="2" && insuredHabit !="3"){
			$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
		}
		
	}
	function checkProductCombination(obj){
		var risk = window.parent.document.getElementById('risk').value;
		var productCombination = obj.value;
		$("[name='quMotorDomainProductCombination'][value='1']").removeAttr("checked");
		$("[name='quMotorDomainProductCombination'][value='2']").removeAttr("checked");
		$("[name='quMotorDomainProductCombination'][value='3']").removeAttr("checked");
		switch(risk){
			case "1363":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "1364":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "1365":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "1383":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "1384":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "1385":
				$("input[name='quMotorDomainProductCombination'][value='3']").attr("checked",true);  
			break;
			case "0801":
				if(productCombination =="2"){
					$.messager.alert('提示信息','0801出单只能选单交或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='1']").attr("checked",true); 
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="1"){
						$("input[name='quMotorDomainInsuredHabit'][value='1']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0812":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0813":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0814":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0822":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0823":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			case "0824":
				if(productCombination =="1"){
					$.messager.alert('提示信息','0812/0813/0814/0815/0822/0823/0824/0825出单只能选单商业或组合投保!',"info");
					$("input[name='quMotorDomainProductCombination'][value='2']").attr("checked",true);
					$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
				}else{
					$("input[name='quMotorDomainProductCombination'][value='"+productCombination+"']").attr("checked",true); 
					if(productCombination=="2"){
						$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true);
					}else {
						$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
					}
				}
			break;
			default:
				$.messager.alert('提示信息','risk Error!',"info");
		}
		setInsuredHabit($("input[name='quMotorDomainInsuredHabit'][checked]"),true);
		getProductCombination();
	}
	//投保习惯校验
	function setInsuredHabit(obj,flag){
		var productCombination = $("input[name='quMotorDomainProductCombination'][checked]").val();
		var insuredHabit = obj.value;
		if(productCombination=="1"){
			if(insuredHabit!="1"){
				$("[name='quMotorDomainInsuredHabit'][value='"+insuredHabit+"']").removeAttr("checked");
				$("input[name='quMotorDomainInsuredHabit'][value='1']").attr("checked",true); 
				if(!flag){
					$.messager.alert('提示信息','产品组合[单交强]投保习惯只能选择[单交强]!',"info");
				}
				return;
			}
		}else if(productCombination=="2"){
			if(insuredHabit!="4"&&insuredHabit!="5"){
				$("[name='quMotorDomainInsuredHabit'][value='"+insuredHabit+"']").removeAttr("checked");
				$("input[name='quMotorDomainInsuredHabit'][value='4']").attr("checked",true); 
				if(!flag){
					$.messager.alert('提示信息','产品组合[单商业]投保习惯只能选择[单商三责],[单商全保]!',"info");
				}	
				return;
			}
		}else if(productCombination=="3"){
			if(insuredHabit!="2"&&insuredHabit!="3"){
				$("[name='quMotorDomainInsuredHabit'][value='"+insuredHabit+"']").removeAttr("checked");
				$("input[name='quMotorDomainInsuredHabit'][value='2']").attr("checked",true);
				if(!flag){
					$.messager.alert('提示信息','产品组合[组合投保]投保习惯只能选择[交强+三责],[交强+全保]!',"info");
				}
				return;
			}
		} 
	}
	//productCombination  1 单交强 2 单商业
	function getProductCombination(){
		var productCombination = $("input[name='quMotorDomainProductCombination'][checked]").val();
		if(productCombination=="1"||productCombination=="2"){
			var frameNo = $("#quMotorDomainFrameNo").val();
			//车架号+riskcode
			var url="${ctx}quote/getProductCombination.do?productCombination="+productCombination+"&frameNo="+frameNo;
			$.ajax({  
		        type:"GET",  
		        url:url,  
		        dataType:"json",  
		        data: null, 
		        global:false,   
		        success: function(data){
					if(data!=''){
						try {
							//通过车架号检索发现存在*******(保单号)与本张交强投保单关联，关系应是交强+三责/交强+全损
							//通过车架号检索发现存在*******(保单号)与本张商业投保单关联
							if(data.msg!=undefined && data.msg!=null && data.msg!=""){
								$.messager.alert('提示信息',data.msg,"info");
							}
					  	} catch (e) {
					  		
					  	} 
				 	}
		        }  
		    }); 
		}
	}
	function checkJsJGbutton(){
		var companyCode = $("#quMainDomainCompanyCode").val();
		if(companyCode != undefined && companyCode != "" && companyCode.substr(0,4) =="0107" ){
			$("#checkJs").css("display","");
		}
	}
	function checkSCJGbutton(){
		var companyCode = $("#quMainDomainCompanyCode").val();
		if(companyCode != undefined && companyCode != "" && companyCode.substr(0,4) =="0103" ){
			$("#checkSC").css("display","");
		}
	}
	function checkGdJGbutton(){
		var companyCode = $("#quMainDomainCompanyCode").val();
		if(companyCode != undefined && companyCode != "" && companyCode.substr(0,4) =="0105" ){
			$("#checkGd").css("display","");
		}
	}
	//关系人名称赋值到投保人名称
	function initInsuredName(){
		$("#quRelatedpartyDomainInsuredName1").val($("#quMainDomainAppliName").val());
	}
   //根据证件类型校验证件号码
    function checkOrganizationCode(){
        var idType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
        var idCard = $("#quMotorDomainIdentifyNumber").val();
        if(idCard != undefined && idCard !="" && idCard.length !=0 ){
            if(idType=="10"){
                if(!checkOrgCode(idCard)){//组织机构代码校验
                    $("#quMotorDomainIdentifyNumber").val("");
                }
            }else if(idType == "01"){
				var result = checkIdcard(idCard);////身份证校验
				if(result=="1"){
					return true;
				}else{
					$.messager.alert('提示信息',result,'info');
					return false;
				}
            }else if(idType == "06"){//社会信用代码校验
            	if(!checkUnifiedSocialCredit(idCard)){
                }
            }else if(idType == "08"){//居留证
                if(!checkResidencePermit(idCard)){
                    $("#quMotorDomainIdentifyNumber").val("");
                }
            }else if(idType == "09"){// 港澳台居民居住证
            	var msg = checkIdcard_X(idCard);
                if( msg == "1"){
                	return true;
                }else{
                    $("#quMotorDomainIdentifyNumber").val("");
                    $.messager.alert('提示信息',msg,'info');   
                    return false;
                }
            }
        }       
     }
   	/*港澳台居民居住证校验 
	 * idcard:证件号吗
	 */
	function checkIdcard_X(idcard){
		var errors=new Array(
			"1",
			"\u6e2f\u6fb3\u53f0\u5c45\u6c11\u5c45\u4f4f\u8bc1\u53f7\u7801\u4e0d\u4e3a\u0031\u0038\u4e2a\u5b57\u7b26\uff0c\u8bf7\u6838\u5b9e\uff01",
			"\u6e2f\u6fb3\u53f0\u5c45\u6c11\u5c45\u4f4f\u8bc1\u51fa\u751f\u65e5\u671f\u8d85\u51fa\u8303\u56f4\u6216\u542b\u6709\u975e\u6cd5\u5b57\u7b26\uff01",
			"\u6e2f\u6fb3\u53f0\u5c45\u6c11\u5c45\u4f4f\u8bc1\u6821\u9a8c\u9519\u8bef\uff01",
			"\u6e2f\u6fb3\u53f0\u5c45\u6c11\u5c45\u4f4f\u8bc1\u8eab\u4efd\u8bc1\u5730\u533a\u975e\u6cd5\uff01"
		);
		var area = {810000:"\u9999\u6e2f",820000:"\u6fb3\u95e8",830000:"\u53f0\u6e7e"};
		//area check
		if(area[parseInt(idcard.substr(0,6))]==null) {
			return errors[4] ;
		}
		//ID No length and format check
		switch(idcard.length){
			case 18:
				//ID No=18 check
				//birthday check
				//runnian month day :((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
				//pingnian month day :((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
				if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
					ereg=/^(810000|820000|830000)(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//runnian birthday check
				} else {
					ereg=/^(810000|820000|830000)(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//pingnian birthday check
				}
				//check
				if(ereg.test(idcard)){
					return errors[0] ;
				}else {
					return errors[3] ;
				}
				break;
			default:
				return errors[1];
			break;
		}
	}
     //居留证校验
     function checkResidencePermit(identifyNumber){
        if(identifyNumber.length == 15){
        }else{
            $.messager.alert('提示信息',"居留证长度错误",'info');
            return false;
        }
        return true;
     }
     //组织机构代码校验
    function checkOrgCode(filed){
	    var url=ResouresPath+"/checkIdentifyNumber.do";
	    var type=true;
	    $.ajax({
	       type: "get",
	       async:false,
	       url: url+"?identifyNumber="+filed,
	       success:function(date){
	           if(date=="0"){
	               type=true;
	           }else if(date=="1"){
	               alert("您输入的组织机构代码错误,请重新输入");
	               type=false;
	           }else if(date=="2"){
	               alert("您输入的组织机构代码格式错误,请重新输入,(格式:XXXXXXXX-X)");
	               type=false;
	           }
	       },
	       error: function(){
	           alert("组织机构校验异常");
	       }
	    });
	    return type;
	}
    //社会信用代码校验
	function checkUnifiedSocialCredit(code){
		if(code.length != 18){
		    alert("社会信用代码长度错误！");
		    return false;
		}
		
		var reg = /^([0-9ABCDEFGHJKLMNPQRTUWXY]{2})([0-9]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-9ABCDEFGHJKLMNPQRTUWXY])$/;
		if(!reg.test(code)){
		    alert("社会信用代码校验错误！");
		    return false;
		}
		//字符序列，对应的值为0-30
		var char_seq = '0123456789ABCDEFGHJKLMNPQRTUWXY';
		//各位置的加权因子
		var weighting_factor =[1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28];
		var ci;
		var sum = 0;
		
		for(var i=0;i<17;i++){
		    //取第i位字符
		    ci = code.substr(i,1);
		    sum += char_seq.indexOf(ci) * weighting_factor[i];
		}   
		
		//校验码字符值
		var v18 = 31 - (sum % 31);
		if( v18 ==31){//社会信用代码最后以为为0处理办法
		    v18 = 0;
		}  
		//取得第18位字符
		var c18 = code.substr(17,1);
		//比较第18位字符对应的值=？计算所得校验值
		if(v18 != char_seq.indexOf(c18)){
		    alert("社会信用代码有误！");
		    return false;
		}
		return true;
	} 
 
	function checkIdentifyNumber(filed){
	   var idType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
	   var idCard = filed.value;
	   if(0!=idCard.length && idType=="10"){
	       if(!checkOrgCode(idCard)){
	           filed.value="";
	       }
	   }
	}
	    
	//初始化验车标识
	function initCarCheck(){
		var imgInfoComplete = $("#quMotorDomainImgInfoComplete").val();
		var carCheckStatus = $("#quMotorDomainCarCheckStatus").val();
		var carCheckReason = $("#quMotorDomainCarCheckReason").val();
		if(imgInfoComplete != null && imgInfoComplete == '0'){
			document.getElementById('quMotorDomainImgInfoComplete1').checked=true;
		}
		else if(imgInfoComplete != null && imgInfoComplete == '1'){
			document.getElementById('quMotorDomainImgInfoComplete2').checked=true;
		}else{
			$("#quMotorDomainImgInfoComplete").val("0");
		}
		if(carCheckStatus != null && carCheckStatus == '1'){
			document.getElementById('quMotorDomainCarCheckStatus1').checked=true;
			CarCheck.style.display = "none";
			CarCheckerid.style.display = "none";
		}
		else if(carCheckStatus != null && carCheckStatus == '2'){
			document.getElementById('quMotorDomainCarCheckStatus2').checked=true;
			CarCheck.style.display = "none";
	    	CarCheckerid.style.display = "";
		}
		else if(carCheckStatus != null && carCheckStatus == '3'){
			document.getElementById('quMotorDomainCarCheckStatus3').checked=true;
			CarCheck.style.display = "";
			CarCheckerid.style.display = "none";
		}else{
			$("#quMotorDomainCarCheckStatus").val("2");
		}
		if(carCheckReason != null && carCheckReason == '1'){
			document.getElementById('quMotorDomainCarCheckReason1').checked=true;
		}
		else if(carCheckReason != null && carCheckReason == '2'){
			document.getElementById('quMotorDomainCarCheckReason2').checked=true;
		}
		else if(carCheckReason != null && carCheckReason == '3'){
			document.getElementById('quMotorDomainCarCheckReason3').checked=true;
		}
		else if(carCheckReason != null && carCheckReason == '4'){
			document.getElementById('quMotorDomainCarCheckReason4').checked=true;
		}
		else if(carCheckReason != null && carCheckReason == '5'){
			document.getElementById('quMotorDomainCarCheckReason5').checked=true;
		}
		else if(carCheckReason != null && carCheckReason == '6'){
			document.getElementById('quMotorDomainCarCheckReason6').checked=true;
		}else{
			$("#quMotorDomainCarCheckReason").val("3");
		}
	}
	//初始化验车标识 新
	function initCarCheckNew(){
		var imgInfoComplete = $("#quMotorDomainImgInfoComplete").val(); //影像资料是否齐全
		var carCheckStatus = $("#quMotorDomainCarCheckStatus").val();//验车情况
		var carCheckReason = $("#quMotorDomainCarCheckReason").val();//验车原因
		var carNewoldFlag = $("#quMotorDomainCarNewoldFlag").val();//新旧车标识
		
		if(imgInfoComplete != null && imgInfoComplete == '0'){
			document.getElementById('quMotorDomainImgInfoComplete1').checked=true;
		}
		else if(imgInfoComplete != null && imgInfoComplete == '1'){
			document.getElementById('quMotorDomainImgInfoComplete2').checked=true;
		}else{
			$("#quMotorDomainImgInfoComplete").val("0");
		}
		if(carCheckStatus != null && carCheckStatus == '1'){
			document.getElementById('quMotorDomainCarCheckStatus1').checked=true;
			CarCheck.style.display = "none";
			CarCheckerid.style.display = "none";
		}
		else if(carCheckStatus != null && carCheckStatus == '2'){
			document.getElementById('quMotorDomainCarCheckStatus2').checked=true;
			CarCheck.style.display = "none";
	    	CarCheckerid.style.display = "";
		}
		else if(carCheckStatus != null && carCheckStatus == '3'){
			document.getElementById('quMotorDomainCarCheckStatus3').checked=true;
			CarCheck.style.display = "";
			CarCheckerid.style.display = "none";
		}else{
			$("#quMotorDomainCarCheckStatus").val("2");
		}
		if(carNewoldFlag == "O"){
			document.getElementById('quMotorDomainCarCheckReason6').checked=true;
			$("#quMotorDomainCarCheckReason").val("6");
		}else {
			document.getElementById('quMotorDomainCarCheckReason3').checked=true;
			$("#quMotorDomainCarCheckReason").val("3");
		}
	}
	////续保不允许修改车架号
	function initRenewFrameNo(){
		var renewInd = $("#quMainDomainRenewInd").val();
		if(renewInd != null && renewInd == "1"){
			$("#quMotorDomainFrameNo").attr("readonly", "readonly");
		}
	}
	//车架号
	function checkFrameNoFind(){
		if($("#quMotorDomainFrameNoFind").val()!=""&&$("#quMotorDomainFrameNoFind").val().length<17){
			 alert("车架号不满17位");
		}
	}
	//过户标志
	function initChgOwnerFlag2(){
	var flag=$("#quMotorDomainChgOwnerFlag").val();
		var chgOwnerFlag = document.getElementById('quMotorDomainChgOwnerFlag1');
		if(flag=='01'){
			chgOwnerFlag.checked=true;
		}else{
			chgOwnerFlag.checked=false;
		}
	}
	<%--判断runmiles是否满足number(14,2)--%>
	function checkRunMiles(){
		var runmiles = $("#quMotorDomainRunMiles").val();
		if(runmiles.indexOf(".") != -1){
			var miles = runmiles.split(".");
			var fmiles =miles[0];
			var bmiles =miles[1];
			if(fmiles.length>12) return false;
			else if (bmiles.indexOf(".") != -1 || bmiles.length > 2) return false;
		}
		
		else if(runmiles.length > 12)		return false;
		
		return true;
	}
	function checkTransferDate(){
		var chgOwnerFlag = document.getElementById('quMotorDomainChgOwnerFlag1');
		if(chgOwnerFlag.checked && $("#quMotorDomainTransferDate").val()==""){
			return false;
		}else return true;
	}
	function idCard(){
		var idType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
		var idCard = $("#quMotorDomainIdentifyNumber").val();
		if(0!=idCard.length && idType == "01"){
			isCardID(idCard);
		}
		else return;
	}
	
	function isCardID(sId){  
        if(!(sId.length >=15 && sId.length <=18)){
            alert("你输入的身份证长度错误");
            return false;  
        }
        switch(sId.length){
            case 15:
                return true;
                break;
            case 18:
                  var iSum=0 ;  
                  if(!/^\d{17}(\d|x)$/i.test(sId)){
                      alert("你输入的身份证长度或格式错误");
                      return false;  
                  }
                  sId=sId.replace(/x$/i,"a");  
                  var sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));  
                  var d=new Date(sBirthday.replace(/-/g,"/")) ;  
                  if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())){
                      alert("身份证上的出生日期非法");
                      return false;  
                  }
                  var idSum = 0;
                  for(var i = 17;i>=0;i --) {
                      idSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;  
                  }
                  if(idSum%11!=1){
                      alert("你输入的身份证号非法");  
                      return false;  
                  }
                  return true;  
               break;
           default:   
        	   alert("你输入的身份证长度错误");
               return false; 
        }
    }
	//身份证校验 
	function checkIdcard(idcard){
		var Errors=new Array(
			"1",
			"身份证号码位数不对!",
			"身份证号码出生日期超出范围或含有非法字符!",
			"身份证号码校验错误!",
			"身份证地区非法!"
		);
		var area={11:"\u5317\u4EAC",12:"\u5929\u6D25",13:"\u6CB3\u5317",14:"\u5C71\u897F",15:"\u5185\u8499\u53E4",21:"\u8FBD\u5B81",22:"\u5409\u6797",23:"\u9ED1\u9F99\u6C5F",31:"\u4E0A\u6D77",32:"\u6C5F\u82CF",33:"\u6D59\u6C5F",34:"\u5B89\u5FBD",35:"\u798F\u5EFA",36:"\u6C5F\u897F",37:"\u5C71\u4E1C",41:"\u6CB3\u5357",42:"\u6E56\u5317",43:"\u6E56\u5357",44:"\u5E7F\u4E1C",45:"\u5E7F\u897F",46:"\u6D77\u5357",50:"\u91CD\u5E86",51:"\u56DB\u5DDD",52:"\u8D35\u5DDE",53:"\u4E91\u5357",54:"\u897F\u85CF",61:"\u9655\u897F",62:"\u7518\u8083",63:"\u9752\u6D77",64:"\u5B81\u590F",65:"\u65B0\u7586",71:"\u53F0\u6E7E",81:"\u9999\u6E2F",82:"\u6FB3\u95E8",91:"\u56FD\u5916"};
		var idcard,Y,JYM;
		var S,M;
		var idcard_array = new Array();
		idcard_array = idcard.split("");
		//area check
		if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];
		//ID No length and format check
		switch(idcard.length){
		case 15:
		if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
		ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//check birthday is right 
		} else {
		ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//check birthday is right 
		}
		if(ereg.test(idcard)) return Errors[0];
		else return Errors[2];
		break;
		case 18:
		//ID No=18 check
		//birthday check
		//ruinian month day :((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
		//pingnian month day :((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
		if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
		ereg=/^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//ruinian birthday check
		} else {
		ereg=/^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//pingnian birthday check
		}
		if(ereg.test(idcard)){//test birthday is right
		//jisuanjiaoyanwei
		S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
		+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
		+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
		+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
		+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
		+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
		+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
		+ parseInt(idcard_array[7]) * 1
		+ parseInt(idcard_array[8]) * 6
		+ parseInt(idcard_array[9]) * 3 ;
		Y = S % 11;
		M = "F";
		JYM = "10X98765432";
		M = JYM.substr(Y,1);//jiaoyanwei check
		if(M == idcard_array[17]) return Errors[0]; //check ID jiaoyanwei
		else return Errors[3];
		}
		else return Errors[2];
		break;
		default:
		return Errors[1];
		break;
		}
	}
	function checkIsSendEPolicy(){
		var isSendEPolicy = document.getElementsByName("quMainDomainIsSendEPolicy")[0].value;
		var email = $("#quMainDomainEmail").val();
		if(isSendEPolicy=='1'){
			if(email == undefined || email == null || email.length == 0 ){
				alert("开通电子保单 必须输入 Email");
				return false;
			}
		}
		return true;
	}
	//交管车辆类型校验
	function checkVehicleCategory(){
		var CarKindCode=$("#quMotorDomainCarKindCode").val();
		if(CarKindCode!='400'){//只校验摩托车的情况
			return true;;
		}
	    var vehicleCategoryVal=$("#quMotorDomainVehicleCategory").val();
	    if(vehicleCategoryVal.indexOf("M")==-1){
	    	return false;
	    }else{
	    	return true;
	    }
	}
	//锁住微信报批号,不能修改
	function lockApplyNo(){
		var applyNo = $("#quMainDomainApplyNo").val();
		var weixinApplyNo = $("#weixinApplyNo").val();
		var quoteType = window.parent.document.getElementById('quoteType').value;
		if(quoteType =="modify"){
			if(applyNo!="" && weixinApplyNo.indexOf(applyNo)>-1){
				$("#quMainDomainApplyNo").attr("readonly", "readonly");
				$("#quMainDomainApplySerialNo").attr("readonly", "readonly");
			}
		}
	}
	function checkApplyNo(obj){
		// 1 直接报价   prepareQuote quote
		// 2 报价复制	 prepareCopyQuote  copy
		// 3 修改报价单 prepareQuote modify
		var applyNo=obj.value;
		var weixinApplyNo = $("#weixinApplyNo").val();
		var quoteType = window.parent.document.getElementById('quoteType').value;
		if(quoteType=="quote" || quoteType=="copy" ){
			if(applyNo!="" && weixinApplyNo.indexOf(applyNo)>-1){
				$.messager.alert('温馨提示','请勿录入微信报批号','info');
				return false;
			}
		}
	}
	//校验交管车辆类型-挂车
	function checkVehicleCategory_handCar(){
		var carKindCode = $("#quMotorDomainCarKindCode").val();
		var vehicleCatagory = $("#quMotorDomainVehicleCategory").val();
		var quMotorDomainVehicleCategoryName = $("#quMotorDomainVehicleCategoryName").val();
		var riskCode = $("#quMainDomainProductCode").val();
		if(vehicleCatagory==''){
			$.messager.alert('温馨提示','交管车辆类型不能为空！','info');
			return false;
		}
		if(carKindCode=='320' || carKindCode=='321' || carKindCode=='322' || carKindCode=='323' || carKindCode=='324'){
			var regExp = new RegExp("^[BG][0-9A-Z]{2}$");
			if(riskCode=='1363'||riskCode=='1364'||riskCode=='1365'||riskCode=='1383'||riskCode=='1384'||riskCode=='1385'){
				var riskName = (riskCode=='1363' || riskCode=='1383')?'机动车综合险！':'特种车综合险！';
				if(riskCode=='1363' || riskCode=='1383'){
					riskName="机动车综合险！";
				}else if(riskCode=='1364' || riskCode=='1384'){
					riskName="特种车综合险！";
				}else if(riskCode=='1365' || riskCode=='1385'){
					riskName="摩托车、拖拉机综合组合险！";
				}
				
				$.messager.alert('温馨提示','由于挂车不予承保交强险，故挂车不能投保'+riskName,'info');
				return false;
			}
			if(!regExp.test(vehicleCatagory)){
				$.messager.alert('温馨提示','机动车种类为'+carKindCode+',交管车辆类型不能选择'+vehicleCatagory+"-"+quMotorDomainVehicleCategoryName,'info');
				$("#quMotorDomainVehicleCategory").val('');
				$("#quMotorDomainVehicleCategoryName").val('');
				return false;
			}
		}
		return true;
		
	}
	
	//	检查车辆用途与使用性质、所属性质的规则
	//		使用性质 GuItemMotorUseNatureShow
	//		所属性质 GuItemMotorAttachNature
	//		车辆用途 GuItemMotorCarUseType
	function checkCarUserNature(){
		//quMotorDomainCarKindCode 机动车种类
		var CarKindCode=$("#quMotorDomainCarKindCode").val();
		if(CarKindCode!='400'){//只校验摩托车的情况
			checkCarUserNatureFlag=true;
			return ;
		}
		var useNatureShow=$("#quMotorDomainUseNatureShow").val();//使用性质
		var attachNature=$("[name='quMotorDomainAttachNature']").val();//所属性质
		var carUseType=$("[name='quMotorDomainCarUseType2']").val();//车辆用途
		
		$.post("${ctx}quote/checkCarUserNature",{fieldName:'GuItemMotorCarUseType',useNatureShow:useNatureShow,attachNature:attachNature,carUseType:carUseType},function(data){
			if('string' ==typeof data){
	    		try{
		    		data = $.parseJSON(data);
	    		}catch(eer){
	    			data = eval("("+data+")");
	    		}
	    	}
			if(data.flag!='Y'){
				alert("‘检查车辆用途与使用性质、所属性质的规则’ 调用发生错误");
			} else {
				if(data.result.indexOf("false")!=-1){
					var msg=data.result.substring(6,data.result.length);
					checkCarUserNatureFlag=false;
					checkCarUserNatureMsg=msg;
					alert(msg);
				}else{
					checkCarUserNatureFlag=true;
				}
			}
		});	
	}
	//新车不录入年审有效期至
	function checkYearReviewTime(){
		var carNewoldFlag = $("#quMotorDomainCarNewoldFlag").val();//新旧车
		var yearReviewTime = $("#quMotorDomainYearReviewTime").val();//年审有效期至
		if(carNewoldFlag == "O" && yearReviewTime == ""){
			$.messager.alert('提示信息',"请录入年审有效期至",'info');
			return false;
		}else if(carNewoldFlag == "N" && yearReviewTime != ""){
			$("#quMotorDomainYearReviewTime").val("");
			$.messager.alert('提示信息',"新车请勿录入年审有效期至",'info');
			return false;
		}
		return true;
	}
	function checkRelatedparty(i){//关系人
		var insuredType = $('#quRelatedpartyDomainInsuredType' + i).val();
		var insuredName = $('#quRelatedpartyDomainInsuredName' + i).val();
		var identifyNumber = $('#quRelatedpartyDomainIdentifyNumber' + i).val();
		var flag = true;
		if(insuredName != undefined && insuredName !="" && insuredName.length !=0){
			var ind = true;
			if(insuredType == "1"){//个人
				if(insuredName.length < 2){
					flag = false;
				}
				var reg = /^[^\-\_\*]*$/;//个人名称不包含-_*
				ind = reg.test(insuredName);
				if(!ind){
					flag = false;
				}
				var n_flag = /[0-9]/.test(insuredName);//包含数字
				var e_flag = /[A-Za-z]/.test(insuredName);//包含英文字母
				var c_flag = /[\u4E00-\u9FA5]/.test(insuredName);//包含中文
				if((n_flag && e_flag) || (n_flag && c_flag) || (c_flag && e_flag)){//不可两两混合
					flag = false;
				}
			}else if(insuredType == "2"){//团体
				if(insuredName.length < 4){
					flag = false;
				}
				var reg = /^[^\-\_\.\*]*$/;//团体名称不包含-_*.
				ind = reg.test(insuredName);
				if(!ind){
					flag = false;
				}
			}
			var reg = /^[0-9]*$/;//纯数字
			ind = reg.test(insuredName);
			if(ind){
				flag = false;
			}
			if(!flag){
				var result = i=="1" ? "请录入正确的投保人名称" : "请录入正确的被保人名称";
	   			$.messager.alert('提示信息',result,'info');
	   			return flag;
			}
		}
		if(identifyNumber != undefined && identifyNumber !="" && identifyNumber.length !=0){
			var ind = true;
			if(insuredType == "1"){//个人
				var identifyType = $("#quRelatedpartyDomainIdentifyType" + i).val();
				if(identifyNumber.length < 4){
					flag = false;
				}
				if(identifyType == "01" || identifyType == "04"){//身份证号码或驾照号码
					if((identifyNumber.length != 18) && (identifyNumber.length != 15)){
						flag = false;
					}
					var result = checkIdcard(identifyNumber);//按身份证校验规则
					if(result!="1"){
						flag = false;
					}
				}else if(identifyType == "03"){//军人证
					var reg = /^([0-9a-zA-Z\u4E00-\u9FA5])*$/g;//只包含数字、英文字母、中文
					ind = reg.test(identifyNumber);
					if(!ind){
						flag = false;
					}						
				}else{
					var reg = /^([0-9a-zA-Z\-\(\)])*$/g;//只包含数字、英文字母、-、(、)
					ind = reg.test(identifyNumber);
					if(!ind){
						flag = false;
					}
				}
			}else if(insuredType == "2"){//团体
				if(identifyNumber.length < 4){
					flag = false;
				}
				var reg = /^[0-9a-zA-Z\-\(\)]*$/g;//只包含数字、英文字母、-、(、)
				ind = reg.test(identifyNumber);
				if(!ind){
					flag = false;
				}
			}
			if(!flag){
				var result = i=="1" ? "请录入正确的证件号码(投保人)" : "请录入正确的证件号码(被保人)";
				$.messager.alert('提示信息',result,'info');
				return flag;
			}
		}
		return flag;
	}
	function checkMotorOwnerName(){//车主名称
		var identifyType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
		var ownerName = $("#quMotorDomainOwnerName").val();
		var flag = true;
		var ind = true;
		if(ownerName != undefined && ownerName !="" && ownerName.length !=0){
			//居民身份证/护照/军人证/居留证/港澳台居民居住证/港澳同胞回乡证（通行卡）/台湾居民来往大陆通行证
			if("01,02,03,08,09,12,13".indexOf(identifyType)>-1){
				if(ownerName.length < 2){
					flag = false;			
				}
				var reg = /^[^\-\_\*]*$/;//不包含-_*
				ind = reg.test(ownerName);
				if(!ind){
					flag = false;
				}
				var n_flag = /[0-9]/.test(ownerName);
				var e_flag = /[A-Za-z]/.test(ownerName);
				var c_flag = /[\u4E00-\u9FA5]/.test(ownerName);
				if((n_flag && e_flag) || (n_flag && c_flag) || (c_flag && e_flag)){//不可中文、数字、英文字母混合
					flag = false;
				}			
			}else{
				if(identifyType == "99"){//其他
					if(ownerName.length < 2){
						flag = false;			
					}
				}else if("06,10,11".indexOf(identifyType)>-1){//组织机构代码/工商注册号码/统一社会信用代码
					if(ownerName.length < 4){
						flag = false;			
					}				
				}
				var reg = /^[^\-\*\.\_]*$/;//不包含-_*.
				ind = reg.test(ownerName);
				if(!ind){
					flag = false;
				}
			}
			var reg = /^[0-9]*$/;//不可纯数字
			ind = reg.test(ownerName);
			if(ind){
				flag = false;
			}
		}
		if(!flag){
  			$.messager.alert('提示信息',"请录入正确的车主名称",'info');
		}
		return flag;
	}
	function checkMotorIdentifyNumber(){//车主证件号
		var identifyType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
		var identifyNumber = $("#quMotorDomainIdentifyNumber").val();
		var flag = true;
		if(identifyNumber != undefined && identifyNumber !="" && identifyNumber.length !=0){
			if(identifyType == "01"){//身份证
				if((identifyNumber.length != 18) && (identifyNumber.length != 15)){
					flag = false;
				}
				var result = checkIdcard(identifyNumber);//身份证校验
				if(result!="1"){
					flag = false;
				}
			}else if("02,03,08,09,12,13,99".indexOf(identifyType)>-1){
				//护照/军人证/居留证/港澳台居民居住证/港澳同胞回乡证（通行卡）/台湾居民来往大陆通行证/其他
				identifyNumber = trim(identifyNumber);//首尾不为空格
				$("#quMotorDomainIdentifyNumber").val(identifyNumber);
			}else if("06,10,11".indexOf(identifyType)>-1){//组织机构代码/工商注册号码/统一社会信用代码
				identifyNumber = trim(identifyNumber);//首尾不为空格
				$("#quMotorDomainIdentifyNumber").val(identifyNumber);
				if(identifyNumber.length < 4){
					flag = false;
				}
				var reg = /^([0-9a-zA-Z\-\(\)])*$/g;//只包含数字、英文字母、-、(、)
				var ind = reg.test(identifyNumber);
				if(!ind){
					flag = false;
				}
			}
		}
		if(!flag){
  			$.messager.alert('提示信息',"请录入正确的车主证件号码",'info');
		}
		return flag;
	}
	function checkLicenseNo1(){//车牌号
		var flag = true;
		var licenseNo = trim($("#quMotorDomainLicenseNo").val());
		$("#quMotorDomainLicenseNo").val(licenseNo);
		if(licenseNo != undefined && licenseNo !="" && licenseNo.length !=0){
			if(licenseNo!="暂未上牌"){
				if(licenseNo.length < 5){
					flag = false;
				}
				var reg = /^[0-9A-Za-z\u4E00-\u9FA5]+$/;//包含汉字、数字、英文字母
				var ind = reg.test(licenseNo);
				if(!ind){
					flag = false;				
				}
			}
		}
		if(!flag){
  			$.messager.alert('提示信息',"请录入正确的车牌号码",'info');
		}
		return flag;
	}
	function checkEngineNo(){//发动机号
		var flag = true;
		var engineNo= trim($("#quMotorDomainEngineNo").val());
		$("#quMotorDomainEngineNo").val(engineNo);
		
		if(engineNo != undefined && engineNo !="" && engineNo.length !=0){
			if(engineNo == "无"){
				return true;
			}
			if(engineNo.length<3){
				flag = false;				
			}
			var reg = /^[0-9A-Za-z\u4E00-\u9FA5\-\/\(\)\s\*\.\ε]*$/;//只能包含数字、英文字母、汉字、-、/、半角括号()、*、空格
			var ind = reg.test(engineNo);
			if(!ind){
				flag = false;
			}
			if(ind && flag){
				reg = /[\(\)]+/;
				if(reg.test(engineNo)){
					var reg1 = /\([0-9a-zA-Z]+\)/;
					if(!reg1.test(engineNo)){
						flag = false;
					}
					if(flag){
						//继续检测()必须成对出现，不能嵌套，不能单独存在
						if(checkBrackets(engineNo)){
							flag = false;
						}
					}
				}
			}
			var first = engineNo.substr(0,1);
			var last = engineNo.substr(engineNo.length-1,1);
			if("-,/".indexOf(first) > -1 || "-,/".indexOf(last) > -1){// -和/符号不可放在开头或末尾。
				flag = false;
			}
		}
		if(!flag){
  			$.messager.alert('提示信息',"请录入正确的发动机号",'info');
		}
		return flag;
	}
	function checkBrackets(str){//继续检测()必须成对出现，不能嵌套，不能单独存在
		var reg = /^[0-9a-zA-Z]+$/;
		var firstInx = str.indexOf("(");
		var lastInx = str.indexOf(")");
		
		if(lastInx == firstInx && lastInx == -1){
			return false;
		}else if(firstInx == -1 || lastInx == -1){
			return true;
		}
		if(lastInx > firstInx){
			if(!reg.test(str.substr(firstInx+1,lastInx-firstInx-1))){
				return true;
			}else{
				return checkBrackets(str.substr(lastInx+1));
			}
		}else{
			return true;
		}
	}
	<%--保存基本信息页面--%>
   function saveBase(){
	   //重新给验车信息赋值
	   initCarCheckNew();
	   var idType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
       var idCard = $("#quMotorDomainIdentifyNumber").val();
       if(idCard != undefined && idCard !="" && idCard.length !=0 ){
           if(idType==""){
        	   $.messager.alert('提示信息',"请选择车主证件类型",'info');
        	   return;
           } 
       }
       var frameNo = $("#quMotorDomainFrameNo").val();
       if(!frameNo){
			alert("请先录入车架号！");
			return false;
		}
       if(!checkFrameNo()){
    	   return;
       }
	   if(!checkContactIdentifyNumberNotNull()){
			return;
	   }

		if(!isNullInsuredHabit() ){
			alert("请录入投保习惯！");
			return false;
		}   
		
		getProductCombination();
		
		
	   checkIdentifyType(0);
	   if("1" != $('#quRelatedpartyDomainInsuredSameInd1').val()){
		   checkIdentifyType(1);
	   }
	   if(!checkInsuredNotNull()){
			return;
	   }
	   if(!checkIsSendEPolicy()){
		  return;
	   }
	   if(!checkVehicleCategory()){
		   alert("交管车辆类型不属于摩托车范畴");
		   return;
	   }
	   if(!checkYearReviewTime()){
		   return;
	   }
	   if(!checkVehicleCategory_handCar()){
		  return; 
	   }
	   
	   if(!checkCarUserNatureFlag){
		   alert(checkCarUserNatureMsg);
		   return;
	   } 
	   
	   if(!checkCarUseTypeFlag){
		   alert(checkCarUseTypeMsg);
		   return;
	   }
	   
	  // checkCarInfo();
	   <%--增加客户信息提醒 add 2015-02-26 --%>
	   if($("#quMotorDomainOwnerName").val() != null && $("#quMotorDomainOwnerName").val() != "") {
		   if($("#quMotorDomainOwnerName").val().length > 4 && $("#quMotorDomainAttachNature").val() == '01') {
			   if(!confirm('车主所属性质与行驶证车主名称可能不匹配，确定要继续保存?')){
			          return true ;
			   }
		   }else if($("#quMotorDomainOwnerName").val().length <= 4 
				   && ($("#quMotorDomainAttachNature").val() == '02' || $("#quMotorDomainAttachNature").val() == '03')) {
			   if(!confirm('车主所属性质与行驶证车主名称可能不匹配，确定要继续保存?')){
			          return true ;
			   }
		   }
	   }
	   if(!checkOuterFlag()){
		   alert("请录入寿险营销员信息！");
		   return false;
	   }
	  // idCard();
	   //根据证件类型校验证件号码
	   checkOrganizationCode();
		//过户车友情提示
	   getTransferMark();
	   if(!checkRunMiles()) {
		   alert("已行驶里程输入有误！");
		   return false;
	   }
		if($("#quMotorDomainModelCode").val()==""){
			$("#quMotorDomainBrandName").val("");
		}
	   if(!$('#newForm').form('validate')){
	    	return false; 
	    } 
	   if(!checkTransferDate()) {
		   alert("选择商业险过户车标志，过户日期必须录入！");
		   return false;
	   }
	   var powerType = $("#quMotorDomainPowerType").val();
		if(powerType.indexOf("电")=== -1 && $("#quMotorDomainPurchasePrice").val() != $("#quMotorDomainPurchaseFlagPrice").val()){
			$.messager.alert('提示信息',"能源类型包不含“电”,新车购置价必须与车型价一致。",'info');
			return false;
		}
		var PIMP_REG_SWITCH = $('#PIMP_REG_SWITCH').val();
		if(PIMP_REG_SWITCH == "Y"){
			if(!checkRelatedparty("1")){
	   			return;
	   		}
			if(!checkRelatedparty("2")){
	   			return;
	   		}
			if(!checkMotorOwnerName()){
	  			return;
	   		}
			if(!checkMotorIdentifyNumber()){
	  			return;
			}
			if(!checkLicenseNo1()){
	  			return;			
			}
			if(!checkEngineNo()){
	  			return;
			}
		}
		//DMP-57468	  关于产险业务系统（核心系统、O2O系统、行销系统）增加规范规则的需求-行销系统
	   if(!checkClientInfoValid()){
		   return;
	   }
		var frameNo = $("#quMotorDomainFrameNo").val();
		var singeinDate = $("#quMotorDomainSingeinDate").val();
		var url="${ctx}quote/checkCarVinYear.do?frameNo="+frameNo+"&singeinDate="+singeinDate;
		$.ajax({  
			type:"POST",  
			url:url,  
			async: true,
			dataType:"json",  
			global:true,   
			success: function(data){
			   if(data!=''){
					if(data.result){
						if(!confirm('车龄存疑，请核实行驶证信息')){
							return false;
						}
				   }
			   }
			   if(confirm('确定保存基本信息?')){
				/*if($("#quMotorDomainFrameNo").val().length<17){
					alert("车架号不足17位");
				}*/
				if($("#quMotorDomainCarNewoldFlag").val()==''||$("#quMotorDomainUseYears").val()==''){
					 var inputDate=getCurrentDate(1);//获得明天的日期默认为起保日期 
					 var purchaseStrFormer = $("#quMotorDomainPurchaseDate").val().replace(/-/g,"/");
					  var GuItemMotorEnrollDate = new Date(purchaseStrFormer);
					//var GuItemMotorEnrollDate = new Date($("#quMotorDomainPurchaseDate").val());
					var monthvalues = parseInt((inputDate.getFullYear() - GuItemMotorEnrollDate.getFullYear()) * 12 + (inputDate.getMonth() - GuItemMotorEnrollDate.getMonth()));
					if(monthvalues >= 9) {
						  $("#quMotorDomainCarNewoldFlag").val("O");
					  }
					  else {
						  $("#quMotorDomainCarNewoldFlag").val("N");
					  }
					$("#quMotorDomainUseYears").val(Math.floor(monthvalues / 12));
				}
				// $("#newForm").attr("action","${ctx}quote/saveQuoteMain?risk="+risk);
				// $("#newForm").submit();
				var riskCode=window.parent.document.getElementById('risk').value;
				var quoteType = window.parent.document.getElementById('quoteType').value;
				var data = $("#newForm").serialize();
				data=data+"&riskCode="+riskCode+"&quoteType="+quoteType;
				var url="${ctx}quote/saveQuoteMain.do";
				var flagF = true;
				$.ajax({  
					type:"POST",  
					url:url,  
					async: false,
					dataType:"json", 
					data: data,
					global:false,   
					success: function(data){
					   if(data!='' && data != undefined){
						 window.parent.document.getElementById('quoteNo').value=data.quoteNo;
						 flagF = false;
					   }
					}
				}); 
				if(flagF){
				   return false;
				}
				   window.parent.document.getElementById('calculate0801').value='0';
				   window.parent.document.getElementById('calculate0802').value='0';
				   var risk=window.parent.document.getElementById('risk').value;
				   if(risk=='0802' || risk=='0806' || risk=='0812' || risk=='0813'|| risk=='0814' || risk=='0822' || risk=='0823'|| risk=='0824'){
					   window.parent.$('#headDiv').tabs('select','商业险');
				   }else{
					   window.parent.$('#headDiv').tabs('select','交强险');
				   }
			   }
			} 
		}); 
   }
	//DMP-57468			关于产险业务系统（核心系统、O2O系统、行销系统）增加规范规则的需求-行销系统
	function checkClientInfoValid(){
		var appliIdentifyType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
		var appliIdentifyNumber = $("#quMotorDomainIdentifyNumber").val();
		var appliName = $("#quMainDomainAppliName").val();
		var appliNationCode = appliIdentifyType!="14"?"156":""; //  证件类型非14-外国人永久居留证 即为中国
		var appliNationName = ""; // 国家名称可空
		var appliMobilePhone = $("#quMainDomainAppliPhone").val();
		var appliBirth = $("#quRelatedpartyDomainBirthDate1").val();
		var appliAge = $("#quMotorDomainCarKindCode").val();

		var insureIdentifyType = $("#quMotorDomainCarKindCode").val();
		var insureIdentifyNumber = $("#quMotorDomainCarKindCode").val();
		var insureName = $("#quMotorDomainCarKindCode").val();
		var insureNationCode = $("#quMotorDomainCarKindCode").val();
		var insureNationName = $("#quMotorDomainCarKindCode").val();
		//var insureMobilePhone = $("#quMotorDomainCarKindCode").val();
		var insureBirth = $("#quRelatedpartyDomainBirthDate2").val();
		var insureAge = $("#quMotorDomainCarKindCode").val();

		var carOwnerType = document.getElementsByName("quMotorDomainIdentifyType")[0].value;
		var carOwnerName = $("#quMotorDomainOwnerName").val();

		var url="${ctx}quote/checkClientInfoValid.do";
		$.ajax({
			type:"POST",
			url:url,
			async: false,
			dateType:"json",
			data: {
				'appliIdentifyType':appliIdentifyType,
				'appliIdentifyNumber':appliIdentifyNumber,
				'appliName':appliName,
				'appliNationCode':appliNationCode,
				'appliNationName':appliNationName,
				'appliMobilePhone':appliMobilePhone,
				'appliAge':appliAge,
				'appliBirth':appliBirth,
				'insureIdentifyType':insureIdentifyType,
				'insureIdentifyNumber':insureIdentifyNumber,
				'insureName':insureName,
				'insureNationCode':insureNationCode,
				'insureNationName':insureNationName,
				'insureAge':insureAge,
				'insureBirth':insureBirth,
				'carOwnerType':carOwnerType,
				'carOwnerName':carOwnerName
			},
			success: function(data){
				console.log(data);
				if(data.flag == "N"){
					var msg="数据异常";
					if(data.errorMsg!=null){
						msg=data.errorMsg;
					}
					alert(msg);
					return false;
				}
				if(data.errorCode == "1111"){
					var msg="数据异常";
					if(data.errorMsg!=null){
						msg=data.errorMsg;
					}
					alert(msg);
					return false;
				}
			}
		});
	}
   //校验车辆用途与车辆种类
	 function checkCarUseTypeByCarKindCode(){
		 var carKindCode = $("#quMotorDomainCarKindCode").val();
		 var carUseType=$("[name='quMotorDomainCarUseType2']").val();//车辆用途
		 var carKindCodeShow = $("#quMotorDomainCarKindCodeShow").val();
		 if(carKindCode != "400" || $.trim(carKindCodeShow) == ""){
			checkCarUseTypeFlag=true;
			 return ;
		 }
		 var url="${ctx}quote/checkCarUseTypeByCarKindCode.do";
		 $.ajax({
			 type:"POST",
			 url:url,
			 async: false,
			 dateType:"json",
			 data: {
				 'carUseType':carUseType,
		 		 'carKindCodeShow':carKindCodeShow
			 },
			 success: function(data){
				 if('string' ==typeof data){
			    		try{
				    		data = $.parseJSON(data);
			    		}catch(eer){
			    			data = eval("("+data+")");
			    		}
			    }
				if(data.flag == "N"){
					var msg="数据异常";
		        	if(data.errorMsg!=null){
		        		msg=data.errorMsg;
		        	}
		        	alert(msg);
				}else{
					if(data.checkMessage.indexOf("false")!=-1){
						var msg=data.checkMessage.substring(6,data.checkMessage.length);
						checkCarUseTypeFlag=false;
						checkCarUseTypeMsg=msg;
						alert(msg);
					}else{
						checkCarUseTypeFlag=true;
					}
				} 
			 }
		 });
	 }
	 <%--控制摩托车投保险种--%>
	 function checkCarKindCodeFor0801(){
	 		var riskCode = $("[name='quMainDomainProductCode']").val();
			var carKindCode = $("#quMotorDomainCarKindCode").val();
			if(carKindCode && carKindCode == "400" && riskCode != "0801"&&riskCode != "0814"&&riskCode != "1365"&& riskCode != "0824" && riskCode != '1385'){
				var checkCarKindCodeMsg="摩托车只能投保单交强险,请重新选择！";
				alert(checkCarKindCodeMsg);
				$("#quMotorDomainCarKindCode").val("");
				$("#quMotorDomainCarKindName").val("");
			}
			if(carKindCode && (carKindCode == "501" || carKindCode == "502" || carKindCode == "503" || carKindCode == "504") && riskCode != "0801" && riskCode != "0814" && riskCode != "0824"){
				var checkCarKindCodeMsg="拖拉机只能投保单交强险,请重新选择！";
				alert(checkCarKindCodeMsg);
				$("#quMotorDomainCarKindCode").val("");
				$("#quMotorDomainCarKindName").val("");
			}
	 }
	<%--快速检索--%>
	   function getVehicleInfo(){
		   $('#quMotorDomainCarNewoldFlag').val("O");
		   var licenseNo=$("#quMotorDomainLicenseNoFind").val();
		   var frameNo=$("#quMotorDomainFrameNoFind").val();
		   var policyNo = $("#quMotorDomainPolicyNoFind").val();
		   var riskCode = document.getElementsByName("quMainDomainProductCode")[0].value;
		if(licenseNo==''&&frameNo==''&&policyNo==''){
			alert("车牌和车架号和保单号不能同时为空");
			return ;
		}
		if(licenseNo=='暂未上牌'){
			alert("请录入车牌");
			return ;
		}
		   var parameter = "";

			parameter ="licenseNo="+licenseNo+"&frameNo="+frameNo+"&policyNo="+policyNo+"&riskCode="+riskCode; 
			JSCoverController.showDiv("正在处理中,请稍候...");
			var url="${ctx}quote/getVehicleInfo.do";
				$.ajax({  
			        type:"POST",  
			        url:url,  
			        dataType:"json",  
			        data: parameter, 
			        global:false,   
			        success: function(data){ 
			        	JSCoverController.stopShowDiv();
			     	   if(data!=''){
			     		  var risk = document.getElementsByName("quMainDomainProductCode")[0].value;
				     	   if(risk == '0801' && (data.guPolicyRisk0801Dto==''||data.guPolicyRisk0801Dto==null)){
				     			 alert("无以往投保记录");
						   }
				     	   else if((risk == '0802'||risk == '0812') && (data.guPolicyRisk0802Dto==''||data.guPolicyRisk0802Dto==null)){
				     			  alert("无以往投保记录");
				   		   }
				     	   else if((risk == '1359'||risk == '1363') && (data.guPolicyRisk0801Dto==''||data.guPolicyRisk0801Dto==null || data.guPolicyRisk0802Dto==''||data.guPolicyRisk0802Dto==null)){
				     			  alert("无以往投保记录");
				   		   }
   						   else{
			     			  try {
			     				   //取被保险人数据
			     				   var guPolicyRiskRelatedPartyDto = data.guPolicyRiskRelatedPartyDtoList[0];
								   var guPolicyItemMotorDto=data.guPolicyItemMotorDto;
								   var policyNo = data.policyNo;
								   var startDate = data.startDate;
								   $("#quMotorDomainLicenseNo").val(guPolicyItemMotorDto.licenseNo);
								   $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.frameNo);
								   if(guPolicyItemMotorDto.identifyType!=null&&guPolicyItemMotorDto.identifyType!=''){
									   document.getElementsByName("quMotorDomainIdentifyType")[0].value=guPolicyItemMotorDto.identifyType;
								   }
								   if(guPolicyItemMotorDto.identifyNumber!=null&&guPolicyItemMotorDto.identifyNumber!=''){
									   document.getElementsByName("quMotorDomainIdentifyNumber")[0].value=guPolicyItemMotorDto.identifyNumber;
								   }
								   if(guPolicyItemMotorDto.licenseTypeCode!=null&&guPolicyItemMotorDto.licenseTypeCode!=''){
									   document.getElementsByName("quMotorDomainLicenseTypeCode")[0].value=guPolicyItemMotorDto.licenseTypeCode;
								   }
	                              if(guPolicyItemMotorDto.licenseColorCode!=null&&guPolicyItemMotorDto.licenseColorCode!=''){
	                            	  document.getElementsByName("quMotorDomainLicenseColorCode")[0].value=guPolicyItemMotorDto.licenseColorCode; 
								   }
	                              if(guPolicyItemMotorDto.runAreaCode!=null&&guPolicyItemMotorDto.runAreaCode!=''){
	                            	  document.getElementsByName("quMotorDomainRunAreaCode")[0].value=guPolicyItemMotorDto.runAreaCode; 
								   }
	                              if(guPolicyItemMotorDto.colorCode!=null&&guPolicyItemMotorDto.colorCode!=''){
	                            	  document.getElementsByName("quMotorDomainColorCode")[0].value=guPolicyItemMotorDto.colorCode;
								   }
	                              if(guPolicyItemMotorDto.localVehicleInd!=null&&guPolicyItemMotorDto.localVehicleInd!=''){
	                            	  document.getElementsByName("quMotorDomainLocalVehicleInd")[0].value=guPolicyItemMotorDto.localVehicleInd;
								   }
	                              if(guPolicyItemMotorDto.carTypeCode!=null&&guPolicyItemMotorDto.carTypeCode!=''){
	                            	  document.getElementsByName("quMotorDomainCarTypeCode")[0].value=guPolicyItemMotorDto.carTypeCode;
								   }
								 //  $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.carKindCode);//车辆种类?
								   $("#quMotorDomainOwnerName").val(guPolicyItemMotorDto.carOwner);	 
								   $("#quMotorDomainEngineNo").val(guPolicyItemMotorDto.engineNo);
								   $("#quMotorDomainRunAreaCode").val(guPolicyItemMotorDto.runAreaCode);
								 //  $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.modelCode);//?
								   $("#quMotorDomainBrandName").val(guPolicyItemMotorDto.brandName);
								   $("#quMotorDomainUseNatureShow").val(guPolicyItemMotorDto.useNatureShow);//?
								   $("#quMotorDomainSeatCount").val(guPolicyItemMotorDto.seatCount);
								   $("#quMotorDomainTonCount").val(guPolicyItemMotorDto.tonCount);
								   $("#quMotorDomainExhaustScale").val(guPolicyItemMotorDto.exhaustScale);
								   $("#quMotorDomainPower").val(guPolicyItemMotorDto.power);
								 if(guPolicyItemMotorDto.useNatureShow=="01"){
									 $("#quMotorDomainUseNatureShow1").val("营运");
								 }
								  // $("#quMotorDomainPurchasePrice").val(round2(parseFloat(guPolicyItemMotorDto.purchasePrice),2));
								  // $("#quMotorDomainActualValue").val(round2(parseFloat(guPolicyItemMotorDto.actualValue),2));
								   
								 
								   $("#quMotorDomainPrintBrandname").val(guPolicyItemMotorDto.printBrandName);
								 //  $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.vehicleType);//?
								//   $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.useNatureShow);//?
								   $("#quMotorDomainAttachNature").val(guPolicyItemMotorDto.attachNature);
								   $("#quMotorDomainCarUseType").val(guPolicyItemMotorDto.carUseType);
								  // $("#quMotorDomainFrameNo").val(guPolicyItemMotorDto.carKindCodeShow);
									$("#quMotorDomainModelCode").val(guPolicyItemMotorDto.modelCode);
								   $("#quMotorDomainCarKindCode").val(guPolicyItemMotorDto.carKindCode);
								   $("#quMotorDomainSingeinDate").val(guPolicyItemMotorDto.singeinDate);
								   $("#quMotorDomainChgOwnerFlag").val(guPolicyItemMotorDto.chgOwnerFlag);
								   initChgOwnerFlag2();//初始化过户标志
								   $("#quMotorDomainTransferDate").val(guPolicyItemMotorDto.transferDate);
								   $("#quMotorDomainPurchaseDate").val(guPolicyItemMotorDto.enrollDate);
								   $("#quMotorDomainCountryNature").val(guPolicyItemMotorDto.countryNature);
								   //$("#quMotorDomainNodamageYears").val(guPolicyItemMotorDto.noDamageYears);
								   $("#quMotorDomainCertificateDate").val(guPolicyItemMotorDto.certificateDate);
								   $("#quMotorDomainPlatformModelDesc").val(guPolicyItemMotorDto.brandName);
								   $("#quMotorDomainPlatformReplacementValue").val(guPolicyItemMotorDto.purchasePrice);
								   //$("#quMotorDomainGroupCode").val(guPolicyItemMotorDto.groupCode);
								   initLicenseNoFlag();//暂未上牌标志初始化
								   getCarKindShow();//车辆种类
								   initCarUseType();//车辆用途
								   //getModelcarByCode();//获取平台车型
								   getCarDepreRate(startDate);
								   $("#quMainDomainRenewInd").val("1");
								   $("#quMotorDomainFrameNo").attr("readonly", "readonly");
								   $("#quMainDomainRenewalNo").val(policyNo);
								   
								   //初始化被保人数据
								   $('#quRelatedpartyDomainInsuredType2').val(guPolicyRiskRelatedPartyDto.insuredType);
								   selectChangeClientType('quRelatedpartyDomainInsuredType2','2');
								   checkIdentifyType(1);
								   $('#quRelatedpartyDomainInsuredName2').val(guPolicyRiskRelatedPartyDto.insuredName);
								   $('#quRelatedpartyDomainIdentifyType2').val(guPolicyRiskRelatedPartyDto.identifyType);
								   $('#quRelatedpartyDomainIdentifyNumber2').val(guPolicyRiskRelatedPartyDto.identifyNumber);
								   $('#quRelatedpartyDomainSex2').val(guPolicyRiskRelatedPartyDto.insuredSex);
								   $('#quRelatedpartyDomainBirthDate2').val(guPolicyRiskRelatedPartyDto.insuredBirthDate);
							    } catch (e) {

							    }
							    try {
							    	var guPolicyRelatedPartyDto=data.guPolicyRelatedPartyDto;
							    	$("#quMainDomainAppliName").val(guPolicyRelatedPartyDto.insuredName);
								    $("#quMainDomainAppliPhone").val(guPolicyRelatedPartyDto.mobilePhone);
								    $("#quMainDomainAppliEmail").val(guPolicyRelatedPartyDto.email);	
								    
									
								    $('#quRelatedpartyDomainInsuredType1').val(guPolicyRelatedPartyDto.insuredType);
								    selectChangeClientType('quRelatedpartyDomainInsuredType1','1');
								    checkIdentifyType(1);
								    $('#quRelatedpartyDomainInsuredName1').val(guPolicyRelatedPartyDto.insuredName);
								    $('#quRelatedpartyDomainIdentifyType1').val(guPolicyRelatedPartyDto.identifyType);
								    $('#quRelatedpartyDomainIdentifyNumber1').val(guPolicyRelatedPartyDto.identifyNumber);
								    $('#quRelatedpartyDomainSex1').val(guPolicyRelatedPartyDto.sex);
								    $('#quRelatedpartyDomainBirthDate1').val(guPolicyRelatedPartyDto.birthDate);
								    } catch (e) {

								    } 
								try {
									//取被保人数据
									var guPolicyRiskRelatedPartyDto = data.guPolicyRiskRelatedPartyDtoList[0];
									//取投保人数据
									var guPolicyRelatedPartyDto = data.guPolicyRelatedPartyDto;
									//判断被保人是否同投保人
									if(guPolicyRiskRelatedPartyDto.identifyNumber != guPolicyRelatedPartyDto.identifyNumber){
										$("#insurantInfo2").show(200);
										$('#quRelatedpartyDomainInsuredSameInd1').val("0");
										$('#quRelatedpartyDomainInsuredSameInd2').val("0");
										$("#sameProposalInfo").attr("checked",false);
									}else{
										$("#insurantInfo2").hide(200);
										$('#quRelatedpartyDomainInsuredSameInd1').val("1");
										$('#quRelatedpartyDomainInsuredSameInd2').val("1");
										$("#sameProposalInfo").attr("checked",true);
									}
								} catch (e) {
								}
						       try {
						    	   //$("#quMotorDomainPlatformModelCode").val(data.CIModelCode);//平台车型代码
						    	   //if(data.purchaseFlagPrice!=null&&data.purchaseFlagPrice!=''){
						    	   	//	document.getElementsByName("quMotorDomainPurchaseFlagPrice")[0].value = round2(parseFloat(data.purchaseFlagPrice),2);
						    	   //}
						    	   jingYouCarMOdelUpdate(riskCode,guPolicyItemMotorDto.modelCode,startDate);
									    } catch (e) {

									   } 
			     		   }
						  
						  }else{
							  alert("无以往投保记录");
						  }
			        }  
			    }); 
	   }
	   
	   var carKindJingyou={carKindCode:'',carKindCodeShow:'',carKindCodeShowName:'',carKindCodeName:''};
	   function jingYouCarMOdelUpdate(riskCode,modelCode,startDate){
			var url="${ctx}quote/getCarModel.do?riskCode="+riskCode+"&ggCarModelDtoModelCode="+modelCode;
			$.ajax({  
				type:"POST",  
				url:url,  
				dataType:"json",  
				global:false,   
				success: function(data){  
				   if(data!=''){
						carKindJingyou.carKindCode=data.carKindCode;
						carKindJingyou.carKindCodeShow=data.carKindCodeShow;
						carKindJingyou.carKindCodeShowName=data.carKindCodeShowName;
						carKindJingyou.carKindCodeName=data.carKindCodeName;
						var ggCarModelDtoArray = data.rows;	
						var ggCarModelDto = data.rows[0];
						var flag = data.flag;
						var taxFlag = data.taxFlag;
						
						if(ggCarModelDto == undefined || ggCarModelDto == null){
							$.messager.alert('提示信息',"返回车型为空!",'info');
							return ;
						}
						if (flag != "" && flag=="2") {
						    if(taxFlag != "" && taxFlag == "1"){
						    	if(ggCarModelDto.purchasePriceNotTax != "") ggCarModelDto.purchasePrice = ggCarModelDto.purchasePriceNotTax;
						    	else ggCarModelDto.purchasePrice = 0;
						   	}   
						    else {
						    	if (ggCarModelDto.analogyModelPriceNotTax != ""
			                        && parseInt(ggCarModelDto.analogyModelPriceNotTax) > 0) {
						    		ggCarModelDto.purchasePrice = ggCarModelDto.analogyModelPriceNotTax;
			                	} else {
			                		if(ggCarModelDto.purchasePriceNotTax != "") ggCarModelDto.purchasePrice = ggCarModelDto.purchasePriceNotTax;
			                		else ggCarModelDto.purchasePrice = 0;
			                	}
						    }
			            } else {
			                if (ggCarModelDto.analogyModelPrice != null && parseInt(ggCarModelDto.analogyModelPrice) > 0) {
			                	ggCarModelDto.purchasePrice = ggCarModelDto.analogyModelPrice;
			                } else {
			                	if(ggCarModelDto.purchasePrice !="") ggCarModelDto.purchasePrice = ggCarModelDto.purchasePrice;
			                	else ggCarModelDto.purchasePrice = 0;
			                }
			            }
						
						try{
							modelCodeUpdate(ggCarModelDto,carKindJingyou,null,startDate);
						}catch(err){
							$.messager.alert('提示信息',"精友预填回写异常!",'info');
						} 
						window.close();
					}
				}
			}); 
		}
	   
	 //车型查询注入值
		var modelPurchasePrice;
		function modelCodeUpdate(ggCarModelDto,carKind) {
			if(ggCarModelDto!=null){
				window.parent.document.getElementById('brandName').value = ggCarModelDto.modelCName;
				var quMainDomainCompanyCode = window.parent.document.getElementById('quMainDomainCompanyCode').value;
				if(quMainDomainCompanyCode != null && quMainDomainCompanyCode.length >=4){
					
					quMainDomainCompanyCode = quMainDomainCompanyCode.substring(0,4);
				}
				
				$("#quMotorDomainPurchasePrice").val(round2(parseFloat(ggCarModelDto.purchasePrice),2));
				var subCompanyCode = $("#quMainDomainCompanyCode").val().substring(0,4);
				if(subCompanyCode=='0108'&&(parseFloat(ggCarModelDto.purchasePrice)-parseFloat(ggCarModelDto.analogyModelPrice)==0)){//辽宁，有类别车型价，不让修改购置价
					setReadonlyOfElement(document.getElementById('quMotorDomainPurchasePrice'));
				}else{
					undoSetReadonlyOfElement(document.getElementById('quMotorDomainPurchasePrice'));
				}
				$("#quMotorDomainPurchaseFlagPrice").val(round2(parseFloat(ggCarModelDto.purchasePrice),2));
				modelPurchasePrice=ggCarModelDto.purchasePrice;	
				
			    //getCarKindShow();
			    //getCarDepreRate();//折旧率
			    //initCarUseType();
			}
			
		}
	   
	   /**
	    *  行销系统汽车使用性质校验
	   */	   
	   function checkCarInfo(){
		var checkSubmit=true;
	   	var licenseNo = $("#quMotorDomainLicenseNo").val(); //车牌号码
	   	var frameNo = $("#quMotorDomainFrameNo").val();  //车架号
	   	//var carUseType = $("#quMotorDomainCarUseType").val();
	   	var carUseType = document.getElementsByName("quMotorDomainCarUseType")[0].value;
	   	var riskCode = window.parent.document.getElementById('risk').value;
	    var data = "";
	    data="&riskCode="+riskCode+"&licenseNo="+licenseNo+"&frameNo="+frameNo+"&carUseType="+carUseType;
	   	var url="${ctx}quote/getCarUseType.do";
	   	$.ajax({  
	        type:"POST",  
	        url:url,  
	        async: false,
	        dataType:"json", 
	        data: data,
	        global:false,   
	        success: function(data){
	     	   if(data[0]!='' && data[0] != undefined){
	     		 alert(data[0]);
	     		 checkSubmit = false;
	     	   }else {
	     		  checkSubmit = true;  
	     	   }
	        }
	    }); 
	   	return checkSubmit;
	   }
	   //判空
		function isEmpty(obj){
			if(obj==undefined || obj == null || obj ==""){
				return true;
			}
			return false;
		}

		function idtype(attachNature){
			var roomIds = $("select[name='quMotorDomainIdentifyType'] option").map(function(){
				return $(this).val();
			}).get().join(",");
			if(roomIds==undefined || roomIds==""){
				return false;
			}
			var idtype = roomIds.split(",");
			
			// 这里要先展示所有，再隐藏。如果先隐藏，再展示，会覆盖已选择的证件类型
			 toggleOptionShow($('select[name="quMotorDomainIdentifyType"]'),idtype,'show');
			 if(attachNature=="01"){
				 toggleOptionShow($('select[name="quMotorDomainIdentifyType"]'),["10","11","06"],'hide');
			 }else if(attachNature=="02"||attachNature=="03"){
				 toggleOptionShow($('select[name="quMotorDomainIdentifyType"]'),["01","02","03","08","12","13","09"],'hide');
			 } 
			 
		}
		//隐藏option
		function toggleOptionShow(obj,arrs,type){
			function arrHandle(arr,type){
				if($.isArray(arr)){
					var len=arr.length;
					for(i=0;i<len;i++){
						var optionNow=obj.find("option[value='"+arr[i]+"']");
						var optionP=optionNow.parent("span");
						if(type=="show"){					
							if(optionP.size()){
								optionP.children().clone().replaceAll(optionP); 
							}				
						}else{
							if(!optionP.size()){
								optionNow.wrap("<span style='display:none'></span>");
							}
						}
					}
				}
			}
			arrHandle(arrs,type);
		}
		
		function checkNameNew(name){
			var PIMP_REG_SWITCH = $('#PIMP_REG_SWITCH').val();
			if(PIMP_REG_SWITCH == "Y"){
				if(isEmpty(name)){
					return "";
				}
				var reg1 = /^[\u4E00-\u9FA5]+$/;
				if(reg1.test(name)){
					name = name.replace(/\s+/gm,'');
				}
				var first = name.substring(0, 1);
				var last = name.substring(name.length - 1);
				var reg2 = /^[^a-zA-Z\u4E00-\u9FA5\(\)\u300a\u300b]*$/;
				if(!reg2.test(first) && !reg2.test(last)){
					return name;				
				}else{
					if(reg2.test(first)){
						name = name.substring(1);
					}
					if(reg2.test(last)){
						name = name.substring(0, name.length - 1);
					}
					return checkNameNew(name);
				}
			}else{
				return name;
			}
		}
		
		function checkLicenseNoNew(licenseNo){
			var PIMP_REG_SWITCH = $('#PIMP_REG_SWITCH').val();
			if(PIMP_REG_SWITCH == "Y"){
				if(isEmpty(licenseNo)){
					return "";
				}
				if(licenseNo!="暂未上牌"){
					var first = licenseNo.substring(0, 1);
					var second = licenseNo.substring(1, 2);
					var reg1 = /^[\u4E00-\u9FA5]+$/;
					var reg2 = /^[a-zA-Z]+$/;
					if(!reg1.test(first) || !reg2.test(second) || licenseNo.length != 7){
						alert("请检查车牌号！");
					}
				}
			}
		}
</script>
<body id="main">	
	<div title="基本信息" style="padding:0px  0px  0px   0px; display: block; width: 100%;">
		
             <sfform:form modelAttribute="filterMask" id="newForm">
             	<input id="quMainDomainProductCode" name="quMainDomainProductCode" type="hidden" value="${risk}"/>
	            <input id="quMainDomainQuoteNo"  name="quMainDomainQuoteNo" type="hidden" value="${quMainDomain.quoteNo}"/>
	            <input id="quMainDomainCompanyCode"  name="quMainDomainCompanyCode" type="hidden" value="${quMain.companyCode}"/>
	            <input id="quMainDomainIntermediaryCode"  name="quMainDomainIntermediaryCode" type="hidden" value="${quMain.intermediaryCode}"/>
	            <input id="quMainDomainCooperatesiteCode"  name="quMainDomainCooperatesiteCode" type="hidden" value="${quMain.cooperatesiteCode}"/>
	            <input id="quMainDomainBusinessSource"  name="quMainDomainBusinessSource" type="hidden" value="${quMain.businessSource}"/>
	            <input id="quMainDomainChannelCode"  name="quMainDomainChannelCode" type="hidden" value="${quMain.channelCode}"/>
	            <input id="quMainDomainChanneltipCode"  name="quMainDomainChanneltipCode" type="hidden" value="${quMain.channeltipCode}"/>
	            <input id="quMainDomainSalesmanCode"  name="quMainDomainSalesmanCode" type="hidden" value="${quMain.salesmanCode}"/>
	            <input id="quMainDomainSalesmanRegisterNo"  name="quMainDomainSalesmanRegisterNo" type="hidden" value="${quMain.salesmanRegisterNo}"/>
	            <input id="quMainDomainRenewalNo"   name="quMainDomainRenewalNo" type="hidden" value="${quMainDomain.renewalNo}"/>
	            <input id="quMainDomainRenewInd"   name="quMainDomainRenewInd" type="hidden" value="${quMainDomain.renewInd}"/>
	            <input id="quMainDomainSystemSource"  name="quMainDomainSystemSource" type="hidden" value="${quMainDomain.systemSource}"/>
	            <input id="quMainDomainIsUploadImage"  name="quMainDomainIsUploadImage" type="hidden" value="${quMainDomain.isUploadImage}"/>
				<input type="hidden" id="quMotorDomainModelCode" name="quMotorDomainModelCode" value="${quMotorDomain.modelCode}">
	            <input id="startDate" name="startDate" type="hidden" value="${startDate}"/>
	            <input id="weixinApplyNo" name="weixinApplyNo" type="hidden" value="${weixinApplyNo}"/>
	            <input id="is_SendE_Policy" name="is_SendE_Policy" type="hidden" value="${is_SendE_Policy}"/>
	            <input id="PIMP_REG_SWITCH" name="PIMP_REG_SWITCH" type="hidden" value="${PIMP_REG_SWITCH}"/>
					<div class="layout_div">
		
						<fieldset class="fieldsetdefault" style="margin:5px;padding:5px">
							<legend>
								续保快速检索
							</legend>
							<table class="layouttable" id="input_info">
								<tr>
									<td class="layouttable_td_label">
										车牌号码
									</td>
									<td class="layouttable_td_widget">
								           <input type="text" id="quMotorDomainLicenseNoFind" style="width: 65%"   onblur="checkLicenseNoInput(this);" 
				                              value="">
									</td>
									<td class="layouttable_td_label">
										车架号
									</td>
									<td class="layouttable_td_widget">
											 <input type="text" id="quMotorDomainFrameNoFind" style="width: 65%" onchange="checkFrameNoFind();"
				                                 value="">
									
									</td>
								</tr>
								<tr>
									<td class="layouttable_td_label">
										保单号码
									</td>
									<td class="layouttable_td_widget">
								           <input type="text" id="quMotorDomainPolicyNoFind"  style="width: 65%"  
				                              value="">
									</td>
								</tr>
								<tr>
								   <td >
										 <a class="easyui-linkbutton" href="javascript:void(0);" onclick="getVehicleInfo();" >续保快速检索</a>
								   </td>
								</tr>

							</table>
						</fieldset>
						<%--客户信息检索--%>
						<jsp:include page="/WEB-INF/views/quote/edit/QueryClient.jsp" />
						 <%--联系人信息--%>
						<jsp:include page="/WEB-INF/views/quote/edit/EditContact.jsp" />
						<%--关系人--%>
						<jsp:include page="/WEB-INF/views/quote/edit/EditRelatedparty.jsp" />
						 <%--车信息--%>
						   <c:if test="${!(risk=='0812'||risk=='1363'||risk=='0813'||risk=='1364'||risk=='0814'||risk=='1365'||risk=='0822'||risk=='0823'||risk=='0824'||risk=='1383'||risk=='1384'||risk=='1385')}">
		                     <jsp:include page="/WEB-INF/views/quote/edit/EditMotor.jsp" />
		                    </c:if>
						<c:if test="${risk=='0812'||risk=='1363'||risk=='0822'||risk=='1383'}">
		                     <jsp:include page="/WEB-INF/views/quote/edit/EditMotor0812.jsp" />
		                </c:if>
		                <c:if test="${risk=='0813'||risk=='1364'||risk=='0823'||risk=='1384'}">
		                     <jsp:include page="/WEB-INF/views/quote/edit/EditMotor0813.jsp" />
		                </c:if>
						<c:if test="${risk=='0814'||risk=='1365'||risk=='0824'||risk=='1385'}">
		                     <jsp:include page="/WEB-INF/views/quote/edit/EditMotor0814.jsp" />
		                </c:if>
							<table class="layouttable" id="input_info">
						        <tr>							         
							      	<td align="center">
							      	  <c:if test="${risk=='0812'||risk=='1363' || risk=='0813' || risk=='1364' || risk=='0822'||risk=='1383' || risk=='0823' || risk=='1384'}">
										 <a class="easyui-linkbutton" href="javascript:void(0);" onclick="javascript:queryPureRiskFeeInfo();" >车损险纯风险保费查询</a>
		                              </c:if>
										 <a class="easyui-linkbutton" href="javascript:void(0);" onclick="javascript:saveBase(this);" >下一步</a>
							      	</td>
						       </tr>
						</table>
					</div>
		     </sfform:form>

	</div>
</body>
</html>
						
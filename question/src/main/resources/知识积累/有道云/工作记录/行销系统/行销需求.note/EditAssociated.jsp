<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/head.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		var essor = $("#essor").val();
		var essorMsg = $("#essorMsg").val();
		if(essor == "Y"){
			alert(essorMsg);
		}
		
		init();
		initCheckbox();
	})
	function initCheckbox(){
		var radioSelectObj = document.getElementsByName("radioSelect");
		var radioSelectObj2 = document.getElementsByName("radioSelect2");
		for(var i=0; i<radioSelectObj.length; i++){
			if(radioSelectObj[i].checked == true){
				$("#checkboxSelect").attr("checked",true);
				break;
			}
		}
		for(var i=0; i<radioSelectObj2.length; i++){
			if(radioSelectObj2[i].checked == true){
				$("#checkboxSelect2").attr("checked",true);
				break;
			}
		}
	}
	function init(){
		var businessType = $("#businessType").val();
		var baseActionType = $("#baseActionType").val();
		var status = $("#status").val();
		//businessType : 02 报价 
		//baseActionType :Quote 报价/修改 - CopyQuote 复制报价
		//status：空或者0 能修改，1-不能修改  &&  投保的插入或者更新   -->  可以修改
		if((businessType=="02") && (baseActionType == "Quote" || baseActionType == "CopyQuote") && (status=="" || status=="0")){
		  //可以修改
		}else{
		  //只读
			//readOnlyPage();  
		}
	  	//根据份数，把金额显示正确
	  	var elements = document.getElementsByName("guAssociatedMainDtoUwCount");
	  	for (var i = 0; i < elements.length; i++) {
			changeUwCount(elements[i])
	  	}
	}
	function readOnlyPage(){
		var quoteAssociated = $("input");
		for(var i=0;i<quoteAssociated.length;i++){
			if(quoteAssociated[i].type != "button"){
				if(quoteAssociated[i].type == "radio"){
					if(quoteAssociated[i].checked != true){
						quoteAssociated[i].disabled = true;
					}
				}else{
				}
				if(quoteAssociated[i].className!="small"){
					if(quoteAssociated[i].name=="registRegistContextWrite") continue;
						setReadonlyOfElement(quoteAssociated[i]);
				}else{
				}
				if(quoteAssociated[i].type == "checkbox"){
					if(quoteAssociated[i].getAttribute("ind") == null){
						quoteAssociated[i].className="";
						quoteAssociated[i].disabled = true; 
					}
				}else{
				}
			}else{
				if(quoteAssociated[i].getAttribute("ind") == null){
					quoteAssociated[i].style.display = "none";
				}
			}
			
		}
	}
	//判空
	function notEmpty(obj){
		if(obj != undefined && obj != "" && obj != null && obj.length >0 ){
			return true;
		}else{
			return false;
		}
	}
	function checkboxBussiness(field){
		var fieldValue = field.value;
		var isCheck = field.checked;
		if("1150"==fieldValue){
			var radioSelectObj = document.getElementsByName("radioSelect");
			var bool = false;
			for(var i=0; i<radioSelectObj.length; i++){
				if(isCheck==false){
					radioSelectObj[i].checked = false;
				}else{
					bool = radioSelectObj[i].checked;
					if(bool==true){
						break;
					}
				}
			}
			if(isCheck==true && bool==false){
				radioSelectObj[0].checked=true;
			}
		}else if("1273"==fieldValue){
			var radioSelectObj2 = document.getElementsByName("radioSelect2");
			var bool2 = false;
			for(var i=0; i<radioSelectObj2.length; i++){
				if(isCheck==false){
					radioSelectObj2[i].checked = false;
				}else{
					bool2 = radioSelectObj2[i].checked;
					if(bool2==true){
						break;
					}
				}
			}
			if(isCheck==true && bool2==false){
				radioSelectObj2[0].checked=true;
			}
		}
	}
	//清空
	function deleteInfo(){
		var businessType = $("#businessType").val();
		var baseActionType = $("#baseActionType").val();
		var status = $("#status").val();
		
		var essor = $("#essor").val();
		var essorMsg = $("#essorMsg").val();
		if(essor == "Y"){
			alert(essorMsg);
			return false;
		}
		//businessType : 02 报价 
		//baseActionType :Quote 报价/修改 - CopyQuote 复制报价
		//status：空或者0 能修改，1-不能修改  &&  投保的插入或者更新   -->  可以修改
		if((businessType=="2") && (baseActionType == "Quote" || baseActionType == "CopyQuote") && (status=="" || status=="0")){
		}else{
			alert("报价新增或者修改状态下才能提交！");
			return false;
		}
	  	if(confirm("确认清空所有方案？")){
			var data = $("#quoteAssociated").serialize();
			$.ajax({
				type : "POST",
				dataType : "json",
				async : false,
				url : "${ctx}/associated/deleteEditAssociated.do",
				data : data,
				success : function(data) { // 请求成功后回调函数 参数
					if(notEmpty(data.type)){
						alert(data.type);
					}
				}
			});
	  	}

	}
	//保存
	function saveInfo(){
		var businessType = $("#businessType").val();
		var baseActionType = $("#baseActionType").val();
		var status = $("#status").val();
		var essor = $("#essor").val();
		var essorMsg = $("#essorMsg").val();
		if(essor == "Y"){
			alert(essorMsg);
			return false;
		}
		//businessType : 02 报价 
		//baseActionType :Quote 报价/修改 - CopyQuote 复制报价
		//status：空或者0 能修改，1-不能修改  &&  投保的插入或者更新   -->  可以修改
		if((businessType=="2") && (baseActionType == "Quote" || baseActionType == "CopyQuote") && (status=="" || status=="0")){
		}else{
			alert("报价新增或者修改状态下才能提交！");
			return false;
		}
		var radioSelectObj = document.getElementsByName("radioSelect");
		var radioSelectObj2 = document.getElementsByName("radioSelect2");
		var bool = false;
		var bool2 = false;
		for(var i=0; i<radioSelectObj.length; i++){
			if(radioSelectObj[i].checked == true){
				bool = true;
				break;
			}
		}
		for(var i=0; i<radioSelectObj2.length; i++){
			if(radioSelectObj2[i].checked == true){
				bool2 = true;
				break;
			}
		}
		if(bool==false && bool2==false){
			alert("至少要选择一个方案！");
			return false;
		}
		if(confirm("确认提交？")){
			var data = $("#quoteAssociated").serialize();
			$.ajax({
				type : "POST",
				dataType : "json",
				async : false,
				url : "${ctx}/associated/saveEditAssociated.do",
				data : data,
				success : function(data) { // 请求成功后回调函数 参数
					if(notEmpty(data.type)){
						alert(data.type);
					}
				}
			});
		}
				
	}
	//1150单选框事件
	function radioBussiness(field,relaRiskCode,planNo){
		$("#checkboxSelect").attr("checked",true);
	}
  
	  //1273单选框事件
	function radioBussiness2(field,relaRiskCode,planNo){
		$("#checkboxSelect2").attr("checked",true);
	}
	
  	//份数改变，对应金额也要联动
  	function changeUwCount(field){
	  var uwCount = field.value; 
	  var order = getElementOrder(field) ;
	  order = order - 1;//不是加减条，要减去模板那个
	  //意外身故、残疾
	  var guAssociatedMainDtoPageKindInsured1_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageKindInsured1_ori")[order].value);
	  if(guAssociatedMainDtoPageKindInsured1_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageKindInsured1")[order].value = formatNumber(guAssociatedMainDtoPageKindInsured1_ori*uwCount,0).replace(".","");
	  }
	  //意外医疗
	  var guAssociatedMainDtoPageKindInsured2_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageKindInsured2_ori")[order].value);
	  if(guAssociatedMainDtoPageKindInsured2_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageKindInsured2")[order].value = formatNumber(guAssociatedMainDtoPageKindInsured2_ori*uwCount,0).replace(".","");
	  }
	  //意外住院津贴
	  var guAssociatedMainDtoPageKindInsured3_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageKindInsured3_ori")[order].value);
	  if(guAssociatedMainDtoPageKindInsured3_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageKindInsured3")[order].value = formatNumber(guAssociatedMainDtoPageKindInsured3_ori*uwCount,0).replace(".","");
	  }
	  //约定节日意外身故、残疾
	  var guAssociatedMainDtoPageKindInsured4_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageKindInsured4_ori")[order].value);
	  if(guAssociatedMainDtoPageKindInsured4_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageKindInsured4")[order].value = formatNumber(guAssociatedMainDtoPageKindInsured4_ori*uwCount,0).replace(".","");
	  }
	  //车内人员财产损失
	  var guAssociatedMainDtoPageKindInsured5_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageKindInsured5_ori")[order].value);
	  if(guAssociatedMainDtoPageKindInsured5_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageKindInsured5")[order].value = formatNumber(guAssociatedMainDtoPageKindInsured5_ori*uwCount,0).replace(".","");
	  }
	  //2-5座
	  var guAssociatedMainDtoPageSeatCountPremium1_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageSeatCountPremium1_ori")[order].value);
	  if(guAssociatedMainDtoPageSeatCountPremium1_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageSeatCountPremium1")[order].value = formatNumber(guAssociatedMainDtoPageSeatCountPremium1_ori*uwCount,0).replace(".","");
	  }
	  //6-9座
	  var guAssociatedMainDtoPageSeatCountPremium2_ori =unformatNumber(document.getElementsByName("guAssociatedMainDtoPageSeatCountPremium2_ori")[order].value);
	  if(guAssociatedMainDtoPageSeatCountPremium2_ori != ""){
		  document.getElementsByName("guAssociatedMainDtoPageSeatCountPremium2")[order].value = formatNumber(guAssociatedMainDtoPageSeatCountPremium2_ori*uwCount,0).replace(".","");
	  }
  	}
  	
  	/**
  	 * unformat number
  	 * example:123,222.23 ==> 123322.23
  	 */
  	function unformatNumber(value){
  	  var retValue = replace(value+"", ",", "");
  	  var valueArray = retValue.split(".");
  	  if(valueArray.length>1 && valueArray[1]=="00"){
  	    retValue = valueArray[0];
  	  }
  	  return retValue;
  	}

  	/**
  	 * format number
  	 * example:123222.23 ==> 123,322.23
  	 * if has precision,the return value will have at least precision number after dot.
  	 */
  	function formatNumber(value,precision){
  	  value  =  value+"";
  	  var pos = value.indexOf('.');
  	  if(pos>-1){
  	    var firstValue=value.substring(0,pos);
  	    var lastValue=value.substring(pos+1);
  	    var  re=/(-?\d+)(\d{3})/
  	    while(re.test(firstValue)){
  	      firstValue=firstValue.replace(re,"$1,$2")
  	    }
  	    value = firstValue + "." + lastValue;
  	  }else{
  	    var re=/(-?\d+)(\d{3})/
  	    while(re.test(value)){
  	      value=value.replace(re,"$1,$2")
  	    }
  	  }
  	  if(precision!=undefined && !isNaN(precision)){
  	  	var pos = value.indexOf('.');
  	  	if(pos==-1){
  	  		value+=".";
  	  		pos = value.indexOf('.');
  	  	}

  	  	var len = value.length-pos-1;

  			for(var i=len;i<precision;i++){
  				value+="0";
  			}
  	  }
  	  return  value;
  	}
  	
  	function replace(str, strFind, strReplaceWith) {
  	    var strReturn;
  	    var re = new RegExp(strFind, "g");
  	    if (str == null) {
  	        return null;
  	    }
  	    strReturn = str.replace(re, strReplaceWith);
  	    return strReturn;
  	}
  	
</script>
<style>
	body {
		width:90%;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fieldset class="" style="">
<sfform:form modelAttribute="filterMask" id="quoteAssociated">
	<input type="hidden" name="businessType" id="businessType" value="${businessType}"/>
	<input type="hidden" name="baseActionType" id="baseActionType" value="${baseActionType}"/>
	<input type="hidden" name="businessNo" id="businessNo" value="${businessNo}"/>
	<input type="hidden" name="status" id="status" value="${status}"/>
	<input type="hidden" name="essor" id="essor" value="${essor}"/>
	<input type="hidden" name="essorMsg" id="essorMsg" value="${essorMsg}"/>
	
	
	<div style="text-align:center;width:90%;height:30px;margin:3px;font-size:18;font-weight:bold;">关联投保</div>
		<div style="text-align:left;width:90%;">
		<input type="checkbox" name="checkboxSelect" value="1150" id="checkboxSelect" onClick="checkboxBussiness(this);"/>
			1150-驾乘人员意外伤害保险
		</div>
		<div id="div1" style="text-align:center;MARGIN-RIGHT:auto; MARGIN-LEFT:auto;width:100%;">
			<table cellpadding="0" cellspacing="1" id="ResultTable" style="background-color: #cccccc; padding:1px; table-layout: fixed;width:100%;">
			  <tr class="tableHead">
				<td style="width:3%"  colspan="1">选择</td>
				<td style="width:12%" colspan="1">方案</td>
				<td style="width:7%" colspan="1">份数</td>
				<td style="width:30%" colspan="5">保障（元）</td>
				<td style="width:10%" colspan="2">保费（元）</td>
			  </tr>
			  <tr  class="tableHead">
				<td style="width:3%"  colspan="1"></td>
				<td style="width:12%" colspan="1">方案</td>
				<td style="width:7%" colspan="1">投保份数</td>
				<td style="width:10%" colspan="1">意外身故、残疾</td>
				<td style="width:10%" colspan="1">意外医疗</td>
				<td style="width:10%" colspan="1">意外住院津贴</td>
				<td style="width:10%" colspan="1">约定节日意外身故、残疾</td>
				<td style="width:10%" colspan="1">车内人员财产损失</td>
				<td style="width:5%" colspan="1">2-5座</td>
				<td style="width:5%" colspan="1">6-9座</td>
			  </tr>
			  
				<%int index=0;%>
			  <c:forEach var="associatedMain1150" items="${guAssociatedMainDto1150List}" varStatus="status">
				<tr class="tableHead">
					<td>
						 <input type="radio" name="radioSelect" value="<%=index++%>" 
						 onClick="radioBussiness(this,'${associatedMain1150.relaRiskCode}','${associatedMain1150.planNo}');"
							<c:if test="${not empty associatedMain1150.businessNo}">
							  checked="checked"
							</c:if>
						 />
					</td>
					<td>
						<input name="guAssociatedMainDtoRelaRiskCode" type="hidden"  
						value="${associatedMain1150.relaRiskCode}" >
						<input name="guAssociatedMainDtoPlanNo" type="text" class="readonly" readonly 
						value="${associatedMain1150.planNo}" >
					</td>
					<td>
				       	<select name="guAssociatedMainDtoUwCount" onchange="changeUwCount(this)">
								<option <c:if test="${associatedMain1150.uwCount =='1'}">selected="selected"</c:if> value="1">1份</option>
								<option <c:if test="${associatedMain1150.uwCount =='2'}">selected="selected"</c:if> value="2">2份</option>
								<option <c:if test="${associatedMain1150.uwCount =='3'}">selected="selected"</c:if> value="3">3份</option>
								<option <c:if test="${associatedMain1150.uwCount =='4'}">selected="selected"</c:if> value="4">4份</option>
								<option <c:if test="${associatedMain1150.uwCount =='5'}">selected="selected"</c:if> value="5">5份</option>
						</select>
			        </td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured1" type="text" class="readonly" readonly
						value='<fmt:formatNumber value="${associatedMain1150.pageKindInsured1}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured1_ori" type="hidden" value="${associatedMain1150.pageKindInsured1}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured2" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${associatedMain1150.pageKindInsured2}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured2_ori" type="hidden" value="${associatedMain1150.pageKindInsured2}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured3" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${associatedMain1150.pageKindInsured3}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured3_ori" type="hidden" value="${associatedMain1150.pageKindInsured3}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured4" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${associatedMain1150.pageKindInsured4}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured4_ori" type="hidden" value="${associatedMain1150.pageKindInsured4}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured5" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${associatedMain1150.pageKindInsured5}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured5_ori" type="hidden" value="${associatedMain1150.pageKindInsured5}">
					</td>
					<td>
					  <input name="guAssociatedMainDtoPageSeatCountPremium1" type="text" class="readonly" readonly 
					    value='<fmt:formatNumber value="${associatedMain1150.pageSeatCountPremium1}" pattern="#,###.##"/>'
						<c:if test="${associatedMain1150.premiumTypeValue =='01'}">
							style="font-weight:bold;color:#ff0000;"
						</c:if>
						>
					  <input name="guAssociatedMainDtoPageSeatCountPremium1_ori" type="hidden" value="${associatedMain1150.pageSeatCountPremium1}">
					</td>
					<td>
					  <input name="guAssociatedMainDtoPageSeatCountPremium2" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${associatedMain1150.pageSeatCountPremium2}" pattern="#,###.##"/>'
						<c:if test="${associatedMain1150.premiumTypeValue =='02'}">
							style="font-weight:bold;color:#ff0000;"
						</c:if>
						>
					  <input name="guAssociatedMainDtoPageSeatCountPremium2_ori" type="hidden" value="${associatedMain1150.pageSeatCountPremium2}">	
					</td>
				</tr>
			  
			  </c:forEach>
			  </table>
		  </div>
	    <div style="text-align:left;width:90%;height:30px;"></div>

		<div style="text-align:left;width:90%;">
		<input type="checkbox" name="checkboxSelect" value="1273" id="checkboxSelect2"
			onClick="checkboxBussiness(this)" />
		1273-个人责任保险（B款）
		</div>
		<table border="0" cellpadding="0" cellspacing="1"  id="ResultTable2"  style="background-color: #cccccc; padding:1px; table-layout: fixed;width:100%;">
		  <tr class="tableHead">
			<td style="width:10%"  colspan="1">选择</td>
			<td style="width:10%" colspan="1">方案</td>
			<td style="width:20%" colspan="1">保障（元）</td>
			<td style="width:40%" colspan="2">保费（元）</td>
		  </tr>
		  <tr class="tableHead">
			<td style="width:10%"  colspan="1"></td>
			<td style="width:10%" colspan="1">方案</td>
			<td style="width:20%" colspan="1">赔付限额</td>
			<td style="width:20%" colspan="1">单独投保交强险</td>
			<td style="width:20%" colspan="1">投保商业车险-商三险</td>
		  </tr>
		  
		  <c:forEach var="ass" items="${guAssociatedMainDto1273List}" varStatus="status">
			<tr class="tableHead">
				<td>
					<input type="radio" name="radioSelect2" value="<%=index++%>" 
					onClick="radioBussiness2(this,'${ass.relaRiskCode}','${ass.planNo}');"  
						<c:if test="${not empty ass.businessNo}">
							checked="checked"
						</c:if>
					/>
				</td>
				<td>
					<input name="guAssociatedMainDtoRelaRiskCode" type="hidden"  
					value="${ass.relaRiskCode}" >
					<input name="guAssociatedMainDtoUwCount" type="hidden"  value="${ass.uwCount}" >
					<input name="guAssociatedMainDtoPlanNo" type="text" class="readonly" readonly 
					value="${ass.planNo}" >
				</td>
				<td>
					<input name="guAssociatedMainDtoPageLimitInsured" type="text" class="readonly" readonly 
					value='<fmt:formatNumber value="${ass.pageLimitInsured}" pattern="#,###.##"/>' >
				</td>
				<td>
					<input name="guAssociatedMainDtoPageJointPremiumOnlyJQ" type="text" class="readonly" readonly 
						value='<fmt:formatNumber value="${ass.pageJointPremiumOnlyJQ}" pattern="#,###.##"/>'
						<c:if test="${ass.premiumTypeValue =='01'}">
							style="font-weight:bold;color:#ff0000;"
						</c:if>
					>
				</td>
				<td>
				   <input name="guAssociatedMainDtoPageJointPremiumThirdSY" type="text" class="readonly" readonly 
					value='<fmt:formatNumber value="${ass.pageJointPremiumThirdSY}" pattern="#,###.##"/>'
						<c:if test="${ass.premiumTypeValue =='02'}">
							style="font-weight:bold;color:#ff0000;"
						</c:if>
					>
				</td>
				
			</tr>
		  </c:forEach>
		</table>

	<div style="text-align:left;width:90%;">
		<input type="checkbox" name="checkboxSelect" value="1150" id="checkboxSelect1" onClick="checkboxBussiness(this);"/>
		1124-机动车驾驶人员意外伤害保险（B款）
	</div>
	<div id="div1" style="text-align:center;MARGIN-RIGHT:auto; MARGIN-LEFT:auto;width:100%;">
		<table cellpadding="0" cellspacing="1" id="ResultTable1" style="background-color: #cccccc; padding:1px; table-layout: fixed;width:100%;">
			<tr class="tableHead">
				<td style="width:3%"  colspan="1">选择</td>
				<td style="width:12%" colspan="1">地区</td>
				<td style="width:7%" colspan="1">份数</td>
				<td style="width:30%" colspan="2">保障（元）</td>
				<td style="width:10%" colspan="2">合计（元）</td>
			</tr>
			<tr  class="tableHead">
				<td style="width:3%"  colspan="1"></td>
				<td style="width:12%" colspan="1">地区</td>
				<td style="width:7%" colspan="1">投保份数</td>
				<td style="width:25%" colspan="1">1124001<br>机动车驾驶人员意外伤害保险</td>
				<td style="width:25%" colspan="1">1124002<br>附加意外伤害医疗保险</td>
				<td style="width:5%" colspan="1">保额</td>
				<td style="width:5%" colspan="1">保费</td>
			</tr>

			<%int index1=0;%>
			<c:forEach var="associatedMain1124" items="${guAssociatedMainDto1124List}" varStatus="status">
				<tr class="tableHead">
					<td>
						<input type="radio" name="radioSelect" value="<%=index1++%>"
							   onClick="radioBussiness(this,'${associatedMain1124.relaRiskCode}','${associatedMain1124.planNo}');"
								<c:if test="${not empty associatedMain1124.businessNo}">
									checked="checked"
								</c:if>
						/>
					</td>
					<td>
						<input name="guAssociatedMainDtoRelaRiskCode" type="hidden"
							   value="${associatedMain1124.relaRiskCode}" >
						<input name="guAssociatedMainDtoPlanNo" type="text" class="readonly" readonly
							   value="${associatedMain1124.planNo}" >
					</td>
					<td>
						<select name="guAssociatedMainDtoUwCount" onchange="changeUwCount(this)">
							<option <c:if test="${associatedMain1124.uwCount =='1'}">selected="selected"</c:if> value="1">1份</option>
							<option <c:if test="${associatedMain1124.uwCount =='2'}">selected="selected"</c:if> value="2">2份</option>
							<option <c:if test="${associatedMain1124.uwCount =='3'}">selected="selected"</c:if> value="3">3份</option>
							<option <c:if test="${associatedMain1124.uwCount =='4'}">selected="selected"</c:if> value="4">4份</option>
							<option <c:if test="${associatedMain1124.uwCount =='5'}">selected="selected"</c:if> value="5">5份</option>
						</select>
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured1" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageKindInsured1}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured1_ori" type="hidden" value="${associatedMain1124.pageKindInsured1}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured2" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageKindInsured2}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured2_ori" type="hidden" value="${associatedMain1124.pageKindInsured2}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured3" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageKindInsured3}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured3_ori" type="hidden" value="${associatedMain1124.pageKindInsured3}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured4" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageKindInsured4}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured4_ori" type="hidden" value="${associatedMain1124.pageKindInsured4}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageKindInsured5" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageKindInsured5}" pattern="#,###.##"/>' >
						<input name="guAssociatedMainDtoPageKindInsured5_ori" type="hidden" value="${associatedMain1124.pageKindInsured5}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageSeatCountPremium1" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageSeatCountPremium1}" pattern="#,###.##"/>'
						<c:if test="${associatedMain1124.premiumTypeValue =='01'}">
							   style="font-weight:bold;color:#ff0000;"
						</c:if>
						>
						<input name="guAssociatedMainDtoPageSeatCountPremium1_ori" type="hidden" value="${associatedMain1124.pageSeatCountPremium1}">
					</td>
					<td>
						<input name="guAssociatedMainDtoPageSeatCountPremium2" type="text" class="readonly" readonly
							   value='<fmt:formatNumber value="${associatedMain1124.pageSeatCountPremium2}" pattern="#,###.##"/>'
						<c:if test="${associatedMain1124.premiumTypeValue =='02'}">
							   style="font-weight:bold;color:#ff0000;"
						</c:if>
						>
						<input name="guAssociatedMainDtoPageSeatCountPremium2_ori" type="hidden" value="${associatedMain1124.pageSeatCountPremium2}">
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div style="text-align:left;width:90%;height:30px;"></div>
	<div style="text-align:center;width:90%;height:40px;margin:20px;">
		<a class="easyui-linkbutton" href="javascript:void(0);"  onclick="saveInfo();" >保存</a>
		<span style="width:50px;"></span>
		<a class="easyui-linkbutton" href="javascript:void(0);"  onclick="deleteInfo();" >删除</a>

   </div>
	</sfform:form>						
</fieldset>
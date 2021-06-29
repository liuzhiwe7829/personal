package com.eagle.ecore.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eagle.echannel.channel.prop.mobile.user.dto.SyncSaleManDTO;
import com.eagle.echannel.channel.prop.mobile.user.dto.SyncSaleManReqDTO;
import com.eagle.echannel.channel.prop.mobile.user.dto.SyncSaleManReqDTO.Body;
import com.eagle.echannel.channel.prop.mobile.user.dto.SyncSaleManReqDTO.Head;
import com.eagle.ecore.batch.biz.prop.BaseOperationBatch;
import com.eagle.ecore.cache.common.AbstEbizCodeCache;
import com.eagle.ecore.config.biz.datasource.ecore.dao.EserviceCommonDAO;
import com.eagle.ecore.core.common.constants.enums.ENUM_IS_DELETE;
import com.eagle.ecore.generated.dao.EbizCodeDAO;
import com.eagle.ecore.generated.dao.PropUserRecommendDAO;
import com.eagle.ecore.generated.model.PropUserRecommend;
import com.eagle.ecore.generated.model.PropUserRecommendExample;
import com.eagle.ecore.integration.lis.prop.biz.action.PropInterfaceAction;
import com.eagle.ecore.integration.lis.prop.biz.bo.impl.VechileToPpspRpcService;
import com.eagle.platform.app.web.controller.BaseController;
import com.eagle.platform.util.DateUtil;
import com.eagle.platform.util.ExcelReadUtil;
import com.eagle.platform.util.JsonUtil;
import com.eagle.platform.util.StringUtil;

@Controller
public class SpecialTestController extends BaseController{
	@Resource
	private AbstEbizCodeCache ebizCodeCache;
	@Resource
	private PropInterfaceAction propInterfaceAction;
	@Resource
	private EbizCodeDAO ebizCodeDAO;
	@Resource
	private PropUserRecommendDAO propUserRecommendDAO;
	@Resource
	private EserviceCommonDAO eserviceCommonDAO;
	@Resource
	private BaseOperationBatch baseOperationBatch;
	
	@RequestMapping("/test/getLisSign.action")
	public void getLisSign(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		baseOperationBatch.getLisSign();
	}
	@RequestMapping("/test/getUCSign.action")
	public void getUCSign(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		baseOperationBatch.getUCSign();
	}
	@RequestMapping("/test/testToLis.action")
	public void testToLis(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File("E:/1.txt");
		String param = FileUtils.readFileToString(file,"utf-8");
		System.out.println(param);
		System.out.println();
		System.out.println();
		System.out.println();
		String result = new PropInterfaceAction().sendPost("http://180.168.131.15:8082/v1/newbiz/car/carProposalSave", param);
		System.out.println(result);
	}
	protected void renderHTML(HttpServletResponse res, String text) throws IOException {
		  res.setCharacterEncoding("UTF-8");
		  res.setHeader("Content-type", "text/html");
		  this.logger.info(text);
		  res.getWriter().print(text);
	}
	/**
	 * 初始化销管数据
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/test/initSaleMan.action")
	public void initSaleMan(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String[] paramNames = {"seq","saleManNo","saleManName","groupNo","idNo","deptNo","channel"};
		String filePath = request.getParameter("filePath");
		List<Map> datas = ExcelReadUtil.readExcel(filePath, paramNames, 2);
		List<SyncSaleManDTO> list = new ArrayList<SyncSaleManDTO>();
		SyncSaleManReqDTO syncSaleManReqDTO = new SyncSaleManReqDTO();
		Head head = new Head();
		head.setApplyNo(DateUtil.getCurrentDate(DateUtil.ZH_CN_DP_NO_TRIM));
		head.setApplyTime(DateUtil.getCurrentDate(DateUtil.ZH_CN_DATETIME_PATTERN));
		syncSaleManReqDTO.setHead(head);
		Body body = new Body();
		body.setSalesManList(list);
		syncSaleManReqDTO.setBody(body);
		
		for(Map map : datas){
			SyncSaleManDTO syncSaleManDTO = new SyncSaleManDTO();
			
			syncSaleManDTO.setSalesmanCode(StringUtil.getString(map.get("saleManNo")));
			syncSaleManDTO.setSalesmanName(StringUtil.getString(map.get("saleManName")));
			syncSaleManDTO.setSolutionCode(StringUtil.getString(map.get("groupNo")));
			syncSaleManDTO.setIDcard(StringUtil.getString(map.get("idNo")));
			syncSaleManDTO.setOrgCode(StringUtil.getString(map.get("deptNo")));
			syncSaleManDTO.setChannel(StringUtil.getString(map.get("channel")));
			syncSaleManDTO.setOption("A");
			syncSaleManDTO.setStatus("1");
			list.add(syncSaleManDTO);
		}
//		this.renderJson(response, syncSaleManReqDTO);
		InetAddress localhost = InetAddress.getLocalHost();
		requestUrl =  "http://"+localhost.getHostAddress()+":"+request.getServerPort()+request.getContextPath();
		this.sendXml(JsonUtil.writeValue(syncSaleManReqDTO), "/mobile/user/syncSaleMan.action"); 
		
	}
	private String requestUrl ;
	private String sendXml(String reqXml, String url) throws Exception {
		HttpClient client = new HttpClient();
		
		PostMethod pm = new PostMethod(requestUrl + url);
		pm.setRequestEntity(new StringRequestEntity(reqXml, "text/xml", "UTF-8"));
		client.executeMethod(pm);
		String result = getResponseXml(pm.getResponseBodyAsStream());
		System.out.println(result);

		return result;
	}
	
	@RequestMapping("/test/life.action")
	public void testCarPoint(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		//组装请求报文
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("salesmanCode", "S000000108");
		VechileToPpspRpcService vechileToPpspRpcService = com.fundins.sdk.platform.PlatformContext.getRpcContext().getRemoteService(VechileToPpspRpcService.class);
		Map<String,Object> respMap = vechileToPpspRpcService.queryLifeBranch(param);
		String errorMsg = (String) respMap.get("errorMess");//错误信息的输出
		if(StringUtils.isNotBlank(errorMsg)){
			throw new Exception(errorMsg);
		}
		respMap = vechileToPpspRpcService.findLifeSalesEmpInfoList(param);
		param.put("empNo", "刘彦");
		param.put("empName", "刘彦");
		param.put("branchCode ", "86480001");
		param.put("salesmanCode", "S000000108");
		respMap = vechileToPpspRpcService.queryLifeBranch(param);
	}
	@RequestMapping("/test/checkRecommend.action")
	public void checkRecommend (HttpServletRequest request, HttpServletResponse response){
		PropUserRecommendExample example = new PropUserRecommendExample();
		example.createCriteria().andIsDeleteEqualTo(ENUM_IS_DELETE.NO.getCode());
		List<PropUserRecommend> list = this.propUserRecommendDAO.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			for(PropUserRecommend r : list){
				
				Map<String, String> params = new HashMap<String, String>();
				params.put("id", r.getUserId()+"");
				try {
					response.getWriter().println(r.getRecommendId()+" : "+ this.eserviceCommonDAO.queryForObject("prop_user.getTreePath", params));
				} catch (Exception e) {
					try {
						response.getWriter().println(r.getRecommendId()+" : "+ r.getUserId()+" 有异常");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public static String getResponseXml(InputStream is) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String demo = "";
		while ((demo = br.readLine()) != null) {
			buffer.append(demo);
		}
		String xml = buffer.toString();
		return xml;
	}
}

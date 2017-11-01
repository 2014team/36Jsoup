package com.jsoup.i51job.login.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.jsoup.abs.impl.BaseJsoupServiceImpl;
import com.jsoup.common.constant.UrlConstant;
import com.jsoup.i51job.login.service.I51JobLoginService;
import com.jsoup.i51job.login.vo.I51JobLoginVO;
@Service
public class I51JobLoginServiceImpl extends BaseJsoupServiceImpl implements I51JobLoginService{
	
	/**
	* @Title: login
	* @Description: 登录
	* @author zhuzq
	* @date  2017-10-25 下午5:18:51
	* @param loginVO
	* @return
	*/
	@Override
	public I51JobLoginVO login(I51JobLoginVO loginVO) {
		//登录请求参数处理
		Map<String,String> paramMap = reqParamHandle(loginVO);
		String url = UrlConstant.I51job.LOGIN_URL;
		I51JobLoginVO login = loginVO;
		try {
		//登录特殊处理(获取reqCookies)
		Map<String,Object>	map = httpPost(url, paramMap, null);
		Document doc = (Document) map.get("doc");
		Connection con = (Connection) map.get("con");
		login.setReqCookies(getReqCookies(con));
		//获取resumeid以及简历url
		loginVO = getResposeInfo(login,doc);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return login;
	}

	/**
	* @Title: getResposeInfo
	* @Description: 获取返回有用信息
	* @author zhuzq
	* @date  2017-10-26 上午11:20:15
	* @param doc
	* @return
	*/
	public I51JobLoginVO getResposeInfo(I51JobLoginVO loginVO,Document doc) {
		Elements trs = doc.select("div.rcon a");
		//<a href="javascript:void(0);" title="卢本高" onclick="edit(81174936,0,'http://i.51job.com/resume')">卢本高</a>
		if(null != trs && trs.size() > 0){
			Element element =  trs.get(0);
			if(null != element){
				String  onclickAttr =element.attr("onclick");
				if(null != onclickAttr){
					int resumeIdStartIndex = onclickAttr.indexOf("(");
					int resumeIdEndtIndex = onclickAttr.indexOf(",");
					try {
						//获取简历resumeId
						String resumeId = onclickAttr.substring(resumeIdStartIndex+1,resumeIdEndtIndex);
						//System.out.println(resumeId);
						loginVO.setResumeId(resumeId);
						int resumeReqUrlStartIndex = onclickAttr.indexOf("'");
						int resumeReqUrlEndIndex = onclickAttr.lastIndexOf("'");
						String resumeReqUrl = onclickAttr.substring(resumeReqUrlStartIndex+1,resumeReqUrlEndIndex);
						//System.out.println(resumeReqUrl);
						//获取请求简历url
						loginVO.setUrl(resumeReqUrl);
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		return loginVO;
	}
	
	
	/**
	* @Title: loginParamHandle
	* @Description: 登录请求参数处理
	* @author zhuzq
	* @date  2017-10-26 上午11:19:19
	* @param loginVO
	* @return
	*/
	public Map<String,String> reqParamHandle(I51JobLoginVO loginVO){
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("lang", loginVO.getLang());
		paramMap.put("action", loginVO.getAction());
		paramMap.put("from_domain", loginVO.getFromDomain());
		paramMap.put("isread", loginVO.getIsread());
		paramMap.put("loginname", loginVO.getLoginName());
		paramMap.put("password", loginVO.getPassword());
		return paramMap;
	}
	
	



}

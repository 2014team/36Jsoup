package com.jsoup.i51job.resume.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.jsoup.abs.impl.BaseJsoupServiceImpl;
import com.jsoup.common.constant.UrlConstant;
import com.jsoup.i51job.login.vo.I51JobLoginVO;
import com.jsoup.i51job.resume.domain.I51JobResume;
import com.jsoup.i51job.resume.service.I51JobResumeService;

@Service
public class I51JobResumeServiceImpl extends BaseJsoupServiceImpl implements I51JobResumeService{

	/**
	* @Title: getResume
	* @Description: 获取简历信息
	* @author zhuzq
	* @date  2017-10-26 下午4:01:49
	* @param loginVO
	* @return
	*/
	@Override
	public I51JobResume getResume(I51JobLoginVO loginVO) {
		String url = UrlConstant.I51job.RESUME_URL ;
		Map<String ,String> paramMap = reqParamHandle(loginVO);
		String cookie = loginVO.getReqCookies();
		try {
			if(StringUtils.isNotBlank(cookie)){
				Map<String,Object> data  = httpGet(url, paramMap, cookie);
				Document doc =(Document)data.get("doc");
				return resumeHandle(doc);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		////证明cookise值已经过期
		return null;
	}

	/**
	* @Title: reqParamHandle
	* @Description: 封装请求参数
	* @author zhuzq
	* @date  2017-10-26 下午3:56:46
	* @param loginVO
	* @return
	*/
	public Map<String,String> reqParamHandle(I51JobLoginVO loginVO){
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("lang", loginVO.getLang());
		paramMap.put("resumeid", loginVO.getResumeId());
		return paramMap;
	}
	
	
	
	public I51JobResume resumeHandle(Document doc){
		//base部分
		I51JobResume resume = baseInfoHandle(doc);
		
		return resume;
	}
	
	
	/**
	* @Title: baseInfoHandle
	* @Description: 简历基本信息部分处理
	* @author zhuzq
	* @date  2017-10-26 下午4:16:28
	* @param doc
	* @return
	*/
	public I51JobResume baseInfoHandle(Document doc){
		System.out.println(doc.html());
		I51JobResume resume = new I51JobResume();
		//姓名
		Elements names = doc.select("td.name");
		if(null != names && names.size() > 0){
			Element element = names.get(0);
			if(null != element){
				resume.setBaseName(element.text());
			}
		}
		return resume;
	}
	
	
	
	
	
	

	
}

package com.jsoup.bossjob.login.service.impl;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.jsoup.abs.impl.BaseJsoupServiceImpl;
import com.jsoup.bossjob.login.domain.BossJobSuccessInfo;
import com.jsoup.bossjob.login.service.BossJobLoginService;
import com.jsoup.bossjob.login.vo.BossJobLoginVO;
import com.jsoup.common.constant.UrlConstant;
import com.jsoup.common.utils.CertificatesUtil;
import com.jsoup.common.utils.GsonUtil;
@Service
public class BossJobLoginServiceImpl extends BaseJsoupServiceImpl implements BossJobLoginService{

	/**
	* @Title: getCaptcha
	* @Description: 获取生成验证码
	* @author zhuzq
	* @date  2017-10-30 上午11:03:47
	* @param url
	* @return
	*/
	@Override
	public BossJobLoginVO getCaptcha(String url) {
		
		BossJobLoginVO bean =null;
		try {
			//获取请求连接
	        Map<String,Object>	data = httpPost(url, null, null);
	        Connection con = (Connection) data.get("con");
	        //插入cookie（头文件形式）
	        con = setHeaderParam(con);
	        Document doc = con.post(); 
	        bean = getRandomKey(doc);
	        String respCookies = getRespCookies(con);
	        bean.setRespCookies(respCookies);
	        return bean;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	* @Title: getRandomKey
	* @Description: 获取randomKey与randomKey生成url
	* @author zhuzq
	* @date  2017-10-30 上午11:00:42
	* @param doc
	* @return
	*/
	private BossJobLoginVO getRandomKey(Document doc) {
		BossJobLoginVO bean = new BossJobLoginVO();
		org.jsoup.select.Elements elements = doc.select("div.form-row.row-code>input.randomkey");
		if(null != elements){
			Element element = elements.get(0);
			if(null !=element){
				String randomKey = element.attr("value");
				bean.setRandomKey(randomKey);
			}
		}
		
		org.jsoup.select.Elements elements2 = doc.select("div.form-row.row-code>span>img");
		if(null != elements2){
			Element element  =elements2.get(0);
			String captchaUrl  = element.attr("src");
			bean.setUrl(UrlConstant.Boss.DOMAIN_URL+captchaUrl);
		}
		return bean;
	}

	/**
	* @Title: login
	* @Description: 登录
	* @author zhuzq
	* @date  2017-10-30 下午1:54:38
	* @param loginVO
	* @return
	*/
	@Override
	public BossJobLoginVO login(BossJobLoginVO loginVO) {
		Map<String,String> paramMap = reqParamHandle(loginVO);
		String url = UrlConstant.Boss.LOGIN_URL;
		try {
			Map<String,Object>	data = httpPost(url, paramMap, null);
			Document doc = (Document) data.get("doc");
			
			//返回成功信息
			BossJobSuccessInfo successInfo = (BossJobSuccessInfo) GsonUtil.jsonToBean(doc.text(), BossJobSuccessInfo.class);
			if(null != successInfo){
				loginVO.setLoginMsg(successInfo.getResmsg());
				
			}
			Connection con = (Connection) data.get("con");
			String cookie = getRespCookies(con);
			loginVO.setRespCookies(cookie);
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			//登录失败
		}
		return loginVO;
	}

	
	private Map<String, String> reqParamHandle(BossJobLoginVO loginVO) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("account", loginVO.getAccount());
		paramMap.put("password", loginVO.getPassword());
		paramMap.put("randomKey", loginVO.getRandomKey());
		paramMap.put("captcha", loginVO.getCaptcha());
		return paramMap;
	}
	


}

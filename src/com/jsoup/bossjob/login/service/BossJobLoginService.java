package com.jsoup.bossjob.login.service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.bossjob.login.vo.BossJobLoginVO;

public interface BossJobLoginService extends BaseJsoupService{
	
	/**
	* @Title: getCaptcha
	* @Description: 获取生成验证码
	* @author zhuzq
	* @date  2017-10-30 上午11:03:47
	* @param url
	* @return
	*/
	public BossJobLoginVO getCaptcha(String url);
	
	
	
	/**
	* @Title: login
	* @Description: 登录
	* @author zhuzq
	* @date  2017-10-30 下午1:54:38
	* @param loginVO
	* @return
	*/
	public BossJobLoginVO login(BossJobLoginVO loginVO);
	
	
	
	

}

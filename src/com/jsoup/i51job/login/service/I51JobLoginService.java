package com.jsoup.i51job.login.service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.i51job.login.vo.I51JobLoginVO;

public interface I51JobLoginService extends BaseJsoupService{
	
	/**
	* @Title: login
	* @Description: 登录
	* @author zhuzq
	* @date  2017-10-25 下午5:18:51
	* @param loginVO
	* @return
	*/
	public I51JobLoginVO login(I51JobLoginVO loginVO);
	
	
	

}

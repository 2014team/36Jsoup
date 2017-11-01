package com.jsoup.zhilianjob.login.service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.zhilianjob.login.vo.ZhilianJobLoginVO;

public interface ZhilianJobLoginService extends BaseJsoupService{
	
	/**
	* @Title: login
	* @Description: 登录
	* @author zhuzq
	* @date  2017-10-25 下午5:18:51
	* @param loginVO
	* @return
	*/
	public ZhilianJobLoginVO login(ZhilianJobLoginVO loginVO);
	
	

}

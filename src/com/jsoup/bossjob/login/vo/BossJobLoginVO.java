package com.jsoup.bossjob.login.vo;

import com.jsoup.base.vo.BaseVO;

/**
* @ClassName: LoginVO
* @Description: 登录VO
* @author zhuzq
* @date 2017-10-26 上午11:41:55
*/
public class BossJobLoginVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String captcha;//验证码
	private String randomKey;
	
	private String account;
	private String password;
	private String respCookies;
	private String loginMsg;
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getRandomKey() {
		return randomKey;
	}
	public void setRandomKey(String randomKey) {
		this.randomKey = randomKey;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRespCookies() {
		return respCookies;
	}
	public void setRespCookies(String respCookies) {
		this.respCookies = respCookies;
	}
	public String getLoginMsg() {
		return loginMsg;
	}
	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}
	
	
	
	
		
}

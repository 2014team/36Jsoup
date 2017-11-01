package com.jsoup.zhilianjob.login.vo;

import com.jsoup.base.vo.BaseVO;

/**
* @ClassName: LoginVO
* @Description: 登录VO
* @author zhuzq
* @date 2017-10-26 上午11:41:55
*/
public class ZhilianJobLoginVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String loginName;
	private String password;
	private String checkCode;
	private String respCookies;
	private String loginMsg;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
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

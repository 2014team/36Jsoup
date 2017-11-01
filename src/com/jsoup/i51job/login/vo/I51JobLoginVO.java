package com.jsoup.i51job.login.vo;

import com.jsoup.base.vo.BaseVO;

/**
* @ClassName: LoginVO
* @Description: 登录VO
* @author zhuzq
* @date 2017-10-26 上午11:41:55
*/
public class I51JobLoginVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String lang = "c";
	private String action = "save";
	private String fromDomain = "i";
	private String isread = "on";
	private String loginName;
	private String password;
	private String resumeId;
	private String reqCookies;
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFromDomain() {
		return fromDomain;
	}
	public void setFromDomain(String fromDomain) {
		this.fromDomain = fromDomain;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
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
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getReqCookies() {
		return reqCookies;
	}
	public void setReqCookies(String reqCookies) {
		this.reqCookies = reqCookies;
	}
	
	
}

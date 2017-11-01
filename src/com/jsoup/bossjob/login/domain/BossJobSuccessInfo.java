package com.jsoup.bossjob.login.domain;

/**
* @ClassName: BossJobSuccessInfo
* @Description: 登录成返回信息实体
* @author zhuzq
* @date 2017-10-30 下午5:45:22
*/
public class BossJobSuccessInfo {
	private String identity;
	private String userEncryptId;
	private String resmsg;
	private String onlineBossCount;
	private String toUrl;
	private String userId;
	private String userName;
	private String bossCount;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getUserEncryptId() {
		return userEncryptId;
	}

	public void setUserEncryptId(String userEncryptId) {
		this.userEncryptId = userEncryptId;
	}

	public String getResmsg() {
		return resmsg;
	}

	public void setResmsg(String resmsg) {
		this.resmsg = resmsg;
	}

	public String getOnlineBossCount() {
		return onlineBossCount;
	}

	public void setOnlineBossCount(String onlineBossCount) {
		this.onlineBossCount = onlineBossCount;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		this.toUrl = toUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBossCount() {
		return bossCount;
	}

	public void setBossCount(String bossCount) {
		this.bossCount = bossCount;
	}

}

package com.jsoup.zhilianjob.login.domain;

public class ZhilianJobSuccessInfo {
	
	//({ErrorCode:23,MessageText:"您输入的密码与账号不匹配",Access_Token:"",Refresh_Token:""})
	private int ErrorCode;
	private String MessageText;
	private String Access_Token;
	private String Refresh_Token;
	
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	public String getMessageText() {
		return MessageText;
	}
	public void setMessageText(String messageText) {
		MessageText = messageText;
	}
	public String getAccess_Token() {
		return Access_Token;
	}
	public void setAccess_Token(String access_Token) {
		Access_Token = access_Token;
	}
	public String getRefresh_Token() {
		return Refresh_Token;
	}
	public void setRefresh_Token(String refresh_Token) {
		Refresh_Token = refresh_Token;
	}
	

}

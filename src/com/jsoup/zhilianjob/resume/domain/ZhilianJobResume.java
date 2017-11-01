package com.jsoup.zhilianjob.resume.domain;

import java.io.Serializable;

public class ZhilianJobResume implements Serializable{
	private static final long serialVersionUID = 1L;
	// BASE
	private String baseName;// 姓名
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	
	
}

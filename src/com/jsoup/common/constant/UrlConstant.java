package com.jsoup.common.constant;

import com.jsoup.common.utils.PropertiesUtils;


/**
* @ClassName: UrlConstant
* @Description: url常量类
* @author zhuzq
* @date 2017-10-27 上午10:28:03
*/
public class UrlConstant {
	
	//I51job(前程无忧)
	public static class I51job{
		public static final String LOGIN_URL = PropertiesUtils.getValue("i51job.login.url");
		public static final String RESUME_URL = PropertiesUtils.getValue("i51job.resume.url");
	}
	
	
	//zhilian(智联招聘)
	public static class Zhilian{
		public static final String LOGIN_URL = PropertiesUtils.getValue("zhilian.login.url");
		public static final String LOGIN_SECOND_URL = PropertiesUtils.getValue("zhilian.login.second.url");//登录跳转url
		public static final String DOMAIN_URL = PropertiesUtils.getValue("zhilian.domain.url");//网站域名
	}
	
	//boss(boss直聘)
	public static class Boss{
		public static final String LOGIN_CAPTCHA_URL = PropertiesUtils.getValue("boss.captcha.url");//获取验证码
		public static final String LOGIN_URL = PropertiesUtils.getValue("boss.login.url");
		public static final String RESUME_URL = PropertiesUtils.getValue("boss.resume.url");
		public static final String DOMAIN_URL = PropertiesUtils.getValue("boss.domain.url");//网站域名
	}
	

}

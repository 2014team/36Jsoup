package com.jsoup.i51job.resume.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsoup.i51job.login.service.I51JobLoginService;
import com.jsoup.i51job.login.vo.I51JobLoginVO;
import com.jsoup.i51job.resume.domain.I51JobResume;
import com.jsoup.i51job.resume.service.I51JobResumeService;

@Controller
@RequestMapping("/i51job/resume")
public class I51JobResumeController {
	
	@Autowired
	I51JobLoginService loginService;
	@Autowired
	I51JobResumeService resumeService;
	
	//测试
	//账号：hahaluyi2003@sina.com 
	//密码 ：lbg123123123
	/**
	* @Title: get
	* @Description:获取简历信息
	* @date  2017-10-30 上午10:15:22
	* @param loginVO（参数只需账号与密码）
	* @param request
	* @return
	* @throws IOException
	 */
	@RequestMapping("/get")
	public String get(I51JobLoginVO loginVO,HttpServletRequest request){
		String view = "/i51job/index";
		//登录
		loginVO = loginService.login(loginVO);
		if(null == loginVO || StringUtils.isBlank(loginVO.getReqCookies())){
			request.setAttribute("errMsg", "用户名或者密码不正确");
			return view;
		}
		I51JobResume resume = resumeService.getResume(loginVO);
		//简历数据
		request.setAttribute("resume", resume);
		//请求参数
		request.setAttribute("loginVO", loginVO);
		return view;
	}
	
	@RequestMapping("/index")
	public String index(){
		return "/i51job/index";
	}
	
	
}
	


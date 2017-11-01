package com.jsoup.zhilianjob.resume.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsoup.zhilianjob.login.service.ZhilianJobLoginService;
import com.jsoup.zhilianjob.login.vo.ZhilianJobLoginVO;
import com.jsoup.zhilianjob.resume.domain.ZhilianJobResume;
import com.jsoup.zhilianjob.resume.service.ZhilianJobResumeService;

@Controller
@RequestMapping("/zhilianjob/resume")
public class zhilianJobResumeController {
	
	@Autowired
	ZhilianJobLoginService loginService;
	@Autowired
	ZhilianJobResumeService resumeService;
	
	
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
	public String get(ZhilianJobLoginVO loginVO,HttpServletRequest request) throws IOException{
		String view = "/zhilianjob/index";
		//登录
		loginVO = loginService.login(loginVO);
		if(null != loginVO && StringUtils.isNotBlank(loginVO.getLoginMsg())){
			request.setAttribute("errMsg", loginVO.getLoginMsg());
			return view;
		}
		ZhilianJobResume resume = resumeService.getResume(loginVO);
		//简历数据
		request.setAttribute("resume", resume);
		//请求参数
		request.setAttribute("loginVO", loginVO);
		return view;	

	}
	
	
	@RequestMapping("/index")
	public String index(){
		return "/zhilianjob/index";
	}
	
	
}
	


package com.jsoup.bossjob.resume.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsoup.bossjob.login.service.BossJobLoginService;
import com.jsoup.bossjob.login.vo.BossJobLoginVO;
import com.jsoup.bossjob.resume.domain.BossJobResume;
import com.jsoup.bossjob.resume.service.BossJobResumeService;
import com.jsoup.common.constant.UrlConstant;

@Controller
@RequestMapping("/bossjob/resume")
public class BossJobResumeController {
	
	@Autowired
	BossJobLoginService loginService;
	@Autowired
	BossJobResumeService resumeService;

	/**
	* @Title: get
	* @Description: 获取简历信息
	* @author zhuzq
	* @date  2017-10-30 下午5:47:45
	* @param loginVO（账号、密码、验证码）
	* @param request
	* @return
	*/
	@RequestMapping("/get")
	public String get(BossJobLoginVO loginVO,HttpServletRequest request){
		String view = "/bossjob/index";
		loginVO  = loginService.login(loginVO);
		if(null == loginVO){
			request.setAttribute("errMsg", "程序异常，稍后访问");
			return view;
		}
		
		
		//验证码错误、登录失败，账户密码错误
		if(null != loginVO && !"请求成功".equalsIgnoreCase(loginVO.getLoginMsg())){
			request.setAttribute("errMsg", loginVO.getLoginMsg());
			return view;
		}
		BossJobResume resume= resumeService.getReume(loginVO);
		request.setAttribute("resume", resume);
		request.setAttribute("loginVO", loginVO);
		return view;
	}
	
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		String url  = UrlConstant.Boss.LOGIN_CAPTCHA_URL;
		BossJobLoginVO loginVO = loginService.getCaptcha(url);
		request.setAttribute("loginVO", loginVO);
		return "/bossjob/index";
	}
	
	
	
	
	
}
	


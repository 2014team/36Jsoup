package com.jsoup.zhilianjob.resume.service;

import org.springframework.stereotype.Service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.zhilianjob.login.vo.ZhilianJobLoginVO;
import com.jsoup.zhilianjob.resume.domain.ZhilianJobResume;

@Service
public interface ZhilianJobResumeService extends BaseJsoupService{
	
	/**
	* @Title: getResume
	* @Description: 获取简历信息
	* @author zhuzq
	* @date  2017-10-26 下午4:01:49
	* @param loginVO
	* @return
	*/
	public ZhilianJobResume getResume(ZhilianJobLoginVO loginVO);
	

}

package com.jsoup.i51job.resume.service;

import org.springframework.stereotype.Service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.i51job.login.vo.I51JobLoginVO;
import com.jsoup.i51job.resume.domain.I51JobResume;

@Service
public interface I51JobResumeService extends BaseJsoupService{
	
	/**
	* @Title: getResume
	* @Description: 获取简历信息
	* @author zhuzq
	* @date  2017-10-26 下午4:01:49
	* @param loginVO
	* @return
	*/
	public I51JobResume getResume(I51JobLoginVO loginVO);
	

}

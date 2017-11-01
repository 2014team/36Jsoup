package com.jsoup.bossjob.resume.service;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.bossjob.login.vo.BossJobLoginVO;
import com.jsoup.bossjob.resume.domain.BossJobResume;

public interface BossJobResumeService extends BaseJsoupService{

	public BossJobResume getReume(BossJobLoginVO loginVO);
	
	
	

}

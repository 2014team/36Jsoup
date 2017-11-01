package com.jsoup.bossjob.resume.service.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.jsoup.abs.impl.BaseJsoupServiceImpl;
import com.jsoup.bossjob.login.vo.BossJobLoginVO;
import com.jsoup.bossjob.resume.domain.BossJobResume;
import com.jsoup.bossjob.resume.service.BossJobResumeService;
import com.jsoup.common.constant.StringUtil;
import com.jsoup.common.constant.UrlConstant;

@Service
public class BossJobResumeServiceImpl extends BaseJsoupServiceImpl  implements BossJobResumeService{

	@Override
	public BossJobResume getReume(BossJobLoginVO loginVO) {
		String url = UrlConstant.Boss.RESUME_URL;
		String cookie = loginVO.getRespCookies();
		try {
			if(StringUtils.isNotBlank(cookie)){
				Map<String,Object> data  = httpGet(url, null, cookie);
				Document doc =(Document)data.get("doc");
				return resumeHandle(doc);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		//证明cookise值已经过期
		return null;
	}

	public BossJobResume resumeHandle(Document doc){
		//base部分
		BossJobResume resume = baseInfoHandle(doc);
		return resume;
	}

	private BossJobResume baseInfoHandle(Document doc) {
		System.out.println(doc.html());
		BossJobResume resume = null;
		Elements names = doc.select("h2.name");
		if(null != names &&names.size() > 0){
			Element name = names.get(0);
			if(null != name){
				resume = new BossJobResume();
				String baseName = name.text();
				if(StringUtils.isNotBlank(baseName) && baseName.indexOf("编辑")!= -1){
					baseName = StringUtil.getStringNoBlank(baseName);
					baseName = baseName.replaceAll("编辑", "");
					resume.setBaseName(baseName);
				}
			}
		}
		return resume;
	}

}

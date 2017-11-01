package com.jsoup.listener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jsoup.common.utils.PropertiesUtils;


@Component
public class ConfigListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) { 
			System.out.println("--------初始化配置文件----------");
			PropertiesUtils.init("/i51job-config.properties");
			PropertiesUtils.init("/zhilianjob-config.properties");
			PropertiesUtils.init("/bossjob-config.properties");
	}
		 
}
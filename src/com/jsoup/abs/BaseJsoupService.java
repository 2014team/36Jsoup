package com.jsoup.abs;
import java.io.IOException;
import java.util.Map;

public interface BaseJsoupService{
	/**
	* @Title: httpPost
	* @Description: Post请求
	* @author zhuzq
	* @date  2017-10-25 下午4:24:41
	* @param url
	* @param paramMap
	* @param cookie
	* @return
	* @throws IOException
	*/
	public Map<String,Object> httpPost(String url,Map<String,String> paramMap,String cookie)throws IOException;
	/**
	* @Title: httpGet
	* @Description: Get请求
	* @author zhuzq
	* @date  2017-10-25 下午4:24:57
	* @param url
	* @param paramMap
	* @param cookie
	* @return
	* @throws IOException
	*/
	public  Map<String,Object> httpGet(String url,Map<String,String> paramMap ,String cookie) throws IOException;
}

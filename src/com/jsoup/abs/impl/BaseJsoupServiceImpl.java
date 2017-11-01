package com.jsoup.abs.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import com.jsoup.abs.BaseJsoupService;
import com.jsoup.common.constant.HttpHeaderConstant;

public class BaseJsoupServiceImpl implements BaseJsoupService{
	
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
	@Override
	 public Map<String, Object> httpGet(String url,Map<String,String> paramMap,String cookie) throws IOException{
	        
		Map<String, Object>  data = new HashMap<String, Object>();
			//获取请求连接
	        Connection con = Jsoup.connect(url);
	        //请求头设置，特别是cookie设置
	        con = setHeaderParam(con);
	      //遍历生成参数
	        if(paramMap!=null){
	            for (Entry<String, String> entry : paramMap.entrySet()) {     
	               //添加参数
	                con.data(entry.getKey(), entry.getValue());
	               } 
	        }
	        if(StringUtils.isNotBlank(cookie)){
	        	con.header("Cookie", cookie);
	        }
	        //解析请求结果
	        Document doc=con.get(); 
	        data.put("doc", doc);
	        data.put("con", con);
	       // System.out.println(doc.html());
	        //返回内容
	        return data;
	        
	    }
	
	
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
	@Override
	public Map<String, Object> httpPost(String url,Map<String, String> paramMap, String cookie) throws IOException {
		Map<String, Object>  data = new HashMap<String, Object>();
		//获取请求连接
       Connection con = Jsoup.connect(url);
       //请求头设置，特别是cookie设置
       con = setHeaderParam(con);
     //遍历生成参数
       if(paramMap!=null){
           for (Entry<String, String> entry : paramMap.entrySet()) {     
              //添加参数
               con.data(entry.getKey(), entry.getValue());
              } 
       }
       if(StringUtils.isNotBlank(cookie)){
       	con.header("Cookie", cookie);
       }
       //解析请求结果
       Document doc=con.post(); 
       data.put("doc", doc);
       data.put("con", con);
      // System.out.println(doc.html());
       //返回内容
       return data;
	}
	
	
	/**
	* @Title: setHeaderParam
	* @Description: 请求头信息封装
	* @author zhuzq
	* @date  2017-10-25 下午4:25:39
	* @param con
	* @return
	*/
	public Connection setHeaderParam(Connection con){
		 con.ignoreContentType(true).header("Accept", HttpHeaderConstant.ACCEPT)
			 .header("Content-Type", HttpHeaderConstant.CONTENT_TYPE)
			 .header("User-Agent", HttpHeaderConstant.USER_AGENT)
		     .timeout(HttpHeaderConstant.TIMEOUT).maxBodySize(HttpHeaderConstant.MAXBODYSIZE);
		return con;
	}
	
	
	/**
	* @Title: getReqCookies
	* @Description: 获取request中cookies值
	* @author zhuzq
	* @date  2017-10-30 下午1:43:56
	* @param con
	* @return
	*/
	public String getReqCookies(Connection con){
		 Request req = con.request();
		 Map<String,String> cookiesMap = req.cookies();
		 StringBuilder sb = new StringBuilder();
		 for (Map.Entry<String, String> item : cookiesMap.entrySet()) {
			 sb.append(item.getKey());
			 sb.append("=");
			 sb.append(item.getValue());
			 sb.append(";");
		}
	    return sb.toString();
	}
	
	
	/**
	* @Title: getRespCookies
	* @Description: 获取respose中cookies值
	* @author zhuzq
	* @date  2017-10-30 下午1:46:01
	* @param con
	* @return
	*/
	public String getRespCookies(Connection con){
		 Response resp = con.response();
		 Map<String,String> cookiesMap = resp.cookies();
		 StringBuilder sb = new StringBuilder();
		 for (Map.Entry<String, String> item : cookiesMap.entrySet()) {
			 sb.append(item.getKey());
			 sb.append("=");
			 sb.append(item.getValue());
			 sb.append(";");
		}
	   return sb.toString();
	}
	
	
	

	
}

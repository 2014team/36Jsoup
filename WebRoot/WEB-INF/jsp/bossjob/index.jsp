<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Boos直聘</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	  <script type="text/javascript" src="js/jquery.js"></script>  

	<style type="text/css">
		.main{
			margin: 10px; auto;
		 	text-align: center;
		}
		.main div{
			padding: 5px
		}
		.main h1{
		 	font-size: 16px;
		}
		.resupse{
			margin-top: 20px;
		}
		.errMsg{
			color: red;
		}
		.imgClass,.captcha{
		 float: left;
		}
	</style>

  </head>
  
  <body>
  		<div class="main">
  			<h1>Boos直聘</h1>
  			<form action="/bossjob/resume/get">
			<div>帐号：<input type="text" name="account" value="${loginVO.account }"></div>
			<div>密码：<input type="text" name="password" value="${loginVO.password }"></div>
			<div><img id="imgObj" src="${loginVO.url}" onclick="javaScript:changeImg()"></div>
			<div>
				验证码：<input type="text" name="captcha" value="${loginVO.captcha }"> 
			</div>
			 <input type="hidden" name="randomKey" value="${loginVO.randomKey }">
   			 <input type="hidden" name="respCookies" value="${loginVO.respCookies }">
			<div class="errMsg">${errMsg }</div>
			<div class = "btn"><input  type="submit" value="登录"></div>
			<div><a href="/bossjob/resume/index"><input  type="button" value="重新请求接口"></a></div>
			</form>
			
	  		<div class="resupse">
				<h1>返回内容</h1>
	  			<div>姓名：<input type="text" value="${resume.baseName }"></div>
	  		</div>
  		</div>
  		
		
  </body>


<script>
	function changeImg() {
	debugger;
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
		// 时间戳
		// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			urlurl = url.substring(0, 17);
			if ((url.indexOf("?") >= 0)) {
				urlurl = url + "&t=" + timestamp;
			} else {
				urlurl = url + "?t=" + timestamp;
			}
			return urlurl;
		}
	}
</script>
</html>

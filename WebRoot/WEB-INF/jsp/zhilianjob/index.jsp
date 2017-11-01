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
    
    <title>智联招聘</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
	</style>

  </head>
  
  <body>
  		<div class="main">
  			<h1>智联招聘</h1>
  			<form action="/zhilianjob/resume/get">
			<div>帐号：<input type="text" name="loginName" value="${loginVO.loginName }"></div>
			<div>密码：<input type="text" name="password" value="${loginVO.password }"></div>
			<div class="errMsg">${errMsg }</div>
			<div><input type="submit" value="登录"></div>
			<div><a href="/zhilianjob/resume/index"><input  type="button" value="重新请求接口"></a></div>
			</form>
			
	  		<div class="resupse">
				<h1>返回内容</h1>
	  			<div>姓名：<input type="text" value="${resume.baseName }"></div>
	  		</div>
  		</div>
  		
		
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		}
		.mian{
			text-align: center;
			margin-top: 20px;
		}
		.mian li{
			margin: 5 auto;
		}
	</style>

  </head>
  		<div class="mian">
  			<h1>列表</h1>
  			<ul>
  				<li><a href="/i51job/resume/index">前程无忧 </a></li>
  				<li><a href="/zhilianjob/resume/index">智联招聘</a></li>
  				<li><a href="/bossjob/resume/index">Boss直聘 </a></li>
  			</ul>
  		</div>
  <body>
    
  </body>
</html>

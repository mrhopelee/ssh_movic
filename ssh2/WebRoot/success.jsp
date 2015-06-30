<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>成功</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<p align="center" color="gray">
	<hr color="gray" size="3">
	<br>
	<font size=" 6" color="gray">--------------------操作成功!!!--------------------</font>
	<br>
	<br>
	<br>
	<font size=" 5" color="gray">--------------------<a
		href="index.jsp">返回首页</a>--------------------
	</font>

	</p>
	<br>
	<br>
	<hr color="gray" size="3">
	<br>

</body>
</html>

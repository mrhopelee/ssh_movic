
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'error.jsp' starting page</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<p align="center" color="gray">
	<hr color="gray" size="3">
	
	
	
	<%
out.println("<script>alert('你今天已经签到过了,一天只能签到一次喔亲！！！');</script>");

%>
	<br>
	<br>
		<font size=" 5" color="gray">--------------------<a href="index.jsp">Click here Back To Index</a>--------------------</font>
	<br>
	<br>
	<hr color="gray" size="3">
	<br>
	</p>
</body>
</html>

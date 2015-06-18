<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 使用bootstrap 的css样式 -->
<title>首页</title>
</head>
<body>
	<s:include value="userFunction.jsp"></s:include>
	<a href="scanMovieAction?id=0">电影0</a>
	<a href="fileDownloadAction">下载</a>
</body>
</html>

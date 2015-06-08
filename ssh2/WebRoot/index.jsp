<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>首页</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
    This is my JSP page. <br>
    <s:form action="" namespace="/">
  <s:textfield label="用户名" name="name" ></s:textfield>
  <s:textfield label="密码" name="password"></s:textfield>
  <s:submit value="登录2"></s:submit>
  </s:form>

  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bean.UserInfo"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'UpdateUserPassword.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link href="css/cc.css" rel="stylesheet" type="text/css" />
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>
  </head>
  
  <body>
<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
<br>
	<p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Welcome--------------------</font>
	</p>
	<br>
	<br>
	<br>
	<hr color="gray" size="3">
	<br>
	
<%-- <s:action name="test" flush="true" namespace="/"></s:action>	 --%>
<%
session=request.getSession();
UserInfo user=(UserInfo)session.getAttribute("user");
//System.out.println(user.getEmail());  
%>
<form method="POST" action="updateUserPassword" namespace="/">
<table align="center"   class="table table-hover table-bordered " >
	<tr  align="center"><p align="center" color="gray">
		<font size=" 3" color="gray">--------------------Update UserMessage Page--------------------</font>
	</p></tr>
	<br>
    <tr  align="center">
      <td ">用户名：</td>
      <td ><label>
        <input name="userName" type="text" id="userName" value="<%=user.getUserName()%>"  readonly="readonly"/>
      </label></td>
    </tr>
    <tr  align="center">
      <td>新密码：</td>
      <td><label>
        <input name="userPassword" type="password" id="userPassword"/>
      </label>
      <s:fielderror fieldName="password"/></td>
    </tr>   
   
  <tr  align="center">
      <td>确认密码：</td>
      <td><label>
        <input name="rePassword" type="password" id="rePassword" />
      </label><s:fielderror fieldName="rePassword"/></td>
    </tr>  

    <tr  align="center">
      <td><label>
        <input class="btn btn-default buttom1"   type="submit" name="Submit" value="提交" />
      </label></td>
      <td><label>
      
 <a href="index.jsp">返回主页</a>
      </label></td>
    </tr>
</table>
</form>
</div>
 
   
  </body>
</html>

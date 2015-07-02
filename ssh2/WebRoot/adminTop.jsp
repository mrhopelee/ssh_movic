<%@ page language="java" import="java.util.*,com.bean.*"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/adminfunction.css">


</head>

<%! UserInfo user; %>
<%
 
  
  if(request.getSession().getAttribute("user")==null)
  {
  	response.sendRedirect("index.jsp");
  	return ;
  }
  
  user=(UserInfo) request.getSession().getAttribute("user");
  
  if(user.getUserType().getValue()<3)
  {
  	response.sendRedirect("index.jsp");
  	return ;
  }
  
   %>

<%if(user.getUserType().getValue()>=3)
	{
	%>
	<div style="margin: 0 auto; width: 980px;">
	<form class="topform" action="updateUserPassword.jsp" style="display: inline;">
		<input type="submit" value="修改密码" class="btn btn-primary">
	</form>
	<form class="topform" action="userLogoutAction" style="display: inline;">
		<input type="submit" value="退出" class="btn btn-danger">
	</form>
	</div>

<%
	}
 %>


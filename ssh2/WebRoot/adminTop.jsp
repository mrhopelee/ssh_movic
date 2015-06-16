<%@ page language="java" import="java.util.*,com.bean.*" pageEncoding="UTF-8"%>
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
	
	

 
<div class="function">
<table class="table table-bordered">
<caption>电影管理功能</caption>
<tr>
<td><form action="movic_area.jsp" ><input type="submit" value="电影地区维护" class="btn btn-info"></form></td>
<td><form action="movic_type.jsp"><input type="submit" value="电影类型维护" class="btn btn-info"></form></td>
<td><form action="goToAddMovicPageAction"><input type="submit" value="电影添加" class="btn btn-info"></form></td>
<td>
<form action="getAllMovicDAction"><input type="submit" value="电影删除" class="btn btn-info">
<input type="hidden" value="1" name="paging.pageNow" >
</form>
</td>
<td>
<form action="getAllMovicUAction"><input type="submit" value="电影修改" class="btn btn-info">
<input type="hidden" value="1" name="paging.pageNow">
</form>
</td>
</tr>
</table>
</div>

<%
	}
 %>
 
 <%if(user.getUserType().getValue()==4)
	{
	%>

<div class="function">
<table class="table table-bordered" >
<caption>用户管理功能</caption>
<tr>
<td><form action="userManage.jsp"><input type="submit" value="用户管理" class="btn btn-info"></form></td>
</tr>
</table>
</div>

<!--  <div class="function">
<table class="table table-bordered">
<caption>广告管理功能</caption>
<tr>
<td><form ><input type="submit" value="添加广告" class="btn btn-info"></form></td>
<td><form ><input type="submit" value="设置广告位置" class="btn btn-info"></form></td>
</tr>
</table>
</div>-->

<div class="function">
<table class="table table-bordered">
<caption>评论管理功能</caption>
<tr>
<td><form action="commentsManage.action"><input type="submit" value="删除评论" class="btn btn-info"></form></td>
</tr>
</table>
</div>
 <%
	}
 %>

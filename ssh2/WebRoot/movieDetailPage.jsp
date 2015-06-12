<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电影详情页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <hr>
    <s:if test="#request.partCommentsList.size()!=0">
	   	<table border="0" align="center">
	   		<tr>
      			<td width="300px"><div align="center">评论日期</div></td>
      			<td width="100px"><div align="center">评论用户</div></td>
      			<td width="300px"><div align="center">评论内容</div></td>
      		</tr>
	   		<s:iterator value="#request.partCommentsList" var="mComments">
	   			<tr>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsDate" /></td>
		   			<td width="100px" align="center"><s:property value="#mComments.userInfo.userName" /></td>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsInfo" /></td>
	   			</tr>
	   		</s:iterator>
	   		<tr><td>...</td></tr>
	   		<tr>
	   			<td align="center">
	   				<form action="scanCommentsAction">
	   					<input type="submit" value="更多评论">
    					<input type="hidden" name="id" value='<s:property value="#request.nowMovieId"/>'>
	   				</form>
	   			</td>
	   		</tr>
	   	</table>
   	</s:if>
   	<s:else>暂无数据</s:else>
   	<hr>
  </body>
</html>

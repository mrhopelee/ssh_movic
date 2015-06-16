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

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

  </head>
  
  <body>
  
	  
  <!-- ==============================显示用户评价区    ( 开始)========================================== -->
  <%
  	
  	int[] average = new int[5];
  	
  	//获得平均值
  	//for(int i=0;i<5;i++){
  		
  	//}
   %>
            
  <table>
  	<tr>
  		<td><img alt="" src="images/star5.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[4]"/>人觉得力荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star4.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[3]"/>人觉得推荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star3.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[2]"/>人觉得还行!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star2.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[1]"/>人觉得较差!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="images/star1.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[0]"/>人觉得很差!</td>
  	</tr>
 
  </table>
  
  
  <!-- ==============================显示用户评价区     (结束)========================================== -->  
  

         
  <!-- ===========================电影详情页面显示部分评论区  (开始)========================================== -->
  <hr>
    <s:if test="#session.partCommentsList.size()!=0">
	   	<table border="0" align="center">
	   		<tr>
      			<td width="300px"><div align="center">评论日期</div></td>
      			<td width="100px"><div align="center">评论用户</div></td>
      			<td width="300px"><div align="center">评论内容</div></td>
      		</tr>
	   		<s:iterator value="#session.partCommentsList" var="mComments">
	   			<tr>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsDate" /></td>
		   			<td width="100px" align="center"><s:property value="#mComments.userInfo.userName" /></td>
		   			<td width="300px" align="center"><s:property value="#mComments.commentsInfo" /></td>
	   			</tr>
	   		</s:iterator>
	   		<tr><td colspan='3' align="center">...</td></tr>
	   		<tr>
	   			<td align="center" colspan='3'>
	   				<form action="scanCommentsAction">
	   					<input type="submit" value="更多评论">
    					<input type="hidden" name="id" value='<s:property value="#session.nowMovieId"/>'>
	   				</form>
	   			</td>
	   		</tr>
	   	</table>
   	</s:if>
   	<s:else>暂无数据</s:else>
   	<hr>   	
<!-- ===========================/电影详情页面显示部分评论区  (结束)========================================== -->

<!-- ============================输写评论区 （开始） ===================================================== -->
   <h2 align="center">
  	<a href="editComments.jsp">我也要评论！</a>
  </h2>

 <!-- ============================输写评论区 （结束） ===================================================== --> 
  </body>
</html>

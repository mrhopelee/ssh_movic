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
	<style type="text/css">

		.starstop {
			float: left;
			/*background: url(/f/shire/2326c3f5f1411a7ed98afb94e9e36b0868d9f3ae/pics/all_star.gif);*/
			display: block;
			width: 50px;
			height: 14px;
			margin: 1px 0 0 7px;
		}
		.starstop, .stars {
			display: inline-block;
			zoom: 1;
			width: 45px;
			height: 9px;
			/*background: url(/f/shire/ef82a60983df6252e9a43fd8d051347e89aa6753/pics/movie/smlstars.gif) no-repeat;*/
			margin: 3px 3px 0 0;
			overflow: hidden;
		}
		.stars5 {
			background-position: 0 0;
			background: url(/images/star5.png) no-repeat;
		}
		.stars4 {
			background-position: 0 -9px;
		}
		.stars3 {
			background-position: 0 -18px;
		}
		.stars2 {
			background-position: 0 -27px;
		}
		.stars1 {
			background-position: 0 -36px;
		}
	</style>

  </head>
  
  <body>
	  
  <!-- ==============================显示用户评价区    ( 开始)========================================== -->
  <!--
  	 <img alt="" src="/images/star5.png" height="30px" width="50px">
 	 <span class="stars5 starstop" title="力荐"></span>
     <div  style="width:36px"></div>
     6.0%
     <br />
     
     <span class="stars4 starstop" title="推荐"></span>
     <div  style="width:60px"></div>
     70.0%
     <br />
     
     <span class="stars3 starstop" title="还行"></span>
     <div  style="width:26px"></div>
     21.2%
     <br />
     
     <span class="stars2 starstop" title="较差"></span>
     <div  style="width:2px"></div>
     2.2%
     <br />
     
     <span class="stars1 starstop" title="很差"></span>
     <div  style="width:0px"></div>
     0.6%
         -->            
  <table>
  	<tr>
  		<td><img alt="" src="/images/star5.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[4]"/>人觉得5分力荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="/images/star4.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[3]"/>人觉得 4分推荐!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="/images/star3.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[2]"/>人觉得 3分还行!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="/images/star2.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[1]"/>人觉得 2分较差!</td>
  	</tr>
  	<tr>
  		<td><img alt="" src="/images/star1.png" height="30px" width="50px"></td>
  		<td>：<s:property value="#session.userCountByScore[0]"/>人觉得1分很差!</td>
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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查看所有评论</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Bootstrap Core CSS -->
<link href="css/comm_bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/comm_modern-business.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<!-- ==============   原来
  <h1 align="center">所有评论~~~~~~~~~~~~~~~</h1>
  <hr size=20">
    <s:if test="#request.allList.size()!=0">
	   	<table border="0" align="center">
	   		<tr>
      			<td width="300px"><div align="center">评论日期</div></td>
      			<td width="100px"><div align="center">评论用户</div></td>
      			<td width="300px"><div align="center">评论内容</div></td>
      		</tr>
	   		<s:iterator value="#request.allList" var="mComments">
	   			<tr>
		   			<td width="300px" align="center" ><s:property value="#mComments.commentsDate" /></td>
		   			<td width="100px" align="center" ><s:property value="#mComments.userInfo.userName" /></td>
		   			<td width="300px" align="center" ><s:property value="#mComments.commentsInfo" /></td>
		   			
	   			</tr>
	   			<tr><td colspan='3'> <hr size="10"> </td></tr>
	   			
	   		</s:iterator>
	   	</table>
   	</s:if>
   	<s:else>暂无数据</s:else>
   	<h2 align="center">
   		<form action="scanMovieAction">
			<input type="submit" value="返回">
			<input type="hidden" name="id" value='<s:property value="#session.nowMovieId"/>'>
		</form>
   	</h2>
   	-->
	<!-- ==========================优化==================================== -->


	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					所有评论 <small>ALL COMMENTS</small>
				</h1>
				<ol class="breadcrumb">
					<li><a
						href="scanMovieAction?id=<s:property value="#session.nowMovieId"/>">返回</a>
					</li>
					<li class="active">Scan All Comments</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->

		<!-- Blog Post Row -->

		<div class="row">
			<s:if test="#request.allList.size()!=0">
				<s:iterator value="#request.allList" var="mComments">
					<div class="col-md-1 text-center">
						<p>
							<img src="<s:property value="#mComments.userInfo.userLogo"/>">
						</p>
					</div>
					<div class="col-md-5">
						<img src="<s:property value="#mComments.movicInfo.movicPost"/>">
					</div>
					<div class="col-md-6">
						<h3>
							<s:property value="#mComments.userInfo.userName" />
						</h3>
						<p>
							in
							<s:property value="#mComments.commentsDate" />
						</p>
						<p>
							<s:property value="#mComments.commentsInfo" />
						</p>
						<hr>
					</div>

				</s:iterator>

			</s:if>
			<s:else>暂无数据</s:else>
		</div>


		<!-- Pager -->
		<!-- =================================================== -->
        <div class="row">
            <ul class="pager">
                <li class="previous"><a href="scanCommentsAction.action?pageNo= <s:property value="pageNo-1"/> &nowMovieId= <s:property value="#session.nowMovieId"/> ">上一页</a>
                </li>
                <li class="next"><a href="scanCommentsAction.action?pageNo= <s:property value="pageNo+1"/> &nowMovieId= <s:property value="#session.nowMovieId"/> ">下一页</a>
                </li>
            </ul>
        </div>



	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/comm_jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/comm_bootstrap.min.js"></script>



</body>
</html>

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

<title>评论维护</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>

</head>

<body>
	您当前位置：
	<a href="adminFunction.jsp">管理员主页</a>--评论管理
	<s:if test="#request.clist.size()!=0">
		<table border="0" align="center">
			<tr>
				<td width="100px"><div align="center">评论人</div></td>
				<td width="300px"><div align="center">评论日期</div></td>
				<td width="300px"><div align="center">评论内容</div></td>
				<td width="100px"><div align="center">操作</div></td>
			</tr>
			<s:iterator value="#request.clist" var="mComments">
				<tr>
					<td width="100px"><div align="center">
							<s:property value="#mComments.userInfo.userName" />
						</div></td>
					<td width="300px"><div align="center">
							<s:property value="#mComments.commentsDate" />
						</div></td>
					<td width="300px"><div align="center">
							<s:property value="#mComments.commentsInfo" />
						</div></td>
					<!-- <td width="100px"><div align="center"><a href="commentsManage!delComments.action?mComments.mcOid=<s:property value="#mComments.mcOid"/>">删除</a></div></td> -->
					<td>
						<div align="center">
							
							
							<a href="commentsManage!delComments.action?id=<s:property value="#mComments.mcOid"/>" >
							<span class="glyphicon glyphicon-trash" aria-hidden="true" >
							
							</span>
							</a>
							<!--  
							<form action="commentsManage!delComments.action">
								<input type="submit" value="删除">
								<input type="hidden"
									name="id" value='<s:property value="#mComments.mcOid"/>'>
							
							</form>-->
						</div>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>暂无数据！</s:else>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影类型</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/movic_at.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>

</head>

<body>
	<span class="myfilm">myfilm</span>
	<div class="userlogin">

		<p>
			<a href="adminFunction.jsp">返回管理页面</a> <a class="sy" href="index.jsp">首页<span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
		</p>
		<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
		所有类型:
		<p>
			<s:iterator value="#session.movictypelist" status="mt">
				<%-- ID: <s:property value="mtOid" /> --%>
				<%-- <s:property value="(#mt.count)" />: --%>
				<s:property value="type" />

				<%-- <s:if test="#mt.count%10==0">
					<br />
				</s:if> --%>
			</s:iterator>
		</p>

		<s:form action="insertmovictype" namespace="/">
			<h4>电影类型增加</h4>
			<s:fielderror fieldName="insertmt"></s:fielderror>
			<s:textfield cssClass="form-control" name="movictype.type"
				label="电影类型" placeholder="请输入电影类型"></s:textfield>
			<s:submit cssClass="btn" value="添加"></s:submit>
		</s:form>

		<s:form action="updatemovictype" namespace="/">
			<h4>电影类型修改</h4>
			<s:fielderror fieldName="updatemt"></s:fielderror>
			<s:select cssClass="form-control" name="movictype.type" label="电影类型"
				labelposition="left" list="#session.movictypelist.{type}"
				value="#session.movictypelist.{type}"></s:select>
			<s:textfield cssClass="form-control" name="updateType" label="修改为"
				placeholder="请输入电影类型"></s:textfield>
			<s:submit cssClass="btn" value="修改"></s:submit>
		</s:form>

		<s:form action="deletemovictype" namespace="/">
			<h4>电影类型删除</h4>
			<s:fielderror fieldName="deletemt"></s:fielderror>
			<s:select cssClass="form-control" name="movictype.type" label="电影类型"
				labelposition="left" list="#session.movictypelist.{type}"
				value="#session.movictypelist.{type}"></s:select>
			<s:submit cssClass="btn"
				onclick="return window.confirm('你确定删除这一电影类型吗吗？')" value="删除"></s:submit>
			<!-- <input type="submit" onclick="return window.confirm('你确定删除吗？')" value="删除"></input> -->
		</s:form>
	</div>
</body>
</html>

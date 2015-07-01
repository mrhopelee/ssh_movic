<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影地区</title>


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
		<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
		所有地区:
		<p>
			<s:iterator value="#session.movicarealist" status="ma">
				<%-- ID: <s:property value="mtOid" /> --%>
				<%-- <s:property value="(#ma.count)" />: --%>
				<s:property value="areaName" />

				<%-- <s:if test="#ma.count%3==0">
					<br />
				</s:if> --%>
			</s:iterator>
		</p>


		<s:form action="insertmovicarea" namespace="/">
			<h4>电影地区增加</h4>
			<s:fielderror fieldName="insertma"></s:fielderror>
			<s:textfield cssClass="form-control" name="movicarea.areaName"
				label="电影地区"></s:textfield>
			<s:submit cssClass="btn" value="添加"></s:submit>
		</s:form>


		<s:form action="updatemovicarea" namespace="/">
			<h4>电影地区修改</h4>
			<s:fielderror fieldName="updatema"></s:fielderror>
			<s:select cssClass="form-control" name="movicarea.areaName"
				label="电影地区" labelposition="left"
				list="#session.movicarealist.{areaName}"
				value="#session.movicarealist.{areaName}"></s:select>
			<s:textfield cssClass="form-control" name="updateArea" label="修改为"></s:textfield>
			<s:submit cssClass="btn" value="修改"></s:submit>
		</s:form>


		<s:form action="deletemovicarea" namespace="/">
			<h4>电影地区删除</h4>
			<s:fielderror fieldName="deletema"></s:fielderror>
			<s:select cssClass="form-control" name="movicarea.areaName"
				label="电影地区" labelposition="left"
				list="#session.movicarealist.{areaName}"
				value="#session.movicarealist.{areaName}"></s:select>
			<s:submit cssClass="btn"
				onclick="return window.confirm('你确定删除这一电影类型吗吗？')" value="删除"></s:submit>
		</s:form>
</body>
</html>

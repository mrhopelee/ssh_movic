<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影地区</title>


<link rel="stylesheet" type="text/css" href="css/normalize.css">

</head>

<body>
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>

	<s:iterator value="#session.movicarealist" status="ma">
		<%-- ID: <s:property value="mtOid" /> --%>
	地区<s:property value="(#ma.count)" />: <s:property value="areaName" />

		<s:if test="#ma.count%3==0">
			<br />
		</s:if>
	</s:iterator>

	<p>电影地区增加</p>
	<s:form action="insertmovicarea" namespace="/">
		<s:fielderror fieldName="insertma"></s:fielderror>
		<s:textfield name="movicarea.areaName" label="电影地区"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>

	<p>电影地区修改</p>
	<s:form action="updatemovicarea" namespace="/">
		<s:fielderror fieldName="updatema"></s:fielderror>
		<s:select name="movicarea.areaName" label="电影地区" labelposition="left"
			list="#session.movicarealist.{areaName}"
			value="#session.movicarealist.{areaName}"></s:select>
		<s:textfield name="updateArea" label="修改为"></s:textfield>
		<s:submit value="修改"></s:submit>
	</s:form>

	<p>电影地区删除</p>
	<s:form action="deletemovicarea" namespace="/">
		<s:fielderror fieldName="deletema"></s:fielderror>
		<s:select name="movicarea.areaName" label="电影地区" labelposition="left"
			list="#session.movicarealist.{areaName}"
			value="#session.movicarealist.{areaName}"></s:select>
		<s:submit onclick="return window.confirm('你确定删除这一电影类型吗吗？')" value="删除"></s:submit>
	</s:form>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影IAT</title>


<link rel="stylesheet" type="text/css" href="css/normalize.css">

</head>

<body>
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
	<p>
		地区:
		<s:iterator value="#session.movicarealist" status="ma">
			<s:a href="moviciatsetsession?paging.pageNow=%{#abc.count}">
					<s:property value="areaName" />
			</s:a>
			
			<s:if test="#ma.count%5==0">
				<br />
			</s:if>
		</s:iterator>
	</p>

	<p>
		类型:
		<s:iterator value="#session.movictypelist" status="mt">
			<s:property value="type" />
			<s:if test="#mt.count%5==0">
				<br />
			</s:if>
		</s:iterator>
	</p>
	<s:action name="moviciatsetsession" flush="false" namespace="/"></s:action>

	<s:iterator value="#session.moviciatlist" status="miat">
		<p>
			<s:property value="movicName" />
			<s:property value="movicDirector" />
			<s:property value="movicActor" />
			<s:property value="movicImdbScore" />
			<s:date name="movicPlayDate" format="yyyy-MM-dd"/>
		</p>
	</s:iterator>

	<%-- <s:iterator value="#session.moviciatpaging" status="pagingt">
		<s:property value="pageCount" />
		<s:property value="rowCount" />
		<s:property value="pageNow" />
		<s:property value="pageSize" />
	</s:iterator> 
	<s:select list="#session.moviciatpaging"></s:select>--%>

	<p>
		一共有
		<s:property value="%{#session.moviciatpaging.rowCount}" />
		部电影 每页
		<s:property value="%{#session.moviciatpaging.pageSize}" />
		部 分有
		<s:property value="%{#session.moviciatpaging.pageCount}" />
		页 当前在第
		<s:property value="%{#session.moviciatpaging.pageNow}" />
		页
	</p>
	<s:bean name="org.apache.struts2.util.Counter" id="counter">
		<s:param name="first" value="1" />
		<s:param name="last" value="%{#session.moviciatpaging.pageCount}" />
		<s:iterator status="abc">
			<s:if test="#session.moviciatpaging.pageNow==#abc.count">
				<s:property />
			</s:if>
			<s:else>
				<s:a href="moviciatsetsession?paging.pageNow=%{#abc.count}">
					<s:property />
				</s:a>
			</s:else>

		</s:iterator>
	</s:bean>
</body>
</html>

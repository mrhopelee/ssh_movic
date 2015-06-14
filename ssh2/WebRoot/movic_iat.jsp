<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影IAT</title>


<link rel="stylesheet" type="text/css" href="css/normalize.css">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="javascript/movic_iat.js"></script>
</head>

<body>
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>

	地区:
	<p>
		<%-- <s:a href="javascript:iatsubmit();"> --%>
		<s:a href="moviciatsetat?movicarea.areaName=不限">
			不限
		</s:a>
		<s:iterator value="#session.movicarealist" status="ma">
			<s:a href="moviciatsetat?movicarea.areaName=%{areaName}">
				<s:property value="areaName" />
			</s:a>

			<%-- <s:url id="idUrl" action="moviciatmixsetsession">
				<s:param name="movicarea.areaName" value="%{areaName}"></s:param>
			</s:url>
			<s:a href="%{idUrl}"><s:property value="areaName" /></s:a> --%>

			<s:if test="(#ma.count+1)%20==0">
				<br />
			</s:if>
		</s:iterator>
	</p>


	类型:
	<p>
		<s:a href="moviciatsetat?movictype.type=不限">
			不限
		</s:a>
		<s:iterator value="#session.movictypelist" status="mt">
			<s:a href="moviciatsetat?movictype.type=%{type}">
				<s:property value="type" />
			</s:a>
			<s:if test="#mt.count%20==0">
				<br />
			</s:if>
		</s:iterator>
	</p>
	
	<s:action name="moviciatmixsetsession" flush="false" namespace="/"></s:action>
	排序:
	<p>
		<s:form action="moviciatsetsort">
			<s:radio name="sort" list="#{'movicPlayDate':'最新电影','movicImdbScore':'高分电影'}" value="#session.moviciatsort" onclick="submit()"></s:radio>
		</s:form>
	</p>
	<!-- 电影信息 -->
	<s:iterator value="#session.moviciatlist" status="miat">
		<p>
			<s:property value="movicOid" />
			<s:property value="movicName" />
			<s:property value="movicImdbScore" />
			<s:date name="movicPlayDate" format="yyyy-MM-dd" />
			<s:property value="movicPost" />
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
				<s:a href="moviciatmixsetsession?paging.pageNow=%{#abc.count}">
					<s:property />
				</s:a>
			</s:else>

		</s:iterator>
	</s:bean>
</body>
</html>

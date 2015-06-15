<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影IAT</title>


<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>
<script src="javascript/movic_iat.js"></script>
</head>

<body>
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
	<s:action name="moviciatmixsetsession" flush="false" namespace="/"></s:action>

	<s:form action="moviciatsetsearch" namespace="/">
		<s:textfield name="search" value="%{#session.moviciatsearch}"
			placeholder="电影">
		</s:textfield>
		<s:submit value="搜索"></s:submit>
	</s:form>

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

	排序:
	<p>
		<s:form action="moviciatsetsort" namespace="/">
			<s:radio name="sort"
				list="#{'movicPlayDate':'最新电影','movicImdbScore':'高分电影'}"
				value="#session.moviciatsort" onclick="submit()"></s:radio>
		</s:form>
	</p>

	<!-- 电影信息 -->
	<s:iterator value="#session.moviciatlist" status="miat">
		<p>
			<s:a href="scanMovieAction?id=%{movicOid}"><s:property value="movicName" /></s:a>			
			<s:property value="movicImdbScore" />
			<s:date name="movicPlayDate" format="yyyy-MM-dd" />
			<s:property value="movicPost" />
		</p>
	</s:iterator>

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

	<s:if test="#session.moviciatpaging.pageNow>4">
		<s:a
				href="moviciatmixsetsession?paging.pageNow=1">
				首页 ...
			</s:a>
	</s:if>
	<s:iterator begin="1" end="2" step="1" status="a">
		<s:if
			test="%{#session.moviciatpaging.pageCount-#session.moviciatpaging.pageNow-#a.index<1}">
			<s:a
				href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index-5}">
				<s:property value="%{#session.moviciatpaging.pageNow+#a.index-5}" />
			</s:a>
		</s:if>
	</s:iterator>

	<s:iterator begin="1" end="3" step="1" status="a">

		<s:if test="%{#session.moviciatpaging.pageNow+#a.index-3>0}">
			<s:a
				href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index-3}">
				<s:property value="%{#session.moviciatpaging.pageNow+#a.index-3}" />
			</s:a>
		</s:if>
	</s:iterator>

	<s:property value="#session.moviciatpaging.pageNow" />

	<s:iterator begin="1" end="2" step="1" status="a">

		<s:if
			test="%{#session.moviciatpaging.pageNow+#a.index+1<=#session.moviciatpaging.pageCount}">
			<s:a
				href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index+1}">
				<s:property value="%{#session.moviciatpaging.pageNow+#a.index+1}" />
			</s:a>
		</s:if>
	</s:iterator>

	<s:iterator begin="1" end="3" step="1" status="a">
		<s:if test="%{#session.moviciatpaging.pageNow-1+#a.index<3}">
			<s:a
				href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index+3}">
				<s:property value="%{#session.moviciatpaging.pageNow+#a.index+3}" />
			</s:a>
		</s:if>
	</s:iterator>
	
	<s:if test="#session.moviciatpaging.pageCount-#session.moviciatpaging.pageNow>2">
		<s:a
				href="moviciatmixsetsession?paging.pageNow=1">
				... 尾页
			</s:a>
	</s:if>
	<%-- <s:bean name="org.apache.struts2.util.Counter" id="counter">
		<s:param name="first" value="1" />
		<s:param name="last" value="%{#session.moviciatpaging.pageCount}" />


		<s:iterator begin="" status="abc">
			<s:if test="#session.moviciatpaging.pageNow==#abc.count">
				<s:property />
			</s:if>
			<s:else>
				<s:a href="moviciatmixsetsession?paging.pageNow=%{#abc.count}">
					<s:property />
				</s:a>
			</s:else>
		</s:iterator>
	</s:bean> --%>
</body>
</html>

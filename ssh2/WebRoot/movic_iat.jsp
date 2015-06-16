<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电影IAT</title>


<link rel="stylesheet" type="text/css" href="css/3.3.4bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/movic_iat.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/3.3.4bootstrap.min.js"></script>
<script src="javascript/movic_iat.js"></script>
</head>

<body>
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
	<s:action name="moviciatmixsetsession" flush="false" namespace="/"></s:action>
	<div class="row">
		<div class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<s:form action="moviciatsetsearch" namespace="/">
						<s:textfield name="search" value="%{#session.moviciatsearch}"
							placeholder="电影">
						</s:textfield>
						<s:submit value="搜索"></s:submit>
					</s:form>
				</div>
			</div>
			<div class="row iatmargin30">
				<div class="col-sm-1 col-md-1 ">
					<h3>
						<span class="label label-primary iatpadding">地区</span>
					</h3>
				</div>
				<div class="col-sm-11 col-md-11 ">
					<%-- <s:a href="javascript:iatsubmit();"> --%>

					<div class="btn-group" role="group" aria-label="...">

						<s:a cssClass="" href="moviciatsetat?movicarea.areaName=不限">
							<button type="button"
								class="btn btn-default iatmargin2 <s:if test="#session.mastr.equals('')">active</s:if>">不限</button>
						</s:a>
						<s:iterator value="#session.movicarealist" status="ma">
							<s:if test="areaOid!=32">
								<s:a cssClass=""
									href="moviciatsetat?movicarea.areaName=%{areaName}">
									<button type="button"
										class="btn btn-default iatmargin2 <s:if test="#session.mastr==areaName">active</s:if>">
										<s:property value="areaName" />
									</button>
								</s:a>
							</s:if>
							<%-- <s:if test="%{#ma.count%10==0}"><br/></s:if> --%>
						</s:iterator>
					</div>

				</div>
			</div>
			<div class="row iatmargin30">
				<div class="col-sm-1 col-md-1 ">
					<h3>
						<span class="label label-primary iatpadding">类型</span>
					</h3>
				</div>
				<div class="col-sm-11 col-md-11 ">
					<div class="btn-group" role="group" aria-label="...">
						<s:a cssClass="" href="moviciatsetat?movictype.type=不限">
							<button type="button"
								class="btn btn-default iatmargin2 <s:if test="#session.mtstr.equals('')">active</s:if>">不限</button>
						</s:a>

						<s:iterator value="#session.movictypelist" status="mt">
							<s:if test="mtOid!=57">
								<s:a cssClass="" href="moviciatsetat?movictype.type=%{type}">
									<button type="button"
										class="btn btn-default iatmargin2 <s:if test="#session.mtstr==type">active</s:if>">
										<s:property value="type" />
									</button>
								</s:a>
							</s:if>
							<%-- <s:if test="%{#mt.count%10==0}"><br/></s:if> --%>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="row iatmargin30">

				<div class="col-sm-12 col-md-12 ">

					<form action="moviciatsetsort" namespace="/">
						<h3>
							<span class="label label-primary iatpadding">排序</span>
						</h3>
						<label class="radio-inline"> <input type="radio"
							onclick="submit();"
							<s:if test="#session.moviciatsort.equals('movicPlayDate')">checked="checked"</s:if>
							name="sort" id="sort1" value="movicPlayDate"> 最新电影
						</label> <label class="radio-inline"> <input type="radio"
							onclick="submit();"
							<s:if test="#session.moviciatsort.equals('movicImdbScore')">checked="checked"</s:if>
							name="sort" id="sort2" value="movicImdbScore"> 高分电影
						</label>
					</form>
				</div>
			</div>
			<!-- 电影信息 -->
			<div class="row">
				<s:iterator value="#session.moviciatlist" status="miat">
					<%-- <s:property value="movicPost" /> --%>

					<div class="col-sm-3 col-md-3">
						<div class="thumbnail">
							<img class="iat_img" src='<s:property value="%{movicPost}"/>'
								alt="<s:property value="%{movicName}"/>" />
							<div class="caption">
								<h4>
									<s:a href="scanMovieAction?id=%{movicOid}">
										<s:property value="movicName" />
										(<s:date name="movicPlayDate" format="yyyy" />)
									</s:a>
								</h4>
								<span class="label label-default"> IMDB:<a
									href="javascript:return(0)"><s:property
											value="movicImdbScore" /></a>
								</span>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>

		</div>
	</div>
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

	<s:if test="#session.moviciatpaging.pageCount<=6">
		<s:bean name="org.apache.struts2.util.Counter" id="counter">
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
		</s:bean>
	</s:if>
	<s:else>
		<s:if test="#session.moviciatpaging.pageNow>4">
			<s:a href="moviciatmixsetsession?paging.pageNow=1">
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

		<s:if
			test="#session.moviciatpaging.pageCount-#session.moviciatpaging.pageNow>2">
			<s:a
				href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageCount}">
				... 尾页
			</s:a>
		</s:if>
	</s:else>
	<%--  --%>
</body>
</html>

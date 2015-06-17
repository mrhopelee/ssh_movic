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

<body class="container-fluid">
	<s:action name="movicareasetsession" flush="false" namespace="/"></s:action>
	<s:action name="movictypesetsession" flush="false" namespace="/"></s:action>
	<s:action name="moviciatmixsetsession" flush="false" namespace="/"></s:action>
	<div class="row">
		<div class="col-sm-12 col-md-12 iatborderline navbar-fixed-top">
			<div class="col-sm-6 col-sm-offset-1 col-md-6 col-md-offset-1 logo ">
				<div class="col-sm-4 col-md-4">myfilm</div>
				<!-- <h2 class="logo">My Film</h2> -->
				<div class="col-sm-8 col-md-8 iatsearch">
					<s:form cssClass="input-group " action="moviciatsetsearch"
						namespace="/">
						<s:textfield cssClass="form-control" name="search"
							value="%{#session.moviciatsearch}" placeholder="我的电影">
						</s:textfield>
						<span class="input-group-btn"> <s:submit
								cssClass="btn btn-default" value="搜索"></s:submit>
						</span>
					</s:form>
				</div>
			</div>
			<div class="col-sm-1 col-md-1 iatnava">
				<a href="index.jsp">首页</a>
			</div>
			<div class="col-sm-3 col-md-3 iatnava">
				<div class="col-sm-3 col-md-3 iatnava">
					<a href="index.jsp">X</a>
				</div>
				<div class="col-sm-3 col-md-3 iatnava">
					<a href="index.jsp">XX</a>
				</div>
				<div class="col-sm-3 col-md-3 iatnava">
					<a href="index.jsp">注册</a>
				</div>
				<div class="col-sm-3 col-md-3 iatnava">
					<a href="index.jsp">登陆</a>
				</div>
				<!-- 登陆后要显示的
				<div class="col-xs-1 col-md-1 iatuser">
					<div class="thumbnail userhead">
						<a href="usermanager.jap"> <img class=""
							src="movic_picture/14.jpg" alt="username" />
						</a>
					</div>
				</div>
				<div class="col-xs-4 col-md-4">n</div> -->
			</div>
		</div>
		<div class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 ">

			<%-- <div class="row">
				<div class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1">
					<s:form cssClass="input-group" action="moviciatsetsearch"
						namespace="/">
						<s:textfield cssClass="form-control" name="search"
							value="%{#session.moviciatsearch}" placeholder="电影">
						</s:textfield>
						<span class="input-group-btn"> <s:submit
								cssClass="btn btn-default" value="搜索"></s:submit>
						</span>
					</s:form>
				</div>
			</div> --%>
			<div class="row iatmargin5">
				<div class="col-sm-1 col-md-1 ">

					<span class="info2 iatpadding">地区</span>

				</div>
				<div class="col-sm-11 col-md-11 ">
					<%-- <s:a href="javascript:iatsubmit();"> --%>

					<div class="btn-group" role="group" aria-label="...">

						<s:a cssClass="" href="moviciatsetat?movicarea.areaName=不限">
							<button type="button"
								class="btn btn-default iatmargin2 <s:if test="#session.mastr.equals('')">active</s:if>">不限</button>
						</s:a>
						<s:iterator value="#session.movicarealist" status="ma">
							<!-- <br/> -->
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

			<div class="row iatmargin5">
				<div class="col-sm-1 col-md-1 ">

					<span class="info2 iatpadding">类型</span>

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

			<div class="row iatmargin50">
				<div class="col-sm-1 col-md-1 ">

					<span class="iatpadding2">排序</span>

				</div>
				<div class="col-sm-9 col-md-9 ">

					<form class="iatpadding8" action="moviciatsetsort" namespace="/">
						<label class="radio-inline"><input type="radio"
							onclick="submit();"
							<s:if test="#session.moviciatsort.equals('mi.movicPlayDate')">checked="checked"</s:if>
							name="sort" id="sort1" value="mi.movicPlayDate" /> 最新电影</label> 
						<label class="radio-inline"><input type="radio"
							onclick="submit();"
							<s:if test="#session.moviciatsort.equals('mi.movicImdbScore')">checked="checked"</s:if>
							name="sort" id="sort2" value="mi.movicImdbScore" /> 高分电影</label>
						<label class="radio-inline"><input type="radio"
							onclick="submit();"
							<s:if test="#session.moviciatsort.equals('mvn.visiterNumber')">checked="checked"</s:if>
							name="sort" id="sort3" value="mvn.visiterNumber" /> 热门电影</label>
					</form>
				</div>
				<div class="col-sm-2 col-md-2 ">
					<span class="iatpadding2 iatfont12">一共有<s:property
							value="%{#session.moviciatpaging.rowCount}" />个筛选结果
					</span>

				</div>

			</div>
			<!-- 电影信息 -->
			<div class="row">
				<div class="col-sm-12 col-md-12 ">
					<s:iterator value="#session.moviciatlist" status="miat">
						<%-- <s:property value="movicPost" /> --%>

						<div class="col-sm-3 col-md-3">
							<div class="thumbnail">
								<s:a href="scanMovieAction?id=%{movicOid}">
									<img class="iat_img" src='<s:property value="%{movicPost}"/>'
										alt="<s:property value="%{movicName}"/>" />

								</s:a>
								<div class="caption">
									<h4>
										<s:a href="scanMovieAction?id=%{movicOid}">
											<s:property value="movicName" />
										(<s:date name="movicPlayDate" format="yyyy" />)
									</s:a>
									</h4>
									<h5>
										<span class="label label-info"> IMDB: <s:property
												value="movicImdbScore" />
										</span>
									</h5>
								</div>
							</div>
						</div>
					</s:iterator>
				</div>
				<div class="col-sm-12 col-md-12 iatcenter">
					<s:if test="#session.moviciatpaging.pageCount==0">
					wu nei rong
					</s:if>
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
							<s:a cssClass="chinesefont"
								href="moviciatmixsetsession?paging.pageNow=1">
				<<
			</s:a> ...
						</s:if>
						<s:iterator begin="1" end="2" step="1" status="a">
							<s:if
								test="%{#session.moviciatpaging.pageCount-#session.moviciatpaging.pageNow-#a.index<1}">
								<s:a
									href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index-5}">
									<s:property
										value="%{#session.moviciatpaging.pageNow+#a.index-5}" />
								</s:a>
							</s:if>
						</s:iterator>

						<s:iterator begin="1" end="3" step="1" status="a">

							<s:if test="%{#session.moviciatpaging.pageNow+#a.index-3>0}">
								<s:a
									href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index-3}">
									<s:property
										value="%{#session.moviciatpaging.pageNow+#a.index-3}" />
								</s:a>
							</s:if>
						</s:iterator>

						<strong class="iatpagenow"><s:property
								value="#session.moviciatpaging.pageNow" /></strong>

						<s:iterator begin="1" end="2" step="1" status="a">

							<s:if
								test="%{#session.moviciatpaging.pageNow+#a.index+1<=#session.moviciatpaging.pageCount}">
								<s:a
									href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index+1}">
									<s:property
										value="%{#session.moviciatpaging.pageNow+#a.index+1}" />
								</s:a>
							</s:if>
						</s:iterator>

						<s:iterator begin="1" end="3" step="1" status="a">
							<s:if test="%{#session.moviciatpaging.pageNow-1+#a.index<3}">
								<s:a
									href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageNow+#a.index+3}">
									<s:property
										value="%{#session.moviciatpaging.pageNow+#a.index+3}" />
								</s:a>
							</s:if>
						</s:iterator>

						<s:if
							test="#session.moviciatpaging.pageCount-#session.moviciatpaging.pageNow>2">
							... <s:a cssClass="chinesefont"
								href="moviciatmixsetsession?paging.pageNow=%{#session.moviciatpaging.pageCount}">
				>>
			</s:a>
						</s:if>
					</s:else>
				</div>
			</div>

		</div>
	</div>
	<%-- <p>
		一共有
		<s:property value="%{#session.moviciatpaging.rowCount}" />
		部电影 每页
		<s:property value="%{#session.moviciatpaging.pageSize}" />
		部 分有
		<s:property value="%{#session.moviciatpaging.pageCount}" />
		页 当前在第
		<s:property value="%{#session.moviciatpaging.pageNow}" />
		页
	</p> --%>

	<%-- <s:if test="#session.moviciatpaging.pageCount<=6">
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
	</s:else> --%>
	<%--  --%>
</body>
</html>

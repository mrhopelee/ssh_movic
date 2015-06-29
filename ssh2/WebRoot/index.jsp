<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 使用bootstrap 的css样式 -->
<title>首页</title> 

<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/index_photoshow.css">
<link rel="stylesheet" type="text/css" href="css/indexlist.css">
<script src="javascript/2.1.4jquery.js"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.js"></script>
<script src="javascript/index_photoshow.js"></script>
</head>
<body>
	<%-- <s:include value="userFunction.jsp"></s:include> --%>
	
	<div
		class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 ">
		<div class="hiddenshadow"></div>
		<div id="photoshow" class="">
			<a class="photoshow_a" title="1" href="javascript:return(0);"
				style="z-index:8;"> <img src="movic_picture/10.jpg" />
			</a> <a class="photoshow_a" title="2" href="javascript:alert(2);"
				style="z-index:7;"> <img src="movic_picture/11.jpg" />
			</a> <a class="photoshow_a" title="3" href="javascript:alert(3);"
				style="z-index:7;"> <img src="movic_picture/12.jpg" />
			</a> <a class="photoshow_a" title="4" href="javascript:alert(4);"
				style="z-index:7;"> <img src="movic_picture/13.jpg" />
			</a> <a class="photoshow_a" title="5" href="javascript:alert(5);"
				style="z-index:7;"> <img src="movic_picture/14.jpg" />
			</a>
			<div id="btn_prev" class=" music-buttons music-title">
				<span class=""><</span>
			</div>
			<div id="btn_next" class=" music-buttons music-title">
				<span class="">></span>
			</div>
		</div>
		<div class="photoshowbottom">
			<div class="rdiv" style="border: 4px solid #4C9ED9;cursor:unset;"></div>
			<div class="rdiv"></div>
			<div class="rdiv"></div>
			<div class="rdiv"></div>
			<div class="rdiv"></div>
		</div>
	</div>
	<div class="col-sm-12 col-md-12 ">
		<s:action name="moviciatIndexlistsetsession" flush="false"
			namespace="/"></s:action>

		<div class="col-sm-12 col-md-12 indexdb">
			<h2 class="listh2">最近上映</h2>
			<s:iterator value="#session.movicnewlist" status="mnew">
				<%-- <s:property value="movicPost" /> 
						id="iatmv<s:property value="%{movicOid}"/>"
				--%>
				<div class="col-sm-2 col-md-2 indexre">
					<s:a href="scanMovieAction?id=%{movicOid}">
						<img class="img-rounded" src='<s:property value="%{movicPost}"/>'
							alt="<s:property value="%{movicName}"/>" />
					</s:a>
					<div class="col-sm-12 col-md-12 ">
						<s:a href="scanMovieAction?id=%{movicOid}">
							<s:property value="movicName" />
							(<s:date name="movicPlayDate" format="yyyy" />)
						</s:a>
					</div>
				</div>
			</s:iterator>
		</div>

		<div class="col-sm-12 col-md-12 indexdb">
			<h2 class="listh2">经典高分</h2>
			<s:iterator value="#session.movicscorelist" status="ms">
				<%-- <s:property value="movicPost" /> 
						id="iatmv<s:property value="%{movicOid}"/>"
				--%>
				<div class="col-sm-2 col-md-2 indexre">
					<s:a href="scanMovieAction?id=%{movicOid}">
						<img class="img-rounded" src='<s:property value="%{movicPost}"/>'
							alt="<s:property value="%{movicName}"/>" />

					</s:a>
					<div class="col-sm-12 col-md-12 ">
						<s:a href="scanMovieAction?id=%{movicOid}">
							<s:property value="movicName" />
							(<s:date name="movicPlayDate" format="yyyy" />)
						</s:a>
					</div>
				</div>
			</s:iterator>
		</div>

		<div class="col-sm-12 col-md-12 indexdb">
			<h2 class="listh2">热门精选</h2>
			<s:iterator value="#session.movicvnlist" status="mvn">
				<%-- <s:property value="movicPost" /> 
						id="iatmv<s:property value="%{movicOid}"/>"
				--%>
				<div class="col-sm-2 col-md-2  indexre">
					<s:a href="scanMovieAction?id=%{movicOid}">
						<img class="img-rounded" src='<s:property value="%{movicPost}"/>'
							alt="<s:property value="%{movicName}"/>" />

					</s:a>
					<div class="col-sm-12 col-md-12 ">
						<s:a href="scanMovieAction?id=%{movicOid}">
							<s:property value="movicName" />
							(<s:date name="movicPlayDate" format="yyyy" />)
						</s:a>
					</div>
				</div>
			</s:iterator>
		</div>
	</div>
	
</body>
<s:include value="movic_nav.jsp"></s:include>
<s:include value="movic_bottom.jsp"></s:include>
</html>

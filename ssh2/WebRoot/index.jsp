<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 使用bootstrap 的css样式 -->
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/new.css">
<!-- <link rel="stylesheet" type="text/css" href="css/index_layout.css">  -->
<script src="javascript/2.1.4jquery.js"></script>
<script src="javascript/new.js"></script>
</head>
<body>
	<%-- <s:include value="userFunction.jsp"></s:include> --%>
	<s:include value="movic_nav.jsp"></s:include>
	<div class="col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 ">
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
		<div class="rdiv" style="border: 8px solid #4C9ED9;cursor:unset;"></div>		
		<div class="rdiv"></div>
		<div class="rdiv"></div>
		<div class="rdiv"></div>
		<div class="rdiv"></div>
	</div>

</body>
</html>

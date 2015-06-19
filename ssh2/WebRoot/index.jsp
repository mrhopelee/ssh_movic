<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <!-- 使用bootstrap 的css样式 -->
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/new.css"> 
    <link rel="stylesheet" type="text/css" href="css/index_layout.css"> 
    <script src="javascript/2.1.4jquery.js"></script>
    <script src="javascript/new.js"></script>
  </head>
  <body>
  <%-- <s:include value="userFunction.jsp"></s:include> --%>
  <s:include value="movic_nav.jsp"></s:include>
  
  <div id="photoshow">
	 <a class="photoshow_a" title="1" href="javascript:alert(1);" style="z-index:8;">
		 <img src="movic_picture/10.jpg" />
	 </a>
	 <a class="photoshow_a" title="2" href="javascript:alert(2);" style="z-index:7;">
		 <img src="movic_picture/11.jpg" />
	 </a>
	 <a class="photoshow_a" title="3" href="javascript:alert(3);" style="z-index:7;">
		 <img src="movic_picture/12.jpg" />
	 </a>
	 <a class="photoshow_a" title="4" href="javascript:alert(4);" style="z-index:7;">
		 <img src="movic_picture/13.jpg" />
	 </a>
	 <a class="photoshow_a" title="5" href="javascript:alert(5);" style="z-index:7;">
		 <img src="movic_picture/14.jpg" />
	 </a>
	 </div>
			<div id="btn_prev" class=" music-buttons music-title">
				<span  href="#" >PREV</span>
            </div>
            <div id="btn_next" class=" music-buttons music-title">
				<span  href="#" >NEXT</span>
            </div>
  </body>
</html>

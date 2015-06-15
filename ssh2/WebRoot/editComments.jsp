<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发表评论</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	
		element.style {
		}
		body {
			margin-top: 0;
		}
		body, td, th {
			font: 12px Helvetica,Arial,sans-serif;
			line-height: 1.62;
		}
		body, div, dl, dt, dd, ul, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, blockquote {
			margin: 0;
			padding: 0;
		}
		user agent stylesheetbody {
			display: block;
			margin: 8px;
		}
		Inherited from html.ua-windows.ua-webkit
		html {
			color: #111;
		}
	</style>

  </head>
  
  
  <body>



            <s:fielderror>
            </s:fielderror>    
    <form  method="POST" name="lzform" action="subCommentsAction" >
        <table align="center">
            <tr>
                <td>评价:
                        <label><input type="radio" name="score" value="1"  checked="checked"/>很差</label>
                        <label><input type="radio" name="score" value="2"  />较差</label>
                        <label><input type="radio" name="score" value="3"  />还行</label>
                        <label><input type="radio" name="score" value="4"  />推荐</label>
                        <label><input type="radio" name="score" value="5"  />力荐</label>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea required="required" name="comments_text" style="width:448px;height:337px"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <br/>
                    <input type="hidden" name="nowMovieId" value='<s:property value="#session.nowMovieId"/>'>
                    <!--  <input type="hidden" name="nowUserId" value='<s:property value="#session.nowUserId"/>'> -->

                    <input name="rev_submit" type="submit" value="好了，添加评论"/>&nbsp;&nbsp;&nbsp;
                    <a href="movieDetailPage.jsp">取消</a>
                </td>
            </tr>
        </table>
    </form>

 
  </body>
</html>

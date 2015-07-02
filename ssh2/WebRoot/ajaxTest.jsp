<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ajaxtest</title>

	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  </head>
  
  <body>
 
    </head>
<body>
    
    <input type="submit" value="点击" id="but">
    <input type="text" name="movicOid">
	<script type="text/javascript">
	$("#but").click(function(){
	alert("点击");
	$.ajax({
	data:{//这里传递页面的值
	//input 标签 name= input中的name属性
	movicOid:$("input[name=movicOid]").val()
	
	},dataType:"JSON",success:function(date){
	alert(date);
	
	var json=eval("("+date+")");
	//追加信息
	$("#result").append("<tr> <td>电影名:</td> <td>"+json.movicName+"</td></tr>");
	$("#result").append("<tr> <td>导演</td> <td>"+json.movicDirector+"</td></tr>");
	$("#result").append("<tr> <td>演员</td> <td>"+json.movicActor+"</td></tr>");
	$("#result").append("<tr> <td>评分</td> <td>"+json.movicImdbScore+"</td></tr>");
	$("#result").append("<tr> <td>上映日期</td> <td>"+json.movicPlayDate+"</td></tr>");
	
	//获取list
	$("#result").append("<tr> <td>电影类型</td> <td>"+json.movicBeloneTypes[0]+"/"+json.movicBeloneTypes[1]+"/"+json.movicBeloneTypes[2]+"</td></tr>");
	$("#result").append("<tr> <td>电影地区</td> <td>"+json.movicBeloneAreas[0]+"/"+json.movicBeloneAreas[1]+"</td></tr>");
	
	//获取海报
	$("#result").append("<tr> <td>电影海报</td> <td> <img alter=\"无法显示\" src=\""+json.movicPost+"\"></td></tr>");
	
	
	},type:"post",url:"getinfoAction"})
	})
	</script>
    
    
 <table id="result">
 </table>
 <input type="submit" value="新加页面" id="but2">
 <div id="page">
 </div>
 <script type="text/javascript">
 	$("#but2").click(function(){
 	
 	$.ajax({data:null,dataType:"HTML",success:function(date){
 	$("#page").append(date);
 	
 	},type:"post",url:"index.jsp"})
 	
 	})
 
 </script>
 


  </body>
</html>

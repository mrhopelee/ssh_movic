<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加电影</title>
    <sx:head extraLocales="UTF-8" />
	
  </head>
  
  <body>
    <a href="adminFunction.jsp">返回管理页面</a><br>
   
    <!-- 	private String movicName;
	private String movicActor;
	private String movicDirector;
	private Double movicImdbScore;
	private Date movicPlayDate;
	private String movicIntroduction; -->
	<div style="margin: 0 auto">
    <form action="addMovicAction" method="post">
    <table border="1" >
    <tr>
    <td>电影名</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicName"></td>
    </tr>
    
    <tr>
    <td>导演</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicDirector"></td>
    </tr>
    
    <tr>
    <td>演员</td>
    <td colspan="3"><input type="text" required="required" name="movic.movicActor"></td>
    </tr>
    
    <tr><sx:datetimepicker name="movic.movicPlayDate" label="上映日期"
					displayFormat="yyyy-M-dd" value="%{'today'}" />

					</tr>
    
  
    <tr>
    <td>评分</td>
    <td colspan="3">
    <select name="score[0]">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    </select>
    .
     <select name="score[1]">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    </select>
    </td>
    </tr>
    
    <tr>
    <td>简介</td>
    <td colspan="3"><textarea rows="10" cols="40" required="required" name="movic.movicIntroduction"></textarea></td>
    </tr>
    
    <!-- 获取出电影类型列表 -->
    <tr>
    <td>电影类型</td>
    <td>
    <select name="mt[0]">
    <s:iterator value="movicType" id="mt">
    <option value='<s:property value="#mt.mtOid"/>'><s:property value="#mt.type" /></option>
    </s:iterator>
    </select>
    
    
    
    <select name="mt[1]">
    <option value="-1">无</option>
    <s:iterator value="movicType" id="mt">
    <option value='<s:property value="#mt.mtOid"/>'><s:property value="#mt.type" /></option>
    </s:iterator>
    </select>
    
    
   
    <select name="mt[2]">
    <option value="-1">无</option>
    <s:iterator value="movicType" id="mt">
    <option value='<s:property value="#mt.mtOid"/>'><s:property value="#mt.type" /></option>
    </s:iterator>
    </select>
    </td>
    
    </tr>
    
    <tr>
    <td>电影地区</td>
    
    <td>
    <select name="ma[0]">
    <s:iterator value="movicArea" id="ma">
    <option value='<s:property value="#ma.areaOid"/>'><s:property value="#ma.areaName" /></option>
    </s:iterator>
    </select>
    
    

    <select name="ma[1]">
    <option value="-1">无</option>
    <s:iterator value="movicArea" id="ma">
    <option value='<s:property value="#ma.areaOid"/>'><s:property value="#ma.areaName" /></option>
    </s:iterator>
    </select>
    </td>
    </tr>
    
    <tr><td><input type="submit" value="添加"></td><td colspan="3"><input type="reset" value="重置"></td></tr>
    </table>
    </form>
    </div>
  </body>
  
</html>

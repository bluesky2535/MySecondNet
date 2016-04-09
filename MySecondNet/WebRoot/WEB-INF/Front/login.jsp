<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    

  </head>
  
  
  <h1>用户登录页面</h1>
  <body>
   <form method="post" action="user_login">
   	  用户名： 	<input  type="text" name="name"/><br/>
   	 密码：  	<input  type="password"  name="password"/><br/>
		<input type="submit" value="登录"/>
   </form>
     <s:actionmessage/>
  </body>
</html>

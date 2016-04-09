<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>更新产品页面</h1>
<s:property value="product"/>
  <form action="product_update" enctype="multipart/form-data" method="post"><br>
  id: <input type="text" name="id" value="<s:property value='product.id'/>"/><br>
  名称： <input type="text" name="name" value="<s:property value='product.name'/>"/><br>
 价格： <input type="text" name="price"value="<s:property value='product.price'/>"/><br>
 简介：    <input type="text" name="short_intro"value="<s:property value='product.short_intro'/>"/><br>
  详情描述：   <input type="text" name="description"value="<s:property value='product.description'/>"/><br>
  数量：   <input type="text" name="quantity"value="<s:property value='product.quantity'/>"/><br>
 <%--    图片： <input  type="file" name="product_img1"value="<s:property value='product.product_img1'/>"/><br> --%>
    
    
     <input type="submit"/>
 </form>
 <s:debug></s:debug>
  </body>
</html>

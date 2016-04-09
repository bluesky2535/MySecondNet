<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="">
<head>

<title>商品详情页</title>
</head>

<body>
<%@ include file="menu.jsp"%>
<h1>这是展示单个产品的信息</h1>
产品id：<s:property value="product.id"/><br/>	
产品名称：<s:property value="product.name"/><br/>
产品原价格：<s:property value="product.initprice"/><br/>
产品转让价格：<s:property value="product.secondprice"/><br/>	
产品简介：<s:property value="product.short_intro"/><br/>	
产品描述：<s:property value="product.description"/><br/>	
产品图片：
 <s:iterator  value="product.img_srcs" var="img">
<img src="<s:property value="#img"/>" height="50"  width="50"/>
</s:iterator><br/>
产品转让价格：<s:property value="product.secondprice"/><br/>	
<form action="cart_addCart" method="post">
<input type="hidden" name="pid" value="<s:property value="product.id"/>"/>
 购买数量：<input type="text" name="count"/>
<input type="submit" value="加入购物车">
</form>
</body>
</html>
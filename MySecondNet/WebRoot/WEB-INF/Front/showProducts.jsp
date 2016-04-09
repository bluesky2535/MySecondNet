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
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'productList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%@ include file="menu.jsp"%>
	<h1>前台产品显示 页面.</h1>
<div >
	<h3>分类</h3>
	<s:iterator value="#session.clist" var="c">
  <h4> <a href="product_findbycid?cid=<s:property value="#c.id" />"><s:property value="#c.name" /></a>	</h4> 
		<s:iterator value="#c.categorySeconds" var="cs">
			<a href="product_findbycsid?csid=<s:property value="#cs.id" />"><s:property value="#cs.name" /></a>
		</s:iterator>
	</s:iterator>
</div>
	
	
			<s:iterator value="products" var="p">
			
			<a href="product_showProduct.action?id=<s:property value="#p.id"/>">
			<div style="border:1px solid; width: 200px;height: 250px;"  >			
		
			<img alt="产品图片" src="<s:property value="#p.img_srcs[0]"/>"  width="90" height="90"/>
				id：<s:property value="#p.id" /><br/>
				名称：<s:property value="#p.name" /><br/>
				原始价格：<s:property value="#p.initprice" /><br/>
				简介：<s:property value="#p.short_intro" /><br/>
				详细描述：<s:property value="#p.description" /><br/>
				数量：<s:property value="#p.quantity" /><br/>
				已经出售：<s:property value="#p.havesell" /><br/>
	</div></a><br/>
			</s:iterator>
		

	<br/>
	<a href="product_addUI">卖我自己的二手货， 添加二手货</a>
</body>
</html>

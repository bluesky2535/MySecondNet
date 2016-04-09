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
	<h1>后台产品管理 页面.</h1>


	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
			<th>short_intro</th>
			<th>description</th>
			<th>quantity</th>
			<th>havesell</th>
			<th>img_srcs</th>
			<th>reply</th>
			<th>删除</th>
			<th>修改</th>
		</tr>
			<s:iterator value="pageBean.recordList" var="p">
				<tr>
					<th><s:property value="#p.id" /></th>
					<th><s:property value="#p.name" /></th>
					<th><s:property value="#p.price" /></th>
					<th><s:property value="#p.short_intro" /></th>
					<th><s:property value="#p.description" /></th>
					<th><s:property value="#p.quantity" /></th>
					<th><s:property value="#p.havesell" /></th>
					<th>
					<a href="product_showProduct"><img alt="产品图片" src="<s:property  value="#p.img_srcs[0]"/>" width="30" height="30"></a>
					</th>
					<th><s:property value="#p.replys" /></th>
					
				
					<th><s:a href="product_delete?id=%{#p.id}">删除</s:a></th>
					<th><s:a href="product_updateUI?id=%{#p.id}">更改</s:a></th>
				</tr>
			</s:iterator>
	</table>
	<a href="product_addUI">添加</a>
	<s:debug></s:debug>
</body>
</html>

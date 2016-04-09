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
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<h1>二手开心网首页</h1>
	<%@ include file="menu.jsp"%>
	<div>
		一级分类：
		<ul>
			<s:iterator value="#session.clist" var="c">
				<li><a
					href="product_findbycid?cid=<s:property value="#c.id" />"><s:property
							value="#c.name" /></a></li>
			</s:iterator>
		</ul>

		最新产品：
		<s:iterator value="newproducts" var="p">
			<a href="product_showProduct?id=<s:property value="#p.id"/>">
				<div style="border:1px solid; width: 200px;height: 250px;">
				
					<s:if test="#p.img_srcs.isEmpty()">
					<img alt="缺少图片" width="90" height="90" />
					</s:if>
					<s:else>
						<img alt="产品图片" src="<s:property value="#p.img_srcs[0]" />"
							width="90" height="90" />	
					</s:else>
					id：
					<s:property value="#p.id" /><br/>
				名称：<s:property value="#p.name" /><br/>
				原始价格：<s:property value="#p.initprice" /><br/>
				简介：<s:property value="#p.short_intro" /><br/>
				详细描述：<s:property value="#p.description" /><br/>
				数量：<s:property value="#p.quantity" /><br/>
				已经出售：<s:property value="#p.havesell" /><br/>
				</div>
			</a>
			<br/>
		</s:iterator>
	</div>
</body>
</html>

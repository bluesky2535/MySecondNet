<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>我的订单页面</title>

</head>

<body>
	<%@ include file="menu.jsp"%>
	<h1>我的订单页面</h1>
	<s:iterator value="myorders" var="myorder">
		<div style=" border: solid;border-color: brown">
			订单id:
			<s:property value="#myorder.oid" />
			<br /> 订单项集合：
			<s:iterator value="#myorder.orderitems" var="orderItem">
				<div style="border: solid;">
				            订单项的Id：<s:property value="#orderItem.itemid" />
					订单项的产品名称：
					<s:property value="#orderItem.product.name" />
					<br /> 订单项数量：
					<s:property value="#orderItem.count" />
					<br /> 订单项价格：
					<s:property value="#orderItem.subtotal" />
					<br />
				</div>
				<br />
			</s:iterator>

			时间：
			<s:property value="#myorder.dateTime" />
			<br /> 订单状态：
			<s:set value="#myorder.status" name="status"></s:set>
			<s:if test="#status==1">
				<a href="order_findByOid?oid=<s:property value="#myorder.oid"/>">去付款</a>
			</s:if>
			<s:elseif test="#status==2">
				<a href="#">提醒商家发货</a>
			</s:elseif>
			<s:elseif test="#status==3">
				<a href="order_updateState?oid=<s:property value="#myorder.oid"/>">确认收货</a>
			</s:elseif>
			<s:elseif test="#status==4">
				<a href="order_comment?oid=<s:property value="#myorder.oid"/>">交易已完成,去评论</a>
			</s:elseif>
			<br /> 订单总价格：
			<s:property value="#myorder.total" />
		</div>
		<br />
		<br />
		<br />
		<br />
	</s:iterator>
	<br />

</body>
</html>

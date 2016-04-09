<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div>

	<s:if test="#session.existUser==null">
		<a href="user_loginUI">登录 </a>	///<a href="user_registUI">注册 </a>

	</s:if>
	<s:else>
		用户：<a href="index.action"><s:property value="#session.existUser.name" /> </a>
		<a href="order_findByUid">我的订单</a> /////  <a href="user_quit">退出</a>
		<a href="order_deal">处理卖出的货</a>
		<a href="product_addUI">卖掉我的二手货</a>
	</s:else>
	///// <a href="cart_myCart">我的购物车</a>/////

</div>


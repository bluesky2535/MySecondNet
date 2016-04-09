<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>购物车</title>
</head>
<body>
	<%@ include file="menu.jsp"%>


	<s:if test="#session.cart.cartItems.size()!=0">
	    产品名称                          图片                         单价                            数量                                     小结<br />
		<s:iterator value="#session.cart.map" var="map">
	商家名称：	<s:property value="#map.key" />
			<br />
			<s:iterator value="#map.value" var="cartItem">
				<s:property value="#cartItem.product.name" />
				<img src="<s:property value="#cartItem.product.img_srcs[0]" />"
					alt="产品图片" width="50px" height="50px" />
				<s:property value="#cartItem.product.secondprice" />
				<s:property value="#cartItem.count" />
				<s:property value="#cartItem.subtotal" />
				<a
					href="cart_removeCart?pid=<s:property value="#cartItem.product.id" />">删除</a>
				<br />
			</s:iterator>		
*************************************************************************<br />


		</s:iterator>
                                             总额：<s:property
			value="#session.cart.total" />
		<div class="bottom">
			<a href="${ pageContext.request.contextPath }/cart_clearCart.action"
				id="clear" class="clear">清空购物车</a> <a
				href="${ pageContext.request.contextPath }/order_saveOrder.action"
				id="submit" class="submit">提交订单</a>
		</div>
	</s:if>
	<s:else>

		<a href="index">亲!您还没有购物!请先去购物!</a>

	</s:else>

<s:actionmessage />




</body>
</html>
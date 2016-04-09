<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
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
    <h3>这是订单显示的页面</h3><br>
    
  <s:iterator  value="#session.orders" var="order">
  
  商家名称：<s:property value="#order.seller.name"/>
 <br>
           <s:iterator value="#order.orderitems" var="orderitem">
           <s:property value="#orderitem.product.seller.name"/>
                                     商家名称： <s:property value="#orderitem.product.name"/>
                                    产品图片：<img alt="" src="<s:property value="#orderitem.product.img_srcs[0]"/>"  width="50" height="50">
                                     产品转让价：<s:property value="#orderitem.product.secondprice"/> 
                                     产品转让价：<s:property value="#orderitem.count"/>                  
                                     产品小计： <s:property value="#orderitem.subtotal"/>  
                                      <br />    
             </s:iterator> 
   *************************************************************************<br />
    </s:iterator> 

<form action="order_payOrder" method="post">
<input type="hidden" name="oid" value="<s:property value="model.oid"/>"/>
<!--之所以提供用户收货表单，是为了用户可以更改收货地址  -->
收货地址：<input name="addr" type="text" value="<s:property value="model.user.addr"/>"  />
								<br />
收货人：<input name="name" type="text" value="<s:property value="model.user.name"/>"  />
								<br /> 
联系方式：<input name="phone" type="text"value="<s:property value="model.user.phone"/>" />



	<hr />
						<p>
							选择银行：<br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
							<img src="${ pageContext.request.contextPath }/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
							<img src="${ pageContext.request.contextPath }/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
							<img src="${ pageContext.request.contextPath }/bank_img/abc.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
							<img src="${ pageContext.request.contextPath }/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
							<img src="${ pageContext.request.contextPath }/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
							<img src="${ pageContext.request.contextPath }/bank_img/ccb.bmp" align="middle"/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
							<img src="${ pageContext.request.contextPath }/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
							<img src="${ pageContext.request.contextPath }/bank_img/cmb.bmp" align="middle"/>
						</p>
						<hr />
					<input type="submit" value="去付款"/>	
</form>

 
  </body>
</html>

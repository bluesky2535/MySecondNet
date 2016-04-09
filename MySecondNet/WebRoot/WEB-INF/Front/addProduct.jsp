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
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
   <script type="text/javascript" >
  
   function getcsid(){
   var vs= $("#csids option:selected").val();
	   $("#csid").val(vs);

   }
   
   

</script>

  </head>
  
  <body>
  <h1>上传产品页面</h1>
  <%@ include file="menu.jsp"%>
  <form action="product_add" enctype="multipart/form-data" method="post"><br>
  名称： <input type="text" name="name"/><br>
 原价格： <input type="text" name="initprice"/><br>
转让价格： <input type="text" name="secondprice"/><br>
 简介：    <input type="text" name="short_intro"/><br>
  详情描述：   <input type="text" name="description"/><br>
  数量：   <input type="text" name="quantity"/><br>
简略图： <input  type="file" name="upload"  /> <br/>
  图片2：   <input  type="file" name="upload" /> <br/>
    图片3： <input  type="file" name="upload" /> <br/>
    
    
<%--     产品一级分类：
  <select>
    <s:iterator value="categories" var="category">
      <option value="<s:property value="#category.id"/>"><s:property value="#category.name"/></option>
    </s:iterator>  
 </select><br/>   --%>
 
 <input  id="csid" name="csid" type="hidden"  /> 
产品二级分类：

  <select  id="csids"  onchange="getcsid()">
      <option  >请选择二级分类</option>
    <s:iterator value="categorySeconds" var="categorySecond"> 
      <option value="<s:property value="#categorySecond.id"/>"><s:property value="#categorySecond.name"/></option>
    </s:iterator>    
</select>  
 <input type="submit" value="上传"/><br/>
 </form>
  </body>
</html>

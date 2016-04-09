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
    
    <title>My JSP 'register.jsp' starting page</title>
   <script type="text/javascript">
	function checkForm(){
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			alert("两次密码输入不一致!");
			return false;
		}
	}
   /**
   Ajax校验用户名是否存在
   */
   function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
			document.getElementById("span1").innerHTML = "用户名不能为空";
			return false;
		}
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		};
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?name="+username,true);
		// 4.发送
		xhr.send(null);
	}
   function createXmlHttp(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }

		return xmlHttp;
	 }
   
   function  checkpassword(){
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			document.getElementById("span2").innerHTML = "密码不能为空!";
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			 document.getElementById("span2").innerHTML = "两次密码输入不一致!";
			return false;
		}  
		else{
			 document.getElementById("span2").innerHTML = "";
			
		}
   }
   
   function isEmail(email)
           {
              //对电子邮件的验证
              var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
             if(!myreg.test(email))
             {
            	 document.getElementById("span3").innerHTML = "邮箱格式不正确";
                 /*  myreg.focus();
                 return false; */
             }else{
            	 document.getElementById("span3").innerHTML = "";
            	 return ;
             }
   
          }
   </script>
  </head>
  
  <body>
  
 <h1> 注册页面</h1> 
 <form action="user_regist" method="post" onsubmit="return checkForm();">
 注册用户名：  <input type="text" name="name" id="username" onblur="checkUsername()"/><span id="span1"></span><br/>
 输入密码： <input type="password" name="password" id="password" /><br/>
 确认密码： <input type="password"  id="repassword"  onblur="checkpassword()" /><span id="span2"></span><br/>
 邮箱： <input type="text" name="email"  onblur="isEmail(this.value)"/><span id="span3"></span><br/>
验证码： <input type="text" name="checkcode"/>
 	<img alt="checkcode" name="checkcode" src="checkImg" onclick="this.src='checkImg.action?random='+Math.random()"><s:actionmessage/><br/>
  <input type="submit" value="注册"/>
 </form>
 
  </body>
</html>

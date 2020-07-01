<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/login.css" />	
		  
		<script type="text/javascript">
		function validate(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var usernameRegex = /^[a-zA-Z0-9]{15}$/;
		if(username.trim()=="")
			{
			document.getElementById('uerror').innerHTML="Please enter a username";
			return false;
			}
		else if(username.length<5 || username.length>15 )
			{
			document.getElementById('uerror').innerHTML="Username must between 5 to 15 characters";
			return false;
			}
		else if(usernameRegex.test(username))
			{
			document.getElementById('uerror').innerHTML="Invalid Username";
			return false;
			}
		else if(password.trim()=="")
			{
			document.getElementById('perror').innerHTML="Please enter a password";
			return false;
			}
		else if(password.length<7 || password.length>15 )
			{
			document.getElementById('perror').innerHTML="Password must between 7 to 15 characters";
			return false;
			}
		}
		</script> 	  
</head>
<body>
<div align="center">
<form:form name="login" onsubmit="return validate();" action="loginprocess" modelAttribute="loginData">
	<div class="container">
	<h1>Login</h1>
	 <hr>
	 <div>
    <div class="uname">
    <label for="uname"><b>Username</b></label><span>*</span>
    </div>
    <div>
    <form:input type="text" placeholder="Enter Username" id="username" path="usrname" />
    </div>
    <span id="uerror" style="color:red"></span>
    </div>
    <div>
	<div class="pass">
    <label for="psw"><b>Password</b></label><span>*</span>
    </div>
     <div>
	<form:input type="password" placeholder="Enter Password" id="password" path="Password" />
	</div>
	<span id="perror" style="color:red"></span>
	</div>
	<button type="submit">Login</button>
	 </div>
	 <div class="container">
    <span class="register">Create Account <a href="signup">SignUp?</a></span>
    <span class="psw">Forgot <a href="forgotpassword">password?</a></span>
  </div>          
</form:form>
</div>
</body>
</html>
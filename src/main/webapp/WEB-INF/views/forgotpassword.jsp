<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgotPassword</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/signup.css" />
</head>
<body>
<div align="center">
<form:form action="forgotpasswordprocess" method="post" modelAttribute="forgotData">
<div class="container">
    <h1>Forgot Password</h1>
    <hr>
    <div class="uname">
    <label for="email"><b>Username</b></label><span>*</span>
    </div>
    <div>
	<form:input type="text" placeholder="Enter Username" id="uname" path="username" autocomplete="off" />
	</div>
	<div class="pass">
	<label for="psw"><b>Password</b></label><span>*</span>
	</div>
	<div>
	<form:input type="password" placeholder="Enter Password" id="password" path="password" />
	</div>
	<div class="confirm">
	<label for="psw-repeat"><b>Repeat Password</b></label><span>*</span>
	</div>
	<div>
    <form:input type="password" placeholder="Enter password again" id="confirm" path="confirm" />
	</div>
<div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Submit</button>
    </div>
  </div>  
  <span class="register">Login  <a href="login">Login?</a></span>        
</form:form>
</div>
</body>
</html>
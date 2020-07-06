<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/signup.css" />
		  
		 	<script type="text/javascript">
		function validate(){
		var username = document.getElementById("uname").value;
		var password = document.getElementById("password").value;
		var rpassword = document.getElementById("rpassword").value;
		var email = document.getElementById("e-mail").value;
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
		else if(password.trim()=="" || password == null)
			{
			document.getElementById('perror').innerHTML="Please enter a password";
			return false;
			}
		else if(password.length<7 || password.length>15 )
			{
			document.getElementById('perror').innerHTML="Password must between 7 to 15 characters";
			return false;
			}
		else if(usernameRegex.test(password))
			{
			document.getElementById('perror').innerHTML="Invalid password";
			return false;
			}
		else if(rpassword.trim()=="" || rpassword == null)
			{
			document.getElementById('rerror').innerHTML="Please enter a confirm password";
			return false;
			}
		else if(rpassword.length<7 || rpassword.length>15 )
			{
			document.getElementById('rerror').innerHTML="Password must between 7 to 15 characters";
			return false;
			}
		else if(password != rpassword)
			{
			document.getElementById('rerror').innerHTML="Confirm Password must same as Password";
			return false;
			}
		else if(email.trim()=="" || email == null)
			{
			document.getElementById('eerror').innerHTML="Please enter a email";
			return false;
			}
		else if(email.length<6 || email.length>50 )
			{
			document.getElementById('eerror').innerHTML="Password must between 7 to 25 characters";
			return false;
			}
		}
		</script>
</head>
<body>
<div align="center">
<form:form onsubmit="return validate();" action="signupprocess" method="post" modelAttribute="signupData">
<div class="container">
    <h1>Sign Up</h1>
    <hr>
    <div>
    <div class="uname">
    <label for="email"><b>Username</b></label><span>*</span>
    </div>
    <div>
	<form:input type="text" placeholder="Enter Username" id="uname" path="username" autocomplete="off" />
	</div>
	<span id="uerror" style="color:red"></span>
	</div>
	<div>
	<div class="pass">
	<label for="psw"><b>Password</b></label><span>*</span>
	</div>
	<div>
	<form:input type="password" placeholder="Enter Password" id="password" path="password" />
	</div>
	<span id="perror" style="color:red"></span>
	</div>
	<div>
	<div class="rpass">
	<label for="psw"><b>Confirm-Password</b></label><span>*</span>
	</div>
	<div>
	<form:input type="password" placeholder="Enter Password again" id="rpassword" path="reptpassword" />
	</div>
	<span id="rerror" style="color:red"></span>
	</div>
	<div>
	<div class="email">
	<label for="psw-repeat"><b>E-Mail</b></label><span>*</span>
	</div>
	<div>
    <form:input type="text" placeholder="Enter E-Mail" id="e-mail" path="email" autocomplete="off" />
    </div>
    <span id="eerror" style="color:red"></span>
    </div>

<div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
  <span class="register">Login  <a href="login">Login?</a></span>         
</form:form>
</div>
</body>
</html>
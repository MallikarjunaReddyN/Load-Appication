<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<style>
.clearfix::after {
  align="center"
  content: "";
  clear: both;
  display: table;
}
.cancelbtn, .signupbtn {
  float: left;
  width: 30%;
}
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
      margin-left: 250px;
}
button:hover {
  opacity:1;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
</style>
</head>
<body>
<div align="center">
<h1>WELCOME TO WEB-APPLICATION</h1>
</div>
<div class="clearfix">
     <form action="login"><button type="submit" class="cancelbtn">Login</button></form>
     <form action="signup"><button type="submit" class="signupbtn">Sign Up</button></form>
    </div>
</body>
</html>

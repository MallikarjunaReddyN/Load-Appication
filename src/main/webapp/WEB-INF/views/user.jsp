<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/user.css" />
</head>
<body>
	<% if(session.getAttribute("uname")== null){
		response.sendRedirect("/springhibernate/login?");
	} %>
	<div>
 	<h1>Welcome <%=session.getAttribute("username") %></h1>
 	</div>
 	<div align="right">
 	<input type="button" class="logout" value="Logout" onclick="window.location.href='logout'; return false;" />
 	</div>
 	<hr>
 	<div class="clearfix">
     <form action="loads"><button type="submit"  class="loadbtn">LOADS</button></form>
     <form action="sold"><button type="submit" class="soldbtn">Packs Sold</button></form>
    <form action="paid">  <button type="submit" class="paidpack">Paid Packs</button></form>
    </div>
</body>
</html>

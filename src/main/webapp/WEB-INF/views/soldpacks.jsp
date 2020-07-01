<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="user.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SoldData</title>
<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/load.css" />
</head>
<body>

<% if(session.getAttribute("uname")== null){
		response.sendRedirect("/springhibernate/login?");
	} %>
<div>
<h1>Sold List</h1>
</div>
<div>
<input type="button" value="Add"
	onclick="window.location.href='addsold'; return false;" class="add-button" />
</div>			   
<form:form action="search" method="GET">
<h4>Search by Person:<input type="text" name="theSearchName" />
<input type="submit" value="Search" class="search" /></h4>
</form:form>

<table id="load">
<tr>
<th>Person Name</th>
<th>No.of packs</th>
<th>Amount(Rs)</th>
<th>Date</th>
<th>actions</th>
</tr>
<c:forEach var="load" items="${loads}">

<c:url var="updatelink" value="/updatesold">
<c:param name="id" value="${load.id}"></c:param>
</c:url>
<c:url var="deletelink" value="/deletesold">
<c:param name="id" value="${load.id}"></c:param>
</c:url>
<tr>
<td>${load.personname}</td>
<td>${load.packs}</td>
<td>${load.cost}</td>
<td>${load.date}</td>
<td><a href="${updatelink}">Update</a>|<a href="${deletelink}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br><br>
<table id="load">
<tr>
<th> Total Packs = <%=session.getAttribute("packs") %></th>
<th> Total Amount(Rs) = <%= session.getAttribute("total") %></th>
</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="user.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoadData</title>
<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/load.css" />
		  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		  
</head>
<body>
<% if(session.getAttribute("uname")== null){
		response.sendRedirect("/springhibernate/login?");
	} %>
<div>
<h1>Load List</h1>
</div>
<div>
<input type="button" value="Add Load"
	onclick="window.location.href='addload'; return false;" class="btn btn-primary btn-sm mb-3" style="position: absolute; margin-left: 1265px; margin-top:10px;" />		   
<form:form action="lsearch" method="GET">
Search by LoadName: <input type="text" name="theSearchName" class="form-control mb-4 col-4" />
<input type="submit" value="Search" class="btn btn-primary btn-sm mb-3" style="margin-top: 10px;" />
</form:form>
</div>
<table id="load">
<tr>
<th>LoadName</th>
<th>No.of Packs</th>
<th>Load Cost</th>
<th>Date</th>
<th>actions</th>
</tr>
<c:forEach var="load" items="${loads}">
<c:url var="updatelink" value="/updateload">
<c:param name="loadId" value="${load.id}"></c:param>
</c:url>
<c:url var="deletelink" value="/deleteload">
<c:param name="loadId" value="${load.id}"></c:param>
</c:url>
<tr>
<td>${load.loadname}</td>
<td>${load.packs}</td>
<td>${load.loadCost}</td>
<td>${load.date}</td>
<td><a href="${updatelink}" class="btn btn-primary">Edit</a> <a href="${deletelink}" class="btn btn-danger">Delete</a></td>
</tr>
</c:forEach>
</table><br><br>
<table id="load">
<tr>
<th> Total Packs = <%=session.getAttribute("lpacks") %></th>
<th> Total Amount(Rs) = <%= session.getAttribute("ltotal") %></th>
</tr>
</table>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add Load</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/addload.css">
		  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		   <script type="text/javascript">
		function validate(){
		var loadname = document.getElementById("person").value;
		var packs = document.getElementById("packs").value;
		var cost = document.getElementById("cost").value;
		var date = document.getElementById("date").value;
		var loadnameRegex = /^[a-zA-Z0-9]{15}$/;
		var packRegex = /^[1-9]{5}$/;
		var costRegex = /^[1-9]{10}$/;
		if(loadname.trim()=="")
			{
			document.getElementById('lerror').innerHTML="Please enter a Person Name";
			return false;
			}
		else if(loadname.length<5 || loadname.length>15 )
			{
			document.getElementById('lerror').innerHTML="Person Name must between 5 to 15 characters";
			return false;
			}
		else if(loadnameRegex.test(loadname))
			{
			document.getElementById('lerror').innerHTML="Invalid Person Name";
			return false;
			}
		else if(packs.trim()=="" || packs=="0")
			{
			document.getElementById('perror').innerHTML="Please enter a No.of packs";
			return false;
			}
		else if(packRegex.test(packs))
			{
			document.getElementById('perror').innerHTML="packs must between 1 to 4 digits";
			return false;
			}
		else if(cost.trim()=="" || cost =="0")
			{
			document.getElementById('cerror').innerHTML="Please enter cost";
			return false;
			}
		else if(costRegex.test(cost))
			{
			document.getElementById('cerror').innerHTML="packs enter valid cost";
			return false;
			}
		else if(date.trim()=="")
			{
			document.getElementById('derror').innerHTML="Please select Date";
			return false;
			}
		}
		</script> 
</head>

<body>

<% if(session.getAttribute("uname")== null){
		response.sendRedirect("/springhibernate/login?");
	} %>

<div class="container">
		<h2>Add Sold Details</h2>
		<hr>
		<form:form onsubmit="return validate();" action="addsoldprocess" modelAttribute="addsold" method="POST">
		<form:hidden path="id"/>
		<div>
		<div>
		<label><b>Person Name:</b></label>
		</div>
		<div>
		<form:input type="text" class="form-control mb-4 col-4" id="person" path="personname" autocomplete="off" />
		</div>
		<span id="lerror" style="color:red"></span>
		</div>
		<div>
		<div>
		<label><b>No.of Packs:</b></label>
		</div>
		<div>
		<form:input type="text" class="form-control mb-4 col-4" id="packs" path="packs" autocomplete="off" />
		</div>
		<span id="perror" style="color:red"></span>
		</div>
		<div>
		<div>
		<label><b>Amount(Rs):</b></label>
		</div>
		<div>
	    <form:input type="text" class="form-control mb-4 col-4" id="cost" path="cost" autocomplete="off" />
	    </div>
	    <span id="cerror" style="color:red"></span>
	    </div>
	    <div>
	    <div>
	    <label><b>Date:</b></label>
		</div>
		<div>
	    <form:input type="date" class="form-control mb-4 col-4" id="date" path="date" />
	    </div>
	    <span id="derror" style="color:red"></span>
	    </div><br>
		<input type="submit" value="Save" class="btn btn-primary" /><br>
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p><br>
			<a href="${pageContext.request.contextPath}/sold" class="btn btn-danger btn-sm mb-3">Back to Sold List</a>
		</p>
</div>
</body>

</html>











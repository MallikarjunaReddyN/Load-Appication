<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add Load</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/addload.css">
		  
		  <script type="text/javascript">
		function validate(){
		var loadname = document.getElementById("loadname").value;
		var packs = document.getElementById("pack").value;
		var cost = document.getElementById("cost").value;
		var date = document.getElementById("date").value;
		var loadnameRegex = /^[a-zA-Z0-9]{15}$/;
		var packRegex = /^[1-9]{5}$/;
		var costRegex = /^[1-9]{10}$/;
		if(loadname.trim()=="")
			{
			document.getElementById('lerror').innerHTML="Please enter a LoadName";
			return false;
			}
		else if(loadname.length<5 || loadname.length>15 )
			{
			document.getElementById('lerror').innerHTML="LoadName must between 5 to 15 characters";
			return false;
			}
		else if(loadnameRegex.test(loadname))
			{
			document.getElementById('lerror').innerHTML="Invalid LoadName";
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

<div class="addload">
	<div id="container">
		<h3>Add Load</h3>
		<hr>
		<form:form onsubmit="return validate();" action="addloadprocess" modelAttribute="addLoad" method="POST">
		<form:hidden path="id"/>
		<div>
		<div>
		<label><b>Load Name:</b></label>
		</div>
		<div>
		<form:input type="text" placeholder="Enter loadname" id="loadname" path="loadname" />
		</div>
		<span id="lerror" style="color:red"></span>
		</div>
		<div>
		<div>
		<label><b>No.of Packs:</b></label>
		</div>
		<div>
		<form:input type="text" placeholder="Enter No of packs" id="pack" path="packs" />
		</div>
		<span id="perror" style="color:red"></span>
		</div>
		<div>
		<div>
		<label><b>Load Cost:</b></label>
		</div>
		<div>
	    <form:input type="text" placeholder="Enter Amount" id="cost" path="loadCost" />
	    </div>
	    <span id="cerror" style="color:red"></span>
	    </div>
	    <div>
	    <div>
	    <label><b>date:</b></label>
		</div>
		<div>
	    <form:input type="date" placeholder="select date" id="date" path="date" />
	    </div>
	    <span id="derror" style="color:red"></span>
	    </div><br>
		<input type="submit" value="Save" class="save" /><br>
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/loads">Back to Loads List</a>
		</p>
	
	</div>
</div>
</body>

</html>











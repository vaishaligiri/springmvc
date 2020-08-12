<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript'>
	function search() {
		var value = document.getElementById("s").value;

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("grid").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "search?n=" + value, true);
		xhttp.send();
	}
</script>
</head>
<body>
	<c:import url="index.jsp"></c:import>
	<br>
	<br>
	<input type='text' name='name' value='' placehoder='Search...'
		onkeyup="search()" id='s' style='width: 400px; height: 30px;' />
	<br>
	<br>
	<div id="grid">
		<table border='5'>
			<tr>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>UPDATE</th>
				<th>DALETE</th>
			</tr>
			<c:forEach var="r" items="${users}">
				<tr>
					<td>${r.getName()}</td>
					<td>${r.getEmail()}</td>
					<td>${r.getContact()}</td>
					<td><a href=''>UPDATE</a></td>
					<td><a href='del?userid=${r.getId()}'>DELETE</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
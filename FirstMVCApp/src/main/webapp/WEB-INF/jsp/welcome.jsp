<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<br>
	<br>
	<form name='frm' action='welcome' method='POST'>
		<input type='text' name='name' value=''
			style='width: 400px; height: 30px' /><br> <br> <input
			type='text' name='email' value='' style='width: 400px; height: 30px' /><br>
		<br> <input type='text' name='contact' value=''
			style='width: 400px; height: 30px' /><br> <br> <input
			type='submit' name='s' value='Register'
			style='width: 400px; height: 30px' /><br> <br> <span
			style='color: white; background: red;'>${msg}</span>
	</form>
</body>
</html>
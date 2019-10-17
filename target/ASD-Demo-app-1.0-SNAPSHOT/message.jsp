<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="container">
		<br /> 
		<span><%=request.getAttribute("message")%></span>
	    <br />
		<br /> 
		<input type="button" value="Back" onclick="history.back()" />
	</div>
</body>
</html>
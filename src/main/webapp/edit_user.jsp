<%@ page language="java" import="asd.demo.model.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/animation.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Edit</title>
</head>
<body>

	<%
		User user = (User) session.getAttribute("user");
	 if(user == null){
     	response.sendRedirect("login.jsp"); 
     	return;
     } 
     String userName = user.getName();
	%>

	<div class="container">

		<p class="title">My Account</p>

		<form method="post" action="${pageContext.request.contextPath}/changeInfo">
			<table class="table">
			    <tr>
					<td>Email</td>
					<td><input type="text" name="email" readonly class="form-control"  
						value="<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Full name</td>
					<td><input type="text" name="name" class="form-control"  
						value="<%=user.getName()%>"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" class="form-control"  
						value="<%=user.getPassword()%>"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" class="form-control"
						value="<%=user.getPhone()%>"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="btn btn-info">&nbsp;&nbsp;&nbsp;
					<a href="main.jsp" class="btn btn-info" target="_parent">Cancel</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" import="asd.demo.model.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="asd.demo.model.Feedback"%>
<%@page import="asd.demo.model.User"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/animation.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Feedback Details</title>
</head>
<body>
	<%
                Feedback feedback = (Feedback) session.getAttribute("feedBackDetails");
	%>

	<div class="container">
		<p class="title">Feedback Details</p>
		<form method="post" action="${pageContext.request.contextPath}/FeedbackDetailsServlet?feedbackUserEmail=<%=feedback.getEmail()%>">
			<table class="table">
		
					<td>Opal Card No.</td>
					<td><%=feedback.getOpalCardNo()%></td>
				</tr>
                                
                                </tr><tr>
					<td>Full Name</td>
                                        <td><%=feedback.getFirstName()%>&nbsp; <%=feedback.getLastName()%></td>
				</tr>
                                <tr>
					<td>Email</td>
                                        <td><%=feedback.getEmail()%></td>
				</tr>
                                <tr>
					<td>Title</td>
					<td>"<%=feedback.getTitle()%></td>
				</tr><tr>
					<td>City</td>
					<td><%=feedback.getCity()%></td>
				</tr><tr>
					<td>Address</td>
					<td><%=feedback.getAddress()%></td>
				</tr><tr>
					<td>Pin Code</td>
					<td><%=feedback.getPinCode()%></td>
				</tr><tr>
					<td>Enquiry Type</td>
					<td><%=feedback.getEnqueryType()%></td>
				</tr><tr>
					<td>Enquiry</td>
					<td><%=feedback.getEnquery()%></td>
				</tr>
                                <tr>
					<td>Reply</td>
                                        <td><textarea rows="3" class="form-control" name="body"></textarea></td>
				
				</tr>
				<tr>
					<td></td>
                                         <input type="hidden" value ="<%=feedback.getEmail()%>" name="email"/>
                                        <td> <button type="submit" class="btn btn-info">Reply Feedback</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

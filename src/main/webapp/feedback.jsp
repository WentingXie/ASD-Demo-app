
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.Feedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="asd.demo.controller.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Feedback</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Nunito:400,300,700'>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <%
        String emptyErr = request.getParameter("empty");
    %>

    <body>

        <div class="row">
            <form action="${pageContext.request.contextPath}/FeedbackServlet" method="post">
                <p class="title">Feedback Details:  </p>&emsp;<span class="error"> <c:if test="${emptyErr!=null}"><c:out value="${emptyErr}"/></c:if></span>
                    <div class="form-group" id="title">
                        <input type="text" class="form-input" name ="title" placeholder="Title" required="true">
                    </div>
                    <div class="form-group" id="description">
                        <textarea required="true" rows="5" class="form-textarea" name="description"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Post" class="login-button" id="post" />                    
                    </div>
                </form>         
            </div>        
                   
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
        <script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>       
    </body>

</html>

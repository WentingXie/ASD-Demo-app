<%-- 
    Document   : login
    Created on : 11/04/2018, 10:20:23 AM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="asd.demo.controller.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Nunito:400,300,700'>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    </head>
    <%
        String emailErr = request.getParameter("emailErr");
        String passErr = request.getParameter("passErr");
        String emptyErr = request.getParameter("empty");
    %>
    <body>
      <div class="container">
       <p class="title">Login Details:  </p>&emsp;<span class="error"> <c:if test="${emptyErr!=null}"><c:out value="${emptyErr}"/></c:if></span>
         <div class="center-block">
            <form action="${pageContext.request.contextPath}/login" method="post" target="_parent" class="form-horizontal">
                  <div class="form-group" id="username">
                        <input class="form-control" placeholder="Email" name="email" required="true">&emsp;<span class="error"><c:if test="${emailErr!=null}"><c:out value="${emailErr}"/></c:if></span>                                       
                    </div>
                    <div class="form-group" id="password">
                        <input type="password" class="form-control" name ="password" placeholder="Password" required="true">&emsp;<span class="error"><c:if test="${passErr!=null}"><c:out value="${passErr}"/></c:if></span>
                    </div>
                    <div class="form-group">
                       <input type="submit" value="Login" name = "login" class="login-button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="Cancel" onclick="javascript:window.location.href='index.jsp'"class="cancle-button"/>                   
                    </div>
                </form>         
        </div>
       </div>       
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
        <script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>       
    </body>

</html>

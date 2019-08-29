<%-- 
    Document   : account
    Created on : 2019-8-26, 18:31:37
    Author     : suyixin
--%>

<%@ page language="java" import="asd.demo.model.*" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript" src="js/animation.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Edit</title>
    </head>
    <body>
        
        <%
         
        %>

        <p class = "title">My Account</p>

        <form method="post" action="edit_user.jsp">
            <table class="table">
                <tr><td>User Name: </td><td>Jimmy</td></tr>
                <tr><td>Email:    </td><td>123@gmail.com</td></tr>
                <tr><td>Password:    </td><td>******</td></tr>
                <tr><td>Phone:    </td><td>123456</td></tr>
                <tr><td><button>Edit</button></td></tr>
            </table>
            <%
               
            %>
        </form>



    </body>
</html>

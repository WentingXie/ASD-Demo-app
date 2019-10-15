<%-- 
    Document   : hello
    Created on : 13/10/2019, 9:53:07 PM
    Author     : jonny
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>a<span class="error"><c:if test="${existErr!=null}"><span class="error"><c:out value="${existErr}"/></span></c:if></span></h2>
<% 
String name=(String)session.getAttribute("existErr"); 
out.print("Error: "+name); 
%> 
    </body>
</html>

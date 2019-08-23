<%-- 
    Document   : register
    Created on : 2019-8-18, 15:41:24
    Author     : suyixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="welcome.jsp">
            <table class="table">
                <tr><td>Full name</td><td><input type="text" name="name" size="25"></td></tr>
                <tr><td>Email    </td><td><input type="text" name="email" size="25"></td></tr>
                <tr><td>Password    </td><td><input type="password" name="password" size="25"></td></tr>
                <tr><td>Phone    </td><td><input type="text" name="phone" size="25"></td></tr>
                <tr><td></td><td><input type="submit" value="Register" class="button"></td></tr>
            </table>
        </form>
    </body>
</html>

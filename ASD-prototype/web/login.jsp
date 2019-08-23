<%-- 
    Document   : login
    Created on : 2019-8-18, 15:41:35
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
            <form method="post" action="main.jsp">
            <table class="table">
                <tr><td>Username</td><td><input type="text" name="name" size="25" ></td></tr>

                <tr><td>Password    </td><td><input type="password" name="password" size="25"></td></tr>

                <tr><td></td><td><input type="submit" value="Login" class="button"></td></tr>
            </table>
        </form>
    </body>
</html>

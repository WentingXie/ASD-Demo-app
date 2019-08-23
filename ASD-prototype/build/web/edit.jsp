<%-- 
    Document   : edit.jsp
    Created on : 2019-8-16, 15:01:35
    Author     : suyixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#F0F8FF">
          <p class="form_title">My Account</p>

        <form method="post" action="account.jsp">
            <table class="table">
                <tr><td>Full name</td><td><input type="text" name="name" size="25" value="Jimmy"></td></tr>
                <tr><td>Email    </td><td><input type="text" name="email" size="25" value="123@gmail.com"></td></tr>
                <tr><td>Password    </td><td><input type="password" name="password" size="25" value="1234567"></td></tr>
                <tr><td>Phone    </td><td><input type="text" name="phone" size="25" value="4326671"></td></tr>
                <tr><td></td><td><input type="submit" value="Save" class="button"></td></tr>
            </table>
        </form>
    </body>
</html>

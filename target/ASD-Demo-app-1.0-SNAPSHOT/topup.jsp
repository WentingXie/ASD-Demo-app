<%-- 
    Document   : topup
    Created on : 06/09/2019, 2:01:00 PM
    Author     : jonny
--%>


<%@page import="asd.demo.model.OpalCard"%>

<% 
    OpalCard card = (OpalCard) session.getAttribute("opalcard");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h2>Top Up</h2>
        <hr />
        <a href="opalcardlist">OpalCards</a>
        <br />
        <br />
        <form method="post">
        <table border="1" width="100%" class="table-bordered">
            <thead>

            </thead>
            <tbody>
                <tr>
                    <td>OpalCardID</td>
                    <td><%=card.getOpalCardID()%></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><%=card.getDescription()%></td>
                </tr>
                
                <tr>
                    <td>Balance</td>
                    <td><%=card.getBalance()%></td>
                </tr>
                
                <tr>
                    <td>Top Up Amount</td>
                    <td><input type="number" name="amount" min="0" step="0.01" > </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Top Up" > </td>
                </tr>

            </tbody>



        </table>
        </form>
    </body>
</html>

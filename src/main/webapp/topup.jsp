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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="title">
            <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
         <h2>Top Up</h2>
        </div>
        <hr />
        <a href="listOpalCard">Cancel</a>
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

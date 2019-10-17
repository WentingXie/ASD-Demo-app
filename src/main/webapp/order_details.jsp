<%-- 
    Document   : paymenthistory
    Created on : 26/09/2019, 3:14:58 PM
    Author     : jonny
--%>
<%@page import="asd.demo.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<%
    List<Order> Order = (ArrayList) session.getAttribute("orderlist");
%>

<html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
    </head>

    <body>
        <div class="container">
            <div class="title">
                <p>
                    <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
                <br/>
                <br/>    
                <h1>My Activated Cards</h1>
                <hr />
            </div>

            <div class="row">
                <div class="col-sm-4">
                    <a href="main.jsp" class="btn btn-default btn-block">Home</a>
                </div>
            </div>
            <hr />

            <table class="table table-bordered table-condensed table-hover table-striped">
                <thead>
                    <tr>
                        <th>OpalCardNumber</th>
                        <th>Address</th>
                        <th>Order Date</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody
                    <%if (Order != null) {%>
                        <%for (Order l : Order) {%>
                        <tr>
                            <td><%=l.getOpalCardSequenceNumber()%></td>
                            <td><%=l.getUserAddress()%></td>
                            <td><%=l.getOrderDate()%></td>
                            <td><a href="deactivate?id=<%=l.getId()%>" class="btn btn-xs btn-primary">Deactivate</a> 
                        </tr>
                        <%}%>
                     <%}%>
                </tbody>

            </table>
        </div>
    </body>
</html>

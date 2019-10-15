<%-- 
    Document   : paymenthistory
    Created on : 26/09/2019, 3:14:58 PM
    Author     : jonny
--%>
<%@page import="asd.demo.model.PaymentHistory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<%List<PaymentHistory> PaymentHistoryList = (ArrayList) session.getAttribute("historylist");%>

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
                <h1>My Payment History</h1>
                <hr />
            </div>

            <div class="row">
                <div class="col-sm-4">
                    <a href="main.jsp" class="btn btn-default btn-block">Home</a>
                </div>
            </div>
            <hr />

            <form>
                <div class="row">
                    <div class="col-sm-3">
                        <input class="form-control" type="search" name="searchbox" placeholder="Enter Card Number search here">
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" name="search" class="btn btn-primary btn-block" value="Search">
                    </div>
                </div>
            </form>
            <br />

            <form method="post" action="clearHistory">
                <div class="row">

                    <div class="col-sm-2">
                        <input type="submit" name="delete" class="btn btn-primary btn-danger" value="Clear Page">
                    </div>
                </div>
            </form>

            <hr />
            <table class="table table-bordered table-condensed table-hover table-striped">
                <thead>
                    <tr>
                        <th>OpalCardNumber</th>
                        <th>TopUpAmount</th>
                        <th>TimeStamp</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody
                    <%for (PaymentHistory l : PaymentHistoryList) {%>
                    <tr>
                        <td><%=l.getOpalCardSequenceNumber()%></td>
                        <td><%=l.getTopUpAmount()%></td>
                        <td><%=l.getTimeStamp()%></td>
                        <td><a href="topup?id=<%=l.getOpalCardSequenceNumber()%>" class="btn btn-xs btn-primary">Delete</a>
                    </tr>
                    <%}%>
                </tbody>

            </table>
        </div>
    </body>
</html>

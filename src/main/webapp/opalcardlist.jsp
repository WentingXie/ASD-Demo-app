<%-- 
    Document   : topup
    Created on : 29/08/2019, 3:14:58 PM
    Author     : jonny
--%>

<%@page import="asd.demo.model.OpalCard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%List<OpalCard> OpalCardList = (ArrayList) session.getAttribute("opallist");%>

<!DOCTYPE html>
<<<<<<< HEAD

<%List<OpalCard> OpalCardList = (ArrayList) session.getAttribute("opallist");%>

=======
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
<html>

    <head>
        <title>OpalCardList</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <div class="container">
            <div class="title">
<<<<<<< HEAD
                <p>
                    <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
                <br/>
                <br/>    
                <h1>My Opal Card</h1>
                <hr />
            </div>

=======
                <p><img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/></p>
            <br/>
            <br/>    
                <h1>My Opal Card</h1>
            <hr />
            </div>
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
            <div class="row">
                <div class="col-sm-4">
                    <a href="main.jsp" class="btn btn-default btn-block">Home</a>
                </div>
            </div>
            <hr />
<<<<<<< HEAD

=======
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
            <table class="table table-bordered table-condensed table-hover table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Balance</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
<<<<<<< HEAD

=======
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
                <tbody
                    <%for (OpalCard l : OpalCardList) {%>
                    <tr>
                        <td><%=l.getSequenceNumber()%></td>
                        <td><%=l.getBalance()%></td>
                        <td><%=l.getDescription()%></td>
<<<<<<< HEAD
                        <td><a href="topup?id=<%=l.getSequenceNumber()%>" class="btn btn-xs btn-primary">Top Up</a> 
                    </tr>
                    <%}%>
                </tbody>

=======
                        <td><a href="topup?id=<%=l.getSequenceNumber()%>" name="select" class="btn btn-xs btn-primary">Top Up</a> 
                    </tr>
                    <%}%>
                </tbody>
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
            </table>
        </div>
    </body>
</html>

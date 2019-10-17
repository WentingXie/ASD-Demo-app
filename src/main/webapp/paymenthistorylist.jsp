<%-- 
    Document   : paymenthistory
    Created on : 26/09/2019, 3:14:58 PM
    Author     : jonny
--%>

<%@page import="asd.demo.model.PaymentHistory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%List<PaymentHistory> PaymentHistoryList = (ArrayList) session.getAttribute("historylist");%>

<!DOCTYPE html>
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
                <p><img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/></p>
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
                <h3 class="text-danger"> 
                    <!--Get the error attribute and clear after using it-->
                    <%
                    String name=(String)session.getAttribute("existErr"); 
                    if(!(name == null || (name.equals("")))){
                    %>
                        <p><%=name %></p>
                    <%
                    }
                    %>
                    <%
                    session.removeAttribute("existErr");
                    %>
                </h3>
            <div class="row">
                <form action="${pageContext.request.contextPath}/ListPaymentHistory" method="post" target="_parent">
                    
                    <div class="col-sm-3" id="searchbox">
                        <input class="form-control" type="search" placeholder="Enter Opal Number Search Here" name="searchbox" id="searchbox" required="true">                               
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" id="search" name="search" value="Search" class="btn btn-primary btn-block"/>                    
                    </div>
                    
                </form>         
            </div> 
            <br />
                <form method="post" action="clearHistory">
                
                <div class="row">
                    <div class="col-sm-2">
                        <input type="submit" name="clear" class="btn btn-primary btn-danger" value="Clear Page">        
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
                        <td>
                            <form method="post" action="deleteHistory">
                                
                                <input type="hidden" name="historyid" value="<%=l.getId()%>" />
                                <input type="submit" name="delete" class="btn btn-xs btn-danger" value="Delete" />
                                
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>

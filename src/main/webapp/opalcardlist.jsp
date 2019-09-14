<%-- 
    Document   : topup
    Created on : 29/08/2019, 3:14:58 PM
    Author     : jonny
--%>
<%@page import="asd.demo.model.OpalCard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<%List<OpalCard> OpalCardList = (ArrayList)session.getAttribute("opallist");%>


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
        <title>Opal</title>
    </head>
    <body>
        <div class="title">
            <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
        <h2>Top Up</h2>
        </div>
        <hr />
        <a href="main.jsp">Home</a>
        <br />
        <br />
        <form>
<!--          <input type="value" name="date" placeholder="Enter your Opal Card ID">  -->
<!--          <input type="submit"  value="Search">-->
        </form>
        <hr />
    <table border="1" width="100%" class="table-bordered">
        <thead>
  <tr>
    <th>OpalCardId</th>
    <th>Balance</th>
    <th>Description</th>
    <th></th>
  </tr>
  
        </thead>
        <tbody
            <%for (OpalCard l : OpalCardList){%>
            <tr>
                <td><%=l.getOpalCardID()%></td>
                <td><%=l.getBalance()%></td>
                <td><%=l.getDescription()%></td>
                
                <td><a href="topup?id=<%=l.getOpalCardID()%>">Top Up</a> 
                    
            </tr>
            <%}%>
    </tbody>
         
 
  
</table>
    </body>
    
</html>

   <tbody>
               
       
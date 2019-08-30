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

<%List<OpalCard> OpalCardList = (ArrayList)session.getAttribute("OpalCardList");%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript" src="js/animation.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        
        <h2 class="title">Top Up</h2>
        <hr />
        <a href="main.jsp">Home</a>
        <br />
        <br />
        <form>
          <input type="date" name="date" placeholder="Enter a date">  
          <input type="submit"  value="Search">
        </form>
        <hr />
    <table  class="table2">
        <thead>
  <tr>
    <th>OpalCardId</th>
    <th>Balance</th>
    <th>Description</th>
    <th></th>
  </tr>
  
        </thead>
       
 
  
</table>
    </body>
    
</html>

   <tbody>
               
       
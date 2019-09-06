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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
    </head>
    <body>
        
        <h2>Top Up</h2>
        <hr />
        <a href="main.jsp">Home</a>
        <br />
        <br />
        <form>
          <input type="date" name="date" placeholder="Enter a date">  
          <input type="submit"  value="Search">
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
               
       
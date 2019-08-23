<%-- 
    Document   : index
    Created on : 17/08/2019, 11:17:28 PM
    Author     : jonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opal</title>
    </head>
    <body>
        
        <h2>My Payment History</h2>
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
  <tr>
    <th>Id</th>
    <th>PaymentID</th>
    <th>OpalID</th>
    <th>Amount</th>
    <th>TimeStamp</th>
    <th></th>
  </tr>
  <tr>
      <td>9021 4121</td>
      <td>10250asdd1510</td>
      <td>1051 1510 6516</td>
      <td>20.00</td>
      <td>2019-05-24</td>
      <td>
          <a onclick="return confirm('Are you sure you want to delete')">Delete</a>
      </td>
  </tr>
  
</table>
    </body>
    
</html>


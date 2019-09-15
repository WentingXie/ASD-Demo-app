<%-- 
    Document   : feedbacklist
    Created on : Sep 14, 2019, 11:01:58 PM
    Author     : Pancham singh
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.Feedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Feedbacks</title>
    </head>
    <%List<Feedback> list = (ArrayList) session.getAttribute("feedbacklist");%>

    <body>
        <div>
        <div class="title">
            <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
        <h2>Customer Feedbacks</h2>
        </div>
        <hr />
        <a href="main.jsp">Home</a>
        <br />
        <br />
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th >#</th>
                        <th >name</th>
                        <th >email</th>
                        <th >title</th>
                        <th>description</th>

                    </tr>
                </thead>
                <tbody>
                    <%for (Feedback f : list) {%>
                    <tr>
                        <td><%=list.indexOf(f)+1%></td>
                        <td><%=f.getName()%></td>
                        <td><%=f.getEmail()%></td>
                        <td><%=f.getTitle()%></td>
                        <td><%=f.getDescription()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>l
        </div>
    </body>
</html>

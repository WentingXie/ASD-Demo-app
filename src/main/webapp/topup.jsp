<%-- 
    Document   : topup
    Created on : 06/09/2019, 2:01:00 PM
    Author     : jonny
--%>

<%@page import="asd.demo.model.OpalCard"%>
<<<<<<< HEAD

<%
    OpalCard card = (OpalCard) session.getAttribute("opalcard");
%>

=======
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%OpalCard card = (OpalCard) session.getAttribute("opalcard");%>

<!DOCTYPE html>
<html>

    <head>
        <title>TopUpPage</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <div class="container">
            <div class="title">
<<<<<<< HEAD
                <p>
                    <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
=======
                <p><img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/></p>
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
                <br/>
                <br/>
                <h1>Top Up</h1>
                <hr />
            </div>
<<<<<<< HEAD

            <div class="row">
                <div class="col-sm-4">
                    <a class="btn btn-default btn-block" href="listOpalCard">Cancel</a>
                </div>
            </div>
            <hr />

            <form method="post">
=======
            <div class="row">
                <div class="col-sm-4">
                    <a class="btn btn-default btn-block" href="ListOpalCard">Cancel</a>
                </div>
            </div>
            <hr />
                <h3 class="text-danger">
                    <!--Get the error attribute and clear after using it-->
                    <%
                    String name=(String)session.getAttribute("existErr2"); 
                    if(!(name == null || (name.equals(""))))
                    {
                    %>
                    <p><%=name %></p>
                    <%
                    }
                    %>
                    <%
                    session.removeAttribute("existErr2");
                    %>
                </h3>
            <form method="post">
                
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
                <table class="table table-bordered table-condensed table-hover table-striped">
                    <tbody>
                        <tr>
                            <td>ID</td>
                            <td><%=card.getSequenceNumber()%></td>
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
<<<<<<< HEAD
                            <td><input type="number" name="amount" min="0" step="0.01" > </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="btn btn-success" type="submit" value="Top Up" > </td>
                        </tr>
                    </tbody>

                </table>
=======
                            <td><input type="number" id="amount" name="amount" min="5" max="100" required="true"> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="btn btn-success" name="topup" type="submit" value="Top Up" > </td>
                        </tr>
                    </tbody>
                </table>
                        
>>>>>>> 8d2df50caeb8b502ff0a23064ce40d38b05ee1a8
            </form>
        </div>
    </body>
</html>

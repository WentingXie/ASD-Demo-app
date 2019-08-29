<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>        
        <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.css">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" ></script>
        <script src="jsanimation.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/script.js"></script>  
        <script type="text/javascript" src="js/animation.js"></script> 
          
    </head>
    <title>Home</title>
  
    <body onload="startTime()">           
        <div>
            <span class="time" id="time" ></span>
            <div class="title">
                <p>Opal Card</h1>                        
                          
            </div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="register.jsp">Register</a>
                        <a class="navbar-brand" href="login.jsp">Login</a>
                       
                        
                    </div>
                   
                </div>
            </nav>           
        </div> 
        
 
        <script src="webjars/jquery/2.1.4/jquery.js"></script>
        <script src="webjars/bootstrap/3.3.5/js/bootstrap.js"></script>
    </body>
</html>
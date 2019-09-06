<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>        
         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        
        <!-- <script src="jsanimation.js"></script>
        <script type="text/javascript" src="js/script.js"></script>  
        <script type="text/javascript" src="js/animation.js"></script> -->
          
    </head>
    <title>Home</title>
  
    <!-- <body onload="startTime()"> -->      
    <body>
            
            <div class="title">
                <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
                <p>Opal Card</p>
            </div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header pull-right">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="register.jsp">Register</a>
                        <a class="navbar-brand" href="login.jsp">Login</a>
                    </div>
                </div>
            </nav>
            <div class="container">
	            <div class="row">
		            <div class="center-block">
					    <a href="#">
					      <img src="image/card_pensioner.png" width="266px" alt="senior/penioner"
					      data-container="body" data-toggle="popover" data-placement="left" data-html="true"
				            data-content="
				            <h4>Where can I use my Senior/Penioner Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            ">
					    </a>
					    <a href="#">
					      <img src="image/adult.png" width="266px" alt="adult"
							data-container="body" data-toggle="popover" data-placement="right" data-html="true"
				            data-content="
				            <h4>Where can I use my Adult Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            ">
					    </a>
					</div>
				</div>
			    <div class="row">
		            <div class="center-block">
					    <a href="#">
					      <img src="image/card_child.png" width="266px" alt="card_child"
							data-container="body" data-toggle="popover" data-placement="left" data-html="true"
				            data-content="
				            <h4>Where can I use my card_child Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            ">
					    </a>
					    <a href="#" >
					      <img src="image/School.png" width="266px" alt="School"
							data-container="body" data-toggle="popover" data-placement="right" data-html="true"
				            data-content="
				            <h4>Where can I use my School Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            ">
					    </a>
		           </div>
		        </div>
       </div> 

	<script>
	$(function (){
	    $("[data-toggle='popover']").popover();
	});
	</script>

    </body>
</html>
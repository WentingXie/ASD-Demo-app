<%@page import="asd.demo.model.*"%>
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
    </head>
    <title>Main</title>

    <%
        User user = (User)session.getAttribute("user");
        if(user == null){
        	response.sendRedirect("login.jsp");
        	return;
        }
        String userName = user.getName();
    %>

    <body>
            <span class="time" id="time" ></span>
            <div class="title">
                <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
                <p>Opal Card</p>
            </div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header pull-left">
                        <%if(user!=null && user.getUserType()!=null && user.getUserType().equals("Admin")) { %>
                             <a class="navbar-brand" href="#">User Management</a>
                        <%} %>
                    </div>
                    <div class="navbar-header pull-right">
                        <a class="navbar-brand" href="#">Customer Care</a>
                        <a class="navbar-brand" href="ListOpalCard">Top Up</a>
                        <a class="navbar-brand" href="ListPaymentHistory">Payment History</a>
                        <a class="navbar-brand dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
						       <%=userName%><span class="caret"></span>
						    </a>
					    <ul class="dropdown-menu">
					        <li><a href="edit_user.jsp">Change Information</a></li>
					        <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
					    </ul>
                    </div>
                </div>
            </nav>
            <div class="container">
                   <span class="text-left"><h1>My Opal Card</h1></span>
                   <div class="col-sm-6 col-md-4">
				      <div class="thumbnail">
				          <img src="image/adult.png" alt="adult">
				      </div>
				    </div>
				    <div class="col-sm-6 col-md-4">
				      <div class="thumbnail">
           		            <div class="card-body" style="height:180px">
           		              <br/><br/><br/><br/>
           		             <a href="#">Activate an Opal Card</a></div>
				      </div>
				    </div>
				     <div class="col-sm-6 col-md-4">
				      <div class="thumbnail">
           		            <div class="card-body" style="height:180px">
           		            </div>
				      </div>
				    </div>
           <!--  </div>
            <div class="container"> -->
            <span class="text-left"><h1>Order an Opal Card</h1></span>
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

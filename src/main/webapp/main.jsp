<%@page import="java.util.List"%>
<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js" ></script>
        <script src="js/jquery.easyui.min.js" ></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
		<script src="js/bootstrapValidator.min.js"></script>
    </head>
    <title>Main</title>
    
    <%
        User user = (User)session.getAttribute("user");
        if(user == null){
        	response.sendRedirect("login.jsp"); 
        	return;
        } 
        String userName = user.getName();
        List<String> opalCardTypes = (List<String>)session.getAttribute("opalCardTypes");
    %>
    
    <body>
            <span class="time" id="time" ></span>
            <div class="title">
                <p>
                  <img height="45px" width="120px" class="pull-left" src="image/Opal_card_logo.svg.png"/>
                </p>
                <p><h1>Opal Card</h1></p>
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
                                                <li><a href="${pageContext.request.contextPath}/ListOrderServlet">Order Information</a></li>
					        <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
					    </ul>
                    </div>
                </div>
            </nav>
            <div class="container">
               <div class="row">
                   <span class="text-left"><h1>My Opal Card</h1></span>
                   <%
					for(int i=0;i<opalCardTypes.size();i++){
					%>
                   <div class="col-sm-6 col-md-4">
				      <div class="thumbnail" style="height:188px" >
				      <%
					     if(opalCardTypes.get(i).equals("Adult")){
					   %>
				          <a href="${pageContext.request.contextPath}/ListActivatedOrderServlet?type=Adult"><img src="image/adult.png" style="height:175px" alt="adult" ></a>  
				          <%
					     } else if(opalCardTypes.get(i).equals("Pensioner")){
					    	 
				          %>
				          <a href="${pageContext.request.contextPath}/ListActivatedOrderServlet?type=Pensioner"><img src="image/card_pensioner.png" style="height:175px" alt="senior/penioner"></a>  
				          <%
 					     } else if(opalCardTypes.get(i).equals("Child")){
 					     %>
				            <a href="${pageContext.request.contextPath}/ListActivatedOrderServlet?type=Child"><img src="image/card_child.png" style="height:175px" alt="child"></a>  
				         <%
					     } else {
				          %>
				             <a href="${pageContext.request.contextPath}/ListActivatedOrderServlet?type=School"><img src="image/School.png" style="height:175px" alt="School"></a>  
				         <%
					     } 
				          %> 
				      </div>
				    </div>
				    <%
					}
					%>
				    <div class="col-sm-6 col-md-4">
				      <div class="thumbnail"style="height:188px">
           		            <div class="card-body">
           		              <br/><br/><br/><br/>
                                      <a class="btn btn-primary btn-lg" data-toggle="modal" name="activated" id="activated" data-target="#myModal">Activate an Opal Card</a>
				            </div>
				       </div>
				     </div>
				    <!--  <div class="col-sm-6 col-md-4">
				      <div class="thumbnail">
           		            <div class="card-body" style="height:180px">
           		            </div>
				      </div>
				    </div> -->
             </div>
	      
	        <div class="row">
            <span class="text-left"><h1>Order an Opal Card</h1></span>
                                            <a href="#" onclick="chooseOrder('${pageContext.request.contextPath}/chooseOrder','Pensioner')">
					      <img src="image/card_pensioner.png" width="266px" alt="senior/penioner"
					     <%--  data-container="body" data-toggle="popover" data-placement="left" data-html="true"
				            data-content="
				            <h4>Where can I use my Senior/Penioner Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            " --%>>
					    </a>
					    <a href="#" onclick="chooseOrder('${pageContext.request.contextPath}/chooseOrder','Adult')">
					      <img src="image/adult.png" width="266px" alt="adult"
							<%-- data-container="body" data-toggle="popover" data-placement="right" data-html="true"
				            data-content="
				            <h4>Where can I use my Adult Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            " --%>>
					    </a>
				</div>
			    <div class="row">
					    <a href="#" onclick="chooseOrder('${pageContext.request.contextPath}/chooseOrder','Child')">
					      <img src="image/card_child.png" width="266px" alt="card_child"
						<%-- 	data-container="body" data-toggle="popover" data-placement="left" data-html="true"
				            data-content="
				            <h4>Where can I use my card_child Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            " --%>
				            >
					    </a>
					    <a href="#" onclick="chooseOrder('${pageContext.request.contextPath}/chooseOrder','School')">
					      <img src="image/School.png" width="266px" alt="School"
							<%-- data-container="body" data-toggle="popover" data-placement="right" data-html="true"
				            data-content="
				            <h4>Where can I use my School Opal card?</h4>
							 <br>Your Opal card can be used on the following:
							 <br>- All Sydney Metro, Sydney Trains and NSW TrainLink Intercity trains
							 <br>- All buses in Sydney, the Blue Mountains, Central Coast, Hunter and Illawarra
							 <br>- All Sydney Ferries and the Stockton Ferry in Newcastle
							 <br>- All Sydney and Newcastle Light Rail
				            " --%>>
					    </a>
		        </div>
       </div> 
<!-- Activate Modal -->
<div class="modal fade" tabindex="-1" role="dialog" id="myModal" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Activate an Opal Card</h4>
      </div>
      <div class="modal-body">
	      <form class="form-horizontal" id="f_ActivateCard" action="${pageContext.request.contextPath}/activateCard" method="post">
			  <div class="form-group has-feedback">
			    <label class="control-label col-sm-3" for="sequenceNumber">SequenceNumber:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="sequenceNumber" name="sequenceNumber" required="true" placeholder="SequenceNumber" aria-describedby="sequenceNumber">
			    </div>
			  </div>
			  <div class="form-group has-feedback">
			    <label class="control-label col-sm-3" for="securityNumber">SecurityNumber:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="securityNumber" name="securityNumber" required="true" placeholder="SecurityNumber" aria-describedby="securityNumber">
			    </div>
		      </div>
		    <div class="form-group has-feedback" id="div_msg">
			    <label id="msg" class="text-danger"></label>
		      </div>
		  </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="ActivateCard();">ActivateCard</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


	<div class="modal fade"  tabindex="-1" id="loadingModal">
		<div
			style="width: 200px; height: 20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%; margin-left: -100px; margin-top: -10px">
			<h5 style="color: black">
				<strong>waiting...</strong>
			</h5>
			<div class="progress progress-striped active"
				style="margin-bottom: 0;">
				<div class="progress-bar" style="width: 100%;"></div>
			</div>
		</div>
	</div>

</body>
    
	<script>
	$(function (){
	    $("[data-toggle='popover']").popover();
	    $('#myModal').modal('hide');
	    $("#myModal").on("show.bs.modal",function(){
			$('#div_msg').hide();
	    });
	});
	
	$('#f_ActivateCard').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphiconglyphicon-ok',
			invalid : 'glyphiconglyphicon-remove',
			validating : 'glyphiconglyphicon-refresh'
		},
		fields : {
			sequenceNumber : {
				message : 'error',
				validators : {
					notEmpty : {
						message : 'SequenceNumber can not be null.'
					}
				}
			},
			securityNumber : {
				message : 'error',
				validators : {
					notEmpty : {
						message : 'SecurityNumber can not be null.'
					}
				}
			}
		},submitHandler: function (validator, form, submitButton) {
			
			
		    $("#f_ActivateCard").form("submit",{  
			    success :function(data){
			    	var rs = JSON.parse(data);
			    	if(typeof(rs.msg) == "undefined" || rs.msg==null){
			    		alert("Binding success");
			    		window.location.href="main.jsp";
			    	} else {
			    		$("#loadingModal").modal('hide');
			    		showHint(rs.msg);
			    	}
			    },
			    error:function(data){  
			    	$("#loadingModal").modal('hide');
			       alert('error'+data); 
			    }
		    }); 
	      }
		
	}).on('success.form.bv', function(e) {
		$("#loadingModal").modal({
			 backdrop:"static",
			 show:true
		});
		
        // Get the form instance
        var $form = $(e.target);
        // Use Ajax to submit form data
        $.post($form.attr('action'), $form.serialize(), function(data) {
        	var rs = JSON.parse(data);
	    	if(typeof(rs.msg) == "undefined" || rs.msg==null){
	    		alert("Binding success");
	    		window.location.href="goMain";
	    	} else {
	    		$("#loadingModal").modal('hide');
	    		showHint(rs.msg);
	    	}
        });
    });
	
	function ActivateCard(){
		$('#div_msg').hide();
		$("#f_ActivateCard").submit();
	}
	

	function showHint(msg){
		$('#div_msg').show();
		$('#msg').text(msg);
	}

	function chooseOrder(url,productTypeId){
		$("#loadingModal").modal({
			 backdrop:"static",
			 show:true
		});
		 $.ajax({
			  url: url,
			  type: 'POST',
			  data: {"productTypeId":productTypeId}
		}).done(function(data){
			 var rs = JSON.parse(data);
			if(rs.msg!='ok'){
	    		alert(rs.msg);
	    		$("#loadingModal").modal('hide');
	    	} else {
	    		window.location.href="order.jsp";
	    	}
		}).fail(function(data){
			  alert(data);
	    		$("#loadingModal").modal('hide');
		});  
	}
	</script>
</html>

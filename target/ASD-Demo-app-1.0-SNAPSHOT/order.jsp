<%@page import="asd.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.bundle.min.js"></script>
<script src="js/jquery.easyui.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrapValidator.min.css">
<script src="js/bootstrapValidator.min.js"></script>
</head>
<title>Main</title>

<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	String userName = user.getName();
	OpalCard card = (OpalCard) session.getAttribute("oc");
	if (card == null) {
		response.sendRedirect("main.jsp");
		return;
	}
%>

<body>
	<span class="time" id="time"></span>
	<div class="title">
		<p>
			<img height="45px" width="120px" class="pull-left"
				src="image/Opal_card_logo.svg.png" />
		</p>
		<p>
		<h1>Opal Card</h1>
		</p>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header pull-left">
				<%
					if (user != null && user.getUserType() != null && user.getUserType().equals("Admin")) {
				%>
				<a class="navbar-brand" href="#">User Management</a>
				<%
					}
				%>
			</div>
			<div class="navbar-header pull-right">
				<a class="navbar-brand" href="#">Customer Care</a> <a
					class="navbar-brand dropdown-toggle" data-toggle="dropdown"
					href="#" role="button" aria-haspopup="true" aria-expanded="false">
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
		<form class="form-horizontal" id="F_createOrder" method="POST"
			action="${pageContext.request.contextPath}/createOrder">
			<div class="form-group">
				<label for="productTypeId" class="col-sm-2 control-label">productTypeId:</label>
				<div class="col-sm-10">
					<input class="form-control" readonly
						value="<%=card.getProductTypeId()%>">
						<input type="hidden" name="productTypeId"
						value="<%=card.getProductTypeId()%>">
				</div>
			</div>
			<div class="form-group">
				<label for="SequenceNumber" class="col-sm-2 control-label">SequenceNumber:</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" readonly
						name="opalCardSequenceNumber"
						value="<%=card.getSequenceNumber()%>">
				</div>
			</div>
			<div class="form-group">
				<label for="userAddress" class="col-sm-2 control-label">UserAddress:</label>
				<div class="col-sm-10">
					<input class="form-control" name="userAddress" type="text"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="postalCode" class="col-sm-2 control-label">Postal
					Code:</label>
				<div class="col-sm-10">
					<input class="form-control" name="postalCode" type="text"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button"
						onclick="javascript:window.location.href='main.jsp'"
						class="btn btn-primary">Cancel</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="createOrder();"
						class="btn btn-primary">Checkout</button>
				</div>
			</div>
		</form>
	</div>
	<div class="modal fade" tabindex="-1" id="loadingModal">
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
	<script>
		function createOrder() {
			$("#F_createOrder").submit();
		}

		$('#F_createOrder').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphiconglyphicon-ok',
				invalid : 'glyphiconglyphicon-remove',
				validating : 'glyphiconglyphicon-refresh'
			},
			fields : {
				userAddress : {
					message : 'error',
					validators : {
						notEmpty : {
							message : 'UserAddress can not be null.'
						}
					}
				},
				postalCode : {
					message : 'error',
					validators : {
						notEmpty : {
							message : 'Postal Code can not be null.'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			$("#loadingModal").modal({
				backdrop : "static",
				show : true
			});

			// Get the form instance
			var $form = $(e.target);
			// Use Ajax to submit form data
			$.post($form.attr('action'), $form.serialize(), function(data) {
				var rs = JSON.parse(data);
				if (typeof (rs.msg) == "undefined" || rs.msg == null) {
					alert("Order an Opal Card Success!");
					window.location.href = "goMain";
				} else {
					$("#loadingModal").modal('hide');
					alert(rs.msg);
				}
			});
		});

	</script>
</body>
</html>
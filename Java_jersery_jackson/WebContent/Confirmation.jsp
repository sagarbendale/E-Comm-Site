<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />


<title>Confirm Order</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://localhost:8080/#/store/TV">Ecommerce
				Website</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Cart.jsp">Order History</a></li>
				<li><a href="http://localhost:8081/eCommSite/Logout">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">

		<div class="row row-offcanvas row-offcanvas-left">

			<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">

				<ul class="nav nav-sidebar">
					<li class="active"><a href="Confirmation.jsp">Confirm
							Order</a></li>
					<li><a href="http://localhost:8080/#/store/TV">TV</a></li>
					<li><a href="http://localhost:8080/#/store/ROUTER">ROUTER</a></li>
					<li><a href="http://localhost:8080/#/store/CAMERA">CAMERA</a></li>

				</ul>
			</div>
			<!--/span-->

			<%
				if (session.getAttribute("id") != null) {

					if (session.getAttribute("receivedData") != null && session.getAttribute("checkDate").equals("true")) {
			%>
			<div class="col-sm-9 col-md-10 main">
				<h2 class="sub-header">Confirm Your Order</h2>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th width="20%">Product Name</th>
								<th width="50%">Description</th>
								<th width="15%">Warranty</th>
								<th width="15%">Price</th>
							</tr>
						</thead>
						<tbody>
							<jsp:include page="view/Confirm.jsp"></jsp:include>
						</tbody>
					</table>
				</div>



				<jsp:include page="view/forms/ConfirmationForm.jsp"></jsp:include>

				<%
					} else {
							response.sendRedirect("Cart.jsp");
						}
					}
					if (session.getAttribute("id") == null) {

						response.sendRedirect("UserLogin.jsp");
					}
				%>
			</div>
			<!--/row-->
		</div>
	</div>
	<!--/.container-->

	<footer>
	<p class="pull-right">©Sagar Bendale</p>
	</footer>

	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>

</body>
</html>
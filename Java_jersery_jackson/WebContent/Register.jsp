<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />


<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/#/store/TV">Ecommerce
				Website</a>
		</div>
	</div>
	</nav>

	<div class="container-fluid">

		<div class="row row-offcanvas row-offcanvas-left">



			<div class="main">

				<form role="form" action="Register" method="post" class="form-login">
					<h2 class="sub-header">Login</h2>

					<div class="form-group">
						<label for="email">Email-Id:</label> <input type="text"
							name="email" placeholder="abc@xyz.com" class="form-display">
					</div>
					<div class="form-group">
						<label for="fname">First Name:</label> <input type="text"
							name="fname"  class="form-display">
					</div>
					<div class="form-group">
						<label for="lname">Last Name:</label> <input type="text"
							name="lname"  class="form-display">
					</div>
					<div class="form-group">
						<label for="username">Choose User ID:</label> <input type="text"
							name="username"  class="form-display">
					</div>
					<div class="form-group">
						<label for="password">Enter Password:</label> <input type="password"
							name="password"  class="form-display">
					</div>
					<div class="form-group">
						<label for="rpassword">Repeat Password:</label> <input type="password"
							name="rpassword"  class="form-display">
					</div>
					<button type="submit" class="btn btn-default">Sign Up</button>
					<a class="btn" href="UserLogin.jsp">Already a User?</a>
				</form>

				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>
				<ul>&nbsp
				</ul>


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
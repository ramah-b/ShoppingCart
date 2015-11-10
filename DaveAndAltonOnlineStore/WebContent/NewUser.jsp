<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">A&D!</a>
				</div>

			</div>
		</div>
		</nav>
		</br>
		<form action="onlineServlet?action=NewUser" method="post">
			<div class="panel panel-default">
			<div class= "panel panel-heading">Registration Form</div>

				<div class="panel-body">
					<div class="form-group">
						<input type="name"
							class="form-control" name="name" id="exampleInputname"
							placeholder="name">
					</div>
					<div class="form-group">
					
						<c:if test="${message != null }">
							<h4 style = "color: #780000 "><c:out value="${message}" /></h4>
						</c:if>
						<input type="name" class="form-control" name="username"
							id="exampleInputUser1" placeholder="Username">
					</div>
					<div class="form-group">
						<input
							type="password" class="form-control" name="password"
							id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-group">
					<c:if test="${emailError != null }">
							<h4 style = "color: #780000 "><c:out value="${emailError}" /></h4>
						</c:if>
						<input
							type="password" class="form-control" name="email"
							id="exampleInputemail" placeholder="email">
					</div>

					<button type="submit" class="btn btn-info">Register</button>
				</div>
			</div>
		</form>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>

</body>
</html>
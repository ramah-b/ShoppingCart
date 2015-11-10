<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dave & Alton Online Store</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body style="background-color: white">

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
					<a class="navbar-brand">A&D!</a> 
					<a class="navbar-brand">Welcome <c:choose>
					<c:when test="${not empty buyerUser}">
					<c:out value="${buyerUser.name }" /><a class="navbar-brand" href="onlineServlet?action=history">Purchase History</a>
					</c:when>
					<c:otherwise>
					Guest User</c:otherwise></c:choose></a> 
					<a class="navbar-brand"
						href="onlineServlet?action=cart">Shopping Cart</a>
						<c:if test="${not empty buyerUser }">
						<a class="navbar-brand" href="onlineServlet?action=logout">Logout</a></c:if>
				</div>

			</div>
		</div>
		</nav>
		</br>


		<div class="panel panel-default">
			<div class="panel panel-heading">An Item Added to Your Cart</div>
			<div class="panel-body">
				<div class="list-group">
				
					
						<ul class="list-group">
							<li class="list-group-item">
								<c:out value="${lineItemBean.product.name}" /><span class="badge">Unit Price $<c:out value="${lineItemBean.price}" /></span><br>
								<span>Quantity: <c:out value="${lineItemBean.quantity}" /></span><span class="badge" style="bgcolor: green">Total Price $<c:out value="${lineItemBean.total_price}" /></span></li>
						</ul>
						<br />
					<label>Total &#36;</label><c:out value="${total}" />
				</div>
				<a class="btn btn-success"
						href="onlineServlet?action=continue">Continue Shopping</a>
						<a class="btn btn-success"
						href="onlineServlet?action=cart">Checkout</a>
			</div>
		</div>

	</div>


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
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
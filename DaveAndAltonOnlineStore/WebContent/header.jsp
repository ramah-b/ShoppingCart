<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<a class="navbar-brand">A&D!</a> <a class="navbar-brand">Welcome
						<c:choose>
							<c:when test="${not empty buyerUser}">
								<c:out value="${buyerUser.name }" />
								<c:choose>
									<c:when test="${buyerUser.adminFlag == '0'}">
										<a class="navbar-brand" href="onlineServlet?action=history">Purchase
											History</a>
										<a class="navbar-brand" href="onlineServlet?action=cart">Shopping
											Cart</a>
									</c:when>
									<c:otherwise>
										<a class="navbar-brand" href="onlineServlet?action=viewAll">Product
											Orders History</a>
											<a class="navbar-brand" href="onlineServlet?action=newProductJSP">Add Product</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
					Guest User<a class="navbar-brand" href="onlineServlet?action=cart">Shopping
									Cart</a>
							</c:otherwise>
						</c:choose>
					</a>

					<c:if test="${not empty buyerUser }">
						<a class="navbar-brand" href="onlineServlet?action=logout">Logout</a>
					</c:if>
				</div>

			</div>
		</div>
		</nav>
		</br>
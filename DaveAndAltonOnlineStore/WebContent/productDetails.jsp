<%@ include file="header.jsp"%>


<c:choose>
	<c:when test="${buyerUser.adminFlag == '1' }">

				<form action="onlineServlet?action=removeProduct" method="POST">
			<input type="hidden" name="product_id"
				value="<c:out value="${productBean.product_id}" />" />
			<div class="panel panel-default">
				<div class="panel-heading">
					<c:out value="${productBean.name}" />
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<th>Description</th>
							<th>Price</th>
							<th>Category</th>
							<th>Quantity</th>
						</thead>
						<tbody>

							<tr>

								<td><c:out value="${productBean.description}" /></td>
								<td><c:out value="${productBean.price}" /></td>

								<td><c:out value="${productBean.category}" /></td>
								<td><c:out value="${productBean.quantity}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<button class="btn btn-success" >Remove Product</button><br>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<form action="onlineServlet?action=purchase" method="POST">
			<input type="hidden" name="product_id"
				value="<c:out value="${productBean.product_id}" />" />
			<div class="panel panel-default">
				<div class="panel-heading">
					<c:out value="${productBean.name}" />
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<th>Description</th>
							<th>Price</th>
							<th>Category</th>
							<th>Quantity</th>
						</thead>
						<tbody>

							<tr>

								<td><c:out value="${productBean.description}" /></td>
								<td><c:out value="${productBean.price}" /></td>

								<td><c:out value="${productBean.category}" /></td>
								<td><input style="width: 60px" type="text"
									class="form-control" name="quantity" required></td>
							</tr>
						</tbody>
					</table>
				</div>
				<button class="btn btn-success">Add to Cart</button>
		</form>
		</div>
	</c:otherwise>

</c:choose>

<div class="panel panel-default">
	<div class="panel-heading">Rates and Reviews</div>
	<div class="panel-body">
		<c:choose>
			<c:when test="${not empty reviewList }">
				<table class="table">
					<thead>
						<th>Username</th>
						<th>Date</th>
						<th>Review</th>
						<th>Rate</th>
					</thead>
					<tbody>
						<c:forEach var="review" items="${reviewList}">
							<tr>

								<td>${review.buyer.username}</td>
								<td>${review.reviewDate}</td>
								<td>${review.text}</td>
								<td>${review.stars}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p>There are no reviews on this product yet.</p>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<c:if test="${not empty buyerUser }">
	<c:if test="${buyerUser.adminFlag == '0'}">
		<form action="onlineServlet?action=review" method="POST">
			<input type="hidden" name="product_id"
				value="<c:out value="${productBean.product_id}" />" /> <input
				type="hidden" name="buyer_username"
				value="<c:out value="${buyerUser.username}" />" />

			<div class="panel panel-default">
				<div class="panel panel-heading">Add a Review</div>

				<div class="panel-body">
					<div class="form-group">
						<input type="name" class="form-control" name="review"
							id="exampleInputname"
							placeholder="Write Your Review (140 Character)">
					</div>

					<div class="form-group">
						<input type="name" class="form-control" name="stars"
							id="exampleInputPassword1" placeholder="How many stars">
					</div>


					<button type="submit" class="btn btn-success">Add Review</button>
				</div>
			</div>


		</form>
	</c:if>
</c:if>
<a class="btn btn-success" href="onlineServlet?action=continue"> <c:choose>
		<c:when test="${buyerUser.adminFlag == '1' }">Products List</c:when>
		<c:otherwise>Continue Shopping</c:otherwise>
	</c:choose>
</a>





<%@ include file="footer.jsp"%>
<%@ include file="header.jsp" %>

		<div class="panel panel-default">
			<div class="panel panel-heading">Available Products</div>
			<div class="panel-body">
				<div class="list-group">
					<c:forEach var="product" items="${productList}">
						<a
							href="productDetails?product_id=${product.product_id}&action=details"
							class="list-group-item active">
							<h4 class="list-group-item-heading">${product.name}</h4>
							<p class="list-group-item-text">Get Details?</p>
						</a>

						<!--  <a href="onlineServlet?product_id=${product.product_id}&action=purchase" class="list-group-item active"> -->

						<!--  <p class="list-group-item-text">Buy Now!</p> -->

						<!-- </a>  -->
						<br />
						<br />
					</c:forEach>
				</div>
			</div>
		</div>

<%@ include file="footer.jsp" %>
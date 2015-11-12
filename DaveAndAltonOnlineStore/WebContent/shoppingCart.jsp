<%@ include file="header.jsp" %>

		<div class="panel panel-default">
			<div class="panel panel-heading">Shopping Cart</div>
			<div class="panel-body">
				<div class="list-group">
					<c:choose>
						<c:when test="${not empty lineItemsList}">
						<c:choose>
						<c:when test="${fn:length(lineItemsList) gt 1}">
						<p>You have ${fn:length(lineItemsList)} items.</p>
						</c:when>
						<c:otherwise>
						<p>You have ${fn:length(lineItemsList)} item.</p>
						</c:otherwise>
						</c:choose>
							<c:forEach var="lineItem" items="${lineItemsList}">
								<ul class="list-group">
									<li class="list-group-item">${lineItem.product.name}<span
										class="badge">Unit Price &#36;${lineItem.price}</span><br>
										<span>Quantity:${lineItem.quantity}</span><span class="badge"
										style="bgcolor: green">Subtotal
											&#36;${lineItem.total_price}</span></li>

								</ul>
								<br />


							</c:forEach>
							<label>Total &#36;</label>
							<c:out value="${total}" />
				</div>
				<c:if test="${not empty buyerUser }">
					<a class="btn btn-success" href="onlineServlet?action=confirm">Confirm
						Purchase</a>
				</c:if>

				</c:when>
				<c:otherwise>
					<p>No items in your shopping cart!</p>
				</c:otherwise>
				</c:choose>

				<a class="btn btn-success" href="onlineServlet?action=continue">Continue
					Shopping</a>
				<c:if test="${empty buyerUser }">
					<a class="btn btn-success" href="onlineServlet?action=homepage">Login</a>
				</c:if>
				<c:if test="${empty buyerUser }">
					<a class="btn btn-success" href="onlineServlet?action=register">Register</a>
				</c:if>

			</div>
		</div>

<%@ include file="footer.jsp" %>
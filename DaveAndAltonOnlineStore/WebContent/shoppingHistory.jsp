<%@ include file="header.jsp" %>


		<div class="panel panel-default">
		<c:choose><c:when test = "${buyerUser.adminFlag == '0' }"><div class="panel panel-heading">Shopping History</div></c:when>
		<c:otherwise><div class="panel panel-heading">Order History</div></c:otherwise></c:choose>
			
			<div class="panel-body">
				<div class="list-group">
				<c:choose>
				<c:when test="${not empty lineItemsList}">
								
					<c:forEach var="lineItem" items="${lineItemsList}">
						<ul class="list-group">
						<li class="list-group-item">${lineItem.product.name}<span class="badge">Unit Price &#36;${lineItem.price}</span><br>
								<span>Quantity:${lineItem.quantity}</span><span class="badge" style="bgcolor: green">Subtotal &#36;${lineItem.totalprice}</span></li>
							
						</ul>
						<br />
						
						
					</c:forEach>
					<label>Total &#36;</label><c:out value="${total}" />
					</div>
						
				</c:when>
				<c:otherwise>
				<p>No Shopping History!</p>
				</c:otherwise>
				</c:choose>

				<a class="btn btn-success"
						href="onlineServlet?action=continue">
						<c:choose>
						<c:when test = "${buyerUser.adminFlag == '0' }">Continue Shopping</c:when>
						<c:otherwise>Products List</c:otherwise>
						</c:choose>
						</a>
						
						
			</div>
		</div>
<%@ include file="footer.jsp" %>
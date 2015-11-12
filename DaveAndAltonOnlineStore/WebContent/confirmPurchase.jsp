<%@ include file="header.jsp" %>

		<div class="panel panel-default">
			<div class="panel panel-heading">Your products are on the way!!</div>
			<div class="panel-body">
				<div class="list-group">
				<c:choose>
				<c:when test="${not empty lineItemsList}">
								
					<c:forEach var="lineItem" items="${lineItemsList}">
						<ul class="list-group">
						<li class="list-group-item">${lineItem.product.name}<span class="badge">Unit Price &#36;${lineItem.price}</span><br>
								<span>Quantity:${lineItem.quantity}</span><span class="badge" style="bgcolor: green">Total Price &#36;${lineItem.totalprice}</span></li>
								<c:if test="message != null">${message}</c:if>
							
						</ul>
						<br />
						
					</c:forEach>
					</div>
					
				</c:when>
				<c:otherwise>
				<p>No items in your shopping cart!</p>
				</c:otherwise>
				</c:choose>

			
						
			</div>
		</div>
<%@ include file="footer.jsp" %>
<%@ include file="header.jsp" %>


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
<%@ include file="footer.jsp" %>
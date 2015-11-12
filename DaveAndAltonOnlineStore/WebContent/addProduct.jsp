<%@ include file="header.jsp" %>
		<form action="onlineServlet?action=newProduct" method="post">
			<div class="panel panel-default">
			<div class= "panel panel-heading">Add a New Product</div>

				<div class="panel-body">
					<div class="form-group">
						<input type="name"
							class="form-control" name="name" id="exampleInputname"
							placeholder="Product Name">
					</div>
					<div class="form-group">
			
						<input type="name" class="form-control" name="description"
							id="exampleInputUser1" placeholder="Product Description">
					</div>
					<div class="form-group">
						<input
							type="name" class="form-control" name="quantity"
							id="exampleInputUser1" placeholder="Quantity">
					</div>
					<div class="form-group">
						<input
							type="name" class="form-control" name="price"
							id="exampleInputUser1" placeholder="Price">
					</div>

					<div class="form-group">
						<input
							type="name" class="form-control" name="category"
							id="exampleInputUser1" placeholder="Category">
					</div>
					
					<button type="submit" class="btn btn-info">Add</button>
				</div>
			</div>
		</form>
		<a class="btn btn-success" href="onlineServlet?action=continue">Products List</a>

<%@ include file="footer.jsp" %>
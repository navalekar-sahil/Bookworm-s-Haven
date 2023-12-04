
<%@page import="com.pojo.BookShopPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchedBood</title>
<link rel="stylesheet" href="css/bootstap.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	ArrayList<BookShopPojo> list = (ArrayList<BookShopPojo>) request.getAttribute("list2");
	%>
	<div class="row">
		<div class="col-2">
			<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 240px; height: 600px;">

				<span class="fs-4" style="margin-left: 50px ;">Book Shop</span>

				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item">
						<a class="nav-link  bi me-2" width="16" height="16" aria-current="page" href="index.html"
							style="margin-left: 50px ;color:white;">Home</a>
					</li>
					<li>
						<a class="nav-link  bi me-2" width="16" height="16" aria-current="page" href="book?action=add"
							style="margin-left: 50px ;color:white;">Add Book</a>

					</li>
					<li>
						<a class="nav-link  bi me-2" width="16" height="16" aria-current="page" href="book?action=list"
							style="margin-left: 50px ;color:white;">Book List</a>

					</li>
					
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle nav-link bi me-2" width="16" height="16" aria-current="page"
							style="margin-left: 50px ;color:white;" href="#" id="navbarDropdown" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							Stock
						</a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="navbarDropdown">
							<li><a class=" dropdown-item" href="book?action=availableStock">Available Stock</a>
							</li>
							<li><a class="dropdown-item" href="book?action=requiredStock">Required Stock</a></li>
							<li><a class="dropdown-item" href="book?action=salelist">Sale List</a></li>


						</ul>
					</li>
					<li>
						<a class="nav-link  bi me-2" width="16" height="16" aria-current="page"
							style="margin-left: 50px ;color:white;" href="book?action=find">Search book</a>
					</li>
				</ul>
				<hr>
				<div>
					<a href="#" class="d-flex align-items-center text-white text-decoration-none" id="dropdownUser1"
						data-bs-toggle="dropdown" aria-expanded="false">
						<img src="profileImg.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
						<strong>sahil navalekar</strong>
					</a>

				</div>
			</div>
		</div>
		<div class="col-10">
	<div class="container" style="margin-top: 30px">
		<label for="exampleFormControlInput1" class="form-label"
			style="font-size: 25px; font-weight: bold;">All Books&nbsp; </label>
		<table border="1px" class="table table-hover">
			
			<tr>
				<th>Id</th>
				<th>Book name</th>
				<th>Auther name</th>
				<th>Edition</th>
				<th>Price</th>
				<th>Is Available</th>
				<th>Quantity</th>
				<th>Sell</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (BookShopPojo obj : list) {
			%>
			<tr>
				<td><%=obj.getId()%></td>
				<td><%=obj.getName()%></td>
				<td><%=obj.getAuther()%></td>
				<td><%=obj.getEdition()%></td>
				<td><%=obj.getPrice()%></td>
				<td><%=obj.isIsavailable()%></td>
				<td><%=obj.getQuantity()%></td>
				<td><a href="book?action=sale&id=<%=obj.getId()%>">sell</a></td>
				<td><a href="book?action=edit&id=<%=obj.getId()%>">Edit</a></td>
				<td><a href="book?action=delete&id=<%=obj.getId()%>">Delete</a></td>

			</tr>
			<%
			}
			%>
			<tr>

				<td colspan="10"><a href="index.html">
						<!-- <div>
							<button class="btn btn-primary" type="button">Home</button>
						</div> -->
				</a></td>
			</tr>
		</table>
	</div>
	</div></div>
</body>
</html>
</body>
</html>
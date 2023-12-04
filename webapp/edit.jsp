<%@page import="com.pojo.BookShopPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
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
	BookShopPojo obj = (BookShopPojo) request.getAttribute("list");
	%>


	<!-- <center> -->
	<div class="row">
		<div class="col-2">
			<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
				style="width: 240px; height: 600px;">

				<span class="fs-4" style="margin-left: 50px;">Book Shop</span>

				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a class="nav-link  bi me-2" width="16"
						height="16" aria-current="page" href="index.html"
						style="margin-left: 50px; color: white;">Home</a></li>
					<li><a class="nav-link  bi me-2" width="16" height="16"
						aria-current="page" href="book?action=add"
						style="margin-left: 50px; color: white;">Add Book</a></li>
					<li><a class="nav-link  bi me-2" width="16" height="16"
						aria-current="page" href="book?action=list"
						style="margin-left: 50px; color: white;">Book List</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle nav-link bi me-2" width="16"
						height="16" aria-current="page"
						style="margin-left: 50px; color: white;" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> Stock </a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
							aria-labelledby="navbarDropdown">
							<li><a class=" dropdown-item"
								href="book?action=availableStock">Available Stock</a></li>
							<li><a class="dropdown-item"
								href="book?action=requiredStock">Required Stock</a></li>
							<li><a class="dropdown-item" href="book?action=salelist">Sale
									List</a></li>


						</ul></li>
					<li><a class="nav-link  bi me-2" width="16" height="16"
						aria-current="page" style="margin-left: 50px; color: white;"
						href="book?action=find">Search book</a></li>
				</ul>
				<hr>
				<div>
					<a href="#"
						class="d-flex align-items-center text-white text-decoration-none"
						id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="profileImg.jpg" alt="" width="32" height="32"
						class="rounded-circle me-2"> <strong>sahil
							navalekar</strong>
					</a>

				</div>
			</div>
		</div>
		<div class="col-10">
			<div class=" card shadow-lg p-3 mb-5 bg-white rounded"
				style="width: 850px; margin-top: 90px; margin-left: 120px">
				<form action="book?action=edit&id=<%=obj.getId()%>" method="post">
					<table>
						<tr>
							<td colspan="2">
								<h2
									style="font-family: Georgia, 'Times New Roman', Times, serif;">Edit
									Book</h2>
							</td>
						</tr>
						<tr>
							<td>Book Id:</td>
							<td><input type="text" name="id" class="form-control"
								value="<%=obj.getId()%>"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Book Name:</td>
							<td><input type="text" class="form-control" name="bookName"
								value="<%=obj.getName()%> "></td>

							<td>&nbsp;</td>

							<td>Auther name:</td>
							<td><input type="text" class="form-control" name="auther"
								value="<%=obj.getAuther()%>"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Book Edition:</td>
							<td><input type="text" class="form-control" name="edition"
								value="<%=obj.getEdition()%>"></td>
							<td>&nbsp;</td>
							<td>Price:</td>
							<td><input type="text" class="form-control" name="price"
								value="<%=obj.getPrice()%>"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Is Available:</td>
							<td><input type="text" class="form-control"
								name="isAvailable" value="<%=obj.isIsavailable()%>"></td>
							<td>&nbsp;</td>
							<td>Quantity:</td>
							<td><input type="text" class="form-control" name="quantity"
								value="<%=obj.getQuantity()%>"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input type="submit" class="form-control"
								class="btn btn-primary" value="Update"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
								class="btn btn-outline-danger" value="reset"></td>
						</tr>
						<tr>

							<!-- <td colspan="2"><a href="index.html">
									<button class="btn btn-primary" type="button">Home</button>
							</a></td> -->
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!-- </center> -->
</body>
</html>
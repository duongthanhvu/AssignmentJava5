<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Thêm sản phẩm</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-register mx-auto mt-5 col-md-6">
			<div class="card-header">Sửa thông tin sản phẩm</div>
			<div class="card-body">

					<h2 style="text-align: center; color: red">${message}</h2>

				<form:form action="admin/edit.html" modelAttribute="sanpham" enctype="multipart/form-data">
						<div class="form-group" style="visibility: hidden;">
								<label for="idsanpham">id sản phẩm</label> <form:input
									class="form-control" id="idsanpham" type="text"
									placeholder="Nhập vào tên sản phẩm" path="sanpham_id"/>
						</div>
						<div class="form-group">
								<label for="tensanpham">Tên sản phẩm</label> <form:input
									class="form-control" id="tensanpham" type="text"
									placeholder="Nhập vào tên sản phẩm" path="ten"/>
						</div>
						<div class="form-group">
								<label for="soluong">Số lượng</label> <form:input
									class="form-control" id="soluong" type="number"
									placeholder="Nhập vào số lượng sản phẩm" path="soluong"/>
						</div>
					<div class="form-group">
						<label for="gia">Giá</label> <form:input
							class="form-control" id="gia" type="number"
							placeholder="Nhập vào giá sản phẩm" path="gia"/>
					</div>
					<div class="form-group">
								<label for="chietkhau"></label> <form:input
									class="form-control" id="chietkhau" type="text"
									placeholder="Nhập vào tên sản phẩm" path="chietkhau"/>
						</div>
					<div class="form-group" style="visibility: hidden;">
								<label for="idsanpham"></label> <form:input
									class="form-control" id="idsanpham" type="text"
									placeholder="Nhập vào tên sản phẩm" path="trangthai"/>
						</div>
						<div class="form-group">
								<label for="urlsanpham">url</label> <form:input
									class="form-control" id="urlsanpham" type="text"
									placeholder="Nhập vào tên sản phẩm" path="url"/>
						</div>
					<div class="form-group">
						<label for="mota">Mô tả</label> <form:input 
							class="form-control" id="mota" type="text"
							placeholder="Nhập vào mô tả về sản phẩm" path="mota"/>
					</div>
					<div class="form-group">
						<label for="anh">Ảnh sản phẩm</label> <input class="form-control"
							id="anh" type="file" name="photo"/>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Sửa thông tin</button>
				</form:form>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>

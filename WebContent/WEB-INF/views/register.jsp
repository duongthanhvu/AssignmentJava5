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
<title>SB Admin - Start Bootstrap Template</title>
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
			<div class="card-header">Đăng ký tài khoản</div>
			<div class="card-body">

					<h2 style="text-align: center; color: red">${message}</h2>

				<form:form action="register.html" modelAttribute="khachhang">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">Tên</label> <form:input
									class="form-control" id="exampleInputName" type="text"
									aria-describedby="nameHelp" placeholder="Nhập vào tên" path="ten"/>
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">Số điện thoại</label> <form:input
									class="form-control" id="exampleInputLastName" type="text"
									aria-describedby="nameHelp"
									placeholder="Nhập vào số điện thoại" path="sodienthoai"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <form:input
							class="form-control" id="exampleInputEmail1" type="email"
							aria-describedby="emailHelp" placeholder="Nhập vào email" path="taikhoan.email"/>
					</div>
					<div class="form-group">
						<label for="diaChi">Địa chỉ</label> <form:input class="form-control"
							id="diaChi" type="text"
							placeholder="Nhập vào địa chỉ (số nhà và đường phố)" path="diachi"/>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="phuong">Phường/Xã</label> <form:input
									class="form-control" id="phuong" type="text"
									placeholder="Nhập vào tên phường (xã)" path="phuongxa"/>
							</div>
							<div class="col-md-6">
								<div class="form-row">
									<label for="quan">Quan/Huyen</label> <form:input
										class="form-control" id="quan" type="text"
										placeholder="Nhập vào tên quận (huyện)" path="quanhuyen"/>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="tinh">Tỉnh/Thành phố</label> <form:input class="form-control"
							id="tinh" type="text"
							placeholder="Nhập vào tên tỉnh (thành phố)" path="tinhthanhpho"/>
					</div>
					<div class="form-group">
						<label for="username">Tên đăng nhập</label> <form:input
							class="form-control" id="username" type="text"
							placeholder="Nhập vào tên đăng nhập" path="taikhoan.username"/>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputPassword1">Mật khẩu</label> <form:input
									class="form-control" id="exampleInputPassword1" type="password"
									placeholder="Nhập vào mật khẩu" path="taikhoan.password"/>
							</div>
							<div class="col-md-6">
								<label for="exampleConfirmPassword">Xác nhận mật khẩu</label> <input
									class="form-control" id="exampleConfirmPassword"
									type="password" placeholder="Nhập lại mật khẩu vừa nhập">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
				</form:form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.html">Đến trang đăng
						nhập</a>
				</div>
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

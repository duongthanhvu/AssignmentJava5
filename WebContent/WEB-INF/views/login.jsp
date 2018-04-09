<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <base href="${pageContext.servletContext.contextPath}/">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5 col-md-6">
      <div class="card-header">Đăng nhập</div>
      <div class="card-body">
      	<h2 style="text-align: center; color: red">${message}</h2>
        <form:form action="login.html" modelAttribute="taikhoan">
          <div class="form-group">
            <label for="exampleInputEmail1">Email/Tên đăng nhập</label>
            <form:input class="form-control" id="exampleInputEmail1" type="text" placeholder="Nhập email hoặc tên đăng nhập" path="username"/>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Mật khẩu</label>
            <form:input class="form-control" id="exampleInputPassword1" type="password" placeholder="Mật khẩu" path="password"/>
          </div>
          <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
        </form:form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Chưa có tài khoản? Đăng ký ngay</a>
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

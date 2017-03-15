<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/compiled.min.css" rel="stylesheet">
<link href="../css/mdb.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/sweetalert.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-toggleable-md fixed-top">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarNav1"
		aria-controls="navbarNav1" aria-expanded="false"
		aria-label="Toggle navigation">
		<i class="fa fa-bars" style="color: #2C97BE" aria-hidden="true"></i>
	</button>
	<a class="navbar-brand" href="#"> <strong><img
			src="../img/logo.png" height="25px;" /></strong>
	</a>
	<div class="collapse navbar-collapse" id="navbarNav1">
		<ul class="navbar-nav mr-auto">
		</ul>
		<ul class="navbar-nav ml-auto">
			<img src="../img/avatar.jpg" alt="Hình đại diện" class="rounded-circle"
				style="width: 40px; height: 40px">
			<li class="nav-item dropdown btn-group"><a
				class="nav-link dropdown-toggle" id="dropdownMenu1"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</a>
				<div class="dropdown-menu dropdown" aria-labelledby="dropdownMenu1">
					<a class="dropdown-item">Đăng xuất</a>
				</div></li>
		</ul>
	</div>
	</nav>

	<div class="row main-board">
		<div class="col-lg-2 hidden-lg-down side-menu-left">
			<div class="row dash-board">
				<button type="button"
					class="btn btn-elegant button-side-menu-left button-dash-board">
					<i class="fa fa-globe icon-in-button" style="color: #2C97BE"
						aria-hidden="true"></i>Dashboard
				</button>
			</div>
			<div class="row">
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-group icon-in-button" aria-hidden="true"></i>Hệ
					thống
				</button>
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-heart icon-in-button" aria-hidden="true"></i>Điều
					hành
				</button>
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-home icon-in-button" aria-hidden="true"></i>Người
					dùng
				</button>
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-image icon-in-button" aria-hidden="true"></i>Bài
					viết
				</button>
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-info-circle icon-in-button" aria-hidden="true"></i>Thể
					loại
				</button>
				<button type="button" class="btn btn-elegant button-side-menu-left">
					<i class="fa fa-language icon-in-button" aria-hidden="true"></i>Tỉnh
				</button>
			</div>
		</div>
		<div class="col-lg-10 col-md-12 col-12">
			<div class="row main-content-form hoverable">
				<div class="clearfix"></div>
				<div class="row" style="width: 100%">
					<div class="col-lg-8 col-6">
						<h2 class="title-in-admin">Tạo mới</h2>
					</div>
					<div class="col-lg-4 col-6 text-right">
						<button class="btn btn-primary" onclick="history.go(-1);">Quay
							lại</button>
					</div>
				</div>

				<html:form action="/admin/add-account-action" method="post"
					styleClass="form-admin-right">
					<div class="card-block">
						<html:hidden styleId="idAction" property="action"></html:hidden>
						<div style="width: 48px; display: inline-block;">
							<i class="fa fa-user prefix" style="font-size: 2rem;"></i>
						</div>
						<div style="width: calc(100% - 52px); display: inline-block;">
							<html:select property="level" styleClass="mdb-select">
								<html:option value="1">Quản trị viên</html:option>
								<html:option value="2">Điều hành viên</html:option>
								<html:option value="3">Người dùng</html:option>
							</html:select>
						</div>
						<div class="md-form">
							<i class="fa fa-user prefix"></i>
							<html:text property="name" styleClass="form-control"></html:text>
							<label for="form3">Họ tên</label>
						</div>

						<div class="md-form">
							<i class="fa fa-envelope prefix"></i>
							<html:text property="email" styleClass="form-control"></html:text>
							<label for="form2">Email</label>
						</div>

						<div class="md-form">
							<i class="fa fa-tag prefix"></i>
							<html:text property="password" styleClass="form-control"></html:text>
							<label for="form34">Mật khẩu</label>
						</div>

						<div class="md-form">
							<i class="fa fa-pencil prefix"></i>
							<html:text property="rePassword" styleClass="form-control"></html:text>
							<label for="form8">Nhập lại mật khẩu</label>
						</div>

						<div class="md-form">
							<i class="fa fa-pencil prefix"></i>
							<html:text property="phone" styleClass="form-control"></html:text>
							<label for="form8">Điện thoại</label>
						</div>

						<div class="text-center">
							<button onclick="return submitAddForm();"
								class="btn btn-default button-login-admin">Thêm</button>
							<button type="reset" class="btn btn-warning">Hủy</button>
						</div>
					</div>
				</html:form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/tether.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/mdb.min.js"></script>
	<script type="text/javascript" src="../js/sweetalert.min.js"></script>
	<script type="text/javascript">
		var idAction = $("#idAction");
		$(document).ready(function() {
			$('.mdb-select').material_select();
		});
		function submitAddForm() {
			var level, name, email, password, rePassword, phone;
			level = $("[name='level']").val();
			name = $("[name='name']").val();
			email = $("[name='email']").val();
			password = $("[name='password']").val();
			rePassword = $("[name='rePassword']").val();
			phone = $("[name='phone']").val();
			if (level == undefined) {
				showAlert("Quyền hạn không được bỏ trống");
				return false;
			} else if (email == undefined || email.length <= 6) {
				showAlert("Email không được bỏ trống hoặc quá ngắn");
				return false;
			} else if (password == undefined || password.length <= 6) {
				showAlert("Mật khẩu không được bỏ trống");
				return false;
			} else if (rePassword != password) {
				showAlert("Mật khẩu không khớp");
				return false;
			}else{
				idAction.val("submit");
				document.forms[0].submit();
				return true;
			}
		}
		function showAlert(text) {
			sweetAlert("Lỗi", text, "error");
		}
	</script>
</body>

</html>
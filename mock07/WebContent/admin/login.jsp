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
</head>
<body>

	<html:form action="/admin/login-action" method="post">
		<div style="height: 100vh">
			<div class="flex-center flex-column animated fadeIn">
				<div class="card" style="min-width: 450px;">
					<div class="card-block">
						<div class="form-header blue-gradient">
							<h3>
								<i class="fa fa-user"></i> Đăng nhập
							</h3>
						</div>
						<div class="md-form">
							<i class="fa fa-envelope prefix"></i>
							<html:text property="email" styleClass="form-control"
								value="admin1@gmail.com"></html:text>
							<label for="form2">Email</label>
							<html:errors property="emailError" />
						</div>
						<div class="md-form">
							<i class="fa fa-lock prefix"></i>
							<html:password property="password" styleClass="form-control"
								value="123"></html:password>
							<label for="form4">Mật khẩu</label>
						</div>
						<div class="text-center">
							<p style="color: red;">
								<bean:write name="loginForm" property="notification" />
							</p>
							<html:submit styleClass="btn btn-indigo button-login-admin">Đăng nhập</html:submit>
							<button class="btn btn-warning" type="reset">Hủy</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</html:form>

	<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/tether.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/mdb.min.js"></script>
</body>

</html>
<%@page import="statics.Pagination"%>
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
			<div class="main-content hoverable">
				<div class="clearfix"></div>
				<div class="row" style="width: 100%; height: 60px;">
					<div class="col-lg-8">
						<h2 class="title-in-admin">Danh sách thể loại bài viết</h2>
					</div>
					<div class="col-lg-4 text-right">
						<html:link styleClass="btn btn-success" action="/admin/add-category-action">
							<i class="fa fa-language icon-in-button" aria-hidden="true"></i> Thêm mới</html:link>
					</div>
				</div>
				<div class="table-custom">
					<div>
						<div class="col-ba">Id</div>
						<div class="col-ba">Tên thể loại</div>
						<div class="col-ba">Thao tác</div>
					</div>
					<logic:iterate name="categoryListForm" property="categorys" id="item">
						<hr>
						<div>
							<div class="col-ba">
								<bean:write name="item" property="categoryId" />
							</div>
							<div class="col-ba">
								<bean:write name="item" property="name" />
							</div>
							
							
							<div class="col-ba">
								<button onclick="editItem(<bean:write name="item" property="categoryId" />)" type="button" class="btn btn-action"
									data-toggle="tooltip" data-placement="top" title="Remove item">
									<i class="fa fa-pencil blue-text icon-btn-action"></i>
								</button>
								<button
		
								
									onclick="deleteItem(<bean:write name="item" property="categoryId" />)"
									type="button" class="btn btn-action" data-toggle="tooltip"
									data-placement="top" title="Remove item">
									<i class="fa fa-times red-text icon-btn-action"></i>
								</button>
							</div>
						</div>
					</logic:iterate>
				</div>
				<nav class="pagination-center">
				<ul class="pagination pagination-md pg-amber">
					<li
						onclick='viewPage(1);'
						class="page-item"><a class="page-link" saria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
							<span aria-hidden="true">&laquo;</span>
					</a></li>
					<li
						onclick='viewPage(<%out.println((Pagination.page - 1) > 1 ? (Pagination.page - 1) : 1);%>);'
						class="page-item"><a class="page-link" saria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
					<%
						for (int i = 1; i <= Pagination.totalPage; i++) {
							if (i != Pagination.page)
								out.println("<li onclick='viewPage(" + i
										+ ");' class=\"page-item\"><a class=\"page-link\" href=\"#\">" + i + "</a></li>");
							else
								out.println("<li onclick='viewPage(" + i
										+ ");' class=\"page-item active\"><a class=\"page-link\" href=\"#\">" + i + "</a></li>");
						}
					%>
					<li
						onclick='viewPage(<%out.println((Pagination.page + 1) < Pagination.totalPage ? (Pagination.page + 1) : Pagination.totalPage);%>);'
						class="page-item"><a class="page-link" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
					<li onclick='viewPage(<%out.println(Pagination.totalPage);%>);'
						class="page-item"><a class="page-link" aria-label="Next">
							<span aria-hidden="true">&raquo;</span><span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>

				<html:form action="/admin/category-action" method="get">
					<html:hidden styleId="pageId" name="categoryListForm"
						property="page" styleClass="form-control"></html:hidden>
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
		//Trỏ đến styleId( tương đương với id) của property page
		var pageId = $("#pageId");
		//Khi load trang xong
		$(document)
				.ready(
						function() {
							//Đọc lại giá trị page hiện tại từ Form Class
							var pageStatic = parseInt('<bean:write name="categoryListForm" property="page"/>');
							//Thêm class active vô id <li> của trang hiện tại
							$(".page-item").eq(pageStatic + 1).addClass("active");
						});
		//Khi muốn xem kết quả tìm kiếm của trang nào đó
		function viewPage(page) {
			//Gán giá trị page truyền vào cho property page của Form Class
			pageId.val(page);
			//Submit form bằng javascript
			document.forms[0].submit();
		};
		//hàm sửa item
		function editItem(id){
			var curentUrl = window.location.href;
			var index = curentUrl.lastIndexOf("/");
			var url = curentUrl.substring(0, index);
			window.location.href = url + "/edit-category-action.do?categoryId="+id; 
		};
		//Hàm xóa item
		function deleteItem(id) {swal({
			  title: "Bạn có chắc?",
			  text: "Dữ liệu bị xóa sẽ mất vĩnh viễn!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#DD6B55",
			  confirmButtonText: "Đồng ý!",
			  closeOnConfirm: false
			},
			function(){
				var curentUrl = window.location.href;
				var index = curentUrl.lastIndexOf("/");
				var url = curentUrl.substring(0, index);
				window.location.href = url + "/delete-category-action.do?categoryId="+id; 
			});
		};
		
	</script>
</body>

</html>
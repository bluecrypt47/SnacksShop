<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<head>
<title>Quản lý tài khoản</title>
</head>
<body>

	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Quản Lý Tài Khoản</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3>Tất cả tài khoản</h3>
							<div class="table-responsive">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Email</th>
											<th>Password</th>
											<th>Tên</th>
											<th>Địa Chỉ</th>
											<th>Số Điện Thoại</th>
											<th>Sửa Tài Khoản</th>
											<th>Xóa Tài Khoản</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="item" items="${ accManagger }">
												<tr>
													<td>${ item.user }</td>
													<td>${ item.password }</td>
													<td>${ item.name }</td>
													<td>${ item.address }</td>
													<td>${ item.phoneNumber }</td>
													<td><a href="#"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-edit"></span>
													</a></td>
													<td><a href="#"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-remove"></span>
													</a></td>
												</tr>
											</c:forEach>
										
									</tbody>
								</table>

							</div>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->


					<!-- /.row -->


					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
</body>
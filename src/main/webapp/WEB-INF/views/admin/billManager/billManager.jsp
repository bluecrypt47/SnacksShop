<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<title>Quản lý hóa đơn</title>
</head>
<body>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/quan-tri"/>">Trang quản trị</a> <span class="divider">/</span></li>
							<li class="active">Quản lý hóa đơn</li>
						</ul>
						<h1 class="page-header">Quản Lý Hóa Đơn</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Tên Người Mua</th>
												<th>Email</th>
												<th>Số Điện Thoại</th>
												<th>Địa Chỉ</th>
												<th>Ghi Chú</th>
												<th>Số Lượng</th>
												<th>Tổng Giá</th>
												<th>Xem Chi Tiết</th>
												<th>Xóa Đơn Hàng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${ billManager }">
												<tr>

													<td>${ item.name }</td>
													<td>${ item.email }</td>
													<td>${ item.phoneNumber }</td>
													<td>${ item.address }</td>
													<td>${ item.note }</td>
													<td>${ item.quantity }</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.total }" /> ₫</td>
													<%-- <c:url  value="/DeleteCart/${ item.key }"/> --%>
													<td><a
														href="<c:url value="/quan-ly-chi-tiet-hoa-don"/>"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-search"></span>
													</a></td>
													<td><a href="#" class="btn btn-mini btn-danger"
														type="button"> <span class="icon-remove"></span>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<br /> <a href="<c:url value="/quan-tri"/>"
										class="shopBtn btn-large"><span class="icon-arrow-left"></span>
										Quay Lại Trang Quản Trị </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
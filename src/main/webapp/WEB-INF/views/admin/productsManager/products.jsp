<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Quản lý sản phẩm</title>
</head>
<body>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Quản Lý Sản Phẩm</h1>
						<button name="button" type="button">Thêm sản phẩm</button>
						<button name="button" type="button">Sửa sản phẩm</button>
						<button name="button" type="button">Xóa sản phẩm</button>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th></th>
												<th>Loại Sản Phẩm</th>
												<th>Tên Sản Phẩm</th>
												<th>Hình ảnh</th>
												<th>Ngày Đăng</th>
												<th>Ngày Cập Nhật</th>
												<th>Giá Bán</th>
												<th>Giảm Giá</th>
												<th>Giới Thiệu</th>
												<th>Sản Phẩm Nổi Bật</th>
												<th>Sản Phẩm Mới</th>
												<!-- <th>Sửa Sản Phẩm</th>
												<th>Xóa Sản Phẩm</th> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${ productsManager }">
												<tr>
												    <td><input type="checkbox" /></td>
													<td>${ item.maLoai }</td>
													<td>${ item.tenSP }</td>
													<td><img width="100"
														src="<c:url value="/assets/admin/img/anh/${ item.image }" />"
														alt=""></td>
													<td>${ item.ngayTao }</td>
													<td>${ item.ngayCapNhat }</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.giaBan }" /> ₫</td>
													<td><fmt:formatNumber type="number"
															groupingUsed="true" value="${ item.giamGia }" /> ₫</td>
													<td>${ item.gioiThieu }</td>
													<td>${ item.noiBat }</td>
													<td>${ item.sanPhamMoi }</td>
													<!-- <td><a href="#"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-edit"></span>
													</a></td>
													<td><a href="#"
														class="btn btn-mini btn-danger" type="button"> <span
															class="icon-remove"></span>
													</a></td> -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
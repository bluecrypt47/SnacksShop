<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<title>Chi tiết đơn hàng</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span
					class="divider">/</span></li>
				<li><a href="<c:url value="/quan-tri"/>">Trang quản trị</a> <span
					class="divider">/</span></li>
				<li><a href="<c:url value="/quan-ly-hoa-don"/>">Quản lý hóa
						đơn</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết đơn hàng</li>
			</ul>
			<div class="well well-small">
				<%-- <h1>
					Chi Tiết Đơn Hàng
					<small class="pull-right"> ${ billManager.quantity }
						Sản phẩm có trong đơn hàng </small>
				</h1> --%>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th>Tên sản phẩm</th>
							<th>Mô tả</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ billDetails }">
							<tr>
								<td><img width="100"
									src="<c:url value="/assets/admin/img/anh/${ item.getProducts().getImage() }"/>"
									alt=""></td>
								<td>${ item.getProducts().getTenSP() }</td>
								<td>${ item.getProducts().getGioiThieu() }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.getProducts().getGiaBan() }" /> ₫</td>
								<%-- <c:forEach var="itemmm" items="${ productBillDetails }">
									<td>${ itemmm.getProducts().getTenSP() }</td>
									<td>${ itemmm.getProducts().getGioiThieu() }</td>
									<td><fmt:formatNumber type="number" groupingUsed="true"
											value="${ itemmm.getProducts().getGiaBan() }" /> ₫</td>
								</c:forEach> --%>
								<td>${ item.quantity }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.total }" /> ₫</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="<c:url value="/quan-ly-hoa-don"/>"
					class="shopBtn btn-large"><span class="icon-arrow-left"></span>
					Quay Lại Trang Quản Trị </a>
			</div>
		</div>
	</div>

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quantity-cart-" + id).val();

			window.location = "EditCart/" + id + "/" + quanty;
		});
	</script> </content>


</body>
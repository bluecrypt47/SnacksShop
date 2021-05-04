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
				<li><a href="<c:url value="/quan-tri"/>">Trang quản trị</a> <span class="divider">/</span></li>
				<li><a href="<c:url value="/quan-ly-hoa-don"/>">Quản lý hóa đơn</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết đơn hàng</li>
			</ul>
			<div class="well well-small">
				<h1>
					Chi Tiết Đơn Hàng <small class="pull-right"> ${ TotalQuantityCart }
						Sản phẩm có trong giỏ hàng </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th>Mô tả</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<!-- <th>Chỉnh sửa</th>
							<th>Xóa</th> -->
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ Cart }">
							<tr>
								<td><img width="100"
									src="<c:url value="/assets/user/img/anh/${ item.value.product.image }"/>"
									alt=""></td>
								<td>${ item.value.product.gioiThieu }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.value.product.giaBan }" /> ₫</td>
								<td><input type="number" min="0" max="100" class="span1"
									style="max-width: 34px" placeholder="1"
									id="quantity-cart-${ item.key }" size="16" type="text"
									value="${ item.value.quantity }"></td>
								<%-- <td><button data-id="${ item.key }"
										class="btn btn-mini btn-danger edit-cart" type="button">
										<span class="icon-edit"></span>
									</button></td>
								<td><a href="<c:url  value="/DeleteCart/${ item.key }"/>"
									class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
								</a></td> --%>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${ item.value.totalPrice }" /> ₫</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="<c:url value="/quan-ly-hoa-don"/>" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Quay Lại Trang Quản Trị </a><%--  
					<a
					href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Thanh
					Toán <span class="icon-arrow-right"></span>
				</a> --%>

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
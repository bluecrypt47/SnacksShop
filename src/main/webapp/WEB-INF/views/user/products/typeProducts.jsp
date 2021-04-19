<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Sản phẩm</title>
<style>
.center {
	text-align: center;
}

.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>

		<c:if test="${ productsPaginate.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">

					<c:forEach var="item" items="${ productsPaginate }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="product_details.html"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="chi-tiet-san-pham/${ item.tenSP }"><img
									src="<c:url value="/assets/user/img/anh/${ item.image }" />"></a>
								<div class="caption cntr">
									<p>${ item.tenSP }</p>
									<p>
										<strong> <fmt:formatNumber type="number"
												groupingUsed="true" value="${item.giaBan}" /> VNĐ
										</strong>

									</p>
									<h4>
										<a class="shopBtn" href="#" title="add to cart"> Thêm vào
											giỏ </a>
									</h4>
									<div class="actionList">
										<a class="pull-left" href="#">Thêm vào danh sách yêu thích
										</a> <a class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>

						<c:if
							test="${ (loop.index+1)  %3 ==0 || (loop.index+1) == productsPaginate.size()}">
				</ul>
			</div>
			<c:if test="${ (loop.index+1) < productsPaginate.size()}">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>

		</c:if>

	</div>

	<div class="pagination">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ loop.index == paginateInfo.currentPage }">
				<a
					href="<c:url value="/san-pham/${ idCategorys }/${ (loop.index)}"/> "
					class="active">${ loop.index }</a>
			</c:if>

			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<a
					href="<c:url value="/san-pham/${ idCategorys }/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div>

</body>

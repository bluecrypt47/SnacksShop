<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>Sản phẩm nổi bật</title>
<style>
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
			<h3 style="margin-left: 25px;">Sản phẩm nổi bật</h3>
		</div>
		<c:if test="${ allHighlighProducts.size() <=0 }">
			<h3 style="text-align: center; color: red;">Hiện tại chưa có sản
				phẩm nào nổi bật!!</h3>
		</c:if>
		<c:if test="${ allHighlighProducts.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${ allHighlighProducts }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="chi-tiet-san-pham/${item.maSP}"
									title="add to cart"><span class="icon-search"></span> Xem
									chi tiết</a> <a href="chi-tiet-san-pham/${ item.maSP }"><img
									src="<c:url value="/assets/user/img/anh/${ item.image }" />"></a>
								<div class="caption cntr">
									<p>${ item.tenSP }</p>
									<p>
										<strong> <fmt:formatNumber type="number"
												groupingUsed="true" value="${item.giaBan}" /> ₫
										</strong>

									</p>
									<h4>
										<a class="shopBtn"
											href="<c:url value="/AddCart/${ item.maSP }"/>"
											title="add to cart"> Thêm vào giỏ </a>
									</h4>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${ (loop.index + 1)  %3 ==0 || (loop.index+1) == allHighlighProducts.size()}">
				</ul>
			</div>
			<c:if test="${ (loop.index + 1) < allHighlighProducts.size()}">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>
	</div>

	<%-- <div class="pagination">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${ idCategory }/${ loop.index }"/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${ idCategory }/${ loop.index }"/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div> --%>

</body>

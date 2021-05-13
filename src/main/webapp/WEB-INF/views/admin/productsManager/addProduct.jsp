<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${catogorys }">
						<li><a href='<c:url value="/san-pham/${ item.maLoai }"/>'><span
								class="icon-circle-blank"></span> ${ item.tenLoai }</a></li>
						<li>
					</c:forEach>
					<li><a class="totalInCart" href="<c:url value="/gio-hang"/>"><strong>Tổng
								tiền mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPriceCart}" />₫</span>
						</strong></a></li>
				</ul>
			</div>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span
					class="divider">/</span></li>
				<li><a href="<c:url value="/quan-tri"/>">Quản trị</a> <span
					class="divider">/</span></li>
				<li><a href="<c:url value="/quan-ly-san-pham"/>">Quản lý
						sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Thêm sản phẩm</li>
			</ul>
			<div class="well">
				<h2 style="text-align: center;">Thêm Sản Phẩm</h2>
				<br>
				<form:form action=" addProduct" class="form-horizontal"
					method="POST" modelAttribute="addProducts">
					<div class="control-group">
						<label class="control-label">Loại sản phẩm <sup>*</sup></label>
						<!-- <div class="controls"> -->
						<%-- <form:input  type="text" placeholder=" VD: Bánh,..." path="maLoai"/> --%>
						<!-- <input type="text" placeholder=" VD: Bánh,..."> -->
						<!-- <label class="control-label">Title <sup>*</sup></label> -->
						<div class="controls">
							<select>
								<option value="">---Loại sản phẩm---</option>
								<option value="1">Bánh</option>
								<option value="2">Kẹo</option>
								<option value="3">Mứt</option>
								<option value="4">Đồ ăn nhanh</option>
								<option value="5">Nước giải khát</option>
								<option value="6">Thịt khô</option>
								<option value="7">Khác...</option>
							</select>
						</div>
						<!-- </div> -->
					</div>
					<div class="control-group">
						<label class="control-label">Tên sản phẩm <sup>*</sup></label>
						<div class="controls">
							<%-- <form:input path="tenSP" type="text"
								placeholder=" VD: Bánh đa,..." /> --%>
							<input type="text" placeholder=" VD: Bánh đa,...">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Hình ảnh <sup>*</sup></label>
						<div class="controls">
							<%-- <form:input path="image" type="text"
								placeholder=" VD: banh-da.png,..." /> --%>
							<input type="text" placeholder=" VD: banh-da.png,...">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Giá bán <sup>*</sup></label>
						<div class="controls">
							<%-- <form:input path="giaBan" type="text"
								placeholder=" VD: 10000,..." /> --%>
							<input type="text" placeholder=" VD: 10000,...">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Giảm giá <sup>*</sup></label>
						<div class="controls">
							<%-- <form:input path="giamGia" type="text"
								placeholder=" VD: Có thể không cần điền!" /> --%>
							<input type="text" placeholder=" Có thể để trống!">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Giới thiệu <sup>*</sup></label>
						<div class="controls">
							<%-- <form:input path="gioiThieu" type="text" maxlength="1000"
								placeholder=" " /> --%>
							<textarea></textarea>
						</div>
					</div>


					<div class="control-group">
						<div class="controls">
							<input type="submit" name="submitAccount" value="Thêm sản phẩm"
								class="exclusive shopBtn">
						</div>
					</div>
				</form:form>
			</div>
			<br /> <a href="<c:url value="/quan-ly-san-pham"/>"
				class="shopBtn btn-large"><span class="icon-arrow-left"></span>
				Quay Lại </a>
		</div>
	</div>
</body>
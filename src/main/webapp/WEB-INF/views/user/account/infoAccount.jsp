<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${catogorys }">
						<li><a href="<c:url value="/san-pham/${ item.maLoai }"/>"><span
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
				<li class="active">Thông tin tài khoản</li>
			</ul>
			<div class="well">
				<form class="form-horizontal">
					<h3>Thông tin tài khoản</h3>

					<div class="control-group">
						<label class="control-label" for="inputFname">Tên người
							dùng <sup>*</sup>
						</label>
						<div class="controls">
							<input type="text" id="inputFname" placeholder="Tên người dùng">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLname">Email <sup>*</sup></label>
						<div class="controls">
							<input type="email" id="inputLname" placeholder="Email">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Password <sup>*</sup></label>
						<div class="controls">
							<input type="password" placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Địa chỉ <sup>*</sup></label>
						<div class="controls">
							<input type="text" placeholder="Địa chỉ">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Số điện
							thoại <sup>*</sup>
						</label>
						<div class="controls">
							<input type="text" placeholder="Số điện thoại">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="submit" name="submitAccount"
								value="Cập nhật thông tin" class="exclusive shopBtn">
						</div>
					</div>
				</form>
			</div>
			<br /> <a href="<c:url value="/trang-chu"/>"
				class="shopBtn btn-large"><span class="icon-arrow-left"></span>
				Tiếp Tục Mua Sắm </a>
		</div>
	</div>
</body>
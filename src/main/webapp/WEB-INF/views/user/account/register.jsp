<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<title>Đăng ký</title>
<style>
.err {
	color: red;
	font-size: italic;
}

.status {
	color: red;
	font-size: italic;
}

.statusLogin {
	color: red;
	font-size: italic;
}
</style>
<!-- <script>
	function getValue(id) {
		return document.getElementById(id).value.trim();
	}
	
	function showErr(key, mess) {
		
		document.getElementById(key+'_err').innerHTML = mess;
	}

	function validateLogin() {
		
		var flag = true;

		// email
		var email = getValue('email');
		var emailFomat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!emailFomat.test(email)) {
			flag = false;
			//showErr('email_err', "Vui lòng nhập đúng và không để trống Email!");
			console.log("Vui lòng nhập đúng và không để trống Email!");
		}
		
		// pass
		var password = getValue('password');
		if (password == '' ) {
			flag = false;
			//showErr('password_err', "Vui lòng không để trống Passowrd!");
			console.log("Vui lòng không để trống Passowrd!");
		}
		return flag;
	}
</script> -->
</head>
<body>
	<!-- 
Body Section 
-->
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
				<li><a href="<c:url value="/trang-chu"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Người dùng</li>
			</ul>
			<h3>Đăng nhập</h3>
			<hr class="soft" />
			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>ĐĂNG KÝ TÀI KHOẢN</h5>
						<h6 class="status">${ status }</h6>
						<form:form action="dang-ky" method="POST"
							modelAttribute="usersRegister">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ
									E-mail</label>
								<div class="controls">
									<form:input type="email" class="span3" placeholder="Email"
										id="email" path="user" />
								</div>
								<h6 class="status">${ statusEmail }</h6>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="********" path="password" />
								</div>
								<h6 class="status">${ statusPassword }</h6>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Họ và tên</label>
								<div class="controls">
									<form:input type="text" class="span3"
										placeholder="VD: Trần Văn A" path="name" />
								</div>
								<h6 class="status">${ statusName }</h6>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Số điện
									thoại liên lạc </label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder=""
										path="phoneNumber" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ </label>
								<div class="controls">
									<%-- <form:input type="text" class="span3" placeholder=""
										path="address" /> --%>
										<form:textarea path="address" rows="6" cols="30" type="text" class="span3" placeholder="" />
										<!-- <textarea path="address" rows="6" cols="30"></textarea> -->
								</div>
							</div>
							
							<div class="controls">
								<button type="submit" class="btn block">Tạo tài khoản</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>ĐĂNG NHẬP HỆ THỐNG</h5>
						<h6 class="status">${ statusLogin }</h6>
						<form:form action="dang-nhap" method="POST"
							modelAttribute="usersRegister">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input class="span3" type="text" placeholder="Email"
										path="user" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="********" path="password" />
									<!-- <span id="password_err"></span> -->
								</div>
							</div>
							<div class="control-group">
								<div class="controls" style="text-align: center;">
									<form:button type="submit" class="defaultBtn">Đăng nhập</form:button>
									<!-- <button type="submit" class="defaultBtn">Đăng nhập</button> -->
									<!-- <button type="submit" onclick="return validateLogin();" class="defaultBtn">Đăng nhập</button> -->
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
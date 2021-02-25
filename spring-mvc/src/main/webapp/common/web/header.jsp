<%@ page import = "com.laptrinhjavaweb.util.SecurityUtils" %> <!-- import để sử dụng hàm có trong "SecurityUtils" để lấy tên người dùng đã đăng nhập vô -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"> 
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="<c:url value='/trang-chu'/>">Trang chủ
						<span class="sr-only">(current)</span>
				</a></li>
				<security:authorize access = "isAnonymous()"><!-- Đây là hàm spring security đã build cho ta, chỉ cần gọi ra và sử dụng -->
					<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
				</security:authorize>
				<security:authorize access = "isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#">Welcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
					<!-- Lấy tên người dùng đăng nhập bằng cách sử dụng hàm dc xay dựng bên SecurityUtils -->
					<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
				</security:authorize>
				
			</ul>
		</div>
	</div>
</nav>
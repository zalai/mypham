<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonTaglid.jsp" %>

<!-- Top menu -->
<nav class="navbar navbar-default">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header hidden-sm hidden-md hidden-lg">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1" aria-expanded="false">Menu</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse"
		id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="${contextPath}">Trang chủ<span class="sr-only">(current)</span></a></li>
			<li><a href="#">Xịt toàn thân nam</a></li>
			<li><a href="#">Phụ kiện trạng điêm</a></li>
			<li><a href="#">Làm đẹp</a></li>
			<li><a href="#">Giới thiệu</a></li>
			<li><a href="#">Khuyến mãi</a></li>
			<li><a href="#">Diễn đàn</a></li>
			<li><a href="<spring:url value="/login"></spring:url>">Login</a></li>
		</ul>
	</div>
</nav>

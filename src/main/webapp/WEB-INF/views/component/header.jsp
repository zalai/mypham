<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../common/commonTaglid.jsp" %>
<!-- Header top -->
<header>
	<div class="row">
		<div class="col-md-6 col-sm-12 hidden-sm hidden-xs">Chào mừng bạn đến với banmypham.vn</div>
		<div class="col-md-6 col-sm-12 hidden-sm hidden-xs">
			<a href="#">Điện thoại : (08)3597.8888 - 0907.807.780 -
				0906.803.308 (ZALO) - 0919.756.079</a>
		</div>
	</div>
	<hr>

	<!-- Search -->
	<div class="search">
		<div class="row">
			<div class="col-md-3">
				<a href="http://banmypham.vn/"> <img
					src="resources/images/system/logo.png" alt="banmypham.vn">
				</a>
			</div>
			<div class="col-md-7">
				<spring:url value="/search" var="urlSearch"></spring:url>
				<form:form action="${urlSearch}" method="get" modelAttribute="searchForm" class="form-group search" role="search" acceptCharset="utf-8">
					<div class="input-group">
						<form:input type="search"  path="searchValue" class="form-control" placeholder="Search for..." />
						<span class="input-group-btn"/>
							<form:button class="btn btn-default" type="submit">Go!</form:button>
						</span>
					</div>
					<!-- /input-group -->
				</form:form>
			</div>
			<!-- /.col-lg-6 -->

			<div class="col-md-2 text-right">
				<div class="search">
					<button type="button" class="btn btn-info btn-show-card">
						Giỏ hàng <span class="badge"><c:out value="${sessionScope.cardItems.products.size()}" /></span>
					</button>
				</div>
			</div>
		</div>
	</div>
</header>
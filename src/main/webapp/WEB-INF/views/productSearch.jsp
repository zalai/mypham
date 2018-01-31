<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>

<%@include file="common/commonTaglid.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="common/css.jsp"></jsp:include>
	<link rel="stylesheet" href="${contextPath}/resources/css/index.css"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/searchProduct.css"/>

	<jsp:include page="common/js.jsp"></jsp:include>
	<script type="text/javascript" src="${contextPath}/resources/js/product/productDetail.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/card/process.js"></script>
	<title>Trang chủ</title>
</head>
<body>

	<%@ include file="component/breadcrumb.jsp"%>

	<!-- Product follow product type -->
	<div class="product">
		<c:forEach var="product" varStatus="status" items="${productList}">
			<ul>
				<li class="box wow fadeInDown animated" product-id="${product.maSp}"
					style="visibility: visible; animation-name: fadeInDown;">
					<div class="demo6 showProductDetail">
						<a
							href="#"><img
							src="${product.hinh}"
							width="250" alt="${product.moTa}"
							title="${product.tenSp}"></a>
					</div>
					<div class="title-product">
						<a href="#">${product.tenSp}</a>
					</div>
					<!-- <div class="bad-code">Mã sản phẩm : E328</div> -->
					<div class="price">
						<fmt:formatNumber pattern=",###" value = "${product.giaBan}" /> VNĐ
					</div>
					<div class="add-card">
						<button class="btn btn-add-card">
							<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
						</button>
					</div>
				</li>
			</ul>
		</c:forEach>

		<div class="clear"></div>

		<div class="text-center">
			<tag:paginate currentPage="${searchForm.page}" count="${searchForm.resultSize}" paramSearch="${searchForm.searchParam}"
				uri="search" next="&raquo;" previous="&laquo;" />
		</div>
	</div>

	<div class="clear"></div>

		<!-- Detail product -->
	<div id="detail-product" class="modal fade" role="dialog"></div>
	<div id="checkout-product" class="modal fade" role="dialog"></div>
	
	<!-- Detail product template -->
	<jsp:include page="./component/template/productDetailTemplate.jsp"></jsp:include>

	<!-- Checkout card template -->
	<jsp:include page="./component/template/cardTemplate.jsp"></jsp:include>
</body>
</html>

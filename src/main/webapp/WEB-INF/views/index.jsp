<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="common/commonTaglid.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="common/css.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/index.css"/>

<jsp:include page="common/js.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/product/handle.js"></script>
<script type="text/javascript" src="resources/js/product/productDetail.js"></script>
<script type="text/javascript" src="resources/js/card/process.js"></script>
<title>Trang chủ</title>
</head>
<body>
	<%@ include file="./component/carousel.jsp"%>
	<%@ include file="./component/breadcrumb.jsp"%>

	<!-- New product -->
	<div id="slider-news" class="slider-featured clear">
		<h1 class="product-title">
			<span> SẢN PHẨM MỚI NHẤT</span>
		</h1>
		<div class="viewport">

			<ul class="overview" style="width: 10363px; left: -5539.17px;">
			<c:forEach var="productNew" varStatus="status" items="${productNewList}">
				<li class="box wow fadeInDown animated" product-id="${productNew.maSp}">
					<div class="showProductDetail">
						<a class="post-img"
							href="#"><img
							src="${productNew.hinh}" width="220"
							alt="${productNew.moTa}"
							title="${productNew.tenSp}"></a>
					</div>
					<div class="title-product">
						<a
							href="#">${productNew.tenSp}</a>
					</div>
					<div class="bad-code">Mã sản phẩm : ${productNew.maSp}</div>
					<div class="price" >
						<fmt:formatNumber pattern=",###" value = "${productNew.giaBan}" /> VNĐ
					</div>
					<div class="add-card">
						<button class="btn btn-add-card">
							<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
						</button>
					</div>
				</li>
			</c:forEach>
			</ul>
			<a class="buttons next" href="">right</a>
			<a class="buttons prev" href="">left</a>
		</div>
	</div>
	
	<!-- New product header tab -->
	<div class="product">
		<h1 class="product-title">
			<span>SẢN PHẨM bán chạy</span>
		</h1>
	</div>
	<div class="main-tab">
		<!-- Product type tab -->
		<ul class="tabs">
			<c:forEach var="productType" varStatus="status" items="${productTypeList}">
				<li class="productTabType tab-link ${status.count == 1 ? 'current' : ''}" data-tab="tab-${productType.maLoai}" productType="${productType.maLoai}">
					<i class="fa fa-check-square-o"></i>${productType.tenLoai}
				</li>
			</c:forEach>
		</ul>

		<!-- Print blank tab content follow product type-->
		<c:forEach var="productType" varStatus="status" items="${productTypeList}">
			<div id="tab-${productType.maLoai}" class="tab-content product ${status.count == 1 ? 'current' : ''}"></div>
		</c:forEach>

		<div id="loadding" class="hidden">
				LOADDING ...
		</div>

	</div>

	<div class="clear"></div>

	<div id="detail-product" class="modal fade" role="dialog"></div>
	<div id="checkout-product" class="modal fade" role="dialog"></div>

	<!-- Product temlate-->
	<jsp:include page="./component/template/productTemplate.jsp"></jsp:include>
	
	<!-- Detail product template -->
	<jsp:include page="./component/template/productDetailTemplate.jsp"></jsp:include>

	<!-- Checkout card template -->
	<jsp:include page="./component/template/cardTemplate.jsp"></jsp:include>
</body>
</html>

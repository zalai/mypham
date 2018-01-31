<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../common/commonTaglid.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="../common/css.jsp"></jsp:include>
	<link rel="stylesheet" href="${contextPath}/resources/css/order.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/index.css"/>

	<jsp:include page="../common/js.jsp"></jsp:include>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Xác nhận đặt hàng</title>
</head>
<body>
	<%--Breadcrumb for order --%>
	<div>
		<ul class="breadcrumb">
			<li class="completed">
				<a href="${contextPath}/order">Thông tin</a>
			</li>
			<li class="active"><a>Xác nhận</a></li>
			<li><a>Hoàn tất</a></li>
		</ul>
	</div>

	<div class="row checkout-card">
		<%--Checkout card form --%>
		<div class="col-md-7 customer-info">
			<div class="panel panel-default">
				<div class="panel-heading">Xác nhận thông tin đặt hàng của bạn</div>
				<div class="panel-body">
					
					<form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="order/confirm">
						<div class="row">
							<div class="col-md-3">Tên của bạn: </div>
							<div class="col-md-9">${orderForm.name}</div>
						</div>
						<div class="row">
							<div class="col-md-3">Email: </div>
							<div class="col-md-9">${orderForm.email}</div>
						</div>
						<div class="row">
							<div class="col-md-3">Địa chỉ nhận hàng </div>
							<div class="col-md-9">${orderForm.address}</div>
						</div>
						<div class="row">
							<div class="col-md-3">Số điện thoại </div>
							<div class="col-md-9">${orderForm.phone}</div>
						</div>
						<form:hidden path="name"/>
						<form:hidden path="email"/>
						<form:hidden path="province"/>
						<form:hidden path="district"/>
						<form:hidden path="village"/>
						<form:hidden path="address"/>
						<form:hidden path="phone"/>
						<spring:bind path="province"/>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10 ">
								<button type="submit" class="btn btn-primary pull-right">Xác nhận</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

				<%--Detail card infor--%>
		<div class="col-md-5 card-infor">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">Thông tin đơn hàng</div>
				<div class="panel-body">
					<table class="table table-fixed">
						<thead>
							<tr>
								<th class="col-md-8">Sản phẩm</th>
								<th class="col-md-2 text-center">SL</th>
								<th class="col-md-2 text-right">Giá</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="product" items="${cardItems.products}">
							<tr>
								<td class="col-md-8">${product.value.tenSp}</td>
								<td class="col-md-2 text-center">${product.value.soLuong}</td>
								<td class="col-md-2 text-right">
									<fmt:formatNumber pattern=",###" value="${product.value.giaBan}"></fmt:formatNumber>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

					<div class="card-total">
						<div class="row">
							<div class="col-md-8">Tạm tính</div>
							<div class="col-md-4 text-right">
								<fmt:formatNumber pattern=",###" value="${cardItems.totalPrice}"></fmt:formatNumber> VND
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">Phí vận chuyển</div>
							<div class="col-md-4 text-right">
								<fmt:formatNumber pattern=",###" value="0"></fmt:formatNumber> VND
							</div>
						</div>
						<div class="row text-danger">
							<div class="col-md-8">Tổng tiền</div>
							<div class="col-md-4 text-right">
								<fmt:formatNumber pattern=",###" value="${cardItems.totalPrice}"></fmt:formatNumber> VND
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
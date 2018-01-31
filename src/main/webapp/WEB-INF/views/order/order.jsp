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
	<title>Đặt hàng</title>
</head>
<body>

	<div>
		<ul class="breadcrumb">
			<li class="active"><a>Thông tin</a></li>
			<li><a>Xác nhận</a></li>
			<li><a>Hoàn tất</a></li>
		</ul>
	</div>

	<div class="row checkout-card">
		<%--Checkout card form --%>
		<div class="col-md-7 customer-info">
			<div class="panel panel-default">
				<div class="panel-heading">Địa chỉ giao hàng của quý khách</div>
				<div class="panel-body">
					<spring:url value="/order/confirm" var="orderConfirm"></spring:url>
					<form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="${orderConfirm}">
			
						<spring:bind path="name">
							<div class="form-group ${status.error ? 'has-error':''} ">
								<label class="control-label col-sm-3" for="name">Tên</label>
								<div class="col-sm-9">
									<form:input path="name" class="form-control" id="name" placeholder="Nhập tên"/>
									<form:errors path="name" class="control-label"></form:errors>
								</div>
							</div>
						</spring:bind>
			
						<spring:bind path="email">
							<div class="form-group ${status.error ? 'has-error':''}">
								<label class="control-label col-sm-3" for="email">Email</label>
								<div class="col-sm-9">
									<form:input path="email" type="email" class="form-control" id="email"
										placeholder="Nhập email"/>
									<form:errors path="email" class="control-label" ></form:errors>
								</div>
							</div>
						</spring:bind>
			
						<spring:bind path="province">
						<div class="form-group ${status.error ? 'has-error':''}">
							<label class="col-sm-3 control-label">Tỉnh/Thành phố</label>
							<div class="col-sm-9">
								<form:select path="province" class="form-control">
									<form:option value="none" label="Vui lòng chọn"></form:option>
									<form:options items="${provinceList}" ></form:options>
								</form:select>
								<form:errors path="province" class="control-label" ></form:errors>
							</div>
						</div>
						</spring:bind>

						<spring:bind path="district">
						<div class="form-group ${status.error ? 'has-error':''}">
							<label class="col-sm-3 control-label">Quận/huyện</label>
							<div class="col-sm-9">
								<form:select path="district" class="form-control" >
									<form:option value="none" label="Vui lòng chọn"></form:option>
									<%-- <form:options items="${districtList}" ></form:options> --%>
								</form:select>
								<form:errors path="province" class="control-label" ></form:errors>
							</div>
						</div>
						</spring:bind>

						<spring:bind path="village">
						<div class="form-group ${status.error ? 'has-error':''}">
							<label class="col-sm-3 control-label">Phường, xã</label>
							<div class="col-sm-9">
								<form:select path="village" class="form-control">
									<form:option value="none" label="Vui lòng chọn"></form:option>
									<%-- <form:options items="${provinceList}" ></form:options> --%>
								</form:select>
								<form:errors path="village" class="control-label" ></form:errors>
							</div>
						</div>
						</spring:bind>

						<spring:bind path="address">
						<div class="form-group">
							<label class="col-sm-3 control-label">Địa chỉ nhận hàng</label>
							<div class="col-sm-9">
								<form:textarea path="address" rows="3" maxlength="255" class="form-control"
									placeholder="Địa chỉ nhận hàng (tầng, số nhà, đường)"></form:textarea>
								<form:errors path="address" class="control-label" ></form:errors>
							</div>
						</div>
						</spring:bind>

						<spring:bind path="phone">
						<div class="form-group">
							<label class="col-sm-3 control-label">Điện thoại di động</label>
							<div class="col-sm-9">
								<form:input path="phone" rows="5" class="form-control"
									placeholder="Số điện thoại"></form:input>
								<form:errors path="phone" class="control-label" ></form:errors>
							</div>
						</div>
						</spring:bind>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10 ">
								<button type="submit" class="btn btn-primary pull-right">Tiếp tục</button>
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
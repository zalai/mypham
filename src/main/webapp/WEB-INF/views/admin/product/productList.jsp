<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/commonTaglid.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="../../common/css.jsp"></jsp:include>

	<jsp:include page="../../common/js.jsp"></jsp:include>
	<title>Quản lí sản phẩm</title>
</head>
<body>
<div class="container">
	<h2>User list</h2>

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<table class="table table-bordered">
		<thead>
			<tr>
				<th>MaSP</th>
				<th>MaLoai</th>
				<th>TenSP</th>
				<th>Framework</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.value.id}</td>
					<td>${user.value.name}</td>
					<td>${user.value.email}</td>
					<td>${user.value.framework}</td>
					<td>
						<spring:url value="/user/${user.value.id}" var="userUrl"></spring:url>
						<button type="button" class="btn btn-primary" onClick="location.href='${userUrl}'">Detail</button>

						<spring:url value="/user/update/${user.value.id}" var="userUpdateUrl"></spring:url>
  						<button type="button" class="btn btn-success" onClick="location.href='${userUpdateUrl}'">Update</button>

						<spring:url value="/user/delete/${user.value.id}" var="userDeleteUrl"></spring:url>
  						<button type="button" class="btn btn-info" onClick="location.href='${userDeleteUrl}'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
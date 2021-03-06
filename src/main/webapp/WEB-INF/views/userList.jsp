<%@ include file="./common/commonTaglid.jsp"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="common/script.jsp"></jsp:include>
<title>User list </title>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
	<h2>User list</h2>

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">�</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
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
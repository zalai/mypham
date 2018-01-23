<%@ include file="./common/commonTaglid.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="common/script.jsp"></jsp:include>
<title>User detail</title>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<h2>User detail</h2>
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${rstUserDto.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${rstUserDto.name}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${rstUserDto.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${rstUserDto.address}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Newsletter</label>
		<div class="col-sm-10">${rstUserDto.newsletter}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Web Frameworks</label>
		<div class="col-sm-10">${rstUserDto.framework}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Sex</label>
		<div class="col-sm-10">${rstUserDto.sex}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${rstUserDto.number}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Country</label>
		<div class="col-sm-10">${rstUserDto.country}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Skill</label>
		<div class="col-sm-10">${rstUserDto.skill}</div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<spring:url value="/user" var="userListUrl"></spring:url>
			<button type="button" class="btn btn-primary pull-right" onClick="location.href='${userListUrl}'">User list</button>
		</div>
	</div>
</div>
</body>
</html>
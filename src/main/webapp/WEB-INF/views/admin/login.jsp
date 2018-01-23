<%@ include file="../common/commonTaglid.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../common/script.jsp"></jsp:include>
<title>Login page</title>
</head>
<body>
<div class="container">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="panel panel-primary" style="min-width: 500px; max-width: 500px;">
			<div class="panel-heading text-center">Login Form</div>
			<div class="panel-body" >
			<p>${param.error}</p>
				<spring:url value="/login" var="loginUrl"></spring:url>

					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<form class="form-horizontal" method="post" action="${loginUrl}">

						<div class="form-group">
						<label class="control-label col-sm-2" for="name">User</label>
						<div class="col-sm-9">
							<input name="ssoId" path="ssoId" class="form-control"  placeholder="Enter name"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">Pass</label>
						<div class="col-sm-9">
							<input name="password" path="password" class="form-control" placeholder="Enter name"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-9 ">
							<button type="submit" class="btn btn-primary btn-block">Login</button>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-9">
							<label class="checkbox-inline"><input type="checkbox" path="sex" value="true" />Remember me</label>
						</div>
					</div>

					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
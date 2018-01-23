<%@include file="common/commonTaglid.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="common/script.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
	<c:choose>
		<c:when test="${userForm['new']}">
			<h2>Add new user</h2>
		</c:when>
		<c:otherwise>
			<h2>Update user</h2>
		</c:otherwise>
	</c:choose>
		<spring:url value="/user/doUpdate" var="userActionUrl"></spring:url>
		<form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">
			<form:hidden path="id" />

			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error':''} ">
					<label class="control-label col-sm-2" for="name">Name:</label>
					<div class="col-sm-10">
						<form:input path="name" class="form-control" id="name" placeholder="Enter name"/>
						<form:errors path="name" class="control-label"></form:errors>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-sm-10">
						<form:input path="email" type="email" class="form-control" id="email"
							placeholder="Enter email"/>
						<form:errors path="email" class="control-label" ></form:errors>
					</div>
				</div>
			</spring:bind>

			<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error':''}">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-10">
					<form:input path="password" type="password" class="form-control" id="password"
						placeholder="Enter password"/>
					<form:errors path="password" class="control-label" ></form:errors>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="confirmPassword">
			<div class="form-group ${status.error ? 'has-error':''}" >
				<label class="control-label col-sm-2" for="confirmPassword">Confirm Password:</label>
				<div class="col-sm-10">
					<form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword"
						placeholder="Enter password"/>
					<form:errors path="confirmPassword" class="control-label" ></form:errors>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="address">
			<div class="form-group">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" rows="5" class="form-control"
						id="address" placeholder="address"></form:textarea>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="newsletter">
			<div class="form-group">
				<label class="col-sm-2 control-label">News letter</label>
				<div class="col-sm-10">
					<div class="checkbox">
						<label><form:checkbox path="newsletter"/></label>
					</div>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="framework">
			<div class="form-group ${status.error ? 'has-error':''}">
				<label class="col-sm-2 control-label">Web Framework</label>
				<div class="col-sm-10">
					<form:checkboxes path="framework" items="${frameworksList}" element="label class='checkbox-inline'"/>
					<br>
					<form:errors path="framework" class="control-label" ></form:errors>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="sex">
			<div class="form-group">
				<label class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<label class="radio-inline"><form:radiobutton path="sex" value="male"/>Male </label>
					<label class="radio-inline"><form:radiobutton path="sex" value="female"/>Female</label>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="number">
			<div class="form-group">
				<label class="col-sm-2 control-label">Number</label>
				<div class="col-sm-10">
					<form:radiobuttons path="number" items="${numberList}" element="label class='radio-inline'"/>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="country">
			<div class="form-group ${status.error ? 'has-error':''}">
				<label class="col-sm-2 control-label">Country</label>
				<div class="col-sm-10">
					<form:select path="country" class="form-control">
						<form:option value="none" label="Please select"></form:option>
						<form:options items="${countryList}" ></form:options>
					</form:select>
					<form:errors path="country" class="control-label" ></form:errors>
				</div>
			</div>
			</spring:bind>

			<spring:bind path="skill">
			<div class="form-group">
				<label class="col-sm-2 control-label">Java skill</label>
				<div class="col-sm-10">
					<form:select path="skill" class="form-control" multiple="true">
						<form:option value="none" label="please select"></form:option>
						<form:options items="${javaSkillList}"/>
					</form:select>
					<form:errors path="skill" class="control-label" ></form:errors>
				</div>
			</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10 ">
					<button type="submit" class="btn btn-primary pull-right">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
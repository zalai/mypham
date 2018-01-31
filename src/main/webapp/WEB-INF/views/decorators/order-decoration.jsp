<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
	<sitemesh:write property='title' />
</title>
	<sitemesh:write property='head' />
</head>

<body>
	<div class="container">
		<%@ include file="../component/headerOrder.jsp"%>
		<%@ include file="../component/slidebar.jsp"%>

		<sitemesh:write property='body' />
	</div>

	<%@ include file="../component/footer.jsp"%>
</body>

</html>
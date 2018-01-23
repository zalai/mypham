<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/commonTaglid.jsp" %>

<!-- Break crum -->
<c:if test="${not empty breadcrumbList}">
	<ol class="breadcrumb">
		<c:forEach var="crumbItem" items="${breadcrumbList}">
			<c:choose>
				<c:when test="${not empty crumbItem.url}">
					<li><a href="${crumbItem.url}">${crumbItem.label}</a></li>
				</c:when>
				<c:otherwise>
					<li class="active">${crumbItem.label}</li>
				</c:otherwise>
			</c:choose>	
		</c:forEach>
	</ol>
</c:if>
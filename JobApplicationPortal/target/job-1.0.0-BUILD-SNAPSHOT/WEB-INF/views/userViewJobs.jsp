<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Jobs</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<!--  form:form action="${contextPath}/applyJob/delete" method="GET"-->
	
	Welcome ${sessionScope.username}, ${sessionScope.userId }
	<br>
		Jobs :
		<table>
		<tr>
		<th>Position</th>
		<th>Location</th>
		<th>Company<th>
		<th>Description</th>
		<th>Apply</th>
		
		</tr>
		<c:forEach items="${jo}" var="temp">
		<tr>
		<td><c:out value="${temp.position}" /> </td>
		<td><c:out value="${temp.location}" /> </td>
		<td><c:out value="${temp.company}" /> </td>
		<td><c:out value="${temp.description}"/></td>
		<td><a href="apply/${temp.jobId},${sessionScope.username},${sessionScope.userId}">Apply</a></td>
		</tr>
		</c:forEach>
		</table>
	
	
		
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Applied Job Details-Job Seeker</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<h3>Applied Job Id is: ${sessionScope.jobId}</h3>
	<h4>Job Details are: </h4>
	
	<br>
		
		<table>
		<tr>
		<th>Position</th>
		<th>Location</th>
		<th>Company<th>
		<th>Description<th>
		
		</tr>
		<c:forEach items="${apd}" var="temp">
		<tr>
		<td><c:out value="${temp.position}" /> </td>
		<td><c:out value="${temp.location}" /> </td>
		<td><c:out value="${temp.company}" /> </td>
		<td><c:out value="${temp.description}" /></td>
		
		</tr>
	
		</c:forEach>
		</table>
		
		<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>
	
</body>
</html>
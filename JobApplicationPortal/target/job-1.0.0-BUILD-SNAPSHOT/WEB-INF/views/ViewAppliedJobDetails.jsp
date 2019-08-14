<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Id details</title>
</head>
<body>

Welcome ${sessionScope.username}

	<table>
	<tr>
		<th>Job Id</th>
		<th>View</th>
	</tr>
	
		
		<c:forEach items="${apd}" var="temp">
		<tr>
		<td><c:out value="${temp.jobId}" /> </td>
		
		
		<td><a href="<%=request.getContextPath() %>/userApplication/viewApplicants/${temp.jobId}">View Applicants</a></td>
		
		</tr>
	
		</c:forEach>
	</table>

	<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>
</body>
</html>
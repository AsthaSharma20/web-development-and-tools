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
<title>View Applications</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<!--  form:form action="${contextPath}/updateJob/delete" method="GET"-->
	
	
	${sessionScope.apll}
	<br><br>
		
		<table>
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Contact No<th>
		<th>Email Id</th>
		<th>Address Line 1</th>
		<th>Address Line 2</th>
		<th>City</th>
		<th>Zip Code</th>
		<th>Country</th>
		<th>View Resume</th>
		<th>Select Applicant</th>
		<th>Reject Applicant</th>
		
		</tr>
		<c:forEach items="${sessionScope.apll}" var="temp">
		<tr>
		<td><c:out value="${temp.fname}" /> </td>
		<td><c:out value="${temp.lname}" /> </td>
		<td><c:out value="${temp.contactNo}" /> </td>
		<td><c:out value="${temp.emailId}" /></td>
		<td><c:out value="${temp.addressLine1}" /></td>
		<td><c:out value="${temp.addressLine1}" /></td>
		<td><c:out value="${temp.city}" /></td>
		<td><c:out value="${temp.zip}" /></td>
		<td><c:out value="${temp.country}" /></td>
		<td><c:out value="${temp.resume}" /></td>
		
		<td><a href="<%=request.getContextPath() %>/userApplication/resumeView/${sessionScope.jobId}">View Resume</a>
		<td><a href="<%=request.getContextPath() %>/userApplication/selected/${sessionScope.jobId},${temp.emailId}">Select</a></td>
		<td><a href="<%=request.getContextPath() %>/userApplication/rejected/${sessionScope.jobId},${temp.emailId}">Reject</a></td>
		</tr>
	
		</c:forEach>
		</table>
	
	

</body>
</html>
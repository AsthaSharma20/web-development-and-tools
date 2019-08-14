<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply Job</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>
	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<a href="<%=request.getContextPath() %>/">Click here to go to Dashboard</a><br><br>
	<form:form action="${contextPath}/userApplication/applyToJob" method="post"
		modelAttribute="appl" enctype="multipart/form-data">
		
		
		
		
		
	<input type="hidden" name="jobId" value="${sessionScope.id}" />
	<input type="hidden" name="userId" value="${sessionScope.userId}" />
	
	<label>First Name: </label><input type="text" name="fname"/><br><br/>  
	<label>Last Name:  </label><input type="text" name="lname"/><br><br/> 
	<label>Contact Number:  </label><input type="text" name="contactNo"/><br><br/> 
	<label>Email Id:  </label><input type="text" name="emailId"/><br><br/> 
	<label>Address Line 1:  </label><input type="text" name="addressLine1"/><br><br/> 
	<label>Address Line 2:  </label><input type="text" name="addressLine2"/><br><br/> 
	<label>City: </label><input type="text" name="city"/><br><br/>  
	<label>Zip Code: </label><input type="text" name="zip"/><br><br/>  
	<label>Country : </label><input type="text" name="country"/><br><br/>  
	
	<label>Paste Resume (text format)</label>
	<textarea rows="100" cols="100" name="resume">
	</textarea>
	
	<input type="submit" name="Apply" value="Apply"/>
	</form:form><br>
</body>
</html>
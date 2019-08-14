<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/authentication/register" method="post"
		modelAttribute="user">
	<label>Select Role: </label>
	<select name="role">
		<option value="jobSeeker">Job Seeker</option>
		<option value="recruiter">Recruiter</option>
	</select>	<br><br>
	<label>Name: </label><input type="text" name="username"/><br><br/>  
	<label>Password:  </label><input type="password" name="password"/><br><br/>  
	<input type="submit" name="register" value="Register"/>
	</form:form><br>
	<a href="<%=request.getContextPath() %>/">Click here to go to Dashboard</a>
</body>
</html>
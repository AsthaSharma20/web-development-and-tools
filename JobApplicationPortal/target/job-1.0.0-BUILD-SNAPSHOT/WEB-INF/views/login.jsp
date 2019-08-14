<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User login</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/">Click here to go to Dashboard</a><br><br>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/authentication/login" method="post"
		modelAttribute="login">
		<label>Select your role:  </label>
		<select name="role">
		<option value="jobSeeker">Job Seeker</option>
		<option value="recruiter">Recruiter</option>
	</select>	<br><br>
	<label>Name: </label><input type="text" name="username"/><br><br/>  
	<label>Password:  </label><input type="password" name="password"/><br><br/>  
	<input type="submit" name="submit" value="Login"/>
	</form:form>
	

</body>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Jobs</title>
</head>
<body>

<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>

<a href="<%=request.getContextPath() %>/">Click here to go to Dashboard</a><br><br>
	<h2>Add Jobs:</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/addJob/add" method="post"
		modelAttribute="addj">
		<input type="hidden" name="userId" value="${sessionScope.userId}" />
		<label>Enter Position: </label>
		<input type="text" name="position"/><br><br>
		<label>Enter Location: </label>
		<input type="text" name="location"/><br><br>
		
		<label>Enter Company Name: </label>
		<input type="text" name="company"/><br><br>
		
		<label>Enter Description: </label>
		<textarea rows="30" cols="50" name="description"></textarea><br>
		<input type="submit" name="submit" value="Submit"/>
		
		</form:form>

</body>
</html>
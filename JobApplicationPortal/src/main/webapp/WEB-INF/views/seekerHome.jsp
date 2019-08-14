<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seeker Home</title>
</head>
<body>
	Welcome to Job seeker portal  ${sessionScope.username}
	<br><br>
	
	<a href="<%=request.getContextPath() %>/userApplication/view">Click here to view all jobs</a>
	<a href="<%=request.getContextPath() %>/userApplication/viewJobsByUserId/${sessionScope.userId}">Click here to view all applied jobs</a>
	
	<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruiter Home</title>
</head>
<body>
	Welcome Recruiter ${sessionScope.username},${sessionScope.userId}<br><br>
	<a href="<%=request.getContextPath() %>/addJob/add/${sessionScope.userId}">Click here to add jobs</a><br><br>
	<a href="<%=request.getContextPath() %>/updateJob/view">Click here to view, update or delete jobs</a><br><br>
	<a href="<%=request.getContextPath() %>/updateJob/viewByRecruiterId/${sessionScope.userId}">Click here to view jobs and applicants</a><br><br>
	<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>
</body>
</html>
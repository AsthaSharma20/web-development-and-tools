<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>Deleted Successfully!</h3>
	
	<a href="<%=request.getContextPath() %>/">Click here to go to Dashboard</a><br><br>
	
	<a href="<%=request.getContextPath() %>/authentication/logout/${sessionScope.userId},${sessionScope.username}">LOGOUT</a><br><br>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>logout.jsp<br>
	${key }<br>
	${requestScope.key }<br>
	<%= request.getAttribute("key") %><br>
	request : <%= request.getParameter("key") %>
	<hr>
	${ok }<br>
	${requestScope.ok }<br>
	<%= request.getAttribute("ok") %>
	
</body>
</html>
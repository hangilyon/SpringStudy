<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>index.jsp
	<h1>request: ${requestScope.index}</h1><br>
	<a href="http://localhost:8090/root/login">로그인 페이지</a> 
	<a href="/root/logout">로그아웃 페이지</a>
</body>
</html>
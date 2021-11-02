<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>login.jsp
	<h1>${login }</h1><br>
	<h1>request: ${requestScope.login}</h1><br>
	<a href="logout">로그아웃 페이지</a> <a href="index">기본 페이지</a>
</body>
</html>
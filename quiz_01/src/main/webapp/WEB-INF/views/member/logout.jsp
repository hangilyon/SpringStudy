<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>logout.jsp
	<h1>${logout }</h1><br>
	<h1>request: ${requestScope.logout}</h1><br>
	<a href="login">로그인 페이지</a> <a href="index">기본 페이지</a>
</body>
</html>
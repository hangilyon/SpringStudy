<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ contextPath.request.pageContext}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>insertView
	<h1>회원가입 페이지</h1>
	<form action="${contextPath }/insertMember" method="post">
		<input type="text" placeholder="id" name="id"><br>
		<input type="text" placeholder="password" name="pwd"><br>
		<input type="text" placeholder="name" name="name"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>
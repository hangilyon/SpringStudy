<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>register_view.jsp</h1><hr>
	<h1>회원가입 페이지</h1>
	<form action="register2" method="post">
		<input type="text" name="id" placeholder="input id"><br>
		<input type="text" name="pwd" placeholder="input password"><br>
		<input type="text" name="name" placeholder="input name"><br>
		<input type="submit" value="register">
	</form>
</body>
</html>
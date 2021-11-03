<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>index.jsp<br>
	<h1>기본 페이지 입니다.</h1>
	<h1>get 방식 전송</h1>
	<form action="${contextPath }/my/result" method="get">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form><br>
	
	<h1>post 방식 전송</h1>
	<form action="${contextPath }/my/result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
	
	<h1>dto 방식 전송</h1>
	<form action="${contextPath }/my/object" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>
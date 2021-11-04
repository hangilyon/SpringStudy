<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="${contextPath }/css/test.css"/>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>h1 연습입니다.</h1>
	<form action="result">
		<input type="text" name="id"><br>
		<input type="submit" value="전송"><br>
	</form>
	<img src="${contextPath }/resources/beaf.jpg" width="500px" height="500px">
	<img src="${contextPath }/resources/test/img.jpg" width="500px" height="500px">
	<img src="<c:url value="/resources/test/img.jpg" />" width="50px" height="50px">
	
</body>
</html>
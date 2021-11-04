<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인정보</h1><br>
	<h3>id : ${dto.id }</h3><br>
	<h3>pwd : ${dto.pwd }</h3><br>
	<h3>name : ${dto.name }</h3><hr>
	<a href="${contextPath }/member/member_list">목록으로 이동</a>
</body>
</html>
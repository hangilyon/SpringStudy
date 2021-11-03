<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${contextPath.request.pageContext }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>index.jsp<br>
<a href="${contextPath }/member/insert">회원가입</a> <a href="${contextPath }/member/memberView">모든 회원보기</a>

</body>
</html>
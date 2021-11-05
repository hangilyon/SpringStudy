<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>logout.jsp<br>
	<c:choose>
		<c:when test="${loginId != null }">
			<script type="text/javascript">
				alert('로그아웃 되었습니다.');
				location.href='login';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('로그인 먼저 진행하세요');
				location.href='login'
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
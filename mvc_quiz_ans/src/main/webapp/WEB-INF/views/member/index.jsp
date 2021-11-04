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
	<h1>member 폴더 -> index.jsp</h1>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("존재하지 않는 비밀번호 입니다!!!")
		</script>
	</c:if>
	<c:if test="${result == -1 }">
		<script type="text/javascript">
			alert("존재하지 않는 id 입니다!!!")
		</script>
	</c:if>
	<form action="login" method="post">
		<input type="text" placeholder="id" name="id"><br>
		<input type="text" placeholder="password" name="pwd"><br>
		<input type="submit" value="login">
		</form>
	<a href="${contextPath }/member/register_view">회원가입</a><br>
	<a href="${contextPath }/member/member_list">모든 회원보기</a>
</body>
</html>
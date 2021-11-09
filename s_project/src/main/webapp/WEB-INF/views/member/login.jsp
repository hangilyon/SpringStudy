<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap.content {
	display:flex;
}
.leftContent {
	width: 50%;
}
.rightContent {
	width: 50%;
}
.rightContent .login{
	display: flex;
	justify-content: center;
}
.rightContent .login div a{
	text-decoration: none;
	color: black;
}
.rightContent .login input {
	width: 250px;
	height: 35px;
	
}
.rightContent .login span input {
	width: 100px;
	height: 81px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/default/header.jsp"/>
	<div class="wrap content">
		<div class="leftContent">
			<h1>로그인 페이지 입니다.</h1>
		</div>
		<div class="rightContent">
			<form class="login" action="loginChk" method="post">
				<div>
					<input type="text" name="id" placeholder="아이디"><br>
					<input type="password" name="pw" placeholder="비밀번호"><br>
					<a href="register">회원가입</a>
				</div>
				<span>
					<input type="submit" value="로그인">
				</span>
			</form>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/default/footer.jsp"/>

</body>
</html>

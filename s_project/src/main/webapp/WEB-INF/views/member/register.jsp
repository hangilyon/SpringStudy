<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/default/header.jsp"/>
	<div class="wrap content">
		<h1>회원등록</h1>
		<form action="insertMem" method="post">
			<input type="text" placeholder="아이디" name="id"><br>
			<input type="text" placeholder="비밀번호" name="pw"><br>
			<input type="text" placeholder="주소" name="addr"><br>
			<input type="submit" value="회원가입">
		</form>
	</div>
<jsp:include page="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>
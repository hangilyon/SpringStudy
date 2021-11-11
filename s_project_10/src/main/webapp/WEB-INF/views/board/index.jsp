<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_index.jsp</title>
<style type="text/css">

</style>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div class="wrap" align="center">
		<h1>게시판 보기 입니다.</h1><hr>
		<table border = "1">
			<tr><th>글 번호</th><th>이 름</th><th>제 목</th></tr>
			<tr></tr>
		</table><br>
		<button>글쓰기</button>
	</div>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>
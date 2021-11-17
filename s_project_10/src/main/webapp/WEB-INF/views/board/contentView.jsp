<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div class="wrap" align="center">
		<h1>게 시 판</h1><br>
		<table border = "1">
			<tr><th>번 호</th><th>I D</th><th>제 목</th><th>날 짜</th><th>조 회 수</th><th>IMAGE_FILE_NAME</th></tr>
			<tr><th colspan="6">등록된 글이 없습니다</th></tr>
			<tr><td colspan="6" align="right"><a href="writeForm">글 작성</a></td></tr>
		</table><br>
		
	</div>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>
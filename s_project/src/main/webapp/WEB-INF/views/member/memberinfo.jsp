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
<jsp:include page="/WEB-INF/views/default/header.jsp"/>
	<div class="wrap content">
		<h1>회원정보</h1>
		<table border="1" width="500">
			<tr>
				<th>아이디</th><th>비밀번호</th><th>주소</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="info?id=${dto.id }">${dto.id }</a></td>
					<td>${dto.pw }</td>
					<td>${dto.addr }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>
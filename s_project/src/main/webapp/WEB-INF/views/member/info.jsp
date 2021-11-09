<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/default/header.jsp"/>
	<div class="wrap content">
	
		<h1>${id } 정보</h1>
		<table>
			<tr>
				<th>아이디</th> <th>${userInfo.id }</th>
			</tr>
			<tr>
				<th>비밀번호</th> <th>${userInfo.pw }</th>
			</tr>
			<tr>
				<th>주소</th> <th>${userInfo.addr }</th>
			</tr>
		</table>
	</div>
<jsp:include page="/WEB-INF/views/default/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr th,td{
width:300px;
height:30px;
}
</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="../default/header.jsp"/>
	<div align="center">
		<table>
			<tr>
				<th>아이디</th><td>${getMember.id }</td>
			</tr>
			<tr>
				<th>이름</th><td>${getMember.pw }</td>
			</tr>
			<tr>
				<th>주소</th><td>${getMember.addr }</td>
			</tr>
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${contextPath.request.pageContext}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>모든 회원보기</h1>
	<table border="1">
		<tr><th>id</th><th>password</th><th>name</th></tr>
		<c:if test="${dao == null }">
			<tr>
				<th colspan="3">데이터 없음</th>
			</tr>
		</c:if>
		<c:if test="${dao != null }">
			<c:forEach begin="1" step="1" end="${dao.size }" items="${dao }">
				<tr>
					
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</c:if>
		<tr>
			<td colspan="3">
				<a href="${contextPage }/member/index">index 이동</a>
			</td>
		</tr>
	</table>
</body>
</html>
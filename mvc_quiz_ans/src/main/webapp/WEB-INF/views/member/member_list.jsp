<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member_list.jsp</h1>
	<table border="1">
		<tr>
			<th>id</th><th>pwd</th><th>name</th>
		</tr>
		<c:choose>
			<c:when test="${list.size() != 0 }">
				<c:forEach var="member" items="${list }">
					<tr>
						<td>${member.id }</td>
						<td>${member.pwd }</td>
						<td><a href="${contextPath }/member/memberInfo_view?id=${member.id}">${member.name }</a></td>						
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="3">데이터가 존재하지 않습니다!!!</th>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3"><a href="${contextPath }/member/index">index 이동</a></td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="wrap" align="center">
		<table border="1" >
			<tr>
				<th>번 호</th>
				<th>i d</th>
				<th>제 목</th>
				<th>날 짜</th>
				<th>조 회 수</th>
				<th>image_file_name</th>
			</tr>
			<c:if test="${boardList.size() == 0 }">
				<tr>
					<td colspan="6" align="center">저장 데이터 없음</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${boardList }">
				<tr>
					<td>${dto.writeNo }</td>
					<td>${dto.id }</td>
					<td><a href="${contextPath }/board/contentView?writeNo=${dto.writeNo}"> ${dto.title }</a></td>
					<td>${dto.saveDate }</td>
					<td>${dto.hit }</td>
					<td>${dto.imageFileName }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right"><a href="${contextPath }/board/writeForm">글작성</a>
				</td>
			</tr>
		</table>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>

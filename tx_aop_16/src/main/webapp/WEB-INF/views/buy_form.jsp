<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
몇개를 구매하시겠습니까?
<form action="buy" method="post">
    <input type="text" name="num"><br>
    <input type="submit" value="구매">
    <button type="button" onclick="location.href='db_result'">
   db결과 페이지
    </button>
</form>
</body>
</html>
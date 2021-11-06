<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function init(){
		popup()
	}
	function popup(){

		var url = "popup.html";
		var name = "popup test";
		var option = "width = 500, height = 500, top = 100,
		left = 200, location = no";
		window.open(url,name,option);

</script>
</head>
<body onload="init()">cookie.jsp<br>
</body>
</html>
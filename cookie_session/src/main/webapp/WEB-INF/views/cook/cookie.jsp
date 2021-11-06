<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		var jsp = "popup";
		var name = "popup";
		var size = "width=400, height=300, left=50, top=50";
		if(${myCookie == null}){
			window.open(jsp,name,size);
		}
	}
</script>
</head>
<body onload="init()">cookie.jsp<br>

</body>
</html>
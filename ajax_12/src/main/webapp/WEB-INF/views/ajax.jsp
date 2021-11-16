<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function ajax(){
		$.ajax({
			url : "ajax_result", type : "get",
			success : function(data){
				$("#count").text(data)
				console.log("성공")
			},
			error : function(){
				alert('문제 발생!!!')
			}
		});
	}
</script>
</head>
<body>
	<h1>내용</h1>
	<h1>내용</h1>
	<h1>내용</h1>
	<h1>내용</h1>
	<button type="button" onclick="ajax()">클릭</button>
	<label id="count">0</label>
</body>
</html>
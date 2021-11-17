<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap1{
	width : 40%;
	height : 90%;
	margin : auto;
	margin-top : 10px;
	border : 1px solid black;
	padding : 15px;
	}
	h1{
	text-align : center;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input){
		var file = input.files[0]; //파일에 대한 정보
		console.log(file)
		if(file != ''){
			var reader = new FileReader();
			console.log(reader)
			reader.readAsDataURL(file); //읽고
			reader.onload = function (e){ // 로드한 값을 표현한다
				$('preview').attr('src',e.target.result);
			}
		}
	}
</script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div class="wrap1">
		<h1>글쓰기</h1>
		<form action="">
			<h3>작성자</h3>
			<input type="text" readonly value="${loginUser }"><hr>
			<h3>제목</h3>
			<input type="text" name="content"><hr>
			<h3>내용</h3>
			<textarea rows="30px" cols="70"></textarea><hr>
			<h3>이미지파일 첨부</h3>
			<input type="file" name="image_file_name" onchange="readURL(this);"/>
			<img id="preview" src="#" width="100px" height="100px" alt="선택된 이미지가 없습니다"/>
			<hr>
			<input type="submit" value="글쓰기"><input type="button" value="목록보기">
		</form>
		
	</div>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getUsers(){
		$.ajax({
			url : "users" , type : "get", dataType : "json" ,
			success : function(list){
				var html = "";
				/*
				for(var i=0; i<list.length; i++){
					html += "<b>이름 : </b>" + list[i].name+"<br>"
					html += "<b>나이 : </b>" + list[i].age+"<hr>"
					//$("#users").text(html);
					//$("#users").html(html);
				}
				*/
				$.each(list,function(index, item){
					html += "<b>이름 : </b>" + item.name+"<br>"
					html += "<b>나이 : </b>" + item.age+"<hr>"
				})
					$("#users").append(html);
				// $("#users").text(list);
			}
		})
	}
	function userInfo(){
		var userId = $("#userId").val()
		$.ajax({
			url : "user/"+userId,//"user?id="+userId,
			dataType : "json",
			success : function(dto){
				var html = "";
				html += "<b>이름 : </b>"+dto.name + "<br>"
				html += "<b>나이 : </b>"+dto.age + "<br>"
				$("#users").html(html);
			}
		})
	}
	function modify(){
		let name = $("#userId1").val();
		let age = $("#userAge").val();
		console.log(name)
		console.log(age)
		let form = {name : name , age : age};
		$.ajax({
			url : "modify", type : "put", dataType : "json",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function(dto){
				var html = "";
				html += "<b>이름 : </b>"+dto.name + "<br>"
				html += "<b>나이 : </b>"+dto.age + "<br>"
				$("#users").html(html);
			}
		})
	}
	function membership(){
		/*
		let uId = $("#uId").val();
		let uName = $("#uName").val();
		let uAge = $("#uAge").val();
		let uAddr = $("#uAddr").val();
		let uPhone = $("#uPhone").val();
		let form = {uId : uId, uName : uName, uAge : uAge, uAddr : uAddr, uPhone : uPhone}
		*/
		let form = {};
		let arr = $("#fo").serializeArray();
		console.log(arr);
		
		for(i=0; i<arr.length; i++){
			form[arr[i].name ] = arr[i].value;
		}
		$.ajax({
			url : "membership",
			type : "post",
			dataType : "json",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function(data){
				if(data.result == true){
					alert('저장 되었습니다!!!');
				}
			}
		})
	}

</script>
</head>
<body>
	<span id="users"></span>
	<button type="button" onclick="getUsers()">사용자 목록 보기</button>
	<hr>
	<input type="text" id="userId"><br>
	<button type="button" onclick="userInfo()">특정 사용자 보기</button>
	<hr>
	<input type="text" id="userId1" placeholder="수정할 이름 입력"><br>
	<input type="text" id="userAge" placeholder="수정할 나이 입력"><br>
	<button type="button" onclick="modify()">사용자 수정</button>
	<h3>회원가입</h3>
	<form id="fo" action="">
		<input type="text" name="uId" id="uId" placeholder="id"><br>
		<input type="text" name="uName" id="uName" placeholder="uName"><br>
		<input type="text" name="uAge" id="uAge" placeholder="uAge"><br>
		<input type="text" name="uAddr" id="uAddr" placeholder="uAddr"><br>
		<input type="text" name="uPhone" id="uPhone" placeholder="uPhone"><br>
		<input type="button" onclick="membership()" value="회원가입"><br>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#idCheck').on('click',()=>{
			let id = $('#userId').val();
			$.ajax({
				//front.do?command=idCheck
				type: 'post',
				url: 'front.do?command=idCheck',//같은 곳에 있음
				data: {'userId': id},				
				//result값 받아서...true / false 출력
				success:function(result){
					
					alert(result);
					//resultView영역에 사용중인 id(붉은색) / 사용가능한 id(파란색)
					if(result=='true'){
						$('#resultView')
						.html('<h3><font color=crimson>'+id+' 는 사용중인 아이디입니다.</font></h3>');
					}
					else{
						$('#resultView')
						.html('<h3><font color=blue>'+id+' 는 사용가능한 아이디입니다.</font></h3>');
					}				
					
				}//callback

				
			});//ajax
		});//on		
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="register.do" method="post">
		ID <input type="text" name="id" required="required" id="userId"> 
		<input type="button" value="중복확인" id="idCheck">
		<span id="resultView"></span>
		<br>
 		PASS <input type="password" name="password" required="required"><br> 
		NAME <input	type="text" name="name"><br>
		ADDR <input type="text"	name="address"><br>
		<input type="submit" value="Register"><br>
	</form>
</body>
</html>
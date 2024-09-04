<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멍프렌즈 홈페이지 :: 회원가입</title>
</head>
<body>
<h1>회원가입</h1>

<form action="front.do?command=register" method="post">
	아이디 <input type="text" name="userId" id="userId" required="required"><br>
	패스워드 <input type="text" name="userId" id="userId" required="required"><br>
	닉네임 <input type="text" name="userId" id="userId" required="required"><br>
	핸드폰번호 <input type="text" name="userId" id="userId" required="required"><br>
	주소 <input type="text" name="userId" id="userId" required="required"><br>
	
	<input type="submit" value="회원가입"> 
</form>

</body>
</html>
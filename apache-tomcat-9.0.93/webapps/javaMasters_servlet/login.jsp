<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멍프렌즈 홈페이지 :: LOGIN</title>
</head>
<body>
<form action="front.do?command=login" method="post">
	ID <input type="text" name="userId" id="userId" required="required" ><br>
	PASSWORD <input type="password" name="Password" id="Password" required="required"><br>
	<input type="submit" value="입장하기">
</form>
</body>
</html>
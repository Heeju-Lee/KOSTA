<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>ȸ������</h2>
	<form action="front.do" method="post">
	<input type="hidden" name="command" value="register">
		ID <input type="text" name="id" required="required"> <br>
		PASS <input type="password" name="password" required="required"><br> 
		NAME <input	type="text" name="name"><br>
		ADDR <input type="text"	name="address"><br>
		<input type="submit" value="Register"><br>
	</form>
</body>
</html>
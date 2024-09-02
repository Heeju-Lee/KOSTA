<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form값을 EL로 받아오기</h2>
<form action="el2_view.jsp" method="post">
	ID <input type="text" name="myId"><br><br>
	<strong>좋아하는 메뉴를 선택...</strong><br><br>
	<input type="checkbox" name="menu" value="spagetii">spagetii
	<input type="checkbox" name="menu" value="curry">curry
	<input type="checkbox" name="menu" value="noodle">noodle
	<input type="checkbox" name="menu" value="coffee">coffee
	
	<input type="submit" value="DataSend">

</form>
</body>
</html>
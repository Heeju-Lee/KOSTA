<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align: center;
	}
	h1{
		color: crimson;
	}

</style>
</head>
<body>
	<h2>${param.id}���� �α��� �Ǿ����ϴ�!!!</h2>
	<br><br><br>
	<div>
		<a href="./book/Book.html">���� ���</a><br>
		<a href="#">�α׾ƿ�</a>
	</div>
</body>
</html>
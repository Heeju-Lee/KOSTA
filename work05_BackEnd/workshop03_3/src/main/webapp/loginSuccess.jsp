<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
/* 자바 코드만 입력함.... */
User user = (User) request.getAttribute("user");//casting 필요
%>
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
	<h2><%=user.getId()%>님이 로그인 되었습니다!!!</h2>
	<br><br><br>
	<div>
		<a href="#">도서 등록</a><br>
		<a href="#">로그아웃</a>
	</div>
</body>
</html>
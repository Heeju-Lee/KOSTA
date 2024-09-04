<%@page import="web.servlet.model.User"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align: center;
	}
</style>
</head>
<body>
<br>
<h1>${vo.name} 님이 로그인 되었습니다.!!!</h1>
<br>
<a href="./book/Book.html">도서등록</a><br><br>
<a href="front.do?command=logout">로그아웃</a><br><br>
<a href="${pageContext.request.contextPath}/front.do?command=bookList">도서목록</a>

</body>
</html>




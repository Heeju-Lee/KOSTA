<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

*{
	text-align: center;
}

</style>
</head>
<body>
<h1>결과페이지</h1>
<br>
<%=request.getParameter("bookTitle") %>이 정상적으로 등록되었습니다.
<br>
<a href="Book.html">추가 등록</a>
<a href="booklist.jsp">도서목록</a>
</body>
</html>
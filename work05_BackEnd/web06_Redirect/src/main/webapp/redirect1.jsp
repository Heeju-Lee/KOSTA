<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String url = "https://search.naver.com/search.naver?";
String word = request.getParameter("word");

url += "query="+word;

//페이지 이동
response.sendRedirect(url);
%>

<h2>redirect1.jsp의 body 입니다.</h2>

</body>
</html>
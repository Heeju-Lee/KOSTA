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

//������ �̵�
response.sendRedirect(url);
%>

<h2>redirect1.jsp�� body �Դϴ�.</h2>

</body>
</html>
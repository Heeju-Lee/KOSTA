<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	/* 자바 코드만 입력함.... */
	Member mem = (Member)request.getAttribute("mem");//casting 필요
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%= mem.getAddress()%>에 거주하는 멤버의 정보입니다.</h2>
<p></p>
이름 : <%=mem.getName() %><br>
나이 : <%=mem.getAge() %><br>
</body>
</html>
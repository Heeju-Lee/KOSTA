<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
Member vo = (Member) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 검색 결과</h2>
	<h3><%=request.getParameter("id")%>님에 대한 정보입니다.
	</h3>
	<hr>
	이름
	<%=vo.getName()%><br>
	주소
	<%=vo.getAddress() %>
</body>
</html>
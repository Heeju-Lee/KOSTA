<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
/* �ڹ� �ڵ常 �Է���.... */
User user = (User) request.getAttribute("user");//casting �ʿ�
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align: center;"><%=user.getId()%>���� �α��� �Ǿ����ϴ�!!!</h2>
	<br><br><br>
	<div style="text-align: center;">
		<a href="">���� ���</a><br>
		<a href="">�α׾ƿ�</a>
	</div>
</body>
</html>
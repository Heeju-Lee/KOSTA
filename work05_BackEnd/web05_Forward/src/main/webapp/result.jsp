<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	/* �ڹ� �ڵ常 �Է���.... */
	Member mem = (Member)request.getAttribute("mem");//casting �ʿ�
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><%= mem.getAddress()%>�� �����ϴ� ����� �����Դϴ�.</h2>
<p></p>
�̸� : <%=mem.getName() %><br>
���� : <%=mem.getAge() %><br>
</body>
</html>
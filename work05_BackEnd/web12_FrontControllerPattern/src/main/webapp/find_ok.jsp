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
	<h2>ȸ�� �˻� ���</h2>
	<h3><%=request.getParameter("id")%>�Կ� ���� �����Դϴ�.
	</h3>
	<hr>
	�̸�
	<%=vo.getName()%><br>
	�ּ�
	<%=vo.getAddress() %>
</body>
</html>
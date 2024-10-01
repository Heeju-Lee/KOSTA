<%@page import="web.servlet.model.Member"%>
<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	Member vo = (Member) session.getAttribute("vo"); 
	if(vo==null){
%>
	<h4>로그인부터 다시 해주세요.</h4>
	<a href="index.html">HOME</a>
<%
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID <%= vo.getId() %><br>
NAME <%= vo.getName() %><br>
ADDRESS <%= vo.getAddress() %><br>
<p></p><hr><p></p>
<a href="logout.jsp">Log Out</a>
<a href="index.html">INDEX</a>

</body>
</html>
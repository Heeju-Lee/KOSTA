<%@page import="web.servlet.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="400px" bgcolor="yellow" align="center">
<c:forEach items="${list}" var="vo"> 
	<tr>
		<td>%{vo.id}</td>
		<td>%{vo.name}</td>
		<td>%{vo.address}</td>
	</tr>
</c:forEach>
</table>
<p></p>
<h3 align="center"><a href="index.jsp">INDEX..</a></h3>
</body>
</html>
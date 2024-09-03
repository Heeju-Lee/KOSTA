<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 검색 결과</h2>
	<h3>${param.id}님에 대한 정보입니다.
	</h3>
	<hr>
	이름
	${vo.name}<br>
	주소
	${vo.address}
</body>
</html>
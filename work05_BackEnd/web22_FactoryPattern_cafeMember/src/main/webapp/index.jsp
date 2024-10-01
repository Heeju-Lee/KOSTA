<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">

a:HOVER{
	color: crimson;
}

</style>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h2>Cafe Member Manage.. Using Factory Method Pattern</h2>
		<p></p>
		<p><a href="find.jsp">회원 검색</a></p>
		
		<c:choose>
			<c:when test="${!empty vo}">
				<p><a href="logout.jsp">로그아웃 하기</a></p><!-- 서블릿으로 바로 보냄 -->
				<p><a href="allMember.do">전체 회원 검색</a></p><!-- 서블릿으로 바로 보냄 -->
				<p><a href="update.jsp">회원 정보 수정하기</a></p>
			</c:when>
			<c:otherwise>
				<p><a href="register.jsp">회원 가입</a></p>
				<p><a href="login.jsp">로그인 하기</a></p><!-- 서블릿으로 바로 보냄 -->
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
	$(function(){
		$('#enterBtn').on('click',()=>{
			location.href="home.jsp";
		})//on
	});//ready
</script>
<style type="text/css">
*{
	text-align: center;
}
</style>
<title>&#128054;멍프렌즈 홈페이지 :: OPENING</title>
</head>
<body>
	<div class="container">
		<header>
			<h6>&#128062;강아지 집사 대표 커뮤니티&#128062;</h6>
			<h2>멍프렌즈에 오신걸 환영합니다.&#128054;</h2>
			<hr>
		</header>
		<c:choose>
			<c:when test="${empty vo}">
				<c:import url="login.jsp"></c:import>
				<h6>
					<a href="register.jsp">회원가입</a>
				</h6>
			</c:when>
			<c:otherwise>
				<c:import url="loginSuccess.jsp"></c:import>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
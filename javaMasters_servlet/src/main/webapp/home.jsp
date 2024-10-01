<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<style type="text/css">
*{
	margin: 0 auto;
}
</style>
<title>&#128054;멍프렌즈 홈페이지 :: HOME</title>
</head>
<body>
	<div class="container">
		<header>
			<h6 align="right">
				<a href="front.do?command=logout">로그아웃</a>
			</h6>
			<hr>
		</header>
		<h2>&#128101;댕댕집사 와글와글</h2>
		<hr>
		<div align="right">
			<button class="btn btn-warning"
				onclick="location.href='writePost.jsp'">게시글 등록하기</button>
		</div>
		<c:import url="boardList.jsp"></c:import>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$('#enterBtn').on('click',()=>{
			location.href="home.jsp";
		})//on
	});//ready
</script>
</head>
<body>
	<div class="container">
		<header>
			<h6 align="right">
				<a href="front.do?command=logout">로그아웃</a>
			</h6>
		<hr>
		</header>
		<h4>${vo.nickName}님
			반가워요&#128080;<br>멍프렌즈에 입장하시려면 '입장하기' 버튼을 눌러주세요.
		</h4>
		<button id="enterBtn" class="btn btn-primary"">입장하기</button>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		var f=confirm("로그아웃 하시겠습니까?");
		if(f)
			location.href="logout.do"; 
	}
</script>
<style type="text/css">
.container{
	width: 980px;	
}
	form{
		width: 500px;
		border: 12px solid MediumSeaGreen;
		border-radius: 40px;
		padding: 20px;
		margin-left: 250px;
	}
</style>
</head>
<body>
<div class="container">
<div class="jumbotron text-center">
	<h2>Board Write, Update, Delete, Select</h2>
</div>
<c:choose>
<c:when test="${empty mvo}">
	<form method="post" action="login.do">		
	  	<div class="form-group">
		  	<label for="id">ID:</label>
		  	<input type="text" name="id" placeholder="Enter ID">
	  	</div>
	   	<div class="form-group">
		  	<label for="pass">PASSWORD:</label>
		  	<input type="password" name="password" placeholder="Enter password">
	  	</div>		
		<button type="submit" class="btn btn-primary">LOGIN</button>	
		<a href="list.do"><button class="btn btn-primary" border="0">LIST</button></a>
	</form>
</c:when>
<c:otherwise>
	${mvo.name} 님은 로그인 상태입니다..<br><br>
	<a href="javascript:logout()">로그아웃</a><p><hr>
	<a href="board/write.jsp"><img alt="게시판 글쓰기" src="img/write_btn.jpg" border="0"></a>
	<a href="list.do"><img src="img/list_btn.jpg" border="0"></a>
</c:otherwise>
</c:choose>
</div>
</body>
</html>

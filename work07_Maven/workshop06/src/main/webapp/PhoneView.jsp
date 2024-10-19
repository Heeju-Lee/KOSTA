<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<form>
		<label for="num">모델번호</label>
		<input type="text" value="${phone.num}" name="num">
		<br>
		<label for="model">모델명</label>
		<input type="text" value="${phone.model}" name="model">
		<br>
		<label for="price">가격</label>
		<input type="number" value="${phone.price}" name="price">
		원 <br>
		<label for="vcode">제조사</label>
		<input type="text" value="${phone.company.vendor}" name="model">
		<br> 
		<a href="searchPhone.do"> <input type="button" value="목록 보기">
		</a>

	</form>
</body>
<script>
	
</script>
</html>
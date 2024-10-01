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
<title>Insert title here</title>
<style type="text/css">
a {
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<h1 style="color: crimson; margin: 20px 10px; text-align: center;">장바구니</h1>
		<a href="itemList.do">쇼핑 계속하기</a> <br>
		<table class="table table-striped">
			<tr style="text-align: center">
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th><button onclick="#" class="btn btn-light">삭제</button></th>
			</tr>

			<c:if test="${empty localStorage.getItem('이름')}">
				<tr style="text-align: center">
					<td colspan="6"><h6 style="color: crimson">장바구니에 등록된 상품이
							없습니다.</h6></td>
				</tr>
			</c:if>
			<c:if test="${not empty localstoragekey}">
				<c:forEach items="fruits" var="fruitInfo">
					<tr>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><input type="number"> </td>
						<td><input type="checkbox"></td>
					</tr>
				</c:forEach>
				<tr style="text-align: right">
					<td colspan="6">총 결제금액: 0000000</td>
				</tr>
			</c:if>

		</table>
	</div>
</body>
</html>
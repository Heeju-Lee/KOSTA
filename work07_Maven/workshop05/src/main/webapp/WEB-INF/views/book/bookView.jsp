<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, h1, h4, p {
	text-align: center;
}

#bookTable {
	margin: 0px auto;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable td:first-child {
	text-align: center;
	background-color: lightgray;
}

#bookTable td:nth-child(2) {
	width: 500px;
}
</style>
</head>
<body>
	<h1>입력된 도서 정보</h1>
	<c:if test="${not empty user}">
		<h4>${user.name}
			님 로그인 되었습니다. <a href="memberLogout.do">로그아웃</a>
		</h4>
	</c:if>
	<table id="bookTable">
		<tr>
			<td colspan="2">도서 정보</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<td>도서분류</td>
			<td>${book.catalogue}</td>
		</tr>
		<tr>
			<td>도서국가</td>
			<td>${book.nation}</td>
		</tr>
		<tr>
			<td>출판일</td>
			<td>${book.publishDate}</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${book.publisher}</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td>도서가격</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td>도서설명</td>
			<td>${book.description}</td>
		</tr>
	</table>
	<p>
	</p>
</body>
</html>
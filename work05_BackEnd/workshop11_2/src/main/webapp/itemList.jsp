<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align: center;
	color: royalblue;
}

#container {
	display: flex;
	justify-content: center;
}

#container>div {
	float: left;
	margin-right: 5px;
}

#container img {
	width: 150px;
	height: 150px;
	border: 4px solid DodgerBlue;
	border-radius: 8px;
}

#container img:hover {
	border: 6px solid crimson;
	cursor: pointer;
}

#productView {
	text-align: center;
}

table {
	border-radius: 10px;
	border: 6px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Fruit Total List 2.</h1>
	<div id="container">
		<c:forEach items="${list}" var="fruit">
			<div>
				<a href="itemView.do?itemnumber=${fruit.itemNumber}"><img
					src="${fruit.url}"></a>
				<p>상품명 : ${fruit.name}</p>
				<p>가 격 : ${fruit.price}원</p>
			</div>
		</c:forEach>
	</div>
	<div>
		<!-- 오늘 본 상품정보를 여기다가 출력 :: 만약에 오늘 본 상품정보가 존재한다면 출력 -->
		<c:if test="${not empty fruits}">
			<h2 align="center"><font color="#708090">오늘 본 상품들</font></h2><br>
			<table align="center" bgcolor="#B0C4DE">
				<tr>
					<c:forEach items="${fruits}" var="fruit">
						<td>
							<img alt="" src="${fruit}" width="100px" height="100px">
						</td>
					</c:forEach>
				</tr>
			</table>
		</c:if>
	</div>
</body>
</html>
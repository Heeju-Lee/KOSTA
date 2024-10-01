<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 오늘날짜 -->
<!-- Set current date -->
<c:set var="ymd" value="<%=new java.util.Date()%>" />

<!-- Format the current date -->
<fmt:formatDate value="${ymd}" pattern="yyyy-MM-dd" var="today" />


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
</head>
<body>
	<div class="container">
		<div align="right">
			<button class="btn btn-warning"
   				 onclick="location.href='updatePost.jsp'">수정하기</button>
			<button class="btn btn-warning"
				onclick="location.href='front.do?command=deletePost'">삭제하기</button>
			<hr>
		</div>
		<div align="center">
			<div class="row">
				<form method="post" action="front.do?command=writeBoard">
					<table class="table table-striped"
						style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="6"
									style="background-color: #eeeeee; text-align: center;">&#128266;집사들의 이야기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>카테고리</td>
								<td>${avo.category}</td>
								<td>작성일자</td>
								<td>${avo.writeDate}</td>
								<td>작성자</td>
								<td>${avo.nickName}</td>
							</tr>
							<tr>
								<td>글제목</td>
								<td colspan="5">${avo.title}</td>
							</tr>
							<tr>
								<td>내용</td>
								<td colspan="5">${avo.content}</td>
							</tr>
							<tr>
								<td>첨부</td>
								<td colspan="5"><img src="${avo.imgFileName}" alt="이미지" /></td>
							</tr>
						</tbody>
					</table>
					<div id="button" align="center">
						<button class="btn btn-outline-dark"
							onclick="location.href='front.do?command=like'">좋아요&#128536;</button>
						<button class="btn btn-outline-dark"
							onclick="location.href='front.do?command=hate'">싫어요&#128545;</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
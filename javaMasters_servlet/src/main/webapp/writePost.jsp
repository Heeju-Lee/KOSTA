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
<style type="text/css">
* {
	margin: 0 auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header>
			<h6 align="right">
				<a href="front.do?command=logout">로그아웃</a>
			</h6>
			<hr>
		</header>
		<div class="row">
			<form method="post" action="front.do?command=writePost">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="6"
								style="background-color: #eeeeee; text-align: center;">&#128066;집사님들의
								이야기를 들려주세요</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>카테고리</td>
							<td><select name="category">
									<option value="가입인사">가입인사</option>
									<option value="일상">일상</option>
									<option value="오산완">오산완</option>
									<option value="경험/후기">경험/후기</option>
							</select></td>
							<td>작성일자</td>
							<td><input type="text" name="writeDate" value="${today}"
								readonly="readonly"></td>
							<td>작성자</td>
							<td><input type="text" name="nickName"
								value="${vo.nickName}" readonly="readonly"></td>
						</tr>
						<tr>
							<td>글제목</td>
							<td colspan="5"><input type="text" class="form-control"
								placeholder="제목을 입력해주세요" name="title" maxlength="50"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="5"><input type="text" class="form-control"
								placeholder="내용을 입력해주세요" name="content" maxlength="2048"
								style="height: 350px;"></td>
						</tr>
						<tr>
							<td>첨부</td>
							<td colspan="5"><input type="text" class="form-control"
								name="imgFileName" placeholder="이미지링크를 넣어주세요" value="/image/image.png""></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary" value="글쓰기">
			</form>
		</div>
	</div>
</body>
</html>
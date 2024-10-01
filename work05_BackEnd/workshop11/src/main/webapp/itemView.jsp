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
<title> 상품 :: 상세페이지 </title> 
<style type ="text/css">
.main{
	display: flex;
	flex-direction: column;
	padding: 0px 50px;
}
.header{
	margin-top: 50px;
	text-align: center;
	font-weight: 100;
	margin-bottom: 20px;
}
.nav{
	background: orange;
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	margin-bottom: 20px;
	padding: 15px 10px;
}
.nav div{
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	margin-left: 30px;
}
.item{
	display: flex;
	flex-direction: row;
}
.listView{
	text-align: center;
	text-decoration: underline;
	margin-top: 10px;
}
#itemImg img{
	width:400px;
	height: 400px;
	border: 1px solid lightgray;
	border-radius: 20px;  
}
#detail{
	margin-left: 20px;
	margin-bottom: 20px;
}

</style>
</head>
<body>
	<div class="main">
		<div class="header">
			<h2 align="center">${vo.name}의정보</h2>
		</div>
		<div class="nav">
			<div>조회수 : ${vo.count}</div>
			<div>
				<a href="#">장바구니 담기</a>
			</div>
			<div>
				<a href="">장바구니 확인</a>
			</div>
		</div>
		<div class="item">
			<div id="itemImg">
				<img src="${vo.url}" alt="${vo.name} 이미지" />
			</div>
			<div id="itemDetails">
				<div id="detail">이름 : ${vo.name}</div>
				<div id="detail">가격 : ${vo.price}</div>
				<p />
				<p />
				<p />
				<div id="detail">설명 : ${vo.description}</div>
			</div>
		</div>
		<div class="listView">
			<h6>
				<a href="itemList.do">상품 목록 보기</a>
			</h6>
		</div>
	</div>
</body>
</html>
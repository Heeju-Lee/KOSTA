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
<title>상품 :: 전체리스트</title>
<style type="text/css">
h1 {
	margin-top: 50px;
	color: skyblue;
	text-align: center;
}

.itemImg, .itemName, .itemPrice {
	width: 200px;
	text-align: center;
}

.itemImg img {
	width: 200px;
	height: 200px;
}

.items {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	padding: 10px;
	box-sizing: border-box;
	margin: 0 auto;
}

.item {
	display: flex;
	flex-direction: column;
	margin: 10px;
	border: 0.5px solid lightgray;
	border-radius: 9px;
	padding: 5px;
}
</style>
</head>
<body>
	<h1>Fruits Total List 1.</h1>
	<!-- foreach -->
	<div class="items">
		<c:forEach items="${list}" var="fruit">
			<div class="item">
				<div class="itemImg">
					<img src="${fruit.url}" alt="${fruit.itemNumber}"
						data-itemnumber="${fruit.itemNumber}">
				</div>
				<div class="itemName">
					<h4>${fruit.name}</h4>
				</div>
				<div class="itemPrice">
					<h4>${fruit.price}</h4>
				</div>
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.itemImg img').on('click', function() {
				var id = $(this).data('itemnumber');
				window.location.href = 'itemView.do?itemNumber='+id;
			});//on
		});//ready
</script>
</body>
</html>
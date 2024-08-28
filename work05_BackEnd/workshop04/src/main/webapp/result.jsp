<%@page import="web.servlet.model.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% Product product = (Product) request.getAttribute("product"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>상품이 저장되었습니다.</h1>

<b>상품번호</b> <%= product.getProductNum()%><br>
<b>상품명</b> <%= product.getName()%><br>
<b>상품가격</b> <%= product.getPrice()%><br>
<b>상품설명</b> <%= product.getDesc()%><br><br>
<br>
<hr>
<a href="List">상품목록</a>

</body>
</html>
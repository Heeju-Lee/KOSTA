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
<h1>��ǰ�� ����Ǿ����ϴ�.</h1>

<b>��ǰ��ȣ</b> <%= product.getProductNum()%><br>
<b>��ǰ��</b> <%= product.getName()%><br>
<b>��ǰ����</b> <%= product.getPrice()%><br>
<b>��ǰ����</b> <%= product.getDesc()%><br><br>
<br>
<hr>
<a href="List">��ǰ���</a>

</body>
</html>
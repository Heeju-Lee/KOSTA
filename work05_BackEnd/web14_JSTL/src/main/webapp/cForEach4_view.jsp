<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>우리 가게에서 판매되는 과일들입니다.</h2>
<c:forEach items="${list}" var="item">
 	<li style="list-style: square;">${item}</li>
</c:forEach>
</body>
</html>
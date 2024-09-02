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
<h2>c:forEach문 사용하기</h2>
<c:forEach var="cnt" begin="1" end="7">

	<font size="${cnt}">Hello Nice Day~~~~~~!!! <br>
	
</c:forEach>
</body>
</html>
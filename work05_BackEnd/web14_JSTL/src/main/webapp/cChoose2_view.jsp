<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:choose 문법 사용하기 :: 양자택일... 또다른 조건을 부여할 때</h2>
	<c:choose>
		<c:when test="${param.NUM=='100'}">
			<B>자동차세 100만원이 입금되었습니다.</B>
		</c:when>

		<c:when test="${param.NUM=='200'}">
			<B>재산세 200만원이 입금되었습니다.</B>
		</c:when>
		<c:otherwise>
			<B>고객님, 입금액을 다시한번 확인해주세요.</B>
		</c:otherwise>


	</c:choose>


</body>
</html>
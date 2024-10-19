<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  user 정보 여부에 따라서 회원가입(회원정보가 아직 없음) | 도서등록(회원 정보 있음) 양갈래로 유도한다..-->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;

a {
	margin: 10px;
}
</style>
</head>
<body>
<h1>메인 페이지</h1>
<p/>
<h4>${msg}</h4>
<c:choose>
	<c:when test="${empty user}">
		<!-- 정적인 문서를 해당 위치에 include 시킴 -->
		<jsp:include page="login.html" />
		<h4><a href="member/member.jsp">회원 가입</a>   <a href="bookList.do">도서 목록</a></h4>
	</c:when>	
	<c:otherwise>
	    <h4><a href="bookForm.jsp">도서 등록</a>   <a href="bookList.do">도서 목록</a></h4>
	</c:otherwise>
</c:choose>	    
</body>
</html>





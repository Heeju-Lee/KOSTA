<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/basic.css" rel="stylesheet" type="text/css">
<c:if test="${!empty loginUser}">
	<div>
		${loginUser.id} 님 로그인 되었습니다. &nbsp;&nbsp;&nbsp; <a href="logout.do">로그아웃</a>
	</div>
</c:if>

<h2><b>${title}</b></h2>

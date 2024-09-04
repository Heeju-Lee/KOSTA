<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function logout(){
		alert("이용해주셔서 감사합니다.");
	}
</script>

</head>
<body onload="return logout()">
	<b>로그아웃 되었습니다.</b><br>
	<a href="index.jsp">처음 화면으로</a>
</body>
</html>
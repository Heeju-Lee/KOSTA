<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element로 받아오기 : </b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= session.getAttribute("RESULT2") %><br>
<hr>
<b>2. JSP EL 받아오기 : </b><br>
1) ${RESULT1}<br>
2) ${RESULT2}<br>
3) ${RESULT1+50}<br>
</body>
</html>
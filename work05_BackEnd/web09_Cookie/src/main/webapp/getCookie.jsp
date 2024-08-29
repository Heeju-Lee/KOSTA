<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>브라우저에 저장된 모든 쿠키 정보를 받아옵니다. :: request.getCookies()</h2>

<% 
 Cookie[] cs = request.getCookies();

	for(Cookie c : cs){
%>
	<ul>
		<li>Cookie Name<%= c.getName()%></li>
		<li>Cookie Value<%= c.getValue()%></li>
	</ul>
<%		
	}
%>
</body>
</html>
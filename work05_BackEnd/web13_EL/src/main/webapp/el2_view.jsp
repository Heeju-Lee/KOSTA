<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element 사용하기</b>
<%= request.getParameter("myId") %>
<hr>
<b>2. JSP EL 사용하기</b>
${param.myId}
<hr>
<b>3. JSP Menu에 해당하는 값 element로 받아오기</b>
<%
	String[] menus =  request.getParameterValues("menu");
	for(String menu : menus){
%>
	<b><%=menu %></b>
<%		
	}
%>

<hr>
<b>4. JSP Menu에 해당하는 값 EL로 받아오기</b>
선택한 메뉴 :: 
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}

</body>
</html>
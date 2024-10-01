<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 값 EL로 받아오기</h2>
<h3>해당 JSP 파일은 서블릿으로 생각해주세요...</h3>
<%
	int sum = 0;
	for(int cnt=0; cnt <=50; cnt++) sum += cnt; // 5050
	
	//바인딩
	request.setAttribute("RESULT1", sum);
	session.setAttribute("RESULT2", "SESSION");
	
	//네비게이션
	
	request.getRequestDispatcher("el1_view.jsp").forward(request,response);
%>
</body>
</html>
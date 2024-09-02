<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ArrayList를 cForEach 로 다뤄보기</h2>
<%
ArrayList<String> list=  new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Grape");
list.add("Orange");
list.add("Melon");

request.setAttribute("list", list);

%>
<jsp:forward page="cForEach4_view.jsp" />
</body>
</html>




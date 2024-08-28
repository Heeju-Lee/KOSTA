<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ConnectionPool Test.......Using JNDI Service</h2>
<%
	Context ic = new InitialContext();
	DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
	
	out.println("<b>1. DataSource Lookup.....</b>");

	Connection conn = ds.getConnection();
	out.println("<br><b>2. Connection Rent Success.....</b>");
	

%>
</body>
</html>
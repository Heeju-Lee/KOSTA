<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ȸ�� �˻�(�ܼ��˻�)</h2><!-- ��ǥ���� �� -->
<form action="front.do" method="post"><!-- ���⼭ �������� ����, id�� �����ű� ������ post-->
	<input type="hidden" name="command" value="find">
	��ȸID<input type="text" name="id" required="required">
	<input type="submit" value="ȸ���˻�">
</form>
</body>
</html>
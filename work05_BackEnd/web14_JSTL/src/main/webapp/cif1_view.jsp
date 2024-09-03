<!-- 
만약에 폼값에 입력된 숫자가 100이면
자동차세 100만원 입금되었습니다...

만약에 폼값에 입력된 숫자가 200이면
보증금 200만원 입금되었습니다..

JSTL IF문으로 작성..

1) jar파일 2개가 필요함(jstl.jar, standard.jar)
2) tag lib 선언문이 필요 

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>jstl의 if를 다뤄보자</h2>
<c:if test="${param.NUM=='100'}">
	<B>자동차세 100만원이 입금되었습니다.</B><BR>
</c:if>

<c:if test="${param.NUM=='200'}">
	<B>재산세 200만원이 입금되었습니다.</B><BR>
</c:if>
</body>
</html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
	<HEAD>
		<TITLE>결과화면</TITLE>
		<META http-equiv="Content-Type" content="text/html;charset=utf-8">
		<style type="text/css">
		 h1, h3, td, h4{
		 	text-align: center;
		 }
		</style>
	</HEAD>
	<BODY BGCOLOR="#FFFFFF" leftmargin="0" topmargin="0" marginwidth=0 marginheight=0>
<c:if test="${not empty user }">

<h4>${user.name} 님 로그인 되었습니다. <a href="memberLogout.do">로그아웃</a></h4>
</c:if>
    <h1> 결과 페이지 </h1>
	<h4>${msg}</h4>
	<br>
	<Table cellpadding="0" cellspacing="1" border="0" width="650" bgcolor="#EAEAEA" align="center">
		<tr>
			<td  height="30" valign="middle">
			<!-- 중요 -->
				<a href="bookForm.jsp">추가 등록</a> &nbsp;&nbsp;<a href="bookList.do">도서목록</a>
			</td>
		</tr>
	</table>		
	</BODY>
</HTML>
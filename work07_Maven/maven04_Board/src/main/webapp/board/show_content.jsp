<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script type="text/javascript">
	function deleteBoard() {
		if(confirm("해당 글을 삭제 하시겠습니까?")){
			location.href="delete.do?no= ${bvo.no}";
		}
	}//deleteBoard
	
	
	function updateBoard() {
		if(confirm("해당 글을 정말 수정하시겠습니까?")){
			location.href="updateView.do?no=${bvo.no}";
		}
	}//	updateBoard
</script>
</head>
<body>
	<table cellpadding="5">
		<tr>
		   <td>
		   	    <table width="550">
					<tr>
						<td><b>글번호 : ${bvo.no} |
							   타이틀 : ${bvo.title}</b>
						<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<tr>
						<td>작성자 :  ${bvo.member.name} |
							작성일시 : ${bvo.writeDate}
							Count : ${bvo.count}
						</td>
					</tr>
					<tr>
						<td>
						<hr style="color: #6691BC; margin: 0">
						<pre>${bvo.content}</pre>					
						</td>
					</tr>
					<tr>
						<td valign="middle">
						<a href="list.do">
						<img alt="전체글목록" src="${pageContext.request.contextPath}/img/list_btn.jpg" border="0">
						</a>						
					
						<c:if test="${bvo.member.id == mvo.id }">
							<img alt="삭제" src="${pageContext.request.contextPath}/img/delete_btn.jpg" border="0" onclick="deleteBoard()">
							<img alt="삭제" src="${pageContext.request.contextPath}/img/modify_btn.jpg" border="0" onclick="updateBoard()">
						</c:if>
						</td>
					</tr>
				</table> 	
			</td>
		</tr>
	</table>	
</body>
</html>











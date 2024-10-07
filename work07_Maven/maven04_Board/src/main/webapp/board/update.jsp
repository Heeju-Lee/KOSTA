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
<form method=post action="updateBoard.do">	
<table cellpadding="5">
	<tr>
		<td>
			<table width="550">
				<tr>
					<td>
					<b>글번호: <input type=text name=no value=${bvo.no } readonly></input>
					| 타이틀:<input type=text name=title value=${bvo.title }></input></b>
					<hr style="color:#6691BC;border-style:dotted;margin: 0">
					</td></tr><tr>	<td>
						<font size="2">작성자: <input type=text name=writer 
						value=${bvo.member.name }  readonly></input>| 
						작성일시:${bvo.writeDate } 
					</font>
					</td>
				</tr>

				<tr>
					<td>
						<hr style="color:#6691BC;margin: 0">
						<textarea rows="15" cols="75" name="content">${bvo.content }</textarea>
					</td>
				</tr>
				<tr>
					<td valign="middle">						
					<input type="submit" value="수정하기"	></input>			
					</td>				
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>	
</body>
</html>











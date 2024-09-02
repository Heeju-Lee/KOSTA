<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">도서 목록 화면</h1>
<div style="float: right;">
	<form action="front.do?command=search">
		<select>
			<option value="all">전체</option>
			<option value="title">도서명</option>
			<option value="publisher">출판사</option>
			<option value="price">가격</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</div>	
<br>
<div>
  <table>
    <tr>
      <th>도서번호</th>
      <th>도서명</th>
      <th>도서분류</th>
      <th>저자</th>
    </tr>
    
	<c:forEach items="${list}" var="item">
	    <tr>
	      <td>${list.isbn}</td>
	      <td>${list.title}</td>
	      <td>${list.catalogue}</td>
	      <td>${list.price}</td>
	    </tr>
    </c:forEach>
    <tr>
      <td>11/14</td>
      <td>박수진</td>
      <td>여</td>
    </tr>
  </table>
</div>

</body>
</html>
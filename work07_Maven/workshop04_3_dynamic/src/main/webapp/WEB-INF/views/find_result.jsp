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
<c:choose>
    <c:when test="${not empty list}">
        <h3>검색 결과</h3>
        <table style="border:1px solid lightgray;" >
            <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>제조사</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${list}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.maker}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <h3>검색 결과</h3>
        <p>검색 결과가 없습니다.</p>
    </c:otherwise>
</c:choose>
</body>
</html>
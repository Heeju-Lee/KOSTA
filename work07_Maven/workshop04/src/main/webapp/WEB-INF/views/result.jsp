<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>결과페이지 :: </title>
</head>
<body>
<!-- 등록된 상품 결과 -->
<c:if test="${not empty myProduct}">
    <h3>등록된 상품 정보</h3>
    <ul>
        <li>상품명: ${myProduct.name}</li>
        <li>제조사: ${myProduct.maker}</li>
        <li>가격: ${myProduct.price}</li>
    </ul>
</c:if>

<!-- 검색 결과 -->
<c:choose>
    <c:when test="${not empty productList}">
        <h3>검색 결과</h3>
        <table style="border:1px solid lightgray;" >
            <thead>
            <tr>
                <th>상품명</th>
                <th>제조사</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${productList}">
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
        <p>검색 결과가 없습니다.</p>
    </c:otherwise>
</c:choose>

</body>
</html>




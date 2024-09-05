<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
        h1 {
            text-align: center;
        }
        form {
            text-align: right;
            margin-right: 438px;
        }
        table {
            width: 800px;
            margin: 20px auto;
        }
        tr {
            height: 43px;
        }
        th{
            background: #ddd;
        }
        .center{
        	margin-left: 740px;
        	padding-top: 30px;
        }
        .booktitle{
            text-decoration: underline;
        	color: blue;
        }
        #detail{
        	text-align: center;
        	color: crimson;
        	font-weight: bold;
        }
        h4{
        	margin-left: 450px;
        
        }
        
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
   <script type="text/javascript">
        $(function(){
            $('.booktitle').on("mouseover", function(){
                let isbn = $(this).attr('id');
                $.ajax({
                    type: 'POST',
                    url: 'details.do',
                    data: {'bookisbn': isbn},
                    success: function(result){
                        $('#detail').text(result);
                    }//callback
                 });//ajax
            });//on
        });//ready
    </script>
</head>
<body>
    <h1>도서 목록 화면</h1>
    
    <!-- 인증된 사용자가 보는 화면 -->
    <c:if test="${not empty vo}">
    	<h4>${vo.name}님이 로그인 되셨습니다.
    	<a href="logout.do">로그아웃</a></h4>
    </c:if>
    
    <c:if test="${empty vo}"></c:if>
    <form action="${pageContext.request.contextPath}/search.do">
        <select name="searchSelect">
            <option disabled selected>전체</option>
            <option value="title">도서명</option>
            <option value="catalogue">도서분류</option>
            <option value="author">저자</option>
        </select>
        <input type="text" name="searchText">
        <input type="submit" value="검색">
    </form>
    <table border="1" style="text-align: center">
        <tr>
            <th>도서번호</th>
            <th>도서명</th>
            <th>도서분류</th>
            <th>저자</th>
        </tr>
        <c:choose>
        	<c:when test="${list.size()==0}">
        		<tr>
        			<td colspan="4" style="text-align: center; color: red"><b>등록되어있는 책 정보가 없습니다.</b></td>
              	</tr>
        	</c:when>
        	<c:otherwise>
   		        <c:forEach items="${list}" var="book">
		            <tr>
		                <td>${book.isbn}</td>
		                <td class="booktitle" id="${book.isbn}">${book.title}</td>
		                <td>${book.catalogue}</td>
		                <td>${book.author}</td>
		            </tr>
	        	</c:forEach>
        	</c:otherwise>
        </c:choose>
    </table>
    <div id="detail"></div>
    <div class="center" style="text-align: center">
        <a href="./book/Book.html">도서 등록</a>
        <a href="${pageContext.request.contextPath}/bookList.do">도서 목록</a>
    </div>
</body>
</html>
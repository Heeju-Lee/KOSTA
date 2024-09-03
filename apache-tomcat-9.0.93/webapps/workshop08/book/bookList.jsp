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
        
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
   <script type="text/javascript">
        $(function(){
            $('.booktitle').on("mouseover", function(){
                let isbn = $(this).attr('id');
                $.ajax({
                    type: 'POST',
                    url: 'front.do?command=details',
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
    <form action="${pageContext.request.contextPath}/front.do">
        <input type="hidden" name="command" value="search">
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
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.isbn}</td>
                <td class="booktitle" id="${book.isbn}">${book.title}</td>
                <td>${book.catalogue}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="detail"></div>
    <div class="center" style="text-align: center">
        <a href="./book/Book.html">도서 등록</a>
        <a href="${pageContext.request.contextPath}/front.do?command=bookList">도서 목록</a>
    </div>
</body>
</html>
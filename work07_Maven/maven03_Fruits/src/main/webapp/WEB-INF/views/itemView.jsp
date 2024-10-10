<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        h1 {
            text-align: center;
            color: crimson;
        }
        #title {
            background: #ffb6c1;
            width: 70%;
            margin: auto;
            text-align: right;
            padding: 5px;
            box-sizing: border-box;
        }
        #title button {
        	background: transparent;
		    border: none;
		    font-size: 1rem;
        }
        #title a {
        	text-decoration: none;
        	color: black;
        }
        #title button, a {
            margin-left: 40px;
        }
        #desc {
            width: 70%;
            margin: auto;
            background: papayawhip;
            box-sizing: border-box;
        }
        #left-image {
            float: left;
            width: 70%;
        }
        #left-image *{
            display: block;
        }
        #left-image img {
            width: 70%;
            height: 350px;
        }
        #left-image a {
            text-align: center;
            padding-top: 20px;
            padding-left: 160px;
            font-size: 22px;
            color: 	royalblue;
            font-weight: 700;
        }
        #right-content {
            float: left;
            width: 30%;
        }
        #right-content p {
            margin: 40px;
        }
    </style>    
</head>
<body>
	<h1>${item.name} 의 정보</h1>
	<p id="title">
       	 조회수 : ${item.count}
        <button name="cartinsert" id="${item.itemNumber}" value="${item.url}, ${item.name}, ${item.price}">장바구니 담기</button>
        <a href="cartList.jsp">장바구니 확인</a>
    </p>
    <div id="desc">
        <div id="left-image">
            <img src="${item.url}">
            <a href="itemList.do">상품 목록 보기</a>
        </div>
        <div id="right-content">
            <p>종 류 : ${item.name}</p>
            <p>가 격 : ${item.price}</p>
            <p style="margin-top: 80px;">설 명 : ${item.description}</p>
        </div>
    </div>
</body>
</html>
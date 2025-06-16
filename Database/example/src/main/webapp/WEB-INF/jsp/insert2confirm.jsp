<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>레코드 삽입 확인</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            color: #333333;
        }
        .record-details {
            margin: 20px auto;
            background-color: #ffffff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
            width: 60%;
        }
        .record-details p {
            margin: 8px 0;
        }
        .home-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4285f4;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            text-align: center;
        }
        .home-button:hover {
            background-color: #3367d6;
        }
    </style>
</head>
<body>
<h2>레코드가 성공적으로 삽입되었습니다!</h2>
<div class="record-details">
    <h3>Book 정보</h3>
    <p><strong>ISBN:</strong> ${isbn}</p>
    <p><strong>제목:</strong> ${title}</p>
    <p><strong>출판년도:</strong> ${year}</p>
    <p><strong>가격:</strong> ${price}</p>

    <h3>Stocks 정보</h3>
    <p><strong>Stock Code:</strong> ${stocksCode}</p>
    <p><strong>Stock 수량:</strong> ${stocksNum}</p>

    <h3>Writer 정보</h3>
    <p><strong>저자:</strong> ${writer}</p>

    <h3>Publisher 정보</h3>
    <p><strong>출판사:</strong> ${publisher}</p>
</div>

<a class="home-button" href="/home">홈으로 가기</a>
</body>
</html>

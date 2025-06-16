<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>2-d</title>
    <style>
        body {
            font-family: "Arial", sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            color: #333333;
        }
        h4{text-align: center;}
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0,0,0,0.05);
            max-width: 600px;
            margin: 0 auto;
        }
        p {
            margin-bottom: 15px;
            font-size: 1em;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #dddddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .home-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .home-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<button class="home-button" onclick="location.href='/home'">문제로 돌아가기</button>
<h2>고객 도서 정보 등록</h2>
<h4>stocks_cod, stocks_num, writter, publisher 등은 이미 있는 data들로 잘 결정했다고 가정</h4>

<form name="customerBookForm" method="post" action="/insert/post">
    <p>isbn: <input type="number" name="isbn"></p>
    <p>title: <input type="text" name="title"></p>
    <p>year: <input type="number" name="year"></p>
    <p>price: <input type="number" name="price"></p>
    <p>stocks_code: <input type="text" name="stocks_code"></p>
    <p>stocks_num: <input type="number" name="stocks_num"></p>
    <p>writter: <input type="text" name="writter"></p>
    <p>publisher: <input type="text" name="publisher"></p>
    <p><input type="submit" name="submit" value="보내기"></p>
</form>

</body>
</html>


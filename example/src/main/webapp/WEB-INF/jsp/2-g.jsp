<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>2-(g)</title>
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
        table {
            width: 100%;
            margin-top: 10px;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 0 5px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #dddddd;
        }
        th {
            background-color: #f2f2f2;
            font-size: 1.1em;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        .home-button, .discount-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
            margin-right: 10px;
        }
        .home-button:hover, .discount-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<button class="home-button" onclick="location.href='/home'">문제로 돌아가기</button>
<h2>2-(g) 재고가 특정 부수 이상 넘어가는 도서를 검색하고, 가격 할인</h2>
<div class="table-section">
    <h2>재고가 ${n}권 이상인 도서 목록</h2>
    <form method="get" action="${pageContext.request.contextPath}/result/2-g" style="display: inline;">
        <label for="n">n:</label>
        <input type="number" id="n" name="n" value="${n}" required>
        <button type="submit">검색</button>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/result/2-g/discount" style="display: inline;">
        <input type="hidden" name="n" value="${n}">
        <button type="submit" class="discount-button">할인 적용</button>
    </form>

    <table id="StockBooksTable">
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>TotalNum</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book[0]}</td>
                <td>${book[1]}</td>
                <td>${book[2]}</td>
                <td>${book[3]}</td>
                <td>${book[4]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Database Homework 7 - 문제 목록</title>
    <style>
        body {
            font-family: "Arial", sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
        }
        h1 {
            text-align: center;
            color: #333333;
        }
        h3 {
            text-align: center;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
        }
        th {
            background-color: #f2f2f2;
            font-size: 1.1em;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        caption {
            caption-side: top;
            text-align: left;
            font-size: 1.3em;
            margin-bottom: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Database Homework 7</h1>
<h3>60212770 이성은</h3>
<table>
    <caption>과제 문제 목록 및 결과 링크</caption>
    <thead>
    <tr>
        <th>문제 번호</th>
        <th>설명</th>
        <th>결과 보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${questionLinks}">
        <tr>
            <td>${entry.key.substring(0,3)}</td>
            <td>${entry.key.substring(4)}</td>
            <td><a href="${entry.value}">결과 보기</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

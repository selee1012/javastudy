<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>1-(e)</title>
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
        .home-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }
        .home-button:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
<button class="home-button" onclick="location.href='/home'">문제로 돌아가기</button>
<h2>1-(e) 학생별로 수강한 교과목의 총학점과 시험점수의 평균을 확인</h2>
<div class="table-section">
    <table id="sumCreditTable">
        <thead>
        <tr>
            <th>Sno</th>
            <th>Sname</th>
            <th>CreditSum</th>
            <th>ExamAvg</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sumCredit}" var="sumCredit">
            <tr>
                <td>${sumCredit[0]}</td>
                <td>${sumCredit[1]}</td>
                <td>${sumCredit[2]}</td>
                <td>${sumCredit[3]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

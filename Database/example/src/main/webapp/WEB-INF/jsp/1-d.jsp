<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>1-(d)</title>
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
        .summary {
            width: 80%;
            margin: 20px auto;
            background-color: #ffffff;
            padding: 10px 15px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
            font-size: 1em;
        }
        .table-section {
            width: 80%;
            margin: 20px auto;
            border-top: 2px solid #333;
            padding-top: 10px;
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
<h2>1-(d) 과목별로 최고 점수와, 최저 점수를 흭득 한 학생의 정보를 확인</h2>
<div class="table-section">
    <table id="MinMaxScoreTable">
        <thead>
        <tr>
            <th>StudentNumber</th>
            <th>ProfessorNumber</th>
            <th>StudentName</th>
            <th>Year</th>
            <th>Department</th>
            <th>CourseNumber</th>
            <th>Grade</th>
            <th>ExamScore</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${MinMaxScore}" var="MinMaxScore">
            <tr>
                <td>${MinMaxScore[0]}</td>
                <td>${MinMaxScore[1]}</td>
                <td>${MinMaxScore[2]}</td>
                <td>${MinMaxScore[3]}</td>
                <td>${MinMaxScore[4]}</td>
                <td>${MinMaxScore[5]}</td>
                <td>${MinMaxScore[6]}</td>
                <td>${MinMaxScore[7]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

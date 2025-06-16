<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>1-(b) ${sname}</title>
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
    <script>
        function toggleTable(id) {
            const table = document.getElementById(id);
            if (table.classList.contains('hidden')) {
                table.classList.remove('hidden');
            } else {
                table.classList.add('hidden');
            }
        }
    </script>
</head>
<body>
<button class="home-button" onclick="location.href='/home'">문제로 돌아가기</button>
<button class="home-button" onclick="location.href='/result/1-b'">이전으로 돌아가기</button>
<h2>${sname}의 학점 및 성적</h2>
<div class="table-section">
    <c:if test="${not empty studentGrade}">
    <table id="studentGradeTable">
        <thead>
        <tr>
            <th>CourseName</th>
            <th>Grade</th>
            <th>Exam</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentGrade}" var="grade">
            <tr>
                <td>${grade[0]}</td>
                <td>${grade[1]}</td>
                <td>${grade[2]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>

    <c:if test="${empty studentGrade}">
        <p>성적 정보가 없습니다.</p>
    </c:if>
</div>
</body>
</html>

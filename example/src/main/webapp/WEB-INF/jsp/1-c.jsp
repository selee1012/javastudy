<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>1-(c)</title>
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
</head>
<body>
<button class="home-button" onclick="location.href='/home'">문제로 돌아가기</button>
<h2>1-(c) Student의 시험 점수에 대한 학점이 잘못 기재되어 있는 학생의 이름과 학번, 과목번호를 확인 및
    수정 요청에 대해 정상적인 학점으로 수정</h2>
<div class="table-section">
    <table id="wrongGradeTable">
        <thead>
        <tr>
            <th>StudentName</th>
            <th>StudentNumber</th>
            <th>CourseNumber</th>
            <th>수정</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${wrongGrade}" var="wrongGrade">
            <tr>
                <td>${wrongGrade[0]}</td>
                <td>${wrongGrade[1]}</td>
                <td>${wrongGrade[2]}</td>
                <td>
                    <form method="post" action="/result/1-c/fix">
                        <input type="hidden" name="sno" value="${wrongGrade[1]}"/>
                        <input type="hidden" name="cno" value="${wrongGrade[2]}"/>
                        <button type="submit">수정</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

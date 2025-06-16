<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>1-(a) 각 Table Data와 Tuple 개수</title>
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
        .toggle-header {
            cursor: pointer;
            background-color: #f2f2f2;
            padding: 10px;
            font-weight: bold;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0,0,0,0.1);
        }
        .toggle-header:hover {
            background-color: #e0e0e0;
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
        .hidden {
            display: none;
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
<h2>1-(a)</h2>

<!-- STUDENT -->
<div class="table-section">
    <div class="summary">Student Table Tuple 갯수: ${studentCount}</div>
    <div class="toggle-header" onclick="toggleTable('studentTable')">▶ Student Table</div>
    <table id="studentTable" class="hidden">
        <thead>
        <tr>
            <th>Sno</th>
            <th>Pno</th>
            <th>Sname</th>
            <th>Year</th>
            <th>Dept</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.sno}</td>
                <td>${student.pno}</td>
                <td>${student.sname}</td>
                <td>${student.year}</td>
                <td>${student.dept}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- PROFESSOR -->
<div class="table-section">
    <div class="summary">Professor Table Tuple 갯수: ${professorCount}</div>
    <div class="toggle-header" onclick="toggleTable('professorTable')">▶ Professor Table</div>
    <table id="professorTable" class="hidden">
        <thead>
        <tr>
            <th>Pno</th>
            <th>Pname</th>
            <th>Pmajor</th>
            <th>Pdept</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${professors}" var="professor">
            <tr>
                <td>${professor.pno}</td>
                <td>${professor.pname}</td>
                <td>${professor.pmajor}</td>
                <td>${professor.pdept}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- COURSE -->
<div class="table-section">
    <div class="summary">Course Table Tuple 갯수: ${courseCount}</div>
    <div class="toggle-header" onclick="toggleTable('courseTable')">▶ Course Table</div>
    <table id="courseTable" class="hidden">
        <thead>
        <tr>
            <th>Cno</th>
            <th>Cname</th>
            <th>Credit</th>
            <th>Sessions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.cno}</td>
                <td>${course.cname}</td>
                <td>${course.credit}</td>
                <td>${course.sessions}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- ENROLL -->
<div class="table-section">
    <div class="summary">Enroll Table Tuple 갯수: ${enrollCount}</div>
    <div class="toggle-header" onclick="toggleTable('enrollTable')">▶ Enroll Table</div>
    <table id="enrollTable" class="hidden">
        <thead>
        <tr>
            <th>Sno</th>
            <th>Cno</th>
            <th>Grade</th>
            <th>Exam</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${enrolls}" var="enroll">
            <tr>
                <td>${enroll.sno}</td>
                <td>${enroll.cno}</td>
                <td>${enroll.grade}</td>
                <td>${enroll.exam}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- LECTURE -->
<div class="table-section">
    <div class="summary">Lecture Table Tuple 갯수: ${lectureCount}</div>
    <div class="toggle-header" onclick="toggleTable('lectureTable')">▶ Lecture Table</div>
    <table id="lectureTable" class="hidden">
        <thead>
        <tr>
            <th>Cno</th>
            <th>Pno</th>
            <th>Lec_time</th>
            <th>Room</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lectures}" var="lecture">
            <tr>
                <td>${lecture.cno}</td>
                <td>${lecture.pno}</td>
                <td>${lecture.lec_time}</td>
                <td>${lecture.room}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

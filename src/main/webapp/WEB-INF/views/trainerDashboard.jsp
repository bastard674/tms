<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainer Dashboard</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value='/js/trainerDashboard.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/css/trainerDashboard.css' />">
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <nav class="sidebar">
            <ul>
                <li><a href="<c:url value='/trainerdashboard' />">Dashboard</a></li>
                <li><a href="<c:url value='/profile' />">Profile</a></li>
                <li><a href="<c:url value='/tmslogin' />">Logout</a></li>
            </ul>
        </nav>

        <!-- Main Content -->
        <div class="main-content">
            <header class="header">
                <h1>Trainer Dashboard</h1>
            </header>

            <div class="info">
                <p>Course ID: <span>${courseId}</span></p>
                <p>Course Name: <span>${courseName}</span></p>
            </div>

            <div class="actions">
                <button name="studentlist" id="studentlist">Students List</button>
            </div>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.name}</td>
                                <td>${student.email}</td>
                                <td>${student.status}</td>
                                <td>
                                    <button data-student-id="${student.id}" data-status="accepted" onclick="updateElement(this)">Accept</button>
                                    <button data-student-id="${student.id}" data-status="rejected" onclick="updateElement(this)">Reject</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

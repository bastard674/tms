<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainer Dashboard</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value='/js/Dashboard.js' />"></script>
</head>
<body>
    <h1>Trainer Dashboard</h1>
   <br>
   <button name="studentlist" id="studentlist" >Students List</button>
	<br>
<br></br>
    <table border="1" cellpadding="10" cellspacing="0">
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
</body>
</html>

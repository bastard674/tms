<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Trainer</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .container { max-width: 600px; margin-top: 50px; }
        .form-container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }
        .form-group label { font-weight: bold; }
        .submit-btn { width: 100%; background-color: #007bff; color: white; }
        .submit-btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>

    <div class="container">
        <div class="form-container">
            <h1 class="text-center mb-4">Add Trainer</h1>
            <form action="addUser" method="POST">
                <div class="form-group">
                    <label for="userName">Username:</label>
                    <input type="text" class="form-control" id="userName" name="userName" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="course">Course:</label>
                    <select id="course" name="course" class="form-control" required>
                        <c:forEach var="course" items="${courses}">
                            <option value="${course.coursename}">${course.coursename}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group role-selection">
                    <label>Role:</label>
                    <input type="radio" id="trainer" name="role" value="Trainer" required>
                    <label for="trainer">Trainer</label>
                    <input type="radio" id="admin" name="role" value="Admin" required>
                    <label for="admin">Admin</label>
                </div>
                <button type="submit" class="btn submit-btn">Submit</button>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

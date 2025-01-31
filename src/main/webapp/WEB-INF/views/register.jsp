<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link rel="stylesheet" href="<c:url value='/css/register.css' />">
    <style>
        /* Toaster notification style */
        .toaster {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #4CAF50;
            color: white;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            opacity: 0;
            transition: opacity 0.5s ease;
        }

        .toaster.show {
            opacity: 1;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Student Registration</h2>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="course">Course:</label>
                <select id="course" name="course" required>
                    <c:forEach var="course" items="${courses}">
                        <option value="${course.coursename}">${course.coursename}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="button-container">
                <button type="submit" class="btn">Register</button>
                <a href="<c:url value='/tmslogin' />" class="btn">Login</a>
            </div>
        </form>
    </div>
    
     <div id="toaster" class="toaster">
        <c:if test="${not empty registrationSuccess}">
            ${registrationSuccess}
        </c:if>
    </div>

    <script>
        // Show toaster notification if the registration success message is present
        window.onload = function() {
            var toaster = document.getElementById('toaster');
            if (toaster.innerHTML.trim() != "") {
                toaster.classList.add('show');
                setTimeout(function() {
                    toaster.classList.remove('show');
                }, 3000); // Hide after 3 seconds
            }
        };

        // Reset the form values after successful registration
        document.querySelector('form').reset();
    </script>
    
    
</body>
</html>

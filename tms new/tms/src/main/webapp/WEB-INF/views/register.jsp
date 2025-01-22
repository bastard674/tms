<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        
       
        
        <label for="course">Course:</label>
        <select id="course" name="course" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.coursename}">${course.coursename}</option>
            </c:forEach>
        </select>
        <br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>

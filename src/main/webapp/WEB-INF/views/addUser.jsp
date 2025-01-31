<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Trainer</title>
    <link rel="stylesheet" href="<c:url value='/css/adduser.css' />">
</head>
<body>
    <h1>Add Trainer</h1>
    <form action="addUser" method="POST">
        
        <label for="username">Username:</label>
        <input type="text" id="userName" name="userName" required>
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

        <!-- Role Selection -->
        <label for="role">Role:</label>
        <input type="radio" id="trainer" name="role" value="Trainer" required>
        <label for="trainer">Trainer</label>
        <input type="radio" id="admin" name="role" value="Admin" required>
        <label for="admin">Admin</label>
        <br><br>

        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>
</body>
</html>

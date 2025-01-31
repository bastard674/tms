<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trainer Login</title>
  	<link rel = "stylesheet" href="/css/trainerlogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script>
        // Configure Toastr options
        toastr.options = {
            "closeButton": true,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "preventDuplicates": true,
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
    </script>
</head>
<body>
	<div class="login-box">
    <h1>Login</h1>
    <form action="/trainerlogin" method="POST">
       
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br><br>

     
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>

       
        <button type="submit">Login</button>
    </form>
    </div>


  
    <script>
        $(document).ready(function () {
            <c:if test="${not empty errorMessage}">
                toastr.error("${errorMessage}", "Login failed");
            </c:if>
        });
    </script>
</body>
</html>

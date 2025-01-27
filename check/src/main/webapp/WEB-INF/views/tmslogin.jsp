<!DOCTYPE html>
<html>
<head>
    <title>Add Trainer</title>
    
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: url('https://img.freepik.com/premium-photo/training-personal-development-business-education-elearning-concept_161452-10162.jpg?w=1380');
            background-size: cover;
            background-position: center;
            transition: background-image 0.5s ease-in-out;
        }
        /* Centering the form container */
        .form-container {
            width: 35%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: rgba(255, 255, 255, 0.5);/* background-color: white; /     / #f9f9f9 */
            text-align: center;
        }
        
        button {
            padding: 10px 20px;
            background-color:#45a049;   /* #4CAF50 */
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
            margin-top: 15px;
        }
        button:hover {
            opacity: 0.8;
        }

        }
        .icon-button img {
            width: 40px;
            height: 40px;
        }
        
        .login-container {
            background: #fff;
            width: 350px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
        }
       
        .input-group {
            margin-bottom: 15px;
        }
        .input-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        .input-group input {
            width: 50%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .role-group {
            margin-bottom: 15px;
        }
        .role-group label {
            margin-right: 10px;
            font-size: 14px;
            color: #555;
        }
        .login-button {
            width: 20%;
            padding: 10px;
            font-size: 16px;
            background: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-button:hover {
            background: #45a049;
        }
        .register-button {
            width: 20%;
            padding: 10px;
            font-size: 16px;
            background: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .register-button:hover {
            background: #45a049;
        }
        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 10px;
        }
        
        
        h1 {
            margin-bottom: 10px; /* Add spacing below the title */
        }

        img {
            margin-bottom: 10px; /* Add spacing below the image */
        }
    </style>
    
  	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#addUserButton').click(function() {
                window.location.href = '/addUser';
            });
        });
    </script>
</head>
<body>
<div class="form-container">
    <h1>Training Management System</h1>
       <br><br>
    
   <img src="https://media.instahyre.com/images/profile/base/employer/16682/a1bc51eae2/brand.webp" width="170" height="100" alt="Brand Logo">
   
   <br>
        
        <form action="/tmslogin" method="post">
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="role-group">
                <label><input type="radio" name="role" value="Admin" required> Admin</label>
                <label><input type="radio" name="role" value="Trainer" required> Trainer</label>
                <label><input type="radio" name="role" value="Trainee" required> Trainee</label>
            </div>
            <div class="error-message">
                <% 
                    String error = (String) request.getAttribute("error");
                    if (error != null) {
                        out.print(error);
                    }
                %>
            </div>
            <button type="submit" class="login-button">Login</button>
            <button type="submit" class="register-button">Register</button>
        </form>
 

   
</div>
</body>
</html>
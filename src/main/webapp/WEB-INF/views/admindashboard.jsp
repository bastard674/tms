<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; font-family: Arial, sans-serif; }
        body { display: flex; min-height: 100vh; background-color: #f4f4f4; }
        
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2c3e50;
            color: white;
            position: fixed;
            left: 0;
            top: 0;
            transition: 0.3s;
            padding-top: 20px;
            text-align: center;
        }

        .profile img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 3px solid white;
            cursor: pointer;
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
            margin-top: 20px;
        }

        .sidebar ul li {
            padding: 15px;
            text-align: center;
            transition: 0.3s;
        }

        .sidebar ul li:hover {
            background-color: #34495e;
        }

        .sidebar ul li a {
            color: white;
            text-decoration: none;
            display: block;
            font-size: 18px;
        }

        .logout {
            background-color: red;
        }

        .logout:hover {
            background-color: darkred;
        }

        .sidebar.collapsed {
            width: 70px;
        }

        .sidebar.collapsed ul li span,
        .sidebar.collapsed .profile h3 {
            display: none;
        }

        .main-content {
            background-color: #90EE90;
            margin-left: 250px;
            padding: 20px;
            transition: 0.3s;
            width: 100%;
            height:80px;
            position: relative;
        }

        .sidebar.collapsed + .main-content {
            margin-left: 70px;
            width: calc(100% - 70px);
        }

        .toggle-btn {
            position: absolute;
            left: 260px;
            top: 20px;
            background-color: #2c3e50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            transition: 0.3s;
            border-radius: 5px;
        }

        .sidebar.collapsed ~ .toggle-btn {
            left: 80px;
        }

        .add-user-btn {
            position: absolute;
            right: 20px;
            top: 20px;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }

        .add-user-btn:hover {
            background-color: #0056b3;
        }
        .delete-btn{
        margin-left:85px;
        background-color:red;
        color:white;
        border:none;}

        /* Box Container Styling */
        .container {
            display: flex;
            gap: 20px;
            margin-top: 20px;
            justify-content: center;
            gap:150px;
        }

    .box1 {
    flex: 1;
    min-width: 300px;
    max-width: 500px;
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
    height: 250px;
    width: 100%; /* Corrected spelling */
    overflow-y: auto; /* Enable vertical scrolling */
    margin-left:-680px;
}
.box2 {
    flex: 1;
    min-width: 300px;
    max-width: 600px; /* Increased max-width for better fit */
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
    height: 250px;
    width: auto; /* Changed from 100% to auto */
    position: absolute;
    top: 120px;
    left: 50%;
    transform: translateX(-50%);
    margin-left: 300px;
    overflow: hidden; /* Prevent unnecessary scrolling */
}

/* Style the table to fit inside .box2 */
.box2 table {
    width: 100%; /* Ensure the table fills .box2 */
    border-collapse: collapse;
    margin-top: 10px;
    table-layout: fixed; /* Prevent table from exceeding container width */
}

/* Ensure table cells fit properly */
.box2 th, .box2 td {
    padding: 8px;
    border: 1px solid black;
    text-align: center;
    font-size: 14px;
    word-wrap: break-word;
    width: 50%; /* Adjust width for two columns */
}

/* Ensure column headers have background */
.box2 th {
    background-color: #f4f4f4;
}

/* Responsive Design */
@media (max-width: 768px) {
    .box2 {
        width: 90%;
        margin-left: 0;
    }
}

.box3 {
    position: fixed; /* Fixed positioning */
    bottom: 20px; /* Adjust distance from the bottom */
    left: 50%; /* Center horizontally */
    transform: translateX(-50%); /* Ensure it's perfectly centered */
    min-width: 300px;
    max-width: 900px;
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
    height: 250px; /* Set a specific height for the box */
    width: 100%;
    z-index: 10; /* Ensure it's on top */
    overflow-y: auto; /* Enable vertical scrolling */
    margin-left: 80px; /* Left margin */
    overflow-x: hidden; /* Hide horizontal scrollbar */
}


#studentTable {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

#studentTable th, #studentTable td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

#studentTable th {
    background-color: #f2f2f2;
}
        
   
        
        
    </style>
</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar" id="sidebar">
        <div class="profile">
            <label for="fileInput">
                <img src="./traineeeeee.jpeg" id="profilePic" alt="Profile Photo">
            </label>
            <input type="file" id="fileInput" accept="image/*" style="display: none;">
            <button id="deleteBtn" class="delete-btn" style="display: none;">Delete Photo</button><br>
            <h3 id="username">Admin</h3>
        </div>
        <ul>
            <li><a href="#">📊 <span>Dashboard</span></a></li><br>
            <li><a href="#">👤 <span>Profile</span></a></li><br>
            <li class="logout"><a href="#">🚪 <span>Logout</span></a></li>
        </ul>
    </div>

    <!-- Toggle Button -->
    <button class="toggle-btn" id="toggleBtn">☰</button>

    
    <div class="main-content">
        <h2 style="text-align: center;">Welcome to Dashboard</h2>
        
        <!-- Add User Button -->
       
    <a href="/addUser">
    <button class="add-user-btn">+ Add User</button>
	</a>


<br>
<br>
<br>
        <!-- Two Containers Below Title -->
        <div class="container" id="boxContainer">
            <div class="box1">
                <h1>Trainers List</h1>
                <table id="trainersTable" style="width:100%; border-collapse: collapse;">
            <thead>
                <tr>
                    
                    <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Trainer ID</th>
                    <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Trainer Name</th>
                    <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Age</th>
                    <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Course ID</th>
                    <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">User ID</th>
                </tr>
            </thead>
            <tbody id="tableBody">
    		<c:forEach var="t" items="${trainer}">
        		<tr>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${t.id}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${t.name}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${t.age}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${t.course.coursename}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${t.user.id}</td>
        		</tr>
    		</c:forEach>
			</tbody>
        		</table>
        <br>
    		</div>
         </div>
         
         
    <div class="box2">
    <h2>Courses</h2>
    	<table border="1">
        	<tr>
            	<th>Course ID</th>
            	<th>Course Name</th>
        </tr>
        <c:forEach var="c" items="${course}">
            <tr>
                <td>${c.id}</td>
                <td>${c.coursename}</td>
            </tr>
        </c:forEach>
    </table>
	</div>
     
  <br>
  <div class="box3">
    <h2>Student Details</h2>
    <table id="studentTable" style="width:100%; border-collapse: collapse;">
        <thead>
            <tr>
                <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Name</th>
                <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Password</th>
                <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Email</th>
                <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Course</th>
                <th style="border: 1px solid #ddd; padding: 8px; text-align: left;">Status</th>
            </tr>
        </thead>
         <tbody id="tableBody">
    		<c:forEach var="s" items="${student}">
        		<tr>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${s.name}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${s.password}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${s.email}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${s.course.coursename}</td>
            <td style="border: 1px solid #ddd; padding: 8px; text-align: left;">${s.status}</td>
        		</tr>
    		</c:forEach>
			</tbody>
    </table>
    
</div>
  
 



    <script>
        // Sidebar toggle functionality
        document.getElementById("toggleBtn").addEventListener("click", function() {
            document.getElementById("sidebar").classList.toggle("collapsed");
        });

        // Profile picture upload and delete functionality
        const fileInput = document.getElementById("fileInput");
        const profilePic = document.getElementById("profilePic");
        const deleteBtn = document.getElementById("deleteBtn");
        const defaultImage = "./traineeeeee.jpeg";

        fileInput.addEventListener("change", function(event) {
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    profilePic.src = e.target.result;
                    deleteBtn.style.display = "block"; // Show delete button
                };
                reader.readAsDataURL(file);
            }
        });

        deleteBtn.addEventListener("click", function() {
            profilePic.src = defaultImage; // Reset to default image
            fileInput.value = ""; // Clear file input
            deleteBtn.style.display = "none"; // Hide delete button
        });

        // Optional: Add a feature to dynamically add new boxes
        function addNewBox() {
            const boxContainer = document.getElementById("boxContainer");
            const newBox = document.createElement("div");
            newBox.className = "box";
            newBox.innerHTML = `
                <h2>New Container</h2>
                <p>This is a dynamically added container.</p>
            `;
            boxContainer.appendChild(newBox);
        }

        // Optional: Uncomment the next line if you want to add a button to create new boxes dynamically.
        // document.body.innerHTML += '<button onclick="addNewBox()" style="position: fixed; bottom: 20px; right: 20px; background: green; color: white; padding: 10px; border: none; cursor: pointer;">+ Add Box</button>';
        function addTrainerRow() {
        const tableBody = document.getElementById('tableBody');

        // Create a new table row (<tr>)
        const newRow = document.createElement('tr');

        // Create cells (<td>) and append them to the new row
        for (let i = 0; i < 5; i++) {
            const cell = document.createElement('td');
            cell.style.border = '1px solid #ddd';
            cell.style.padding = '8px';

            // For now, cells will be empty, you can add content later
            cell.innerText = ''; 

            newRow.appendChild(cell);
        }

        // Append the new row to the table body
        tableBody.appendChild(newRow);
    }
        function addStudentRow() {
            const tableBody = document.getElementById('studentTableBody');

            // Create a new table row (<tr>)
            const newRow = document.createElement('tr');

            // Sample data for now (You can replace it with form inputs)
            const studentData = ["John Doe", "********", "john@example.com", "Active"];

            // Create cells (<td>) and append them to the new row
            for (let i = 0; i < studentData.length; i++) {
                const cell = document.createElement('td');
                cell.style.border = '1px solid #ddd';
                cell.style.padding = '8px';
                cell.innerText = studentData[i]; // Assigning sample data

                newRow.appendChild(cell);
            }

            // Append the new row to the table body
            tableBody.appendChild(newRow);
        }

</script>
  

</body>
</html>
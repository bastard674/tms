<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sidebar Layout</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex;
            height: 100vh;
        }

        .sidebar {
            width: 15%;
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            display: flex;
            flex-direction: column;
        }

        .sidebar a {
            text-decoration: none;
            color: white;
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
            text-align: center;
        }

        .sidebar a:hover {
            background-color: #34495e;
        }

        .content {
            width: 70%;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h2>Menu</h2>
            <a href="/studentdashboardbtn" target="content-frame">Dashboard</a>
            <a href="/studentprofile" target="content-frame">Profile</a>
            <a href="/tmslogin" target="_self">Logout</a>
        </div>
        <div class="content">
            <iframe name="content-frame" style="width: 100%; height: 100%; border: none;"></iframe>
        </div>
    </div>
</body>
</html>

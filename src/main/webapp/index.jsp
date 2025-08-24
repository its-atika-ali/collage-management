<%-- 
    Document   : index
    Created on : Aug 23, 2025, 9:10:47 PM
    Author     : ADMIN
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page session="true" %>
<%
    // If user is logged in, redirect to dashboard
    if(session.getAttribute("name") != null){
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Poppins', sans-serif;
            margin:0;
        }
        .welcome-card {
            max-width: 500px;
            width: 100%;
            background: rgba(255,255,255,0.85);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            padding: 40px;
            text-align: center;
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .welcome-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.25);
        }
        .welcome-card h1 {
            font-weight: 700;
            color: #1e3c72;
            margin-bottom: 20px;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.1);
        }
        .welcome-card p {
            font-size: 1.1rem;
            color: #333;
            margin-bottom: 30px;
        }
        .btn-login {
            background: linear-gradient(90deg, #4facfe, #00f2fe);
            color: #fff;
            font-weight: 600;
            padding: 12px 30px;
            border-radius: 14px;
            border: none;
            transition: all 0.3s ease;
        }
        .btn-login:hover {
            background: linear-gradient(90deg, #43e97b, #38f9d7);
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(56,249,215,0.5);
        }
    </style>
</head>
<body>
    <div class="welcome-card">
        <h1><i class="fas fa-graduation-cap me-2"></i>Welcome to College Management</h1>
        <p>Manage your students and employees efficiently. Please login to continue.</p>
        <button class="btn-login" onclick="window.location='login.jsp'">
            <i class="fas fa-sign-in-alt me-1"></i> Login
        </button>
    </div>
</body>
</html>

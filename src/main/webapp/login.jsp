<%-- 
    Document   : login
    Created on : Aug 11, 2025, 8:53:29 AM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login - Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        /* Background & Body */
        body {
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Poppins', sans-serif;
            margin: 0;
            color: #333;
        }

        /* Centered Login Card */
        .login-card {
            width: 100%;
            max-width: 400px;
            background: rgba(255, 255, 255, 0.85);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            padding: 40px 30px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .login-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.25);
        }

        .login-card h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #1e3c72;
            font-weight: 700;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.1);
        }

        .form-label {
            font-weight: 600;
            color: #222;
            margin-bottom: 6px;
        }

        .form-control {
            border-radius: 12px;
            padding: 12px;
            border: 1px solid #ddd;
            background: #fdfdfd;
            transition: all 0.3s ease;
        }

        .form-control:focus {
            border-color: #4facfe;
            box-shadow: 0 0 10px rgba(79,172,254,0.5);
            transform: scale(1.02);
        }

        /* Button */
        .btn-login {
            width: 100%;
            background: linear-gradient(90deg, #4facfe, #00f2fe);
            border: none;
            border-radius: 14px;
            font-weight: 600;
            padding: 12px;
            box-shadow: 0 6px 15px rgba(79,172,254,0.4);
            transition: all 0.3s ease;
        }

        .btn-login:hover {
            background: linear-gradient(90deg, #43e97b, #38f9d7);
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(56,249,215,0.5);
        }

        .text-center a {
            color: #38f9d7;
            text-decoration: none;
            font-weight: 600;
        }

        .text-center a:hover {
            color: #43e97b;
        }

        .alert {
            border-radius: 10px;
            padding: 10px 15px;
            margin-top: 15px;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <div class="login-card">
        <h2><i class="fas fa-user-circle me-2"></i>Login</h2>
        <form action="StudentController" method="post">
            <input type="hidden" name="action" value="login">
            
            <div class="mb-3">
                <label for="phone" class="form-label"><i class="fas fa-phone me-1"></i> Phone</label>
                <input type="text" class="form-control" id="phone" name="phone_no" placeholder="Enter your phone" required>
            </div>
            
            <div class="mb-3">
                <label for="password" class="form-label"><i class="fas fa-lock me-1"></i> Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            
            <input type="submit" class="btn btn-login" value="Login">
        </form>

        <p class="text-center mt-3">
            Don't have an account? <a href="students.jsp">Register here</a>
        </p>

        <% if(request.getParameter("message") != null){ %>
            <div class="alert alert-danger" role="alert">
                <%= request.getParameter("message") %>
            </div>
        <% } %>
    </div>
</body>
</html>

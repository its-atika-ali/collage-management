<%-- 
    Document   : index
    Created on : Aug 3, 2025, 10:49:09 AM
    Author     : ADMIN
--%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.qt.apnweb.models.Students"%>
<%@ page import="com.qt.apnweb.models.Employees"%>
<%@ page import="com.qt.apnweb.controllers.StudentController"%>
<%@ page import="com.qt.apnweb.controllers.EmployeeController"%>
<%@ page session="true" %>
<%
    if(session.getAttribute("name") == null){
        response.sendRedirect("login.jsp");
        return;
    }

    StudentController sc = new StudentController();
    EmployeeController ec = new EmployeeController();
    ArrayList<Students> studentList = sc.findAll();
    ArrayList<Employees> empList = ec.findAll();
    int totalStudents = studentList.size();
    int totalEmployees = empList.size();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Poppins', sans-serif;
            margin:0;
        }
        .main-content {
            width: 100%;
            max-width: 950px;
        }
        .page-header h2 {
            font-weight: 700;
            color: #1e3c72;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.1);
        }
        .page-header p {
            color: #555;
            font-size: 1rem;
            font-weight: 400;
        }
        .card {
            border-radius: 20px;
            border: none;
            background: rgba(255, 255, 255, 0.85);
            backdrop-filter: blur(10px);
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            margin-bottom: 20px;
        }
        .card:hover {
            transform: translateY(-6px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.25);
        }
        .stat-card {
            text-align: center;
            padding: 2rem;
        }
        .stat-card h2 {
            font-size: 2.5rem;
            margin: 10px 0;
            color: #4facfe;
        }
        .stat-card p {
            margin: 0;
            font-size: 1rem;
            color: #333;
        }
        .stat-card i {
            font-size: 2rem;
            color: #00f2fe;
            margin-bottom: 0.5rem;
            display:block;
        }
        .btn-primary {
            background: linear-gradient(90deg, #4facfe, #00f2fe);
            border: none;
            border-radius: 14px;
            font-weight: 600;
            padding: 12px 24px;
            box-shadow: 0 6px 15px rgba(79,172,254,0.4);
            transition: all 0.3s ease;
        }
        .btn-primary:hover {
            background: linear-gradient(90deg, #43e97b, #38f9d7);
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(56,249,215,0.5);
        }
        .d-flex-gap {
            display:flex;
            gap:20px;
            flex-wrap:wrap;
        }
        @media (max-width:768px){
            .main-content{padding:1rem;}
        }
    </style>
</head>
<body>
    <div class="main-content">
        <div class="page-header mb-4 text-center">
            <h2><i class="fas fa-home me-2"></i>Dashboard</h2>
            <p>Overview of your students and employees</p>
        </div>

        <div class="d-flex-gap">
            <div class="card stat-card flex-fill">
                <i class="fas fa-users"></i>
                <h2><%= totalEmployees %></h2>
                <p>Total Employees</p>
                <button class="btn-primary mt-3" onclick="window.location='employees.jsp'">
                    Manage Employees
                </button>
            </div>
            <div class="card stat-card flex-fill">
                <i class="fas fa-user-graduate"></i>
                <h2><%= totalStudents %></h2>
                <p>Total Students</p>
                <button class="btn-primary mt-3" onclick="window.location='students.jsp'">
                    Manage Students
                </button>
            </div>
        </div>
    </div>
</body>
</html>

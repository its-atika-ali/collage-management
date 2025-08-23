<%-- 
    Document   : students
    Created on : Aug 19, 2025, 11:41:31 PM
    Author     : ADMIN
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qt.apnweb.models.Students"%>
<%@page import="com.qt.apnweb.controllers.StudentController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
/* ====== Global Layout ====== */
body {
  font-family: 'Poppins', sans-serif;
  background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%);
  min-height: 100vh;
  margin: 0;
  display: flex;
  color: #333;
}

/* ====== Sidebar ====== */
.sidebar {
  width: 250px;
  background: rgba(255, 255, 255, 0.2);
  -webkit-backdrop-filter: blur(12px);
  backdrop-filter: blur(12px);
  color: #fff;
  height: 100vh;
  position: fixed;
  left: 0;
  top: 0;
  transition: width 0.3s ease;
  padding-top: 20px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.2);
  overflow: hidden;
}
.sidebar.collapsed {
  width: 70px;
}
.sidebar .profile {
  text-align: center;
  margin-bottom: 20px;
}
.sidebar .profile img {
  width: 70px;
  height: 70px;
  border-radius: 50%;
  border: 3px solid #fff;
}
.sidebar .profile h5 {
  margin-top: 10px;
  color: #fff;
  font-weight: 600;
  transition: opacity 0.3s;
}
.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}
.sidebar ul li {
  margin: 15px 0;
}
.sidebar ul li a {
  color: #fff;
  text-decoration: none;
  padding: 12px 20px;
  display: flex;
  align-items: center;
  border-radius: 10px;
  transition: 0.3s;
  font-weight: 500;
}
.sidebar ul li a:hover,
.sidebar ul li a.active {
  background: rgba(255, 255, 255, 0.3);
  color: #222;
}
.sidebar ul li a span {
  margin-left: 10px;
  transition: opacity 0.3s;
}
.sidebar.collapsed ul li a span {
  display: none;
}
.sidebar.collapsed .profile h5 {
  opacity: 0;
}

/* ====== Sidebar Toggle Button ====== */
#sidebarToggle {
  position: fixed;
  left: 260px;
  top: 20px;
  background: #fff;
  border: none;
  padding: 8px 12px;
  border-radius: 8px;
  cursor: pointer;
  box-shadow: 0 4px 10px rgba(0,0,0,0.2);
  transition: all 0.3s ease;
  z-index: 1000;
}
#sidebarToggle.collapsed {
  left: 80px;
}
#sidebarToggle:hover {
  background: #74ebd5;
  color: #fff;
}

/* ====== Main Content ====== */
.main-content {
  margin-left: 250px;
  padding: 30px;
  flex-grow: 1;
  transition: margin-left 0.3s ease;
}
.main-content.collapsed {
  margin-left: 70px;
}

/* ====== Page Header ====== */
.page-header {
  text-align: center;
  margin-bottom: 30px;
}
.page-header h2 {
  font-weight: 700;
  color: #333;
}
.page-header p {
  color: #666;
}

/* ====== Cards ====== */
.content-card {
  background: rgba(255, 255, 255, 0.8);
  -webkit-backdrop-filter: blur(12px);
  backdrop-filter: blur(12px);
  padding: 25px;
  border-radius: 15px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.15);
  margin-bottom: 30px;
}

/* ====== Form Styling ====== */
.form-label {
  font-weight: 600;
  color: #444;
}
.form-control {
  border-radius: 10px;
  border: 1px solid #ddd;
  padding: 10px;
  transition: 0.3s;
}
.form-control:focus {
  border-color: #74ebd5;
  box-shadow: 0 0 8px rgba(116, 235, 213, 0.6);
}

/* ====== Submit Button ====== */
.btn-submit {
  background: linear-gradient(135deg, #74ebd5, #9face6);
  border: none;
  padding: 12px 20px;
  border-radius: 12px;
  color: #fff;
  font-weight: 600;
  transition: all 0.3s ease;
  width: 100%;
  cursor: pointer;
}
.btn-submit:hover {
  background: linear-gradient(135deg, #9face6, #74ebd5);
  transform: translateY(-2px);
  box-shadow: 0 8px 15px rgba(0,0,0,0.2);
}

/* ====== Alerts ====== */
.alert-message {
  border-radius: 12px;
  padding: 12px 20px;
  font-weight: 500;
}

/* ====== Table Styling ====== */
.table-container {
  overflow-x: auto;
}
.table {
  background: #fff;
  border-radius: 12px;
  overflow: hidden;
}
.table thead {
  background: #74ebd5;
  color: #fff;
}
.table th,
.table td {
  padding: 12px;
  vertical-align: middle;
}
.table tbody tr:hover {
  background: rgba(116, 235, 213, 0.1);
}

/* ====== Action Buttons ====== */
.action-btn {
  padding: 8px 12px;
  border-radius: 8px;
  color: #fff;
  font-size: 14px;
  transition: all 0.3s ease;
}
.btn-edit {
  background: #4cafef;
}
.btn-edit:hover {
  background: #007bff;
}
.btn-delete {
  background: #ff5f5f;
}
.btn-delete:hover {
  background: #e63939;
}
</style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <div class="profile">
        <img src="assets/profile.png" alt="Profile">
        <h5>Admin</h5>
    </div>
    <ul class="nav-links">
        <li><a href="index.jsp"><i class="fas fa-home me-2"></i> <span>Dashboard</span></a></li>
        <li><a class="active" href="students.jsp"><i class="fas fa-user-graduate me-2"></i> <span>Students</span></a></li>
        <li><a href="employees.jsp"><i class="fas fa-chalkboard-teacher me-2"></i> <span>Employees</span></a></li>
        <li><a href="logout.jsp"><i class="fas fa-sign-out-alt me-2"></i> <span>Logout</span></a></li>
    </ul>
</div>

<!-- Sidebar Toggle Button -->
<button id="sidebarToggle"><i class="fas fa-bars"></i></button>

<div class="main-content">
    <!-- Page Header -->
    <div class="page-header">
        <h2><i class="fas fa-user-graduate me-2"></i>Student Management</h2>
        <p>Register new students and manage existing records</p>
    </div>

    <!-- Student Form -->
    <div class="content-card">
        <h4 class="mb-4"><i class="fas fa-user-plus me-2"></i>Student Registration</h4>

        <% if (request.getParameter("message") != null && !request.getParameter("message").equals("null")) { %>
            <div class="alert alert-info alert-message">
                <%= request.getParameter("message") %>
            </div>
        <% } %>

        <form action="StudentController" method="post">
            <input type="hidden" name="action" value="insert" />

            <div class="mb-3">
                <label class="form-label">Full Name</label>
                <input type="text" class="form-control" name="full_name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email_id" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" name="address" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Phone</label>
                <input type="text" class="form-control" name="phone_no" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>
            <div class="mb-4">
                <label class="form-label">Branch</label>
                <input type="text" class="form-control" name="branch" required>
            </div>

            <button type="submit" class="btn-submit"><i class="fas fa-user-plus me-2"></i>Register Student</button>
        </form>
    </div>

    <!-- Student Table -->
    <div class="content-card table-container">
        <%
            StudentController sc = new StudentController();
            ArrayList<Students> studentList = sc.findAll();
        %>

        <% if (studentList.isEmpty()) { %>
            <div class="text-center py-5 text-muted">
                <i class="fas fa-users fa-3x mb-3"></i>
                <h5>No Students Found</h5>
                <p>Start by registering your first student!</p>
            </div>
        <% } else { %>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th><th>Name</th><th>Email</th><th>Branch</th>
                        <th>Roll No</th><th>Phone</th><th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Students student : studentList) { %>
                        <tr>
                            <td><%= student.getId() %></td>
                            <td><%= student.getName() %></td>
                            <td><%= student.getEmail() %></td>
                            <td><%= student.getBranch() %></td>
                            <td><%= student.getRollNo() %></td>
                            <td><%= student.getPhone() %></td>
                            <td>
                                <div class="d-flex justify-content-center gap-2">
                                    <a href="student_update.jsp?id=<%= student.getId() %>" class="action-btn btn-edit"><i class="fas fa-edit"></i></a>
                                    <a href="StudentController?action=delete&student_id=<%= student.getId() %>" class="action-btn btn-delete" onclick="return confirm('Are you sure?')"><i class="fas fa-trash"></i></a>
                                </div>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
<script>
    const sidebar = document.querySelector('.sidebar');
    const mainContent = document.querySelector('.main-content');
    const toggleBtn = document.getElementById('sidebarToggle');

    toggleBtn.addEventListener('click', () => {
        sidebar.classList.toggle('collapsed');
        mainContent.classList.toggle('collapsed');
    });
</script>
</body>
</html>

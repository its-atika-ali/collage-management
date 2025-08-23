<%-- 
    Document   : student_update
    Created on : Aug 10, 2025, 11:39:57 AM
    Author     : ADMIN
--%>
<%@page import="com.qt.apnweb.models.Students"%>
<%@page import="com.qt.apnweb.controllers.StudentController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
/* Background */
body {
    background: linear-gradient(135deg, #74ebd5, #ACB6E5);
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: 'Poppins', sans-serif;
    color: #333;
    margin: 0;
}

/* Center content */
.main-content {
    width: 100%;
    max-width: 950px;
}

/* Page header */
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

/* Card styling (Glass effect) */
.card {
    border-radius: 20px;
    border: none;
    background: rgba(255, 255, 255, 0.85);
    backdrop-filter: blur(10px);
    box-shadow: 0 10px 25px rgba(0,0,0,0.15);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.card:hover {
    transform: translateY(-6px);
    box-shadow: 0 15px 30px rgba(0,0,0,0.25);
}

/* Labels */
.form-label {
    font-weight: 600;
    color: #222;
    margin-bottom: 6px;
}

/* Inputs */
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
</style>
</head>
<body>

<div class="main-content">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-10">

                <div class="page-header mb-4 text-center">
                    <h2><i class="fas fa-user-edit me-2"></i>Update Student</h2>
                    <p class="lead">Edit student details below</p>
                </div>

                <%
                    StudentController sc = new StudentController();
                    Students student = sc.findById(Integer.parseInt(request.getParameter("id")));
                %>

                <div class="card shadow-sm p-4">
                    <form action="StudentController" method="post">
                        <input type="hidden" name="action" value="update"/>
                        <input type="hidden" name="id" value="<%= student.getId() %>"/>

                        <div class="row g-3">
                            <!-- Full Name -->
                            <div class="col-md-6">
                                <label class="form-label">Full Name</label>
                                <input type="text" class="form-control" name="full_name" value="<%= student.getName() %>" required>
                            </div>

                            <!-- Email -->
                            <div class="col-md-6">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" name="email_id" value="<%= student.getEmail() %>" required>
                            </div>

                            <!-- Address -->
                            <div class="col-md-6">
                                <label class="form-label">Address</label>
                                <input type="text" class="form-control" name="address" value="<%= student.getAddress() %>" required>
                            </div>

                            <!-- Phone Number -->
                            <div class="col-md-6">
                                <label class="form-label">Phone Number</label>
                                <input type="tel" class="form-control" name="phone_no" value="<%= student.getPhone() %>" required>
                            </div>

                            <!-- Branch -->
                            <div class="col-md-6">
                                <label class="form-label">Branch</label>
                                <input type="text" class="form-control" name="branch" value="<%= student.getBranch() %>" required>
                            </div>
                        </div>

                        <div class="text-end mt-4">
                            <button type="submit" class="btn btn-primary">
                                <i class="fas fa-save me-2"></i>Update Student
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>

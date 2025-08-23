
<%-- 
    Document   : employee_update
    Created on : Aug 13, 2025, 12:55:28 AM
    Author     : ADMIN
--%>
<%@page import="com.qt.apnweb.models.Employees"%>
<%@page import="com.qt.apnweb.controllers.EmployeeController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
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

/* Switch */
.form-check-input {
    width: 55px;
    height: 28px;
    cursor: pointer;
}

.form-check-input:checked {
    background-color: #4facfe;
    border-color: #4facfe;
    box-shadow: 0 0 6px rgba(79,172,254,0.6);
}

.form-check-label {
    font-weight: 500;
    color: #333;
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
                    <h2><i class="fas fa-user-edit me-2"></i>Update Employee</h2>
                    <p class="lead">Edit employee details below</p>
                </div>

                <% 
                    EmployeeController sc = new EmployeeController();
                    Employees employee = sc.findById(Integer.parseInt(request.getParameter("id")));
                %>

                <div class="card shadow-sm p-4">
                    <form action="EmployeeController" method="post">
                        <input type="hidden" name="action" value="update"/>
                        <input type="hidden" name="id" value="<%= employee.getId() %>"/>

                        <div class="row g-3">
                            <!-- Name -->
                            <div class="col-md-6">
                                <label class="form-label">Full Name</label>
                                <input type="text" class="form-control" name="name" value="<%= employee.getName() %>" required>
                            </div>

                            <!-- Email -->
                            <div class="col-md-6">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" name="email_id" value="<%= employee.getEmail() %>" required>
                            </div>

                            <!-- Contact -->
                            <div class="col-md-6">
                                <label class="form-label">Phone Number</label>
                                <input type="tel" class="form-control" name="contact_no" value="<%= employee.getContactNo() %>" required>
                            </div>

                            <!-- Designation -->
                            <div class="col-md-6">
                                <label class="form-label">Designation</label>
                                <input type="text" class="form-control" name="designation" value="<%= employee.getDesignation() %>" required>
                            </div>

                            <!-- Status (Toggle) -->
                            <div class="col-md-6 d-flex align-items-center mt-3">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" name="status" id="statusSwitch"
                                           <%= employee.getStatus() == 1 ? "checked" : "" %>>
                                    <label class="form-check-label" for="statusSwitch">Status: Active</label>
                                </div>
                            </div>

                            <!-- Salary -->
                            <div class="col-md-6">
                                <label class="form-label">Salary</label>
                                <input type="number" class="form-control" name="salary" value="<%= employee.getSalary() %>">
                            </div>

                            <!-- Address -->
                            <div class="col-md-12">
                                <label class="form-label">Address</label>
                                <input type="text" class="form-control" name="address" value="<%= employee.getAddress() %>">
                            </div>
                        </div>

                        <div class="text-end mt-4">
                            <button type="submit" class="btn btn-primary px-4 py-2">
                                <i class="fas fa-save me-2"></i>Update Employee
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

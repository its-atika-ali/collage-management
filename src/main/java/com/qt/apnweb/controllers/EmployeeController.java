/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.controllers;

import com.qt.apnweb.dao.EmployeeDao;
import com.qt.apnweb.models.Employees;
import com.qt.apnweb.models.response.ResponseMessages;
import com.qt.apnweb.services.EmployeeService;
import com.qt.apnweb.utilities.Utils;
import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {

    EmployeeService es = new EmployeeService();

    String emp_message;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employees employee = new Employees();

        String action = request.getParameter("action");

        if (action.equals("insert")) {

            try {
                employee.setName(Utils.requireNonNull(request.getParameter("name"),ResponseMessages.NAME_NOT_NULL.getMessage()));
                employee.setEmail(Utils.requireNonNull(request.getParameter("email_id"),ResponseMessages.EMAIL_NOT_NULL.getMessage()));
                employee.setContactNo(Utils.requireNonNull(request.getParameter("contact_no"), ResponseMessages.PHONE_NOT_NULL.getMessage()));
                employee.setDesignation(Utils.requireNonNull(request.getParameter("designation"),ResponseMessages.POST_NOT_NULL.getMessage()));
                employee.setYearsOfExperience(Integer.parseInt(Utils.requireNonNull(request.getParameter("years_of_experience"), ResponseMessages.YEARS_NOT_NULL.getMessage())));
                employee.setDateOfJoining(Utils.requireNonNull(request.getParameter("date_of_joining"), ResponseMessages.DATE_NOT_NULL.getMessage()));
                employee.setStatus(Integer.parseInt(Utils.requireNonNull(request.getParameter("status"), ResponseMessages.STATUS_NOT_NULL.getMessage())));
                employee.setSubject(Utils.requireNonNull(request.getParameter("subject"), ResponseMessages.SUB_NOT_NULL.getMessage()));
                employee.setIsTeaching(Utils.requireNonNull(request.getParameter("is_teaching"),ResponseMessages.IS_TEACHING_NOT_NULL.getMessage()));
                employee.setDepartment(Utils.requireNonNull(request.getParameter("department"),ResponseMessages.DEPT_NOT_NULL.getMessage()));
                employee.setDeptId(Utils.requireNonNull(request.getParameter("dept_id"), ResponseMessages.DEPT_ID_NOT_NULL.getMessage()));
                employee.setAddress(Utils.requireNonNull(request.getParameter("address"),ResponseMessages.ADDR_NOT_NULL.getMessage()));
                employee.setQualification(Utils.requireNonNull(request.getParameter("qualification"),ResponseMessages.QUAL_NOT_NULL.getMessage()));
                employee.setSalary(Double.parseDouble(Utils.requireNonNull(request.getParameter("salary"), ResponseMessages.SALARY_NOT_NULL.getMessage())));
                emp_message = es.save(employee);
            } catch (Exception e) {
                emp_message = e.getMessage();
            } finally {
                response.sendRedirect("index.jsp?emp_message=" + emp_message);
            }
        } else if (action.equals("delete")) {
            employee.setId(Integer.valueOf(request.getParameter("employee_id")));
            emp_message = es.delete(employee);
            response.sendRedirect("index.jsp?emp_message=" + emp_message);

        } else if (action.equals("update")) {

            employee.setId(Integer.parseInt(request.getParameter("id")));
            
              employee.setName(request.getParameter("name"));
                employee.setEmail(request.getParameter("email_id"));
                employee.setContactNo(request.getParameter("contact_no"));
                employee.setDesignation(request.getParameter("designation"));
                employee.setStatus(request.getParameter("status") != null ? 1 : 0);
                employee.setAddress(request.getParameter("address"));
                employee.setSalary(Double.parseDouble(request.getParameter("salary")));
               
            
           emp_message = es.update(employee);
request.setAttribute("emp_message", emp_message);
RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
rd.forward(request, response);



        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public ArrayList<Employees> findAll() {
        return es.findAll();
    }

    public Employees findById(Integer id) {
        return es.findById(id);
    }
}

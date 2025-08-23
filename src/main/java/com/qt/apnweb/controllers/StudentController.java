/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.controllers;

import com.qt.apnweb.models.Students;
import com.qt.apnweb.models.response.ResponseMessages;
import com.qt.apnweb.services.StudentService;
import com.qt.apnweb.utilities.Utils;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.internal.joptsimple.internal.Messages.message;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {
    StudentService ss = new StudentService();
     String message;

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
       
        Students student = new Students();
        

        String action = request.getParameter("action");
        
        if (action.equals("insert")) {

            try {
                student.setName(Utils.requireNonNull(request.getParameter("full_name"), ResponseMessages.NAME_NOT_NULL.getMessage()));
                student.setEmail(Utils.requireNonNull(request.getParameter("email_id"),ResponseMessages.EMAIL_NOT_NULL.getMessage()));
                student.setAddress(Utils.requireNonNull(request.getParameter("address"),  ResponseMessages.ADDR_NOT_NULL.getMessage()));
                student.setPhone(Utils.requireNonNull(request.getParameter("phone_no"), ResponseMessages.PHONE_NOT_NULL.getMessage()));
                 student.setPassword(Utils.requireNonNull(request.getParameter("password"), ResponseMessages.PASS_NOT_NULL.getMessage()));
                student.setBranch(Utils.requireNonNull(request.getParameter("branch"), ResponseMessages.BRANCH_NOT_NULL.getMessage()));
               
                message = ss.save(student);
            } catch (Exception e) {
                message = e.getMessage();
            } finally {
                response.sendRedirect("index.jsp?message=" + message);
            }
        } else if (action.equals("delete")) {
            student.setId(Integer.valueOf(request.getParameter("student_id")));
            message = ss.delete(student);
            response.sendRedirect("index.jsp?message=" + message);

        } else if (action.equals("update")) {

            student.setId(Integer.parseInt(request.getParameter("id")));
          
           
            student.setName(Utils.requireNonNull(request.getParameter("full_name"), ResponseMessages.NAME_NOT_NULL.getMessage()));
                student.setEmail(Utils.requireNonNull(request.getParameter("email_id"),ResponseMessages.EMAIL_NOT_NULL.getMessage()));
                student.setAddress(Utils.requireNonNull(request.getParameter("address"),  ResponseMessages.ADDR_NOT_NULL.getMessage()));
                student.setPhone(Utils.requireNonNull(request.getParameter("phone_no"), ResponseMessages.PHONE_NOT_NULL.getMessage()));
                 
                student.setBranch(Utils.requireNonNull(request.getParameter("branch"), ResponseMessages.BRANCH_NOT_NULL.getMessage()));
               

            message = ss.update(student);
            response.sendRedirect("students.jsp?message=" + message);
        }
    
         else if (action.equals("login")) {
            try {
                student.setPhone(Utils.requireNonNull(request.getParameter("phone_no"), ResponseMessages.PHONE_NOT_NULL.getMessage()));
                student.setPassword(Utils.requireNonNull(request.getParameter("password"), ResponseMessages.PASS_NOT_NULL.getMessage()));
                
                

                message = ss.login(student, request);
            } catch (Exception e) {
                message = e.getMessage();

            } finally {
                response.sendRedirect("index.jsp?message=" + message);
            }
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

    public ArrayList<Students> findAll() {
        return ss.findAll();
    }

    public Students findById(Integer id) {
        return ss.findById(id);
    }
}

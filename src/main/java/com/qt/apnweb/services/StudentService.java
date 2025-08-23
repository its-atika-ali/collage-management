/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.services;

import com.qt.apnweb.dao.StudentDao;
import com.qt.apnweb.models.Students;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class StudentService {

    StudentDao studentDAO = new StudentDao();

    public ArrayList<Students> findAll() {
        return studentDAO.findAll();

    }

    public String save(Students student) {
        student.setRollNo(001);
        student.setEnrollNo("334725");
        student.setSessionYear("2025-26");
        
        
        return studentDAO.save(student);
        
    }

    public String delete(Students student) {
        Students existingStudent = studentDAO.findById(student);
        if (existingStudent == null) {
            return "No record found with provided Id";
        }
        return studentDAO.delete(student);
    }

    public String update(Students newStudent) {
        Students existingStudent = studentDAO.findById(newStudent);
        if (existingStudent == null) {
            return "no users found with provided id";

        }
        existingStudent.setName(newStudent.getName());
        existingStudent.setEmail(newStudent.getEmail());
        existingStudent.setAddress(newStudent.getAddress());
        existingStudent.setPhone(newStudent.getPhone());
        existingStudent.setBranch(newStudent.getBranch());
        return studentDAO.update(existingStudent);
    }
    public Students findById(Integer id){
        Students student = new Students();
        student.setId(id);
        return studentDAO.findById(student);
    }

    public String login(Students student, HttpServletRequest request){
        
        String message = null;
        
        Students existingStudent = studentDAO.findByPhone(student.getPhone());
        if(existingStudent == null){
            throw new RuntimeException("PLease Register yourself or check your entered correct login details");
        
        }
        
        if(existingStudent.getPassword().equals(student.getPassword())){
            
            HttpSession session =  request.getSession();
            session.setAttribute("name", existingStudent.getName());
            session.setAttribute("id",existingStudent.getId());
            message = "Login successful";
            
            
            
        }
        else{
            throw new RuntimeException("You entered wrong password");
        }
    return message;
 }
   
}

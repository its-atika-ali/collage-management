/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.services;

import com.qt.apnweb.dao.EmployeeDao;
import com.qt.apnweb.models.Employees;

import java.util.ArrayList;


/**
 *
 * @author ADMIN
 */
public class EmployeeService {

    EmployeeDao employeeDAO = new EmployeeDao();

    public ArrayList<Employees> findAll() {
        return employeeDAO.findAll();
    }

    public String save(Employees employee) {
        employee.setEmpId(101);
       

        return employeeDAO.save(employee);
    }

    public String delete(Employees employee) {
        Employees existingEmployee = employeeDAO.findById(employee);
        if (existingEmployee == null) {
            return "No record found with provided id";
        }
        return employeeDAO.delete(employee);
    }

    public String update(Employees newEmployee) {
        Employees existingEmployee = employeeDAO.findById(newEmployee);

        if (existingEmployee == null) {
            return "No user found with provided id";
        }
        existingEmployee.setName(newEmployee.getName());
        existingEmployee.setEmail(newEmployee.getEmail());
        existingEmployee.setContactNo(newEmployee.getContactNo());
        existingEmployee.setDesignation(newEmployee.getDesignation());
        existingEmployee.setYearsOfExperience(newEmployee.getYearsOfExperience());
        existingEmployee.setDateOfJoining(newEmployee.getDateOfJoining());
        existingEmployee.setStatus(newEmployee.getStatus());
        existingEmployee.setSubject(newEmployee.getSubject());
        existingEmployee.setIsTeaching(newEmployee.getIsTeaching());
        existingEmployee.setDepartment(newEmployee.getDepartment());
        existingEmployee.setDeptId(newEmployee.getDeptId());
        existingEmployee.setAddress(newEmployee.getAddress());
        existingEmployee.setQualification(newEmployee.getQualification());
        existingEmployee.setSalary(newEmployee.getSalary());

        return employeeDAO.update(existingEmployee);
    }
    
    public Employees findById(Integer id){
        Employees employee = new Employees();
        employee.setId(id);
        return employeeDAO.findById(employee);
        
    }
  

}

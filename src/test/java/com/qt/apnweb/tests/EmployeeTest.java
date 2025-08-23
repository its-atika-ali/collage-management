/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.tests;

import com.qt.apnweb.models.Employees;
import com.qt.apnweb.services.EmployeeService;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class EmployeeTest {
    public static void main(String[] args){
        EmployeeService service = new EmployeeService();
        
        ArrayList<Employees> employeeList = service.findAll();
        for(Employees employees : employeeList){
            System.out.println(employees);
        }
                
               
             
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.tests;

import com.qt.apnweb.models.Students;
import com.qt.apnweb.services.StudentService;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class StudentTest {
    
    //Read Operation
//    public static void main(String[] args){
//        
//        StudentService service = new StudentService();
//        
//        ArrayList<Students> studentList = service.findAll();
//        for(Students students : studentList){
//            System.out.println(students);
//        }
//    }
//    
//    Create operation
//    public static void main(String args[]){
//        Students student = new Students();
//        
//        student.setName("Atika");
//        student.setEmail("aliatika607@gmail.com");
//        student.setAddress("Ghar pe");
//        student.setRollNo(56);
//        student.setEnrollNo("5");
//        student.setPhone("6388364792");
//        student.setBranch("CO");
//        student.setSessionYear("2025-2026");
//        
//        
//        
//        StudentService service = new StudentService();
//        System.out.println(service.save(student));
//        
//        System.out.println("After Insertion");
//        
//        ArrayList<Students> studentList = service.findAll();
//        for(Students students : studentList){
//        System.out.println(students );
//    
//    }
    
//}
    //Delete Operation
//    public static void main(String args[]){
//        Students stud = new Students();
//        stud.setId(20);
//        
//        
//        
//        
//        StudentService ss = new StudentService();
//        System.out.println(ss.delete(stud));
//        
//        System.out.println("\n------------After Deletion-----------");
//        ArrayList<Students> studentList = ss.findAll();
//        for(Students students : studentList){
//        System.out.println(students );
//        
//    }
//
//    } 
    
    //Update Operation
    
    public static void main(String[] args){
        Students student = new Students();
        
        student.setName("Saher");
        student.setEmail("saher@gmail.com");
        student.setAddress("Mankapur");
        student.setPhone("356475847");
        student.setBranch("CS");
        student.setId(6);
        
        StudentService ss = new StudentService();
        
        System.out.println(ss.update(student));
        
          System.out.println("\n------------After Update-----------");
       ArrayList<Students> studentList = ss.findAll();
       for(Students students : studentList){
      System.out.println(students );
    }
        
        
    }
}
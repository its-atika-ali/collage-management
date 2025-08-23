/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.models.response;

/**
 *
 * @author ADMIN
 */
public enum ResponseMessages {
    DATA_ADDED("Data added successfully"),
    DATA_UPDATED("Data updated successfully"),
    DATA_DELETED("Data deleted successfully"),
    NAME_NOT_NULL("Name cannot be empty"),
    PASS_NOT_NULL("Password cannot be empty"),
    PHONE_NOT_NULL("Phone no cannot be empty"),
    EMAIL_NOT_NULL("Email cannot be empty"),
    POST_NOT_NULL("Post cannot be empty"),
    YEARS_NOT_NULL("Enter years of Experience"),
    DATE_NOT_NULL("Date of joining cannot be empty"),
    STATUS_NOT_NULL("Status cannot be empty"),
    IS_TEACHING_NOT_NULL("Enter is teaching or not"),
    DEPT_NOT_NULL("Departmnet cannot be null"),
    DEPT_ID_NOT_NULL("Department id cannot be empty"),
    ADDR_NOT_NULL("Address cannot be empty"),
    QUAL_NOT_NULL("QUalifications canot be empty"),
    SALARY_NOT_NULL("Salary cannot be empty"),
    BRANCH_NOT_NULL("Branch cannot be empty"),
    SUB_NOT_NULL("Subject not null")
   
    
    
    
    
    ;
    
    
       private String message;
    private ResponseMessages(String message){
        this.message = message;
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
   
    
    
}

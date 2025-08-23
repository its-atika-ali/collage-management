/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.models;

/**
 *
 * @author ADMIN
 */
public class Employees {
    private int id;
    private int empId;
    private String name;
    private String email;
    private String contactNo;
    private String designation;
    private int yearsOfExperience;

    private String dateOfJoining;
    private int status;
    private String subject;
    private String isTeaching;
    private String department;
    private String deptId;
    private String address;
    private String qualification;
    private double salary;
    private String createdAt;
    private String modifiedAt;

    public Employees() {
    }

    public Employees(int id, int empId, String name, String email, String contactNo, String designation, int yearsOfExperience, String dateOfJoining, int status, String subject, String isTeaching, String department, String deptId, String address, String qualification, double salary, String createdAt, String modifiedAt) {
        this.id = id;
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.designation = designation;
        this.yearsOfExperience = yearsOfExperience;
        this.dateOfJoining = dateOfJoining;
        this.status = status;
        this.subject = subject;
        this.isTeaching = isTeaching;
        this.department = department;
        this.deptId = deptId;
        this.address = address;
        this.qualification = qualification;
        this.salary = salary;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIsTeaching() {
        return isTeaching;
    }

    public void setIsTeaching(String isTeaching) {
        this.isTeaching = isTeaching;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", empId=" + empId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", designation=" + designation + ", yearsOfExperience=" + yearsOfExperience + ", dateOfJoining=" + dateOfJoining + ", status=" + status + ", subject=" + subject + ", isTeaching=" + isTeaching + ", department=" + department + ", deptId=" + deptId + ", address=" + address + ", qualification=" + qualification + ", salary=" + salary + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }

    
    
}

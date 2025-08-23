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

//Model/POJO (Plain Old Java Object 
public class Students {
    int id;
    private String name;
    private String email;
    private String address;
    private int rollNo;
    private String enrollNo;
    private String phone;
    private String password;
    private String branch;
    private String sessionYear;
    private String  createdAt;
    private String modifiedAt;

    public Students() {
    }

    public Students(int id, String name, String email, String address, int rollNo, String enrollNo, String phone, String password, String branch, String sessionYear, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.rollNo = rollNo;
        this.enrollNo = enrollNo;
        this.phone = phone;
        this.password = password;
        this.branch = branch;
        this.sessionYear = sessionYear;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(String enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSessionYear() {
        return sessionYear;
    }

    public void setSessionYear(String sessionYear) {
        this.sessionYear = sessionYear;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", rollNo=" + rollNo + ", enrollNo=" + enrollNo + ", phone=" + phone + ", password=" + password + ", branch=" + branch + ", sessionYear=" + sessionYear + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }

   
    
}

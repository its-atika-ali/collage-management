/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.dao;

import com.qt.apnweb.database.ApnDb;
import com.qt.apnweb.models.Employees;
import com.qt.apnweb.models.response.ResponseMessages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class EmployeeDao {

    public ArrayList<Employees> findAll() {

        Connection connection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<Employees> employees = new ArrayList();
        String sql = "Select * from employees";

        try {
            connection = ApnDb.connectDB();
            cs = connection.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                employees.add(
                        new Employees(
                                rs.getInt("id"),
                                rs.getInt("emp_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("contact_no"),
                                rs.getString("designation"),
                                rs.getInt("years_of_experience"),
                                rs.getString("date_of_joining"),
                                rs.getInt("status"),
                                rs.getString("subject"),
                                rs.getString("is_teaching"),
                                rs.getString("department"),
                                rs.getString("dept_id"),
                                rs.getString("address"),
                                rs.getString("qualification"),
                                rs.getDouble("salary"),
                                rs.getString("created_at"),
                                rs.getString("modified_at")
                        )
                );

            }

        } catch (Exception e) {
            System.out.println("com.qt.apnweb.dao.EmpoyeeDao.findAll()" + e.getMessage());
        } finally {
            try {

                if (connection != null) {
                    connection.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }
        return employees;

    }

    public String save(Employees employee) {
        String emp_message = null;
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = " insert into employees(emp_id, name, email, contact_no, designation,years_of_experience, date_of_joining,status,subject,is_teaching, department, dept_id, address,qualification,salary)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            con = ApnDb.connectDB();
            cs = con.prepareCall(sql);

            cs.setInt(1, employee.getEmpId());
            cs.setString(2, employee.getName());
            cs.setString(3, employee.getEmail());

            cs.setString(4, employee.getContactNo());

            cs.setString(5, employee.getDesignation());

            cs.setInt(6, employee.getYearsOfExperience());

            cs.setString(7, employee.getDateOfJoining());

            cs.setInt(8, employee.getStatus());

            cs.setString(9, employee.getSubject());
            cs.setString(10, employee.getIsTeaching());
            cs.setString(11, employee.getDepartment());
            cs.setString(12, employee.getDeptId());
            cs.setString(13, employee.getAddress());
            cs.setString(14, employee.getQualification());
            cs.setDouble(15, employee.getSalary());

            int rows = cs.executeUpdate();

            if (rows >= 1) {

                emp_message = ResponseMessages.DATA_UPDATED.getMessage();

            }

        } catch (Exception e) {
            System.out.println("com.qt.apnweb.dao.EmployeeDao.save" + e.getMessage());

            emp_message = e.getMessage();

        } finally {
            try {

                if (con != null) {
                    con.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }
        return emp_message;
    }

    public String delete(Employees employee) {

        String emp_message = null;
        Connection con = null;
        CallableStatement cs = null;
        String sql = "delete from employees where id = ?";

        try {
            con = ApnDb.connectDB();
            cs = con.prepareCall(sql);
            cs.setInt(1, employee.getId());

            int rows = cs.executeUpdate();

            if (rows >= 1) {
                emp_message = "Data deleted successfully";
            }
        } catch (Exception e) {
            System.out.println("com.qt.apnweb.dao.EmployeeDao.delete" + e.getMessage());
            emp_message = "Unable to delete because of " + e.getMessage();

        } finally {
            try {

                if (con != null) {
                    con.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (Exception e) {

            }
        }
        return emp_message;

    }

    public Employees findById(Employees employee) {
        Employees existingEmployee = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "Select * from employees where id = ?";
        try {
            conn = ApnDb.connectDB();
            cs = conn.prepareCall(sql);
            cs.setInt(1, employee.getId());

            rs = cs.executeQuery();

            while (rs.next()) {
                existingEmployee = new Employees(
                        rs.getInt("id"),
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact_no"),
                        rs.getString("designation"),
                        rs.getInt("years_of_experience"),
                        rs.getString("date_of_joining"),
                        rs.getInt("status"),
                        rs.getString("subject"),
                        rs.getString("is_teaching"),
                        rs.getString("department"),
                        rs.getString("dept_id"),
                        rs.getString("address"),
                        rs.getString("qualification"),
                        rs.getDouble("salary"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );

            }
        } catch (Exception e) {
            System.out.println("com.qt.dao.EmployeeDao.findById()" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
        return existingEmployee;
    }

    public String update(Employees employee) {
        String emp_message = null;
        Connection conn = null;
        CallableStatement cs = null;
        String sql = "Update employees set name = ?, email = ?, contact_no = ?, designation = ?, years_of_experience = ?, date_of_joining = ?, status = ?, subject = ?, is_teaching = ?, department = ?, dept_id = ?, address = ?, qualification = ?, salary = ? where id = ?";

        try {
            conn = ApnDb.connectDB();
            cs = conn.prepareCall(sql);

            cs.setString(1, employee.getName());

            cs.setString(2, employee.getEmail());

            cs.setString(3, employee.getContactNo());

            cs.setString(4, employee.getDesignation());

            cs.setInt(5, employee.getYearsOfExperience());

            cs.setString(6, employee.getDateOfJoining());

            cs.setInt(7, employee.getStatus());

            cs.setString(8, employee.getSubject());
            cs.setString(9, employee.getIsTeaching());
            cs.setString(10, employee.getDepartment());
            cs.setString(11, employee.getDeptId());
            cs.setString(12, employee.getAddress());
            cs.setString(13, employee.getQualification());
            cs.setDouble(14, employee.getSalary());
            cs.setInt(15, employee.getId());

            int rows = cs.executeUpdate();
            if (rows >= 1) {
                emp_message = ResponseMessages.DATA_UPDATED.getMessage();

            }
        } catch (Exception e) {
            System.out.print("com.qt.apnweb.dao.EmployeeDao.update()" + e.getMessage());
            emp_message = "Unable to update because of : " + e.getMessage();

        } finally {
            try {
                if (conn != null) {
                    conn.close();

                }
                if (cs != null) {
                    cs.close();
                }
            } catch (Exception e) {

            }

        }

        return emp_message;

    }

}

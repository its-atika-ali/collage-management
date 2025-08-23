/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.dao;

import com.qt.apnweb.database.ApnDb;
import com.qt.apnweb.models.Students;
import com.qt.apnweb.models.response.ResponseMessages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author ADMINg
 */
//Dta Access Object
public class StudentDao {

    public ArrayList<Students> findAll() {

        Connection connection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<Students> students = new ArrayList();
        String sql = "Select * from students";

        try {
            connection = ApnDb.connectDB();
            cs = connection.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                students.add(
                        new Students(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("address"),
                                rs.getInt("roll_no"),
                                rs.getString("enrollment_no"),
                                rs.getString("phone"),
                                rs.getString("Password"),
                                rs.getString("branch"),
                                rs.getString("session_year"),
                                rs.getString("created_at"),
                                rs.getString("modified_at")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println("com.qt.apnweb.dao.StudentDao.findAll()" + e.getMessage());

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
        return students;

    }

    public String save(Students student) {
        String message = null;
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "insert into students(name, email, address, roll_no, enrollment_no, phone,password, branch , session_year)  values(?,?,?,?,?,?,?,?,?) ";

        try {

            con = ApnDb.connectDB();
            cs = con.prepareCall(sql);

            cs.setString(1, student.getName());

            cs.setString(2, student.getEmail());
            cs.setString(3, student.getAddress());
            cs.setInt(4, student.getRollNo());
            cs.setString(5, student.getEnrollNo());
            cs.setString(6, student.getPhone());
             cs.setString(7, student.getPassword());

            cs.setString(8, student.getBranch());
            cs.setString(9, student.getSessionYear());
           
            int rows = cs.executeUpdate();

            if (rows >= 1) {
                message = ResponseMessages.DATA_UPDATED.getMessage();

            }
        } catch (Exception e) {
            System.out.println("com.qt.apnweb.dao.StudentDao.save" + e.getMessage());

            message = e.getMessage();
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

        return message;
    }

    //To delete a record
    public String delete(Students student) {
        String message = null;
        Connection con = null;
        CallableStatement cs = null;
        String sql = "delete from students where id = ?";
        try {
            con = ApnDb.connectDB();
            cs = con.prepareCall(sql);
            cs.setInt(1, student.getId());

            int rows = cs.executeUpdate();

            if (rows >= 1) {
                message = "Data deleted successfully";

            }
        } catch (Exception e) {
            System.out.println("con.qt.apnweb.dao.StudentDao.delete" + e.getMessage());
            message = "Unable to delete because of :" + e.getMessage();

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

        return message;

    }

    public Students findById(Students student) {
        Students existingStudent = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "Select * from students where id = ?";
        try {
            conn = ApnDb.connectDB();
            cs = conn.prepareCall(sql);
            cs.setInt(1, student.getId());

            rs = cs.executeQuery();

            while (rs.next()) {
                existingStudent = new Students(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("roll_no"),
                        rs.getString("enrollment_no"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getString("branch"),
                        rs.getString("session_year"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );

            }
        } catch (Exception e) {
            System.out.println("com.qt.dao.StudentDao.findById()" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
        return existingStudent;
    }

    public String update(Students student) {
        String message = null;
        Connection conn = null;
        CallableStatement cs = null;
        String sql = "update students set name = ?, email = ? , address = ?,phone = ?, branch = ? where id = ?";

        try {
            conn = ApnDb.connectDB();
            cs = conn.prepareCall(sql);
            cs.setString(1, student.getName());
            cs.setString(2, student.getEmail());
            cs.setString(3, student.getAddress());
            cs.setString(4, student.getPhone());
            cs.setString(5, student.getBranch());

            cs.setInt(6, student.getId());

            int rows = cs.executeUpdate();
            if (rows >= 1) {
                message = "Data updated successfully";

            }
        } catch (Exception e) {
            System.out.print("com.qt.apnweb.dao.StudentDao.update()" + e.getMessage());
            message = "Unable to update because of : " + e.getMessage();

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

        return message;

    }
    
    public Students findByPhone(String phoneNo){
        
        Students existingStudent = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "select * from Students where phone =?";
        
        try{
            conn = ApnDb.connectDB();
            cs = conn.prepareCall(sql);
            cs.setString(1, phoneNo);
            rs = cs.executeQuery();
            
            while(rs.next()){
                existingStudent = new Students(
                        
                         rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("roll_no"),
                        rs.getString("enrollment_no"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getString("branch"),
                        rs.getString("session_year"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                        
                        
                );
                
            
            }
            
        }catch(Exception e){
            System.out.println("com.qt.apnweb.dao.StudentDao.findByPhone()"+e.getMessage());
            
        }finally{
            
            try {
                if (conn != null) {
                    conn.close();
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
        return existingStudent;
    }
}

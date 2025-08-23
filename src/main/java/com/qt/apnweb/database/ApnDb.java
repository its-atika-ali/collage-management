/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class ApnDb {
    
    //MySql details 
    private static final String DATABASE = "studentDB";
    private static final String URL ="jdbc:mysql://localhost:3306/"+DATABASE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "$ayyad@tika510";
    
    
    public static Connection connectDB(){
        
        Connection connection = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //Connecting to the databse 
            System.out.println("Done");
    }
        catch(Exception e){
            System.out.println("Ala re Aala, error Aala"+e.getMessage());
        }
            return connection;
        }
    
    
    public static void main(String[] args){
        connectDB();
}
}


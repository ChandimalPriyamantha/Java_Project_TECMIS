/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class StudentDBCon {
      static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/tecmis_db";
    static String uname = "root";
    static String pass = "";
    
    
    public static Connection Connect(){
        try
        {
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url, uname, pass);
        }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.tecnicalOfficer;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ganidusahan
 */
public class DBconnect {
    
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tecmis_DB","root","Csgs2413@");
        }catch(Exception e){
            System.out.println(e);
        }
        
        return con;
    }
    
}

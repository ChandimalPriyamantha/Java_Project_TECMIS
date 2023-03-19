/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class student extends User
{
    
    private String level;
    
   
    public student() 
    {      
        String q="SELECT level FROM STUDENT WHERE id= ";
    }
    
    public String getlevel()
    {
        return level;
    }

    public void setlevel(String level) 
    {
        this.level = level;
    }
    
    public static void main(String[] args) {
        student s=new student();
    }
    
}



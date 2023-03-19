/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class viewImple implements studentInterface{

        
  //  String query;


    @Override
    public void tableview(String query) {
        
          try
        {
           
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs=(ResultSet)pst.executeQuery();
            
           //tbl.setModel(DbUtils.resultSetToTableModel((ResultSet)rs));
            
            //tableview(query,tbl);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}

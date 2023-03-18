/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.B05.course;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CourseMaterials {
    
    private int Material_ID;
    private String coure_code;
    private String filePath;

    public int getMaterial_ID() {
        return Material_ID;
    }

    public void setMaterial_ID(int Material_ID) {
        this.Material_ID = Material_ID;
    }

    public String getCoure_code() {
        return coure_code;
    }

    public void setCoure_code(String coure_code) {
        this.coure_code = coure_code;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
     public List<CourseMaterials> list()
     {
       List<CourseMaterials> list = new ArrayList<CourseMaterials>();
       
       
       try
       {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM coursematerials";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
                           
             while(rs.next()){  
               CourseMaterials cm=new CourseMaterials();
               cm.setMaterial_ID(rs.getInt("Material_ID"));
               cm.setCoure_code(rs.getString("course_code"));
               cm.setFilePath(rs.getString("filePath"));
               
               
               list.add( cm);
            }
            }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        
        return list;
    }
    
     
     
     
        public  CourseMaterials get(String id) {
        
            CourseMaterials cm =new CourseMaterials();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM coursematerials WHERE course_code=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
             
               cm.setMaterial_ID(rs.getInt("Material_ID"));
               cm.setCoure_code(rs.getString("course_code"));
               cm.setFilePath(rs.getString("filePath"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return cm;
    }
   
}
     
     
     
     
     
     
     
     
     
     
     
     


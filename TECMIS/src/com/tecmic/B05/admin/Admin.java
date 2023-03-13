/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.admin;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import com.tecmis.B05.notice.Notice;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.JOptionPane;


/**
 *
 * @author Vivobook
 */
public class Admin extends User{
    
   public void CrateNotice(Notice notice ){
      
        try {
            Connection con =  TecmisDB.getConnection();
            String sql = "INSERT INTO notice(file_path,title,date_and_time,discripsion) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(notice.getDescription());
            ps.setString(1, notice.getFilePath());
            ps.setString(2, notice.getTitle());
            ps.setString(3, notice.getDate_Time());
            ps.setString(4, notice.getDescription());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   }
   
   
   public void EditNotice(Notice notice){
       
   
       try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "UPDATE notice SET file_path=?,title=?,date_and_time=?, discripsion=? WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notice.getFilePath());
            ps.setString(2, notice.getTitle());
            ps.setString(3, notice.getDate_Time());
            ps.setString(4, notice.getDescription());
             ps.setString(5, notice.getNoticeID());
            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   
   public void deleteNotice(Notice notice){
       
       try {
          
            Connection con = TecmisDB.getConnection();
            String sql = "delete from notice  WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, notice.getNoticeID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
   
   }
   
   
  
    
}

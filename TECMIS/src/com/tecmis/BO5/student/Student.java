/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import com.tecmis.B05.notice.Notice;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import sun.awt.www.content.image.png;

/**
 *
 * @author ACER
 */
public class Student extends User
{
    /*public Notice get(int notice_id){
        Notice nt = new Notice();
        try{
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM notice";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            nt.setNoticeID(sql);
            nt.setFilePath(sql);
            nt.setTitle(sql);
            nt.setDate_Time(sql);
            nt.setDescription(sql);
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");

        }
        return nt;
    }*/
    
}



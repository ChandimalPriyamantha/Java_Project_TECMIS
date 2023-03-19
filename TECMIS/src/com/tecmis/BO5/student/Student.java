/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmis.BO5.student;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmic.B05.user.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Student extends User
{

    public Student() {
        
       Auth auth = Auth.getInstance();
       String usr = auth.getUsername();
       studentDetails(usr);
       
    }
    
    
     public void  studentDetails(String uname)
    {
       Student s=new Student();
        try
        {
           
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM student where username='"+ uname + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                s.setUserID(rs.getString("id"));
                s.setNIC(rs.getString("nic"));
                s.setFirstName(rs.getString("fname"));
                s.setMiddleName(rs.getString("mname"));
                s.setLastName(rs.getString("lname"));
                s.setBirthDate(rs.getString("birth_date"));
                s.setAddress(rs.getString("address"));
                s.setSex(rs.getString("sex"));
                s.setLevel(rs.getString("level"));
                s.setPhoneNumner(rs.getString("phone_no"));
                s.setUserName(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setEmail(rs.getString("email"));
                s.setImagePathe(rs.getString("image_path"));
                s.setLevel(rs.getString("level"));
                s.setDepartmentID(rs.getString("department_id"));
 
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void EditProfile(Student student){
       String sql;
       PreparedStatement ps;
       try{
       Connection con =  TecmisDB.getConnection();
            sql = "UPDATE student SET id=?,nic=?,fname=?,mname=?,lname=?,birth_date=?,address=?,sex=?,phone_no=?,username=?,password=?,email=?,image_path=?,level=?,department_department_id=? WHERE id=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, student.getUserID());
            ps.setString(2, student.getNIC());
            ps.setString(3, student.getFirstName());
            ps.setString(4, student.getMiddleName());
            ps.setString(5, student.getLastName());
            ps.setString(6, student.getBirthDate());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getSex());
            ps.setString(9, student.getPhoneNumner());
            ps.setString(10, student.getUserName());
            ps.setString(11, student.getPassword());
            ps.setString(12, student.getEmail());
            ps.setString(13, "E:\\Profile_pic\\TechnicalOfficer\\'"+student.getUserID()+"'.png");
            ps.setString(14, student.getLevel());
            ps.setString(14, student.getDepartmentID());
            ps.setString(15, student.getUserID());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
       
       try{
              
            String file = student.getImagePathe(); 
            BufferedImage image = ImageIO.read(new File(file));
            ImageIO.write(image , "png", new File("E:\\Profile_pic\\TechnicalOfficer\\'"+student.getUserID()+"'.png"));
               
           }catch(Exception e){
               
               JOptionPane.showMessageDialog(null, "Image Update Error!");
           }
    }
    
    
}



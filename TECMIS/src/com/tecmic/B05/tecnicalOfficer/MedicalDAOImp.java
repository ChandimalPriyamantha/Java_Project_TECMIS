/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.tecnicalOfficer;

import com.tecmic.B05.TecmisDB.TecmisDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ganidusahan
 */
public class MedicalDAOImp implements MedicalDAO{

    @Override
    public void save(Medical medical) {
        
        try{
            
            Connection con = TecmisDB.getConnection();
            String sql = "INSERT INTO medical(date,state,description,department_id,subject_code,student_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,medical.getDate());
            ps.setString(2,medical.getState());
            ps.setString(3,medical.getDescription());
            ps.setString(4,medical.getDepartment_id());
            ps.setString(5,medical.getSubject_code());
            ps.setString(6,medical.getStudent_id());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SAVED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }

    @Override
    public void update(Medical medical) {
        
        try{
            
           Connection con = TecmisDB.getConnection();
           String sql = "UPDATE attendance SET type=?,state=?,date=?,course_id=?,lecturer_id=?,hour=?,student_id=? WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,medical.getDate());
           ps.setString(2,medical.getState());
           ps.setString(3,medical.getDescription());
           ps.setString(4,medical.getDepartment_id());
           ps.setString(5,medical.getSubject_code());
           ps.setString(6,medical.getStudent_id());
           ps.executeUpdate();
           
           
           JOptionPane.showMessageDialog(null, "UPDATED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
    }

    @Override
    public void delete(Medical medical) {
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "DELETE FROM attendance WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, attendance.getAttendence_id());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "DELETED!");
           
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        
        
    }

    @Override
    public Medical get(int medical_id) {
        Attendance st = new Attendance();
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM attendance WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,attendence_id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               st.setAttendence_id(rs.getInt("attendence_id"));
               st.setType(rs.getString("type"));
               st.setState(rs.getString("state"));
               st.setDate(rs.getString("date"));
               st.setCourse_id(rs.getString("course_id"));
               st.setLecturer_id(rs.getString("lecturer_id"));
               st.setHour(rs.getInt("hour"));
               st.setStudent_id(rs.getString("student_id"));
               
           }
           
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return st;
        
        
    }

    @Override
    public List<Medical> list() {
        
        List<Attendance> list = new ArrayList<Attendance>();
        try{
           
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM attendance";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Attendance st = new Attendance();
               st.setAttendence_id(rs.getInt("attendence_id"));
               st.setType(rs.getString("type"));
               st.setState(rs.getString("state"));
               st.setDate(rs.getString("date"));
               st.setCourse_id(rs.getString("course_id"));
               st.setLecturer_id(rs.getString("lecturer_id"));
               st.setHour(rs.getInt("hour"));
               st.setStudent_id(rs.getString("student_id"));
               
               list.add(st);
           }
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERROR");
       } 
        return list;
    }
        
}
    

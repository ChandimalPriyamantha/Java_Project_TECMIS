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
public class AttendanceDAOImp implements AttendanceDAO{

    @Override
    public void save(Attendance attendance) {
        try{
            
            Connection con = TecmisDB.getConnection();
            String sql = "INSERT INTO attendance(type,state,date,course_id,lecturer_id,hour,student_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,attendance.getType());
            ps.setString(2,attendance.getState());
            ps.setString(3,attendance.getDate());
            ps.setString(4,attendance.getCourse_id());
            ps.setString(5,attendance.getLecturer_id());
            ps.setInt(6, attendance.getHour());
            ps.setString(7,attendance.getStudent_id());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SAVED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-attendence-save");
        }
    }

    @Override
    public void update(Attendance attendance) {
        
        try{
            
           Connection con = TecmisDB.getConnection();
           String sql = "UPDATE attendance SET type=?,state=?,date=?,course_id=?,lecturer_id=?,hour=?,student_id=? WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1,attendance.getType());
           ps.setString(2,attendance.getState());
           ps.setString(3,attendance.getDate());
           ps.setString(4,attendance.getCourse_id());
           ps.setString(5,attendance.getLecturer_id());
           ps.setInt(6, attendance.getHour());
           ps.setString(7,attendance.getStudent_id());
           ps.executeUpdate();
           
           
           JOptionPane.showMessageDialog(null, "UPDATED!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-attendence-update");
        }
    }

    @Override
    public void delete(Attendance attendance) {
        
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "DELETE FROM attendance WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, attendance.getAttendence_id());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "DELETED!");
           
            
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-attendence-delete");
        }
        
    }

    @Override
    public Attendance get(int attendence_id) {
        Attendance atnd = new Attendance();
        try{
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM attendance WHERE attendence_id=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,attendence_id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               atnd.setAttendence_id(rs.getInt("attendence_id"));
               atnd.setType(rs.getString("type"));
               atnd.setState(rs.getString("state"));
               atnd.setDate(rs.getString("date"));
               atnd.setCourse_id(rs.getString("course_id"));
               atnd.setLecturer_id(rs.getString("lecturer_id"));
               atnd.setHour(rs.getInt("hour"));
               atnd.setStudent_id(rs.getString("student_id"));
               
           }
           
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR-attendence-search");
        }
        return atnd;
    }

    @Override
    public List<Attendance> list() {
        List<Attendance> list = new ArrayList<Attendance>();
        try{
           
           Connection con = TecmisDB.getConnection();
           String sql = "SELECT * FROM attendance";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Attendance atnd = new Attendance();
               atnd.setAttendence_id(rs.getInt("attendence_id"));
               atnd.setType(rs.getString("type"));
               atnd.setState(rs.getString("state"));
               atnd.setDate(rs.getString("date"));
               atnd.setCourse_id(rs.getString("course_id"));
               atnd.setLecturer_id(rs.getString("lecturer_id"));
               atnd.setHour(rs.getInt("hour"));
               atnd.setStudent_id(rs.getString("student_id"));
               
               list.add(atnd);
           }
           
       }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "ERROR-attendence-list");
       } 
        return list;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecmic.B05.Medical;

import com.tecmic.B05.TecmisDB.TecmisDB;
import com.tecmis.B05.notice.Notice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vivobook
 */
public class Medical {
    
    private String medicalID;
    private String date;
    private String subjectCode;
    private String departmentId;
    private String description;
    private String student_id;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    

    public String getMedicalID() {
        return medicalID;
    }

    public void setMedicalID(String medicalID) {
        this.medicalID = medicalID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public List<Medical> list() {
        
       List<Medical> list = new ArrayList<Medical>();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM medical";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
               
                Medical medical = new Medical();
                
                medical.getMedicalID(rs.getString("medical_id"));
                notice.setTitle(rs.getString("date"));
                notice.setDate_Time(rs.getString("state"));
                notice.setDescription(rs.getString("discription"));
                notice.setDescription(rs.getString("department_id"));
                notice.setDescription(rs.getString("subject_code"));
                notice.setDescription(rs.getString("student_id"));
                
                
 
                list.add(notice);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
  
    
    }
    
    public Notice get(int id) {
        Notice notice = new Notice();
        try {
            Connection con = TecmisDB.getConnection();
            String sql = "SELECT * FROM notice WHERE notice_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                setNoticeID(rs.getString("notice_id"));
                setFilePath(rs.getString("file_path"));
                setTitle(rs.getString("title"));
                setDate_Time(rs.getString("date_and_time"));
                setDescription(rs.getString("discripsion"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return notice;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import com.sms.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Siron
 */
public class TeacherDao {
    
    public boolean insert(Teacher t){
         boolean status = false;
         Connection conn= DbConnection.connect();
         PreparedStatement ps = null;
         
         if(conn==null){
            System.out.println("Db connection not available");
            } 
         else{
            try{
            String sql="insert into teacher_table(subject,name,salary) values (?,?,?)";
            ps= conn.preparedStatement(sql);
            ps.setString(1,t.getSubject());
            ps.setString(2,t.getName());
            ps.setDouble(3,t.getSalary());
            
            if(ps.executeUpdate()>0){
                status=true;
            }
    
        }catch(SQLException se){
            System.out.println(se);
        }finally{
                try{
                    if(ps!=null)
                        ps.close();
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    System.out.println(se);
                }
            }
        }
         
         return status;   
    }
}

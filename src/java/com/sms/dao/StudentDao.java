/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import com.sms.model.Course;
import com.sms.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Siron
 */
public class StudentDao {
    //insert or update operation
    
    public boolean insert (Student s){
        boolean status =false;
        // i try to insert student object into student table
        Connection conn= DbConnection.connect();
        PreparedStatement ps= null;
        
        String sql1="insert into student_table(name,gender,hobbies,course,country) values(?,?,?,?,?)";
        
        String sql2 = "update student_table set name=?, gender=?, hobbies=? ,course=?,country=? where id=?";
        try{
            if(s.getId()==0){
            ps = conn.prepareStatement(sql1);
            }else{
                ps=conn.prepareStatement(sql2);
                ps.setInt(6,s.getId());
            }
            ps.setString(1,s.getName());
            ps.setString(2, s.getGender());
            ps.setString(3,s.getHobbies());
            ps.setInt(4,s.getCourse());
            ps.setString(5,s.getCountry());
            
            
            if(ps.executeUpdate()==1){
                status = true;
            }
            
        } catch(SQLException se){
            System.out.println(se);
        }
            finally{
                try{
                    if(ps!=null)
                        ps.close();
                  
                        conn.close();
                
                } catch(SQLException se){
                    System.out.println(se);
                }
                
            }
        
        return status;
    }
    
     public ArrayList<Student> getAllStudent(){
        ArrayList<Student> sl = new ArrayList();
        Connection conn = DbConnection.connect();
        PreparedStatement ps= null;
        
        if(conn==null){
            System.out.println("database connection not available");
            
        }
        else{
            //connection available
            String sql="select * from student_table";
            
            try{
            
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               sl.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getString("gender"),rs.getString("hobbies"),rs.getInt("course"),rs.getString("country")));
            }
            }catch(SQLException se){
                System.out.println(se);
            } finally{
                try{
                    if(ps!=null)
                        ps.close();
                    if(conn!=null)
                        conn.close();
                }catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
      return sl;  
    } 
     
 public Student selectStudentById(int id){
        Student s= null;
        Connection conn= DbConnection.connect();
        PreparedStatement ps = null;
        if(conn==null){
            System.out.println("Connection not available");
        }
        else{
            String sql="select id,name,gender,hobbies,course,country from student_table where id=?";
            try{
                ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                if(rs.next()){
                    s= new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                }
                
            }catch(SQLException se){
                System.out.println(se);
            }finally{
                try{
                    if(ps!=null)
                        ps.close();
                    if(conn!=null)
                        conn.close();
                
                } catch(SQLException se){
                    System.out.println(se);
                }
            }
        }
        return s;
    }
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import com.sms.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Siron
 */
public class CourseDao {
    
    public boolean insert(Course c){
        boolean status=false;
        Connection conn =DbConnection.connect();
        PreparedStatement ps= null;
         
        if(conn==null){
            System.out.println("Database connection not available");
        }else{
            //perform database operation
            try{
                String sql="insert into course_table(title,duration,price) values(?,?,?)";
                ps=conn.prepareStatement(sql);
                ps.setString(1,c.getTitle());
                ps.setString(2,c.getDuration());
                ps.setDouble(3,c.getPrice());
                
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
    
    public ArrayList<Course> getAllCourse(){
        ArrayList<Course> cl = new ArrayList();
        Connection conn = DbConnection.connect();
        PreparedStatement ps= null;
        
        if(conn==null){
            System.out.println("database connection not available");
            
        }
        else{
            //connection available
            String sql="select * from course_table";
            
            try{
            
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               cl.add( new Course(rs.getInt("id"),rs.getString("title"),rs.getString("duration"),rs.getDouble("price")));
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
      return cl;  
    } 
    
    public Course selectById(int id){
        Course c= null;
        Connection conn= DbConnection.connect();
        PreparedStatement ps = null;
        if(conn==null){
            System.out.println("Connection not available");
        }
        else{
            String sql="select id,title,duration,price from course_table where id=?";
            try{
                ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                if(rs.next()){
                    c= new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
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
        return c;
    }
    
    public boolean update(Course cm){
        boolean status=false;
        Connection conn = DbConnection.connect();
        PreparedStatement ps= null;
        
        if(conn == null){
            System.out.println("database connection not available");
        }else{
            //when connected to database perform following
            String sql="update course_table set title=?, duration=?, price=? where id=?";
            try{
                ps= conn.prepareStatement(sql);
                ps.setString(1,cm.getTitle());
                ps.setString(2,cm.getDuration());
                ps.setDouble(3,cm.getPrice());
                ps.setInt(4,cm.getId());
                if (ps.executeUpdate()>0){
                System.out.println("Recored inserted");
                status=true;
            }
                
            } catch(SQLException se){
                System.out.println(se);
                
            }finally{
                try{
                    if(ps!=null)
                        ps.close();
                  
                        conn.close();
                
                } catch(SQLException se){
                    System.out.println(se);
                }
            }
        }
        
        return status;
    
    
}

public boolean delete (int id){
         boolean status=false;
        Connection conn = DbConnection.connect();
        PreparedStatement ps= null;
        
        if(conn == null){
            System.out.println("database connection not available");
        }else{
            //when connected to database perform following
            String sql="delete from  course_table where id=?";
        
            try{
                ps= conn.prepareStatement(sql);
                ps.setInt(1,id);
                if (ps.executeUpdate()>0){
                System.out.println("Recored deleted");
                status=true;
                }
            
                
            } catch(SQLException se){
                System.out.println(se);
                
            }finally{
                try{
                    if(ps!=null)
                        ps.close();
                  
                        conn.close();
                
                } catch(SQLException se){
                    System.out.println(se);
                }
                
            }
            
               
            }
         
                return status;
}

}
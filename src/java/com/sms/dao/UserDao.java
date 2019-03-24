/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import com.sms.model.UserDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author test
 */
public class UserDao {

    public boolean addUser(UserDetail ud) {

        boolean status = false;
        Connection conn = DbConnection.connect();
        PreparedStatement ps = null;
        int foreign_key = 0;

        String sql1 = "insert into user_detail(firstname,lastname,email,dob,image) values(?,?,?,?,?)";

        String sql2 = "select id from user_detail where email=?";

        String sql3 = "insert into user_login(username,password,authority,active,user_id) values(?,?,?,?,?)";

        try {
            //1.save userdetail info into user_detail table
            ps = conn.prepareStatement(sql1);

            ps.setString(1, ud.getFirstName());
            ps.setString(2, ud.getLastName());
            ps.setString(3, ud.getEmail());
            ps.setDate(4, Date.valueOf(ud.getDob()));//Date is imported and value of will change Localdate into Date type of data .....
            ps.setString(5, ud.getImage());

            if (ps.executeUpdate() > 0) {

                System.out.println("user detail inserted!");

                //2.
                //get primary key...for that:
                //run select query using unique field email
                //this returns a primary key value which is used to insert as a 
                //foreign key in user_login table...
                ps = conn.prepareStatement(sql2);
                ps.setString(1, ud.getEmail());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    foreign_key = rs.getInt("id");//we can use object ...
                    //fetch id of recently inserted user_detail object.

                    System.out.println(foreign_key);

                    //3.save user login info into user_login table
                    ps = conn.prepareStatement(sql3);

                    ps.setString(1, ud.getUsername());
                    ps.setString(2, ud.getPassword());
                    ps.setString(3, ud.getAuthority());
                    ps.setString(4, ud.getActive());
                    ps.setInt(5, foreign_key);

                    if (ps.executeUpdate() > 0) {
                        System.out.println("user login info added!!");
                        status = true;
                    }
                }

            }

        } catch (SQLException se) {
            System.out.println(se);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException se) {
                System.out.println(se);
            }
        }

        return status;
    }
    
    public static boolean validateUser(String un, String pw, String au){
        
        boolean valid = false;
        Connection conn = DbConnection.connect();
        PreparedStatement ps =null;
        
        if(conn!=null){
            
            String sql = "select authority,active from user_login where username=? and password=?";
            try{
                ps = conn.prepareStatement(sql);
                
                ps.setString(1, un);
                ps.setString(2, pw);
                
                ResultSet rs = ps.executeQuery();
                // here username is also unique....
                if(rs.next()){
                    if(rs.getString(1).equals(au) && rs.getString("active").equals("1")){//checking for authority match and if that user is active
                        valid = true;
                    }
                }
            }catch(SQLException se){
                System.out.println(se);
            }finally{
                try{
                    if(ps!= null){
                        ps.close();
                    }
                    conn.close();
                }catch(SQLException se){
                    System.out.println(se);
                }
            }
        }
        
        return valid;
    }
}

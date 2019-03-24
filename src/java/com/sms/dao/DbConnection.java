/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Siron
 */
public class DbConnection {
    
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/sms";
    private static final String USER ="root";
    private static final String PASS ="";
    
    
    public static  Connection connect(){
        
        Connection conn = null;
        
        try{
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URL,USER,PASS);
            
        }catch(ClassNotFoundException | SQLException ee){
            
            System.out.println(ee);
        }
        return conn;
        
    }
    
    
}

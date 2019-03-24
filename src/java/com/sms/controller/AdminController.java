/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author test
 */
@WebServlet({"/admin/home","/admin/dashboard","/login","/logout"})//if there is braces than it can takearray 
public class AdminController extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uri = request.getRequestURI();
        String cp = request.getContextPath();
        
         if(uri.equals(cp + "/admin/home")){//such type of url patterns helps to filter the admin request...
            request.getRequestDispatcher("/admin/admindashboard.jsp").forward(request, response);
            //one line code for previous steps...
            
        }
        
       
        else if(uri.equals(cp + "/login")){
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
        else if(uri.equals(cp + "/logout")){
            HttpSession s = request.getSession(false);
            
            if(s!=null){
                s.invalidate();
            }
            
            response.sendRedirect(cp + "/login?logout");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String cp = request.getContextPath();
        
        if(uri.equals(cp + "/login")){
            //authenticate and authorize user
            String username = request.getParameter("luser");
            String password = request.getParameter("lpassword");
            String authority = request.getParameter("lauthority");
            
             if(new UserDao().validateUser(username,password,authority)){
                 //start a new session...
                HttpSession s = request.getSession();
                
                if(authority.equals("admin")){
                  s.setAttribute("user", "admin");  
                  response.sendRedirect(cp + "/admin/home");
                }else{
                    s.setAttribute("user", "user");
                    response.sendRedirect(cp + "/user/profile");
                }
             }else{
                 response.sendRedirect(cp + "/login?failure");
             }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


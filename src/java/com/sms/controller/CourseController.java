/*
 * To change this liczzzense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.dao.CourseDao;
import com.sms.model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siron
 */
@WebServlet(name = "CourseController", urlPatterns = {"/admin/course/add", "/admin/course/display","/admin/course/edit","/admin/course/update","/admin/course/delete"})
public class CourseController extends HttpServlet {
    
    private static  CourseDao courseDao = new CourseDao();

    
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
        
        if(uri.equals(cp+"/admin/course/add")){
            request.getRequestDispatcher("/admin/addcourse.jsp").forward(request,response);
            
        }else if(uri.equals(cp+"/admin/course/display")){
            //fetch some data and add it to request object as an attribute
             request.setAttribute("courselist",courseDao.getAllCourse());
             request.getRequestDispatcher("/admin/showcourse.jsp").forward(request,response);
        }
        
        else if(uri.equals(cp+"/admin/course/edit")){
            //read id from request parameter
            int id= Integer.parseInt(request.getParameter("id"));
            //get record of course with given id
            Course c = courseDao.selectById(id);
            
            //add course object as an attribute to request object and forward it to display page
            if(c!=null){
            request.setAttribute("course",c);
            request.getRequestDispatcher("/admin/editcourse.jsp").forward(request, response);
            
        }else{
                response.sendRedirect(cp + "/admin/course/display?refreshed");
            }
   
    }
        else if(uri.equals(cp+"/admin/course/delete")){
              int id= Integer.parseInt(request.getParameter("id"));
              
              if(courseDao.delete(id)){
                  System.out.println("record deleted");
                  response.sendRedirect(cp+"/admin/course/display");
              }
              else{
                  System.out.println("record not deleted");
                  response.sendRedirect(cp+"/admin/course/display?delete_failed");
              }
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
        
        if(uri.equals(cp+"/admin/course/add")){
            
            //process submitted form
            //collect data from form
            // and place it in a Course object
            //send it to dao so it could be saved..
            String title = request.getParameter("ctitle");
            String duration = request.getParameter("cduration");
            double price= Double.parseDouble(request.getParameter("cprice"));
            //bundles data in cm object
            
            Course cm= new Course(title,duration,price);
            //send it to dao to insert into db
           
            
            if(courseDao.insert(cm)){
                response.sendRedirect(cp + "/admin/course/add?success");
            }else{
                response.sendRedirect(cp + "/admin/course/add?failure");
            }
            
            
        } else if(uri.equals(cp + "/admin/course/update")){
            int id= Integer.parseInt(request.getParameter("cid"));
            String title = request.getParameter("ctitle");
            String duration = request.getParameter("cduration");
            double price = Double.parseDouble(request.getParameter("cprice"));
            
            Course cm = new Course(id,title,duration,price);
            
            //update this object in database
            
            if(courseDao.update(cm)){
                response.sendRedirect(cp + "/admin/course/display");
                
            }else{
                // to return to edit page
                response.sendRedirect(cp + "/admin/course/edit?id="+id+"&update_failed!");
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

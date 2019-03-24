/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.dao.CourseDao;
import com.sms.dao.StudentDao;
import com.sms.model.Course;
import com.sms.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siron
 */
@WebServlet({"/admin/student/add", "/admin/student/display","/admin/student/edit","/admin/student/delete"})
public class StudentController extends HttpServlet {
    
    private static StudentDao studentDao;
    
    static{
        studentDao= new StudentDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        String cp= request.getContextPath();
        
        if(uri.equals(cp+"/admin/student/add")){
            if(request.getParameter("success")!=null){
                request.setAttribute("success", "true");
            
        }
            request.setAttribute("courselist",new CourseDao().getAllCourse());
             request.setAttribute("studentlist",new StudentDao().getAllStudent());
            request.getRequestDispatcher("/admin/student.jsp").forward(request,response);
        }else if(uri.equals(cp+"/admin/student/display")){
            //fetch some data and add it to request object as an attribute
             request.setAttribute("courselist",new CourseDao().getAllCourse());
             request.setAttribute("studentlist",studentDao.getAllStudent());
             request.getRequestDispatcher("/admin/student.jsp").forward(request,response);
        }else if(uri.equals(cp+"/admin/student/edit")){
            int id= Integer.parseInt(request.getParameter("id"));
            request.setAttribute("courselist",new CourseDao().getAllCourse());
            request.setAttribute("student",  studentDao.selectStudentById(id));
            request.setAttribute("edit","true");
            
            request.getRequestDispatcher("/admin/student.jsp").forward(request,response);
            
            
            
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
        String cp= request.getContextPath();
        
       if (uri.equals(cp+"/admin/student/add")){
           Student s= new Student();
           s.setName(request.getParameter("sname"));
           s.setGender(request.getParameter("sgender"));
           s.setHobbies(Arrays.toString(request.getParameterValues("shobbies")));
           System.out.println(s.getHobbies());
           s.setCountry(request.getParameter("scountry"));
           s.setCourse(Integer.parseInt(request.getParameter("scourse")));
           //set student id lonly when it is present as aparameter in our post request
           
           //for add or update condition
           //boolean edi =false;
           if(request.getParameter("sid")!=null){
               //if side is present we are editing the student record
               //else we are inserting new sudent
               //edit= true;
               s.setId(Integer.parseInt(request.getParameter("sid")));
               
           }
           
           //call dao to save student object into sms database student table
           if(studentDao.insert(s)){
            //open appropriate response for user
            //it may insert or it may update
            response.sendRedirect(cp+"/admin/student/add?success=true");
           }else{
           
          request.setAttribute("success","false");
          request.getRequestDispatcher("/admin/student.jsp").forward(request,response);
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

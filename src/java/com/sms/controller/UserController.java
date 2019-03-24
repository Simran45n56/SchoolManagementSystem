/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.dao.UserDao;
import com.sms.model.UserDetail;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author test
 */  
//done for file type ofdata to collect....
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb chunk
                 maxFileSize = 1024 * 1024 * 10,      //10mb one file size
                 maxRequestSize = 1024 * 1024 * 50     //50mb total file that can be sent in a chunk..
)
@WebServlet({"/admin/user/register"})
public class UserController extends HttpServlet {


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
        String cp =request.getContextPath();
        
        if(uri.equals(cp + "/admin/user/register")){
            request.getRequestDispatcher("/admin/user_registration.jsp").forward(request, response);
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
        
        if(uri.equals(cp + "/admin/user/register")){
            //user detail is collected...
            System.out.println("user registration process started..");
            
            UserDetail ud = new UserDetail();
            //for checking..
            boolean register_ok = false;
            boolean upload_ok = false;
            
            //checking here more important field first...
            if(request.getParameter("password").equals(request.getParameter("cpassword"))){//checking password and if ok set to ud object
                ud.setPassword(request.getParameter("password"));
            }else{
                //set in uri error message
                request.setAttribute("err_pass", "password field did not match");
            }
            
            //rest of form processing code...
            //2.upload fileimage..
            for(Part part: request.getParts()){
                
                if(part.getName().equals("image")){
                    //image file part...
                    String serverPath = request.getServletContext().getRealPath("/");//gives root path of the project ..??
                    File uploadDir = new File(serverPath + "user_image");//making ready new upload directory to upload image ...
                    
                    if(!uploadDir.exists()){//if not exists then this will be true and it will create new directory.......
                        uploadDir.mkdir();
                    }
                    
                    System.out.println("Path: " + uploadDir.getAbsolutePath());//looking into new directory uding .getAbsolutepath method...
                    
                    String fileName = getFileName(part);//we need to get filename which is to be uploaded. we have created a new method...
                    System.out.println(fileName);
                    
                    File imageUpload = new File(serverPath+"user_image"+File.separator+fileName);//total file directory ie(uploadDir+ \ + filename)
                    
                    String filePath = imageUpload.getAbsolutePath();
                    System.out.println("filepath: " + filePath);
                    
                    part.write(filePath);//now writing into the filepath the image....
                    upload_ok = true;//making upload status true...
                    
                    ud.setImage(fileName);//to store in db .....
                }
            }
            
            if(!upload_ok){
                request.setAttribute("err_upload", "file upload failed");
                request.getRequestDispatcher("/admin/user_registration.jsp").forward(request, response);
            }
            
            ud.setFirstName(request.getParameter("firstname"));
            ud.setLastName(request.getParameter("lastname"));
            ud.setEmail(request.getParameter("email"));
            ud.setDob(LocalDate.parse(request.getParameter("dob")));//parsing in Localdate for date of birth .....
            ud.setAuthority(request.getParameter("authority"));
            ud.setActive(request.getParameter("active"));
            ud.setUsername(request.getParameter("username"));
            
             
            if( new UserDao().addUser(ud)){
                register_ok = true;
            System.out.println("user detail is added....");
            }
            
            
            if(register_ok){
                response.sendRedirect(cp + "/admin/user/register?success");
            }else{
                request.getRequestDispatcher("/admin/user_registration.jsp").forward(request, response);
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
    
    //making a methid that will give file name to upload an image(String manapulation ius done...) .....
    private String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");//split checks for ; and reads an new data.....
        String[] items = contentDisp.split(";");//items of content Disposition...
        
        for(String st:items){
           
           if(st.trim().startsWith("filename")){
               String filename = st.substring(st.indexOf("=")+2, st.length()-1);  //trim trims out spaces....
               
               if(filename.contains("\\")){
                   filename = filename.substring(filename.lastIndexOf("\\")+1, filename.length());
               }
               return filename;
           }
        }
        return "";
    }

}



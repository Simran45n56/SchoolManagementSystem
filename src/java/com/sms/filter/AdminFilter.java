/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author test
 */
@WebFilter({"/admin/*"})
public class AdminFilter implements Filter {
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
//        System.out.println("Filtering admin..");
        
        HttpServletRequest req = (HttpServletRequest) request;//changing into http request and response object... casting
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession s = req.getSession(false);//here it will give null if there is no session in the req object(fetch existing session)....
//        System.out.println(s+" and "+s.getAttribute("user"));
        if(s != null && s.getAttribute("user")!= null){//checking if session is not null and user is also not null
//            System.out.println("ok");
            chain.doFilter(req, res);//then do filtering or allowing that url...to go to servlet..(filter can be multiple this will send to another level filter..here only one and sends to servelet...)
        }else{
            res.sendRedirect(req.getContextPath() + "/login");//otherwise redirect to the login page..
        }
        
    }

    

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.dao.QueryDao;
import com.neu.edu.pojo.MovieDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asthasharma
 */
public class MovieServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("check");

        if (option.equals("browse")) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/browse.jsp");
            requestDispatcher.forward(request, response);
        } else if (option.equals("add")) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/addMovie.jsp");
            requestDispatcher.forward(request, response);
        }
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher;
        List<MovieDetails> l=null;
        String key = request.getParameter("key");
        String choice = request.getParameter("choice");
        QueryDao bd=new QueryDao();
       
            if (key.equals("")) {
                response.sendRedirect("index.html");

            }
            if (choice.equals("")) {
                response.sendRedirect("index.html");

            }

            if (choice.equals("title")) {
               l = bd.getMoviesByTitle(key);
                
                
                
            }
            else if(choice.equals("actor")){
                 l = bd.getMoviesByActor(key);

                
                
            }
            else if(choice.equals("actress")){
            l = bd.getMoviesByActress(key);
  
            }
            request.setAttribute("list", l);
            request.setAttribute("keyword", key);
            requestDispatcher = getServletContext().getRequestDispatcher("/result.jsp");
            requestDispatcher.forward(request, response);
            
        
       
        
   
        
    }

   

}

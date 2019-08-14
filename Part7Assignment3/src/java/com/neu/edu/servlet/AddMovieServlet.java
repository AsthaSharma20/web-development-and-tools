/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.dao.AddMovieDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asthasharma
 */
public class AddMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("check");

        if (option.equals("add")) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/addMovie.jsp");
            requestDispatcher.forward(request, response);
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        int result =0;
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        String year = request.getParameter("year");
        AddMovieDao ad=new AddMovieDao();
        result=ad.AddMovies(title, actor, actress, genre, Integer.parseInt(year));
      if(result!=0)
      {
            requestDispatcher = getServletContext().getRequestDispatcher("/final.html");
            requestDispatcher.forward(request, response);
      }
       
    }

    
}

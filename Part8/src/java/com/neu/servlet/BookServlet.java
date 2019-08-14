/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asthasharma
 */
public class BookServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String cnt=request.getParameter("count");
            request.setAttribute("sendcount", cnt);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/entry.jsp");
            requestDispatcher.forward(request, response);
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String title = request.getParameter("title");
      String isbn = request.getParameter("isbn");
      String author = request.getParameter("author");
      String price = request.getParameter("price");  
      PrintWriter out = response.getWriter();
      String key = request.getParameter("count");
       String cnt=request.getParameter("cnt");
       int count=Integer.parseInt(request.getParameter(cnt));
      //String choice=request.getParameter("choice");
      Connection conn=null;
      PreparedStatement stmt =null;
     
     
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/booksdb", "student", "p@ssw0rd");
         //String query="INSERT INTO movies(?,?,?,?)");

           stmt = conn.prepareStatement("INSERT INTO books values(?,?,?,?)");
           stmt.setString(1, isbn);
           stmt.setString(2, title);
           stmt.setString(3, author);
           stmt.setString(4, price);
           out.print(stmt);
           stmt.executeUpdate();
           


                   out.println("after Update");
                   request.setAttribute("keyword", key);
                   request.setAttribute("countnext",cnt);
                   RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result.jsp");
                   requestDispatcher.forward(request, response);
      }
      catch(ClassNotFoundException ex)
      {
          java.util.logging.Logger.getLogger(BookServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch(SQLException ex)
      {
          java.util.logging.Logger.getLogger(BookServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      finally {
               try {
                   if (stmt != null) {
                       stmt.close();
                   }
                   if (conn != null) {
                       conn.close();
                   }
               } catch (SQLException ex) {
                   System.out.println("SQLException" + ex.getMessage());
               }
           }
            

    }
    

    
    }




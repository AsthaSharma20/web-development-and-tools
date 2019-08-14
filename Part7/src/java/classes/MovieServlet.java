/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Browse;

/**
 *
 * @author asthasharma
 */
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //PrintWriter out = response.getWriter();
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

        PrintWriter out = response.getWriter();
        String key = request.getParameter("key");
        String choice = request.getParameter("choice");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/moviedb", "student", "p@ssw0rd");

            stmt = conn.createStatement();

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MovieServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Writing query and executing it
        try {
            if (key.equals("")) {
                response.sendRedirect("index.html");

            }
            if (choice.equals("")) {
                response.sendRedirect("index.html");

            }

            if (choice.equals("title")) {
                String query = "SELECT * FROM movies where title='" + key + "'";
                ArrayList<Browse> msgList = new ArrayList<Browse>();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Browse b1 = new Browse();
                    b1.setTitle(rs.getString(1));

                    b1.setActor(rs.getString(2));
                    b1.setActress(rs.getString(3));
                    b1.setGenre(rs.getString(4));
                    b1.setYear(rs.getString(5));
                  

                    msgList.add(b1);
               
                }

                request.setAttribute("messages", msgList);
                 request.setAttribute("keyword", key);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/title.jsp");
                requestDispatcher.forward(request, response);

             
            } else if (choice.equals("actor")) {
                String query = "SELECT * FROM movies where actor='" + key + "'";
                ResultSet rs = stmt.executeQuery(query);
                 ArrayList<Browse> msgList = new ArrayList<Browse>();
                 while (rs.next()) {
                    Browse b1 = new Browse();
                    b1.setTitle(rs.getString(1));

                    b1.setActor(rs.getString(2));
                    b1.setActress(rs.getString(3));
                    b1.setGenre(rs.getString(4));
                    b1.setYear(rs.getString(5));
                    

                    msgList.add(b1);
                    
                }

                request.setAttribute("messages", msgList);
                request.setAttribute("keyword", key);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/actor.jsp");
                requestDispatcher.forward(request, response);

      

            } else if (choice.equals("actress")) {
                String query = "SELECT * FROM movies where actress='" + key + "'";
                ResultSet rs = stmt.executeQuery(query);
                 ArrayList<Browse> msgList = new ArrayList<Browse>();
                 while (rs.next()) {
                    Browse b1 = new Browse();
                    b1.setTitle(rs.getString(1));

                    b1.setActor(rs.getString(2));
                    b1.setActress(rs.getString(3));
                    b1.setGenre(rs.getString(4));
                    b1.setYear(rs.getString(5));
                   

                    msgList.add(b1);
                    
                }

                request.setAttribute("messages", msgList);
                request.setAttribute("keyword", key);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/actress.jsp");
                requestDispatcher.forward(request, response);


            }

            // response.sendRedirect(redirectPage);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
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

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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asthasharma
 */
public class AddServlet extends HttpServlet {

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

        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        String year = request.getParameter("year");
        

        PrintWriter out = response.getWriter();
        out.println("entered post");
        out.println("title id"+title);

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/moviedb", "student", "p@ssw0rd");

            stmt = conn.createStatement();
            out.println("db connected");
           
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MovieServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Writing query and executing it
        try {

            if((title.equals(""))||(actor.equals(""))||(actress.equals(""))||(genre.equals(""))||(year.equals("")))
            {
                   
                   response.sendRedirect("index.html");
                
            }
                String query = "INSERT INTO movies(title,actor,actress,genre,year)" + "VALUES ('" + title + "','" + actor + "','" + actress + "','" + genre + "','" + year + "')";
                int rs = stmt.executeUpdate(query);
                if (rs != 0) {
                    System.out.println(rs);
                    response.sendRedirect("result.html");
                }
            

            

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

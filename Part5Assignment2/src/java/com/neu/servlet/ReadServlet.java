
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author asthasharma
 */
public class ReadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
       HttpSession session=req.getSession();
       String fileName=req.getParameter("csvFileName");
       
       Connection conn=null;
       Statement stmt=null;
       

       
       try{
           Class.forName("org.relique.jdbc.csv.CsvDriver");
           String pathCsv="Users\\asthasharma\\Downloads\\";
           conn=DriverManager.getConnection("jdbc:relique:csv:/Users/asthasharma/Downloads");
           stmt = conn.createStatement();
       }
       catch(ClassNotFoundException ex)
       {
           java.util.logging.Logger.getLogger(ReadServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       catch(SQLException ex)
       {
           java.util.logging.Logger.getLogger(ReadServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }  
        //Writing query and executing it
        try
      {
        String quer="SELECT * FROM SalesOrder";
        ResultSet rs = stmt.executeQuery(quer);
        
        PrintWriter out = res.getWriter();

        while(rs.next())
           {
               for(int i=1;i<26;i++)
               {
               out.print(rs.getObject(i)+"\t");
               }
   
           }
       conn.close();

      }
        catch(Exception e)
        {
            System.out.println(e);
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



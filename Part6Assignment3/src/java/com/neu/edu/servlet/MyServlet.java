/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.dao.QueryCsvDao;
import com.neu.edu.pojo.CsvFile;
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
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        
        String fileName=request.getParameter("csvFileName");
        
        
        
        RequestDispatcher requestDispatcher;
        QueryCsvDao q=new QueryCsvDao();
        
        List<CsvFile> fl =q.RunFile(fileName);
        
        request.setAttribute("fileName", fl);
            requestDispatcher=request.getRequestDispatcher("/result.jsp");
            requestDispatcher.forward(request, response);
            
        
        
    }

   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.dao.ShoppingDao;
import com.neu.edu.pojo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class myServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String task = request.getParameter("hide");
        ArrayList<Item> itemList;
        if (task.equals("add")) {
            if (session.getAttribute("cartItems") == null) {
                itemList = new ArrayList<Item>();
                session.setAttribute("cartItems", itemList);
            } else {
                itemList = (ArrayList) session.getAttribute("cartItems");
            }
            ShoppingDao s = new ShoppingDao();
            String[] selectedValues = request.getParameterValues("items");
            session.setAttribute("cartItems", s.addItems(selectedValues, itemList));
            requestDispatcher = request.getRequestDispatcher("/viewCart.jsp");
            requestDispatcher.forward(request, response);
        } else if (task.equals("remove")) {
            itemList = (ArrayList) session.getAttribute("cartItems");
            ShoppingDao s = new ShoppingDao();
            String[] selectedValues = request.getParameterValues("selectedProducts");
            session.setAttribute("cartItems", s.removeItem(selectedValues, itemList));
            requestDispatcher = request.getRequestDispatcher("/viewCart.jsp");
            requestDispatcher.forward(request, response);
            
        } else if (task.equals("view")) {
            itemList = (ArrayList) session.getAttribute("cartItems");
            session.setAttribute("cartItems", itemList);
            requestDispatcher = request.getRequestDispatcher("/viewCart.jsp");
            requestDispatcher.forward(request, response);
        }

    }

   
    }

    
   

    



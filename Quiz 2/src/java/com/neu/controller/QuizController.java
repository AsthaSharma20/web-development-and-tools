/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.pojo.Quiz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author asthasharma
 */
public class QuizController extends AbstractController{
    
     public QuizController() {
    }

    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        String q;
        HttpSession session=request.getSession();
        List<String> userans=null;
        List<String> opt=null;
        List<String> corrans=null;
        
        if (uri.endsWith("1.htm"))
        {
            Quiz quiz=new Quiz();
            corrans=new ArrayList<String>();
            opt=new ArrayList<String>();
            
            quiz.setQuestion("1.Bla Bla Bla");
            opt.add("op1check");
            opt.add("op2");
            opt.add("op3");
            opt.add("op4");
            quiz.setOption(opt);
            
            corrans.add("op2");
            q = "1"; 
            request.setAttribute("q",1);
            session.setAttribute("corrans", corrans);
            return new ModelAndView("quiz","quiz",quiz);
    
}
        else if(uri.endsWith("2.htm"))
        {
            Quiz quiz=new Quiz();
            opt=new ArrayList<String>();
            userans=new ArrayList<String>();
            quiz.setQuestion("2.Bla Bla Bla");
            opt.add("op1");
            opt.add("op2");
            opt.add("op3");
            opt.add("op4");
            quiz.setOption(opt);
            String a=request.getParameter("answers");
            userans.add(a);
            
            q="2";
            corrans=(List<String>)session.getAttribute("corrans");
            corrans.add("op2");
            request.setAttribute("q",2);
            
            session.setAttribute("userans",userans);
            return new ModelAndView("quiz","quiz",quiz);
            
        }
        
        else if(uri.endsWith("3.htm"))
        {
            Quiz quiz=new Quiz();
            opt=new ArrayList<String>();
            userans=new ArrayList<String>();
            quiz.setQuestion("3.Bla Bla Bla");
            opt.add("op1");
            opt.add("op2");
            opt.add("op3");
            opt.add("op4");
            quiz.setOption(opt);
            userans=(List<String>)session.getAttribute("userans");
            String a=request.getParameter("answers");
            userans.add(a);
            
            q="3";
            corrans=(List<String>)session.getAttribute("corrans");
            corrans.add("op2");
            request.setAttribute("q",3);
            session.setAttribute("userans",userans);
            return new ModelAndView("quiz","quiz",quiz);
            
        }
        else if(uri.endsWith("answer.htm"))
        {
            userans=new ArrayList<String>();
            userans=(List<String>)session.getAttribute("userans");
            Quiz quiz=new Quiz();
            q="4";
            String a=request.getParameter("answers");
            userans.add(a);
            request.setAttribute("q",4);
            session.setAttribute("userans",userans);
            return new ModelAndView("quiz","quiz",quiz);
        }
            return new ModelAndView("quiz");

}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AddDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author asthasharma
 */
public class AddController extends AbstractController {
    
    public AddController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         ModelAndView mv = null;
        HttpSession session = request.getSession();
           int result =0;
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        String year = request.getParameter("year");
        AddDao ad=new AddDao();
        result=ad.AddMovies(title, actor, actress, genre, Integer.parseInt(year));
      if(result!=0)
      {
            mv = new ModelAndView("result");      }
        return mv;
    }
    
}

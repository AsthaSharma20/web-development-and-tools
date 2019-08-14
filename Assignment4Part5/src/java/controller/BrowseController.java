/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BrowseDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;
import pojo.Browse;

/**
 *
 * @author asthasharma
 */
public class BrowseController extends AbstractController {
    
    public BrowseController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
                ModelAndView mv = null;
        HttpSession session = request.getSession();
List<Browse> l=null;
    String key = request.getParameter("key");
        String choice = request.getParameter("choice");
        BrowseDao bd=new BrowseDao();
              if (key.equals("")) {
                mv = new ModelAndView(new RedirectView("/Assignment4Part5/hom.htm", false));


            }
            if (choice.equals("")) {
                mv = new ModelAndView(new RedirectView("/Assignment4Part5/hom.htm", false));

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
         mv = new ModelAndView("title");

       return mv;
    }
    
}

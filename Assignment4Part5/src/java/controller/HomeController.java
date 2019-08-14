/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author asthasharma
 */
public class HomeController extends AbstractController {
    
    public HomeController() {
    }
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
      //  throw new UnsupportedOperationException("Not yet implemented");
       HttpSession session = request.getSession();
        ModelAndView mv = null;
        String option = request.getParameter("check") == null ? "" : request.getParameter("check");
        if (option.equals("")) {
            return new ModelAndView("home");
        }
  switch (option) {
            case "browse":
                //session.invalidate();
                mv = new ModelAndView("browse");
                break;
            case "add":
               
                   mv = new ModelAndView("add");
                    break;                                                                         
            default:
                mv = new ModelAndView(new RedirectView("/Assignment4Part5/hom.htm", false));
        }
      return mv;
    }
    
}

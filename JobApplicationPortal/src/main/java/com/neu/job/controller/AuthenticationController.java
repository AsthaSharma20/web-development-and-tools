package com.neu.job.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.job.dao.UserDao;
import com.neu.job.exception.UserException;
import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.User;


@Controller
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser() throws Exception{
		
		User u=new User();
		ModelAndView mv=new ModelAndView("register");
		
		mv.addObject("authentication",u);
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(HttpServletRequest request, @ModelAttribute("user") User user, HttpSession session)throws Exception {
			
		
		ArrayList<User> u=(ArrayList<User>) userDao.getUser(user.getUsername());
		for(int i=0;i<u.size();i++) {
			if(u.get(i).getUsername().equalsIgnoreCase(user.getUsername())) {
				System.out.println("registration page");
				return "register";
			}
		
			System.out.println("Customer details:"+u.get(i).getUsername());
		}
			session.setAttribute("username",user.getUsername());	
			
			userDao.addUser(user);
			
			if(user.getRole().equalsIgnoreCase("recruiter")) {
				return "recruiterHome";
			}
			else if(user.getRole().equalsIgnoreCase("jobSeeker")) {
				return "seekerHome";
			}
			
			return "dashboard";
			
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginUser() throws Exception{
		User u=new User();
		ModelAndView mv=new ModelAndView("login");
		
		mv.addObject("authentication",u);
		return mv;
		
		
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(HttpServletRequest request, @ModelAttribute("login") User user, HttpSession session)throws Exception {
		
		ArrayList<User> u=(ArrayList<User>) userDao.getUser(user.getUsername());
		for(int i=0;i<u.size();i++) {
			if(u.get(i).getUsername().equalsIgnoreCase(user.getUsername())) {
				System.out.println("login page");
				session.setAttribute("username", user.getUsername());	
		
				if(u.get(i).getRole().equalsIgnoreCase("jobSeeker")){
				
				session.setAttribute("userId", userDao.login(user).getUserId());
				return "seekerHome";
			}
			
				
				
				else if(u.get(i).getRole().equalsIgnoreCase("recruiter")){
				session.setAttribute("userId", userDao.login(user).getUserId());
				return "recruiterHome";
			}
			
			else
				return "login";
				
	}
}
		return "dashboard";
}
}
		
	
	
	
	
	
	
	
	

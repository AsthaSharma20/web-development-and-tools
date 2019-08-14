package com.neu.job.controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.job.dao.AddJobDao;
import com.neu.job.dao.UserDao;
import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.User;


@Controller
@RequestMapping("/addJob")
public class AddJobController {
	
	@Autowired
	AddJobDao addJobDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/add/{userId}", method= RequestMethod.GET)
	public ModelAndView addJob(@PathVariable long userId, Model m, HttpSession session ) throws Exception{
		
		session.setAttribute("userId", userId);
		
		AddJob j=new AddJob();
		ModelAndView mv=new ModelAndView("add");
		
		mv.addObject("addJob", j);
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addJob(HttpServletRequest request, @ModelAttribute("addj") AddJob addJo)throws Exception {
		
		
		try {
			
			int userId=Integer.parseInt(request.getParameter("userId"));
			System.out.println("Id from jsp using getParameter() is: "+userId);
			User us= userDao.getUserById(userId);
			
			addJo.setUsr(us);
			
			addJobDao.addJob(addJo);
			List<AddJob> jo=addJobDao.list();
			for(AddJob j:jo) {
				System.out.println(j.getCompany()+j.getDescription()+j.getJobId()+j.getLocation()+j.getPosition());
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		
	}
		return new ModelAndView("recruiterHome");		

	}
	
	
}

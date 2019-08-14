package com.neu.job.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.job.dao.AddJobDao;
import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.Application;
import com.neu.job.pojo.User;

@Controller
@RequestMapping("/updateJob")
public class UpdateJobController {
	
	@Autowired
	AddJobDao addJobDao;
			
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(HttpServletRequest request, Model model)throws Exception {
				
		
				List<AddJob> jo=addJobDao.list();
				
			
				model.addAttribute("jo", jo);
				return "view";
		}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id) throws Exception {
		
			addJobDao.delete(id);
		
		return "deleted";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String update(@PathVariable int id, Model m) throws Exception {
		
			AddJob ad=addJobDao.getJobById(id);
			System.out.println(ad);
			m.addAttribute("ad", ad); 
			System.out.println("after add Attribute");
			System.out.println("Job details are: "+ad.getJobId()+"  "+ad.getPosition()+"  "+ad.getLocation()+"  "+ad.getCompany()+"  "+ad.getDescription());
			return "jobUpdate";
	
	}
	
	@RequestMapping(value="/updatesave", method=RequestMethod.POST )
	public String updateSave(@ModelAttribute("uj") AddJob ad) throws Exception {
		System.out.println("in update save");
			int myid=ad.getJobId();
			System.out.println(myid);
			addJobDao.update(ad);
			System.out.println("before return");
			return "dashboard";
		
	}
	
	@RequestMapping(value="/viewByRecruiterId/{userId}", method=RequestMethod.GET)
	public String viewByRecruiterId(@PathVariable long userId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
		session.setAttribute("userId", userId);
		
		
		ArrayList<AddJob> apd=(ArrayList<AddJob>) addJobDao.viewJobByUserId(userId);
		
		model.addAttribute("apd", apd);		
			
				
				return "ViewAppliedJobDetails";
		}
	
	@RequestMapping(value="/viewByJobId/{jobId}", method=RequestMethod.GET)
	public String viewByjobId(@PathVariable int jobId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
		
		session.setAttribute("jobId", jobId);
		
		
		ArrayList<AddJob> apd=(ArrayList<AddJob>) addJobDao.viewJobDetailsByJobId(jobId);
		
		model.addAttribute("apd", apd);		
			
				
				return "viewJobDetailsToSeeker";
		}
	
	
	
	
}


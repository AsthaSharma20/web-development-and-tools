package com.neu.job.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.*;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.job.dao.AddJobDao;
import com.neu.job.dao.ApplicationDao;
import com.neu.job.dao.UserDao;
import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.Application;
import com.neu.job.pojo.ResumePdfView;
import com.neu.job.pojo.User;

@Controller
@RequestMapping("/userApplication")
public class UserApplicationController {
	
	
	
	@Autowired
	ApplicationDao apDao;
	@Autowired
	AddJobDao addJobDao;
	
	@Autowired
	UserDao userDao;
			
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(HttpServletRequest request, Model model)throws Exception {
				
		
		List<AddJob> jo=addJobDao.list();
				
			
				model.addAttribute("jo", jo);
				return "userViewJobs";
		}
	
	@RequestMapping(value="/apply/{id},{username},{userId}", method=RequestMethod.GET)
	public String update(@PathVariable int id,@PathVariable  String username , @PathVariable long userId, Model m, HttpSession session) throws Exception {
		
			session.setAttribute("username", username);
			session.setAttribute("id", id);
			session.setAttribute("userId", userId);
		 
			
			return "applyToJob";
	
	}

		@RequestMapping(value="/applyToJob", method=RequestMethod.POST)
		public ModelAndView apply(HttpServletRequest request, @ModelAttribute("appl") Application ap,Model m, HttpSession session,BindingResult result)throws Exception {
			try {
				System.out.println("Inside applyTojob");
				
				int id=Integer.parseInt(request.getParameter("jobId"));
				int userId=Integer.parseInt(request.getParameter("userId"));
				
				
				System.out.println("Id from jsp using getParameter() is: "+id);
				
				AddJob aj = addJobDao.getJobById(id);
				User us= userDao.getUserById(userId);
				ap.setAj(aj);
				ap.setUsr(us);
				
				apDao.addApplication(ap);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("seekerHome");		
	
	}
		//resume pdf
		@RequestMapping(value = "/resumeView/{jobId}", method = RequestMethod.GET)
		public ModelAndView showResumeView(@PathVariable  int jobId,
										  ModelMap model, 
				                          HttpServletRequest request) throws Exception
		{
			
			ArrayList<Application> apll=(ArrayList<Application>) apDao.viewApplicantByJobId(jobId);
			
			String res = null;
			for(int i=0;i<apll.size();i++) {
				res=apll.get(i).getResume();
				
			}
			model.addAttribute("resume",res);
			
			System.out.println("resume in controller is:"+res);
			
			View v = new ResumePdfView();
			return new ModelAndView(v);
		}
		
		
		@RequestMapping(value="/viewApplicants/{jobId}", method=RequestMethod.GET)
		public String viewApplicants(@PathVariable int jobId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
			System.out.println("entered in view applicants method");
			
			session.setAttribute("jobId", jobId);
			
			System.out.println("job id from jsp is:"+jobId);
			
			ArrayList<Application> apll=(ArrayList<Application>) apDao.viewApplicantByJobId(jobId);
			
			for(int i=0;i<apll.size();i++) {
				System.out.println("application id in controller is:"+apll.get(i).getApplicationId());
			}
			model.addAttribute("apll", apll);
			session.setAttribute("apll", apll);
			System.out.println("model attribute added");
				
			
					return "recruiterViewApplicantDetails";
			}
		
		@RequestMapping(value="/viewJobsByUserId/{userId}", method=RequestMethod.GET)
		public String viewJobsByUserId(@PathVariable long userId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
			System.out.println("entered in view applicants method");
			
			session.setAttribute("userId", userId);
			
			System.out.println("User id from jsp is:"+userId);
			
			ArrayList<Application> apll=(ArrayList<Application>) apDao.viewJobByApplicantId(userId);
			
			int arr[]=new int[apll.size()];
			for(int i=0;i<apll.size();i++) {
				arr[i]=apll.get(i).getAj().getJobId();
			}
			
			model.addAttribute("apll", arr);
		
			//session.setAttribute("apll", apll);
			System.out.println("model attribute added");
				
			
					return "viewAppliedJobs";
			}
		
		@RequestMapping(value="/selected/{jobId},{emailId}", method=RequestMethod.GET)
		public String selected(@PathVariable int jobId,@PathVariable String emailId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
			System.out.println("entered in selected for job method");
			
			
			System.out.println("Job id from jsp is:"+jobId);
			
			System.out.println("Email id from jsp is:"+emailId);
			
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			
			email.setAuthenticator(new DefaultAuthenticator("careersatreviewer@gmail.com", "Admin@123"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@jobportal.com");
			email.setSubject("Update for your application");
			email.setMsg("We were impressed by your background and would like to invite you to interview via Skype to tell you a little more about the position and get to know you better. ");
			email.addTo(emailId+".com");
			email.send();
			
				
			
					return "recruiterViewApplicantDetails";
			}
		
		@RequestMapping(value="/rejected/{jobId},{emailId}", method=RequestMethod.GET)
		public String rejected(@PathVariable int jobId,@PathVariable String emailId,HttpServletRequest request, Model model, HttpSession session)throws Exception {		
			System.out.println("entered in selected for job method");
			
			
			System.out.println("Job id from jsp is:"+jobId);
			
			System.out.println("Email id from jsp is:"+emailId);
			
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			
			email.setAuthenticator(new DefaultAuthenticator("careersatreviewer@gmail.com", "Admin@123"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@jobportal.com");
			email.setSubject("Update for your application");
			email.setMsg("We regret to inform you that we have filled this position. However, we will keep your resume on file, and if a position matching your qualifications opens up, we will contact you. I also encourage you to visit our website as new positions become available regularly. ");
			email.addTo(emailId+".com");
			email.send();
			
				
			
					return "recruiterViewApplicantDetails";
			}
		
		
		//Resume pdf generation
		
}




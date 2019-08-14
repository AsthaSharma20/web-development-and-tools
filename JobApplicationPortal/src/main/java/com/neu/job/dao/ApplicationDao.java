package com.neu.job.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.Application;

public class ApplicationDao extends Dao {
	public ApplicationDao() {
	}
	
	public int addApplication(Application app)throws Exception{
		int addSuccess=0;
		
		
		
		try {
			begin();
			getSession().save(app);
            commit();
            addSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new Exception("Could not apply!",e);
        } 
        finally {
            close();
        }

        return addSuccess;
		}
	
	public List<Application> list() throws Exception {

		
		try {
			begin();
			Query q = getSession().createQuery("from Application");
			List<Application> list1 = q.list();
			commit();
			System.out.println(list1);
			return list1;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the applications", e);
		}
	}
	
	@SuppressWarnings("unused")
	public List<Application> viewApplicantByJobId(int jobId) throws Exception {
		System.out.println("entered in viewapplicant by id dao method");
		System.out.println(jobId);

		ArrayList<Application> lis=new ArrayList<Application>();
		try {
			begin();
			Query q = getSession().createQuery("from Application where jobId=:jobId");
			q.setInteger("jobId", jobId);
			
			List<Application> list1 = q.list();
			for(int i=0;i<list1.size();i++) {
				System.out.println("Application id in dao is : "+list1.get(i).getApplicationId());
				System.out.println("First Name in dao is: "+list1.get(i).getFname());
			}
			commit();
			
			System.out.println(list1);
			return list1;
			
			
			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the applications", e);
		}
	}

	public List<Application> viewJobByApplicantId(long userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entered in viewjobbyapplicant by id dao method");
		System.out.println(userId);

		ArrayList<Application> lis=new ArrayList<Application>();
		try {
			begin();
			Query q = getSession().createQuery("from Application where userId=:userId");
			q.setLong("userId", userId);
			
			List<Application> list1 = q.list();
			for(int i=0;i<list1.size();i++) {
				System.out.println("Job id in dao is : "+list1.get(i).getAj().getJobId());
				System.out.println("First Name in dao is: "+list1.get(i).getFname());
			}
			commit();
			
			System.out.println(list1);
			return list1;
			
			
			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the jobs per user", e);
		}
		
		
	}

	
	
	

}

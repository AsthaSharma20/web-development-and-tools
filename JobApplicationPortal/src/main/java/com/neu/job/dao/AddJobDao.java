/**
 * 
 */
package com.neu.job.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;


import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.Application;
import com.neu.job.pojo.User;


/**
 * @author asthasharma
 *
 */
public class AddJobDao extends Dao{
	public AddJobDao() {
		
	}
	
	 /*public AddJob find(Long id) throws Exception {
	        return (AddJob) super.find(AddJob.class, id);
	    }*/
	
	public int addJob(AddJob job)throws Exception{
		int addSuccess=0;
		try {
			begin();
			getSession().save(job);
            commit();
            addSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new Exception("Could not add job!",e);
        } 
        finally {
            close();
        }

        return addSuccess;
		}
	
	public void update(AddJob job) throws Exception{
		try {
			begin();
			
			Query q=getSession().createQuery("update AddJob set position=:position,location=:location,company=:company,description=:description where jobId=:jobId");
			
			q.setInteger("jobId", job.getJobId());
			q.setString("position",job.getPosition());
			q.setString("location",job.getLocation());
			q.setString("company",job.getCompany());
			q.setString("description",job.getDescription());
			q.executeUpdate();
			//getSession().update(job);
			commit();
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
			rollback();
			throw new Exception("Could not update the job!",e);
		}
	}
	
	public void delete(int id) throws Exception {
		try {
			begin();
			Query q=getSession().createQuery("delete from AddJob where jobId=:jobId");
			q.setInteger("jobId", id);
			
			q.executeUpdate();
			
            commit();
			
		}
		catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new Exception("Could not delete job!",e);
        } 
        finally {
            close();
        }
	}
		public List<AddJob> list() throws Exception {

			
			try {
				begin();
				Query q = getSession().createQuery("from AddJob");
				List<AddJob> list1 = q.list();
				commit();
				System.out.println(list1);
				return list1;
			} catch (HibernateException e) {
				rollback();
				throw new Exception("Could not list the jobs", e);
			}
		}
		public AddJob getJobById(int id) throws Exception{ 
			System.out.println("in getId");
			AddJob j=null;
			try {
				begin();
				Query q=getSession().createQuery("from AddJob where jobId=:jobId");
				q.setInteger("jobId", id);
				j = (AddJob) q.uniqueResult();
				System.out.println("job id is "+id);

	            commit();
	            System.out.println(j);
	            return j;
			}
			catch (HibernateException e) {
				rollback();
				throw new Exception("Could not find the job", e);
			}
			
		    
		    
		}
		public List<AddJob> viewJobByUserId(long userId) throws Exception {

			ArrayList<AddJob> lis=new ArrayList<AddJob>();
			try {
				begin();
				Query q = getSession().createQuery("from AddJob where userId=:userId");
				q.setLong("userId", userId);
				List<AddJob> list1 = q.list();
				commit();
				System.out.println(list1);
				return list1;
			} catch (HibernateException e) {
				rollback();
				throw new Exception("Could not list the jobs by recruiter id!", e);
			}
		}
		
		public List<AddJob> viewJobDetailsByJobId(int jobId) throws Exception {

			ArrayList<AddJob> lis=new ArrayList<AddJob>();
			try {
				begin();
				Query q = getSession().createQuery("from AddJob where jobId=:jobId");
				q.setLong("jobId", jobId);
				List<AddJob> list1 = q.list();
				commit();
				System.out.println(list1);
				return list1;
			} catch (HibernateException e) {
				rollback();
				throw new Exception("Could not list the jobs by job id!", e);
			}
		}
	
	}
		




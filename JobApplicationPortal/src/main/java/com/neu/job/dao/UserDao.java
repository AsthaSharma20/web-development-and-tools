package com.neu.job.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.job.exception.UserException;
import com.neu.job.pojo.AddJob;
import com.neu.job.pojo.User;


public class UserDao extends Dao {
	public UserDao() {
			
	}

	public int addUser(User u) throws Exception {
        
        int registerSuccess = 0;
        try {
            begin();
            getSession().save(u);
            commit();
            registerSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new Exception("Could not create user!",e);
        } 
        finally {
            close();
        }

        return registerSuccess;

    }

	public User login(User u) throws Exception {
		
	     User usr=null;
	     try{
	         begin();
	         System.out.println("role in dao is"+u.getRole());
	         Query q= getSession().createQuery("from User where username= :username AND password= :password AND role= :role");
	         	q.setString("role", u.getRole());
	            q.setString("username", u.getUsername());
	            q.setString("password",u.getPassword());
	            usr = (User)q.uniqueResult();
	            System.out.println("user id in login dao is :"+usr.getUserId());
	            commit();
	            
	            
	            
	            
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            rollback();
	            throw new Exception("Could not login!",e);
	        } 
	        finally {
	            close();
	        }
	        return usr;
	}
	public User getUserById(int id) throws Exception{ 
		System.out.println("in getId");
		User j=null;
		try {
			begin();
			Query q=getSession().createQuery("from User where userId=:userId");
			q.setInteger("userId", id);
			j = (User) q.uniqueResult();
			System.out.println("User id is "+id);

            commit();
            System.out.println(j);
            return j;
		}
		catch (HibernateException e) {
			rollback();
			throw new Exception("Could not find the user by ID", e);
		}
		
	    
	    
	}
	
	public List<User> getUser(String searchUser) throws Exception {

			ArrayList<User> lis=new ArrayList<User>();
		try {
			begin();
			Query q = getSession().createQuery("from User where username=:username");
			q.setString("username", searchUser);
			List<User> list1 = q.list();
			commit();
			System.out.println(list1);
			return list1;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the users", e);
		}
	}
	
		
		
	
	

}

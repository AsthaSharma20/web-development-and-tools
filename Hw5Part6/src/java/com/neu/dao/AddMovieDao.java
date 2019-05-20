/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author asthasharma
 */
public class AddMovieDao {
    
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    public AddMovieDao() {
    }
    private Session getSession()
    {
        if(session==null||!session.isOpen())
        {
            session=sf.openSession();
        }
        return session;
    }
    private void beginTransaction()
    {
        getSession().beginTransaction();
    }
    private void commit() {
        getSession().getTransaction().commit();
    }
    private void close() {
        if (session != null) {
            getSession().close();
        }
    }
         private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
    
          public int AddMovie(String title, String actor, String actress, String genre, int year) {
              Movie newMovie =null;
              int movieadd=0;
              try{
               beginTransaction();
            newMovie = new Movie();
            newMovie.setTitle(title);
            newMovie.setActor(actor);
            newMovie.setActress(actress);
            newMovie.setGenre(genre);
            newMovie.setYear(year);
            getSession().save(newMovie);
            commit();
            movieadd = 1;        
              
                  
              }catch(Exception e){
                  e.printStackTrace();
                  rollbackTransaction();
              }finally {
            close();
        }
              return movieadd;
              
          }
       public Movie searchMovie(long id){
        
        Movie result = null;
        
        try {
            beginTransaction();
            Query q= getSession().createQuery("from Movie where id= :id");
            q.setLong("id", id);
            result = (Movie)q.uniqueResult();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        
        return result;
    }
}

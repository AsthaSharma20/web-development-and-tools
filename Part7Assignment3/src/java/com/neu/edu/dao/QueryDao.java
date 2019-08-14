/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.dao;

import com.neu.edu.pojo.MovieDetails;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author asthasharma
 */
public class QueryDao {
  public List<MovieDetails> getMoviesByTitle(String key) {
        Connection connection = null;
        List<MovieDetails> result = null;
        try {
            MovieDao dbdao = new MovieDao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<MovieDetails>> h = new BeanListHandler<MovieDetails>(MovieDetails.class);
            String query = "SELECT * FROM movies where title=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }
      public List<MovieDetails> getMoviesByActor(String key) {
        Connection connection = null;
        List<MovieDetails> result = null;
        try {
            MovieDao dbdao = new MovieDao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<MovieDetails>> h = new BeanListHandler<MovieDetails>(MovieDetails.class);
            String query = "SELECT * FROM movies where actor=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }
        public List<MovieDetails> getMoviesByActress(String key) {
        Connection connection = null;
        List<MovieDetails> result = null;
        try {
            MovieDao dbdao = new MovieDao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<MovieDetails>> h = new BeanListHandler<MovieDetails>(MovieDetails.class);
            String query = "SELECT * FROM movies where actress=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }

      
    }   
    

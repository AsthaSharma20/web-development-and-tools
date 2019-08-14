/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Browse;

/**
 *
 * @author asthasharma
 */
public class BrowseDao {
    
    public List<Browse> getMoviesByTitle(String key) {
        Connection connection = null;
        List<Browse> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Browse>> h = new BeanListHandler<Browse>(Browse.class);
            String query = "SELECT * FROM movies where title=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }
      public List<Browse> getMoviesByActor(String key) {
        Connection connection = null;
        List<Browse> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Browse>> h = new BeanListHandler<Browse>(Browse.class);
            String query = "SELECT * FROM movies where actor=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }
        public List<Browse> getMoviesByActress(String key) {
        Connection connection = null;
        List<Browse> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Browse>> h = new BeanListHandler<Browse>(Browse.class);
            String query = "SELECT * FROM movies where actress=?";

            result = queryRunner.query(connection, query, h,key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }
    
}

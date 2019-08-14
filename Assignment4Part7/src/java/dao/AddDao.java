/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author asthasharma
 */
public class AddDao {
  public int AddMovies(String title,String actor,String actress,String genre,int year) {
        Connection connection = null;
        int result = 0;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "INSERT INTO movies(title,actor,actress,genre,year) VALUES (?,?,?,?,?)";
            result = queryRunner.update(connection, query,title,actor,actress,genre,year);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;

    }
    
}

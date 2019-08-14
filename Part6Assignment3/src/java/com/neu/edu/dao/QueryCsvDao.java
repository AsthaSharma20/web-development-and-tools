/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.dao;

import com.neu.edu.pojo.CsvFile;
import java.util.List;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author asthasharma
 */
public class QueryCsvDao {
    
    public List<CsvFile> RunFile(String fileName) {
        Connection connection = null;
        List<CsvFile> result=null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
          
            ResultSetHandler<List<CsvFile>> h = new BeanListHandler<CsvFile>(CsvFile.class);
              String query = "SELECT * FROM "+fileName;
            result = queryRunner.query(connection, query, h);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return result;

      
    }   
        
          
}
        
    


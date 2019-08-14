package com.neu.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asthasharma
 */
public class Dao {
  
    static final String JDBC_DRIVER = "org.relique.jdbc.csv.CsvDriver";
    static final String DB_URL = "jdbc:relique:csv:/Users/asthasharma/Downloads";
 
   
    private Connection connection;

    public Connection getConnection() throws Exception {
        try {
            Connection connection = null;
            DbUtils.loadDriver(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
//            endConnection();
            System.out.println("SQL Exception");
            ex.printStackTrace();
            throw new Exception();
        }
//            endConnection();
        return this.connection;
    }

}

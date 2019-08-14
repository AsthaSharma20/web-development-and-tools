/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.Sales;

/**
 *
 * @author asthasharma
 */
public class readCsvDAO {
    public ArrayList<Sales> getCSVData(String path, String csvName){
       ArrayList<Sales> salesList = new ArrayList<Sales>();
       try{     
       Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + path);
             Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM"+ csvName);
            if(results!=null)
                System.out.println("Not null");
            while(results.next()){
                Sales s= new Sales();
               s.setSalesOrderID(results.getString(1));
                s.setRevisionNumber(results.getString(2));
               	s.setOrderDate(results.getString(3));
                s.setDueDate(results.getString(4));
                s.setShipDate(results.getString(5));
                s.setStatus(results.getString(6));
                 s.setOnlineOrderFlag(results.getString(7));
                  s.setSalesOrderNumber(results.getString(8));
                   s.setPurchaseOrderNumber(results.getString(9));
                    s.setAccountNumber(results.getString(10));
                     s.setCustomerID(results.getString(11));
                      s.setSalesPersonID(results.getString(12));
                  s.setTerritoryID(results.getString(13));
                   s.setBillToAddressID(results.getString(14));
                    s.setShipToAddressID(results.getString(15));
                     s.setShipMethodID(results.getString(16));
                      s.setCreditCardID(results.getString(17));
                       s.setCreditCardApprovalCode(results.getString(18));
                        s.setCurrencyRateID(results.getString(19));
                        s.setSubTotal(results.getString(20));
                        s.setTaxAmt(results.getString(21));
                        s.setFreight(results.getString(22));
                        s.setTotalDue(results.getString(23));
                        s.setComment(results.getString(24));
                        s.setModifiedDate(results.getString(25));
                        salesList.add(s);
            }
            
       }
       catch(Exception e){
           
       }
       
       return salesList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.springframework.web.servlet.ModelAndView;
import pojo.Sales;

/**
 *
 * @author asthasharma
 */
public class DisplayCSVData extends SimpleTagSupport {
    private String csvName;

    public void setCsvName(String csvName) {
        this.csvName = csvName;
    }
    
    @Override
    public void doTag() throws IOException  {
        ArrayList<Sales> salesList= new ArrayList<>();
      JspWriter out = getJspContext().getOut();
       String path="/Users/asthasharma/Downloads";
       try{     
       Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + path);
             Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM "+ csvName);
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
       
        out.println("<form action='form.htm'>");
            out.println("<table border='1px'>");
                out.println("<tr>");
                out.println("<th>    SalesOrderID</th>");
                out.println("<th>	RevisionNumber</th>");
                out.println("<th>	OrderDate</th>");
                out.println("<th>	DueDate</th>");
                out.println("<th>	ShipDate	</th>");
                out.println("<th>    Status  </th>");
                out.println("<th>	OnlineOrderFlag</th>");
                out.println("<th>	SalesOrderNumber</th>");
                out.println("<th>	PurchaseOrderNumber</th>");
                out.println("<th>	AccountNumber</th>");
                out.println("<th>	CustomerID</th>");
                out.println("<th>	SalesPersonID</th>");
                out.println("<th>	TerritoryID</th>");
                out.println("<th>	BillToAddressID</th>");
                out.println("<th>	ShipToAddressID</th>");
                out.println("<th>	ShipMethodID</th>");
                out.println("<th>	CreditCardID</th>");
                out.println("<th>	CreditCardApprovalCode</th>");
                out.println("<th>	CurrencyRateID</th>");
                out.println("<th>	SubTotal</th>");
                out.println("<th>	TaxAmt</th>");
                out.println("<th>	Freight</th>");
                out.println("<th>	TotalDue</th>");
                out.println("<th>	Comment</th>");
                out.println("<th>    ModifiedDate</th>");
                out.println("</tr>");
                for(Sales sale:salesList){
            out.println("<tr>");
                out.println("<td> "  +sale.getSalesOrderID()+"</td>");
                out.println("<td>"+ sale.getRevisionNumber()+"</td>");
                out.println("<td>"+sale.getOrderDate()+"</td>");
                out.println("<td>"+ sale.getDueDate()+"</td>");
                out.println("<td>"+sale.getShipDate()+"	</td>");
                out.println("<td> "+sale.getStatus()+"</td>");
                out.println("<td>"+sale.getOnlineOrderFlag()+"</td>");
                out.println("<td>"+sale.getSalesOrderNumber()+"</td>");
                out.println("<td>"+sale.getPurchaseOrderNumber()+"</td>");
                out.println("<td>"+sale.getAccountNumber()+"</td>");
                out.println("<td>"+sale.getCustomerID()+"</td>");
                out.println("<td>"+sale.getSalesPersonID()+"</td>");
                out.println("<td>"+sale.getTerritoryID()+"</td>");
                out.println("<td>"+sale.getBillToAddressID()+"</td>");
                out.println("<td>"+sale.getShipToAddressID()+"</td>");
                out.println("<td>"+sale.getShipMethodID()+"</td>");
                out.println("<td>"+sale.getCreditCardID()+"</td>");
                out.println("<td>"+sale.getCreditCardApprovalCode()+"</td>");
                out.println("<td>"+sale.getSubTotal()+"</td>");
                out.println("<td>"+sale.getCurrencyRateID()+"</td>");
                out.println("<td>"+sale.getTaxAmt()+"</td>");
                out.println("<td>"+sale.getFreight()+"</td>");
                out.println("<td>"+sale.getTotalDue()+"</td>");
                out.println("<td>"+sale.getComment()+"</td>");
                out.println("<td>"+sale.getModifiedDate()+"</td>");
            out.println("</tr>");
                }
            out.println("</table>");
            
            try{
           Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
            PreparedStatement stmt=conn.prepareStatement("insert into sales values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"); 
            for(Sales sale:salesList){
            stmt.setString(1,sale.getSalesOrderID());
            stmt.setString(2,sale.getRevisionNumber());
            stmt.setString(3,sale.getOrderDate());
            stmt.setString(4,sale.getDueDate());
            stmt.setString(5,sale.getShipDate());
            stmt.setString(6,sale.getStatus());
            stmt.setString(7,sale.getOnlineOrderFlag());
            stmt.setString(8,sale.getSalesOrderNumber());
            stmt.setString(9,sale.getPurchaseOrderNumber());
            stmt.setString(10,sale.getAccountNumber());
            stmt.setString(11,sale.getCustomerID());
            stmt.setString(12,sale.getSalesPersonID());
            stmt.setString(13,sale.getTerritoryID());
            stmt.setString(14,sale.getBillToAddressID());
            stmt.setString(15,sale.getShipToAddressID());
            stmt.setString(16,sale.getShipMethodID());
            stmt.setString(17,sale.getCreditCardID());
            stmt.setString(18,sale.getCreditCardApprovalCode());
            stmt.setString(19,sale.getCurrencyRateID());
            stmt.setString(20,sale.getSubTotal());
            stmt.setString(21,sale.getTaxAmt());
            stmt.setString(22,sale.getFreight());
            stmt.setString(23,sale.getTotalDue());
            stmt.setString(24,sale.getComment());
            stmt.setString(25,sale.getModifiedDate());
            stmt.executeUpdate();     
        }
            int rowCount= stmt.getMaxRows();
        stmt.close();
        conn.close();
            }
            catch(Exception e){
                System.out.println("SQL Error");
            }
            out.println("<input type='hidden' value='store' name='action' />");
            out.println("<input type='submit' value='Add to Database' />");
        
   }
}

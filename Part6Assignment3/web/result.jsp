<%-- 
    Document   : result
    Created on : Feb 12, 2019, 5:38:40 PM
    Author     : asthasharma
--%>

<%@page import="com.neu.edu.pojo.CsvFile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
</style>
       
    </head>
    <body>
        <table>
            <tr>
                <th>Sales Order ID</th>
                <th>RevisionNumber</th>
                <th>OrderDate</th>	
                <th>DueDate</th>	
                <th>ShipDate</th>	
                <th>Status</th>	
                <th>OnlineOrderFlag</th>	
                <th>SalesOrderNumber</th>	
                <th>PurchaseOrderNumber</th>	
                <th>AccountNumber</th>	
                <th>CustomerID</th>	
                <th>SalesPersonID</th>	
                <th>TerritoryID</th>	
                <th>BillToAddressID</th>	
                <th>ShipToAddressID</th>	
                <th>ShipMethodID</th>	
                <th>CreditCardID</th>	
                <th>CreditCardApprovalCode</th>	
                <th>CurrencyRateID</th>	
                <th>SubTotal</th>	
                <th>TaxAmt</th>	
                <th>Freight</th>	
                <th>TotalDue</th>	
                <th>Comment</th>	
                <th>ModifiedDate </th>
            </tr>
            
        
        
        
       <c:forEach var="msg" items="${ requestScope.fileName }">
       <tr>
           <td><c:out value="${msg.getSalesOrderID()}"/></td>
           <td><c:out value="${msg.getRevisionNumber()}"/></td>
            <td><c:out value="${msg.getOrderDate()}"/></td>
            <td><c:out value="${msg.getDueDate()}"/></td>
            <td><c:out value="${msg.getShipDate()}"/></td>
            <td><c:out value="${msg.getStatus()}"/></td>
            <td><c:out value="${msg.getOnlineOrderFlag()}"/></td>
            <td><c:out value="${msg.getSalesOrderNumber()}"/></td>
                <td><c:out value="${msg.getPurchaseOrderNumber()}"/></td>
                <td><c:out value="${msg.getAccountNumber()}"/></td>
                <td><c:out value="${msg.getCustomerID()}"/></td>
                <td><c:out value="${msg.getSalesPersonID()}"/></td>
                <td><c:out value="${msg.getTerritoryID()}"/></td>
                <td><c:out value="${msg.getBillToAddressID()}"/></td>
                <td><c:out value="${msg.getShipToAddressID()}"/></td>
                <td><c:out value="${msg.getShipMethodID()}"/></td>
                <td><c:out value="${msg.getCreditCardID()}"/></td>
                <td><c:out value="${msg.getCreditCardApprovalCode()}"/></td>
                <td><c:out value="${msg.getCurrencyRateID()}"/></td>
                <td><c:out value="${msg.getSubTotal()}"/></td>
                <td><c:out value="${msg.getTaxAmt()}"/></td>
                <td><c:out value="${msg.getFreight()}"/></td>
                <td><c:out value="${msg.getTotalDue()}"/></td>
                <td><c:out value="${msg.getComment()}"/></td>
                <td><c:out value="${msg.getModifiedDate()}"/></td>
       </tr>  
      
               
        </c:forEach> 
        </table>
        
    </body>
</html>

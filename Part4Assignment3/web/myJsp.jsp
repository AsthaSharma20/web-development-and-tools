<%-- 
    Document   : myJsp
    Created on : Feb 11, 2019, 3:13:51 PM
    Author     : asthasharma
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
 <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Jsp Page</title>
    </head>
    <body>
        
        <c:out value="${'Welcome to Jsp using JSTL'}"/>  
        
        <c:forEach var="i" begin="1" end="3">          
            Value is: <c:out value="${i}"/><p>  
        </c:forEach>
          <c:set var="i" value="2" scope="request"/>      
         <c:if test="${i>2}">  
            <c:redirect url="index.html"/>  
        </c:if>         
        
         <c:set var="string1" value="You are what you believe yourself to be"/> 
         
         <p>Index-1 : ${fn:indexOf(string1, "to")}</p> 
         You are what you ${fn:toUpperCase(believe)} yourself to ${fn:toUpperCase(be)}.  
         
         Substring function: ${fn:substring(string, 5, 17)} 
        
         <c:set var="Date" value="<%=new java.util.Date()%>" />  
        <p>  
            Formatted Time :  
            <fmt:formatDate type="time" value="${Date}" />  
        </p>  
        <p><b>Date and Time in GMT-10 time Zone: </b><fmt:formatDate value="${date}"  
             type="both" timeStyle="long" dateStyle="long" /></p>
        
        <c:set var="Amount" value="4576.8902" />  
           <p> Formatted Number-1:  
            <fmt:formatNumber value="${Amount}" type="currency" /></p>  
        
           <c:set var="currency">  
            <currency>  
            <currency>  
                <name>USD</name>  
            </currency>  
            <currency>  
                <name>Dirham</name>  
            </currency>  
            </currency>
           </c:set>  
            <x:parse xml="${currency}" var="output"/>  
                <b>Currency is:</b>:  
            <x:out select="$output/currency/currency[1]/name" /><br>  
            <x:set var="curr" select="$output/currency/currency[2]/name" /><br>  
             <x:out select="$curr" /> 
             
             <x:choose>  
            <x:when select="$output//currency/name = 'USD'">  
                CURRENCY OF USA
            </x:when>
             </x:choose> 
                
               <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
                url="jdbc:mysql://newton.neu.edu:3306/booksdb" user="student" password="p@ssw0rd"/>  
  
            <sql:query dataSource="${db}" var="rs">  
                SELECT * from books;  
            </sql:query>
            <table border=“2" width=“100%“>
                <tr>
                    <th>ISBN</th>
                    <th>TITLE</th>
                    <th>AUTHORS</th>
                    <th>PRICE</th>
                </tr>
            <c:forEach var="table" items="${rs.rows}">
                <tr>
                    <td><c:out value="${table.isbn}"/></td>
                    <td><c:out value="${table.title}"/></td>
                    <td><c:out value="${table.authors}"/></td>
                    <td><c:out value="${table.price}"/></td>
                </tr>
            </c:forEach>
            </table>
                
                <sql:update dataSource="${db}" var="count">  
                INSERT INTO books VALUES('234e45','Kiterunner','Khaled Hosseini','35.50');  
            </sql:update>
                
                <sql:query dataSource="${db}" var="rs">  
                SELECT * from books;  
            </sql:query>
                
                 <table border=“2" width=“100%“>
                <tr>
                    <th>ISBN</th>
                    <th>TITLE</th>
                    <th>AUTHORS</th>
                    <th>PRICE</th>
                </tr>
            <c:forEach var="table" items="${rs.rows}">
                <tr>
                    <td><c:out value="${table.isbn}"/></td>
                    <td><c:out value="${table.title}"/></td>
                    <td><c:out value="${table.authors}"/></td>
                    <td><c:out value="${table.price}"/></td>
                </tr>
            </c:forEach>
            </table>
                
                
    </body>
</html>

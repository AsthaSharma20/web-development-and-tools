<%-- 
    Document   : result
    Created on : Feb 13, 2019, 5:19:45 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
 
    <body bgcolor="green">
        <p>YOU SEARCHED FOR &nbsp; &nbsp;<%= request.getAttribute("keyword")%> </p> 
        <table>
            <tr>
            <th>TITLE</th>
            <th>ACTOR</th>
            <th>ACTRESS</th>
            <th>GENRE</th>
            <th>YEAR</th>

            </tr>
            
               
            <c:forEach var="message" items="${requestScope.list}">
            <tr>
                <td><c:out value="${message.getTitle()}" />   </td>      
                <td><c:out value="${message.getActor()}" />  </td>
                <td><c:out value="${message.getActress()}" />  </td>
                <td><c:out value="${message.getGenre()}" />  </td>
                <td><c:out value="${message.getYear() }" />  </td>
        </tr>
        </c:forEach> 
            
        </table>
            <a href='index.html'>Go back to main page</a>
    </body>
</html>

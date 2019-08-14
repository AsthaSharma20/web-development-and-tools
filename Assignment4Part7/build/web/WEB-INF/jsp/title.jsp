<%-- 
    Document   : add
    Created on : Feb 22, 2019, 12:45:02 PM
    Author     : asthasharma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="pojo.Browse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TITLE</title>
    </head>
    <body bgcolor="green">
        <p>YOU SEARCHED FOR &nbsp; &nbsp;<%= request.getAttribute("keyword")%> </p> 
        <table>
            <thead>
            <th>TITLE</th>
            <th>ACTOR</th>
            <th>ACTRESS</th>
            <th>GENRE</th>
            <th>YEAR</th>

            </thead>
            <tbody>
               
            <c:forEach var="message" items="${requestScope.list}">
            <tr>
                <td><c:out value="${message.getTitle()}" />   </td>      
                <td><c:out value="${message.getActor()}" />  </td>
                <td><c:out value="${message.getActress()}" />  </td>
                <td><c:out value="${message.getGenre()}" />  </td>
                <td><c:out value="${message.getYear() }" />  </td>
        </tr>
        </c:forEach> 
            </tbody>
        </table>
            <a href='redirect.jsp'>Go back to main page</a>
    </body>
</html>

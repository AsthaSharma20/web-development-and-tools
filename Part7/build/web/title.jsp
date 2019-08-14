<%-- 
    Document   : title
    Created on : Feb 6, 2019, 6:28:14 PM
    Author     : asthasharma
--%>

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
                <% List<Browse>  messages = (List<Browse>)request.getAttribute("messages"); %>
                <% for(Browse message : messages) { %>
                    <tr>
                    <td><%= message.getTitle()%></td>
                    <td><%= message.getActor() %></td>
                    <td><%= message.getActress() %></td>
                    <td><%= message.getGenre() %></td>
                    <td><%= message.getYear() %></td>
                <% } %>
            </tbody>
        </table>
            <a href='index.html'>Go back to main page</a>
    </body>
</html>

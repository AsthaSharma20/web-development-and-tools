<%-- 
    Document   : results
    Created on : Mar 9, 2019, 2:22:11 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <body style="background-color:powderblue;">
        <table border="1" align="center">
            <thead>
            <th>title</th>
            <th>actor</th>
            <th>actress</th>
            <th>genre</th>
            <th>year</th>
        </thead>
        <tbody>            

            <tr>
                <td>${movieSearch.title}</td>
                <td>${movieSearch.actor}</td>
                <td>${movieSearch.actress}</td>
                <td>${movieSearch.genre}</td>
                <td>${movieSearch.year}</td>
            </tr>    


        </tbody>
    </table>
    <br>
    <br>
    <br>
    <br>
    <p align="center"><a href="/Hw5Part6/redirect.htm">Click here to go back to main page</a></p>   
    </body>
</html>

<%-- 
    Document   : browse
    Created on : Feb 13, 2019, 12:12:26 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse movies</title>
    </head>
   <body bgcolor="yellow">
        <h1>Searching Movies</h1>
        <form method="POST" action="movieServlet">
            Keyword &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="key"><br><br><br>
  <input type="radio" name="choice" value="title"> Search by title<br>
  <input type="radio" name="choice" value="actor"> Search by Actor<br>
  <input type="radio" name="choice" value="actress">Search by Actress<br>  
  <input type="submit" value="Search Movies">
</form>
    </body>
</html>

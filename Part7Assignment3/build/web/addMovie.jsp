<%-- 
    Document   : addMovie
    Created on : Feb 14, 2019, 7:38:58 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body bgcolor="cyan">
        
         <h1>Add Movies</h1>
       <form method="POST" action="addMovieServlet">
           <h3><b>Please enter the details below:</b></h3><br><br><br>
           <label>Movie Title : </label><input type="text" name="title"><br><br><br>
           <label>Lead Actor  : </label><input type="text" name="actor"><br><br><br>
           <label>Lead Actress: </label><input type="text" name="actress"><br><br><br>
           <label>Genre       : </label><input type="text" name="genre"><br><br><br>
           <label>Year        : </label><input type="text" name="year"><br><br><br>
           <input type="submit" value="Add Movies">
       </form>
    </body>
</html>

<%-- 
    Document   : add
    Created on : Feb 22, 2019, 12:45:02 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body bgcolor="cyan">
        
         <h1>Add Movies</h1>
       <form method="POST" action="add.htm">
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

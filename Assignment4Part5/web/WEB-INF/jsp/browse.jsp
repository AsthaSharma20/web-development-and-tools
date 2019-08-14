<%-- 
    Document   : add
    Created on : Feb 20, 2019, 1:16:06 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Page</title>
    </head>
    <body bgcolor="yellow">
        <h1>Searching Movies</h1>
        <form method="POST" action="title.htm">
            Keyword &nbsp; &nbsp;&nbsp; &nbsp;<input type="text" name="key"><br><br><br>
  <input type="radio" name="choice" value="title"> Search by title<br>
  <input type="radio" name="choice" value="actor"> Search by Actor<br>
  <input type="radio" name="choice" value="actress">Search by Actress<br>  
  <input type="submit" value="Search Movies">
</form>
    </body>
</html>

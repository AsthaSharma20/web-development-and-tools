<%-- 
    Document   : add
    Created on : Feb 20, 2019, 9:25:11 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body bgcolor="pink">
        <h3> Welcome to our Movie Store</h3>

        <h4> Please make a selection below</h4>
        <form method="POST" action="home.htm">
            <select name="check" id="check">
                <option  value="browse">Browse Movies</option>
                <option  value="add">Add new movies to the database</option>

            </select>
            <input type="submit" value="Send">
        </form>

    </body>
</html>

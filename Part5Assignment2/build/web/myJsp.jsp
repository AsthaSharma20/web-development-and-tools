<%-- 
    Document   : MyJsp
    Created on : Feb 5, 2019, 10:00:54 AM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ReadServlet.xls" method="post">
            <label>Enter File Name: </label><input type="text" name="csvFileName">
            <input type="submit" value="Submit" required>
        </form>
    </body>
</html>

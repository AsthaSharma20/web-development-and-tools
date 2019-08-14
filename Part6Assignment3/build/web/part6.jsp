<%-- 
    Document   : part6
    Created on : Feb 12, 2019, 2:53:56 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Request File</title>
    </head>
    <body>
        <form action="myServlet.xls" method="post">
            <label>Enter File Name: </label><input type="text" name="csvFileName">
            <input type="submit" value="Submit" required>
        </form>
    </body>
</html>


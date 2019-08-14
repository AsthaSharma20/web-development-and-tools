<%-- 
    Document   : result
    Created on : Feb 6, 2019, 8:06:26 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Added</title>
    </head>
    <body bgcolor="green">
         <p>Books added successfully &nbsp; &nbsp;<%= request.getAttribute("countnext")%> </p> 
         <p>request.getAt</p>
        <a href="index.html">Click here to go back to the Homepage</a>
    </body>
</html>

<%-- 
    Document   : form
    Created on : Feb 20, 2019, 2:45:38 AM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "../tlds/taglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CSV </title>
        
    
    
    </head>
    <body>
        <h1> CSV DETAILS </h1>
        <!--input name="csvName" /-->
        <ex:DisplayCSVData csvName="SalesOrder" />
        
    </body>
</html>

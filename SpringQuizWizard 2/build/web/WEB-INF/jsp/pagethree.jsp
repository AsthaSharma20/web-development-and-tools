<%-- 
    Document   : pageone
    Created on : Mar 6, 2019, 11:53:18 AM
    Author     : kasai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page 3</h1>
        
        <p>3) Which http method is idempotent?</p>
         <form:form method="POST" commandName="quizForm">
              <form:errors path="*" element="div" />
               <form:radiobutton path="userOption['Question3']" value="1" />get <br>
              <form:radiobutton path="userOption['Question3']" value="2" />post <br>
              <form:radiobutton path="userOption['Question3']" value="3" />put <br>
              <form:radiobutton path="userOption['Question3']" value="4" />delete<br>
              <input type="submit" value="Previous" name="_target2" />
              <input type="submit" value="Cancel" name="_cancel" />
              <input type="submit" value="Submit" name="_finish" />
           </form:form>    
    </body>
</html>

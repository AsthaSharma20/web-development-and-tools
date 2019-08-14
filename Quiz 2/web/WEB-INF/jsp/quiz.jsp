<%-- 
    Document   : quiz
    Created on : Mar 7, 2019, 2:21:45 PM
    Author     : asthasharma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${requestScope.q<3}">
            <form action="${requestScope.q + 1}.htm" method="post">
        
        <c:out value="${quiz.question} "/>
        <c:forEach var="options" items="${quiz.option}"> 
        <input type="radio" name="answers" value="${options}"/><c:out value="${options}"/>
         </c:forEach>
        <input type="submit" value="next question"/>
          </form>
        </c:if>
         <c:if test="${requestScope.q==3}">
             <form action="answer.htm" method="post">        
        <c:out value="${quiz.question} "/>
        <c:forEach var="options" items="${quiz.option}"> 
        <input type="radio" name="answers" value="${options}"/><c:out value="${options}"/>
         </c:forEach>
        <input type="submit" value="Results"/>
        </form>
         </c:if>
        
        <c:if test="${requestScope.q==4}">
                    
        
        <c:forEach var="options" items="${userans}"> 
        <c:out value="${options}"/>
         </c:forEach>
        
         </c:if>
       
        
      
    </body>
</html>

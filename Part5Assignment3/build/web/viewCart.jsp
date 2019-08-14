<%-- 
    Document   : viewCart
    Created on : Feb 14, 2019, 9:24:04 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View cart</title>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Shopping Cart</h1>
            </header>
            <nav>
                <ul>
                    <li><a href="myCart.jsp">Home</a></li>
                    <br><br>
                    <li><a href="books.jsp">Books</a></li>
                    <br>
                    <li><a href="cd.jsp">CDS</a></li>
                    <br>
                    <li><a href="computer.jsp">Computers</a></li>
                    <br>      

                    <br>
                    <form action="myServlet" method = "POST">
                        <input type='hidden' name="hide" value="view"/>     
                        <input type="submit" value="View cart">
                    </form>
                </ul>
            </nav>
            <div id="main">
                <div class="content"> 
                    <form action="myServlet" method="POST">

                        <c:choose>
                            <c:when test="${null != sessionScope.cartItems}">

                                <c:forEach var="it" items="${sessionScope.cartItems}">
                                    <c:set var="items" scope="page" value="${it.name}"/>  
                                    <input type='checkbox' name='selectedProducts' value="${it.name}"> ${it.name} <br>
                                </c:forEach> 
                                <br><br><br>
                                <input type='hidden' name="hide" value="remove"/>
                                <input type="submit" value="Remove" name="remove">

                            </c:when>
                            <c:otherwise>
                                <h4>Empty cart you</h4>  
                            </c:otherwise>
                        </c:choose>
                        <br><br><br><br><br><br><br><br><br><br><br><br><br>
                    </form>

                </div>

            </div>
        </div>
    </body>
</html>

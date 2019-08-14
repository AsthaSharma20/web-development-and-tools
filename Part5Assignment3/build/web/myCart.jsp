<%-- 
    Document   : result
    Created on : Feb 14, 2019, 9:23:19 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
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
                    <p>Welcome to shopping cart</p>
                    <br>
            
                    
                </div>
            </div>
        </div>
    </body>
</html>

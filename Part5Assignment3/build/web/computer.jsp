<%-- 
    Document   : computer
    Created on : Feb 13, 2019, 4:43:53 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computer</title>
    </head>
    <body background-color="blue">
    		<h1>Welcome to trizon</h1>

	   <nav >
		  <ul class="init"> 
		    <li ><a href= "cd.jsp" target="_parent">CDS </a></li>
		     <li ><a href= "books.jsp" target="_parent">Books</a></li>
		     <li ><a href= "computer.jsp" target="_parent"> Computers</a></li>
	      </ul>
	  </nav>

<form action="myServlet" method="post">
<input type="checkbox" name="cart" value="macBook">MacBook<br>
<input type="checkbox" name="cart" value="hp">HP<br>
<input type="checkbox" name="cart" value="lenovo"> Lenovo <br>
<input type="checkbox" name="cart" value="dell"> Dell <br>
<input type="checkbox" name="cart" value="ibm">IBM <br>
<input type="submit" value="add to cart" />

</form>
<form action="myServlet" method="get">
<input type="submit" value="View Cart" /> 
</form>
</body> 

    
</html>

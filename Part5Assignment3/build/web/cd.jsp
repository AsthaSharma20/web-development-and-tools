<%-- 
    Document   : cd
    Created on : Feb 13, 2019, 4:43:30 PM
    Author     : asthasharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CDs</title>
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

<form action="myServlet" method="post" >
<input type="checkbox" name="cart" value="charlie">Charlie<br>
<input type="checkbox" name="cart" value="rhonda">Rhonda<br>
<input type="checkbox" name="cart" value="chris"> Chris<br>
<input type="checkbox" name="cart" value="arianna"> Arianna <br>
<input type="checkbox" name="cart" value="shawn">Shawn <br>
<input type="submit" value="add to cart" />
</form>
<form action="store" method="get">
<input type="submit" value="View Cart" /> 
</form>
</body> 
>
</html>

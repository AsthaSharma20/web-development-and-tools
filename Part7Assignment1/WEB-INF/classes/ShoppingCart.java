import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class ShoppingCart extends HttpServlet 
	{

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{


	HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> shoppingcart  = (ArrayList)session.getAttribute("itemsincart");;
		if(shoppingcart==null){
shoppingcart = new ArrayList<String>();

session.setAttribute("itemsincart",shoppingcart);
}else{

	shoppingcart = (ArrayList)session.getAttribute("itemsincart");
}

String[] values = request.getParameterValues("cart");

for (String ppp : values){

	shoppingcart.add(ppp);
}

//session.setAttribute("itemsincart", shoppingcart);
String val = request.getHeader("referer");
System.out.println("value ::"+ val);

out.println("<script>");
out.println("alert('Product added');");
out.println("location='"+val+"';");
out.println("</script>");
out.close();
}



public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
HttpSession session = request.getSession();
ArrayList<String> vals = (ArrayList)session.getAttribute("itemsincart");
out.println("<html><head></head><body>Cart items are:");

Set<String> toshow = new HashSet<>(vals);


 out.println("<form action='store' method='get' >");
 for(String ij : toshow)
{
 out.println("<input type='checkbox' value='"+ij+"' name='removal' />"+ij);
}
 out.println("<input type='submit' value='remove'>");
 out.println("</form>");


out.println("<a href='index.html'>Back to shopping area</a>");
out.println("|||");
out.println("<a href='books.html'>Book section </a>");
out.println("|||");
out.println("<a href='cd.html'>Music section </a>");
out.println("|||");
out.println("<a href='computer.html'>Computers and Laptop section </a>");



String[] removed = request.getParameterValues("removal");
System.out.println(removed.length);
ArrayList<String> allitems = ((ArrayList)session.getAttribute("itemsincart"));

for(String pii: removed)
{
	System.out.println(pii);

	if(allitems.contains(pii))
	{
		allitems.remove(pii);
	}
}

System.out.println(allitems);

session.setAttribute("itemsincart", allitems);

out.println("</body></html>");
}
}
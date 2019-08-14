import java.io.IOException;

import java.io.PrintWriter;

import java.util.Random;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



public class Part3 extends HttpServlet{

            
   
 @Override
    
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  }

    
@Override
    
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
	 response.setContentType("text/html");
        
	PrintWriter out = response.getWriter();
        
	String[] hobby = request.getParameterValues("hobby");
        		
	String address = request.getParameter("address");

	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String country = request.getParameter("country");        
        
	out.println("<html>");
        
	out.println("<head>");
        
	out.println("<title>Details :</title>");
        
	out.println("</head>");
       
	out.println("<body>");
        
	out.println("<p>Email : " + email +"</p>");
        
	out.println("<p>Gender :"+gender+"</p>");
 
	out.println("<p>Country : " +country +"</p>");
   
	out.println("<p>Address : " + address +"</p>");
     	
	out.println("<ul>");
        
	for(String h: hobby){
            
		out.println("<li>"+h+"</li>");
        
	}
        	
	out.println("</body>");
        
	out.println("</html>");
    
	}


}
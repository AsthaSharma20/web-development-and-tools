import java.io.IOException;

import java.io.PrintWriter;

import java.util.Random;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;



public class Part4 extends HttpServlet{

            
   
 @Override
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  	}

    
@Override
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
	 	response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
        
		out.println("<html>");
        
		out.println("<head>");
        
		out.println("<title>Details: </title>");
        
		out.println("</head>");
        
		out.println("<body>");
       
		Enumeration detail = request.getParameterNames();
        
		while(detail.hasMoreElements())
		 {
        
			Object obj = detail.nextElement();
        
			String par=(String)obj;
        
			String value=request.getParameter(par);
        
			out.println("<p>"+value+"</p>");
        
		}


        
		out.println("</body>");
        
		out.println("</html>");
    
	}


}
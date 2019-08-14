import java.io.IOException;

import java.io.PrintWriter;

import java.util.Random;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Iterator;


import java.util.Set

;
public class Part5 extends HttpServlet{

   
 @SuppressWarnings("unchecked")
           
   
 @Override
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
  	}

 
 @SuppressWarnings("unchecked")
     
@Override
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
	 	response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
        
		out.println("<html>");
        
		out.println("<head>");
        
		out.println("<title>Details: </title>");
        
		out.println("</head>");
        
		out.println("<body>");
       
		 Map m = request.getParameterMap();
        
		Set s = m.entrySet();
        
		Iterator it = s.iterator();



		while(it.hasNext()){

                		Map.Entry<String,String[]> entry=(Map.Entry<String,String[]>)it.next();
			String key= entry.getKey();
                		String[] value= entry.getValue();
               		out.println("<p> "+key+"</p>");
                    		if(value.length>1){    
                       			for (int i = 0; i < value.length; i++) {
                            				out.println("<ul>" );
					out.println("<li>" +value[i].toString()+"</li><br>");
					out.println("</ul>");
                        				}
                    		}
			else
                            			out.println("<p> "+value[0].toString()+"</p><br>");
           		}

		out.println("</body>");
        
		out.println("</html>");
    
	}


}
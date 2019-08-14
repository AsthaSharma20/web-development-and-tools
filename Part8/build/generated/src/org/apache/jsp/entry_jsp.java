package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class entry_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Enter Details</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"yellow\">\n");
      out.write("        ");
String count = request.getParameter("count");
      out.write("\n");
      out.write("         ");
 int cnt=Integer.parseInt(count); 
      out.write("\n");
      out.write("        <form method=\"POST\" action=\"bookServlet\">\n");
      out.write("            <TABLE BORDER=\"1\" ALIGN=\"CENTER\">\n");
      out.write("              <TR>\n");
      out.write("                  <Th>ISBN</Th><br/><br/><br/> \n");
      out.write("                <Th>BOOK TITLE</Th><br>\n");
      out.write("              \n");
      out.write("                <Th>AUTHOR</Th>\n");
      out.write("                \n");
      out.write("              \n");
      out.write("                <Th>PRICE</Th>\n");
      out.write("                \n");
      out.write("              </TR>\n");
      out.write("              <TR>\n");
      out.write("              ");
 for(int i=0;i<cnt;i++) { 
      out.write("\n");
      out.write("                  <TD><INPUT TYPE=\"TEXT\" NAME=\"isbn\" > </TD>\n");
      out.write("                  <TD>\\<INPUT TYPE=\"TEXT\" NAME=\"title\" ></TD>\n");
      out.write("                  <TD><INPUT TYPE=\"TEXT\" NAME=\"author\" ></TD>\n");
      out.write("                  <TD><INPUT TYPE=\"TEXT\" NAME=\"price\" ></TD>\n");
      out.write("            ");
  } 
      out.write("\n");
      out.write("            \n");
      out.write("              </TR>\n");
      out.write("             \n");
      out.write("            </TABLE>\n");
      out.write("            <P><INPUT TYPE=\"SUBMIT\" VALUE=\"Add Books\" NAME=\"submit\"></P> \n");
      out.write("        </form>   \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

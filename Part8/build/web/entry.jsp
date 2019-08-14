<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Enter Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </thead>
    <body bgcolor="yellow">
        <%String count = request.getParameter("count");%>
         <% int cnt=Integer.parseInt(count); %>
         
        <form method="POST" action="bookServlet">

            <TABLE BORDER="1" ALIGN="CENTER">
              <thead>
                 <th>ISBN </th>
                <th>BOOK TITLE</th>
              
                <Th>AUTHOR</Th>
                
              
                <Th>PRICE</Th>
                
              </thead>
              <tbody>
              <% for(int i=0;i<cnt;i++) { %>
              <tr>
                  <TD><INPUT TYPE="TEXT" NAME="isbn" > </TD>
                  <TD><INPUT TYPE="TEXT" NAME="title" ></TD>
                  <TD><INPUT TYPE="TEXT" NAME="author" ></TD>
                  <TD><INPUT TYPE="TEXT" NAME="price" ></TD>
                  
            <%  } %>
            
              </tbody>
             
            </TABLE>
            <P><INPUT TYPE="SUBMIT" VALUE="Add Books" NAME="submit"></P> 
        </form>   
    </body>
</html>

package org.btm.contextApp;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/bp")
public class BookServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	
		ServletContext ctx=getServletContext();
		String offmsg=ctx.getInitParameter("ofm");//from web.xml
		String offperc=ctx.getInitParameter("ofp");
		
		//FETCH CONTEXT(ctx) OBJECT INTO SCOPE ONCE//
		Product pd=(Product)ctx.getAttribute("prd");  //we can'nt directly access obj(downcasting is required)
		
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='green'>"
		                 + "<h1>Book Product Details</h1><p>"
		                 + " "+offmsg+" "+offperc+"%off"
		                 		+ "<br><a href=\"product.html\">Back</a>"
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();
	}

}

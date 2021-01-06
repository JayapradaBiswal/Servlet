package org.btm.contextApp;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ep")
public class ElectronicServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	
		ServletContext ctx=getServletContext();
		String offmsg=ctx.getInitParameter("ofm");//from web.xml
		String offperc=ctx.getInitParameter("ofp");
		
		//ADD CONTEXT(ctx) OBJECT INTO SCOPE ONCE//
		Product p=new Product();
		ctx.setAttribute("prd",p);
		
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='yellow'>"
		                 + "<h1>Electronic Product Details</h1><p>"
		                 + " "+offmsg+" "+offperc+"%off"
		                 		+ "<br><a href=\"product.html\">Back</a>"
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();
	}

}

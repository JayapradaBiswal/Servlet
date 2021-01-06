package org.btm.contextApp;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/cp")
public class ClothSevlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	
		ServletContext ctx=getServletContext();
		String offmsg=ctx.getInitParameter("ofm");//from web.xml
		String offperc=ctx.getInitParameter("ofp");
		
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='pink'>"
		                 + "<h1>Cloth Product Details</h1><p>"
		                 + " "+offmsg+" "+offperc+"%off"
		                 		+ "<br><a href=\"product.html\">Back</a>"
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();
	}

}

package org.btm.uiApp1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/jaya")
public class FirstServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		String fname=req.getParameter("fn");
		String lname=req.getParameter("ln");
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='pink'>"
		                 + "<h1>Student Nmae is: "+fname+" "+lname+"</h1> "
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();
	}

}

package org.btm.lifecycleApp;
import java.io.*;
import javax.servlet.*;
public class FirstServlet extends GenericServlet
{
	public FirstServlet()
	{
		System.out.println("Servlet Object is Created");
	}
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Servlet obj is Initialized!!!");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='yellow'>"
		                 + "<h1>Student details are "+name+" "+place+"</h1> "
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();
		System.out.println("service() is Executed!!");
	}
	@Override
	public void destroy()
	{
      System.out.println("closed all costly Resources!!" );
    }

}


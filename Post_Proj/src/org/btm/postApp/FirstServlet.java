package org.btm.postApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet
{
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
{
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String sperc=req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		
		PrintWriter out=resp.getWriter();//SERVLET RESPONSE
		out.println("<html><body bgcolor='yellow'>"
		                 + "<h1>Student details are "+name+" "+dept+"</h1> "
		                 + "</body></html>");//Presentation Logic
		out.flush();//PrintWriter
		out.close();

		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");//static
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			
			//SET THE VALUE FOR PLACE HOLDER
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,dept);
			pstmt.setDouble(4,perc);
			pstmt.executeUpdate();//Persistence Logic
			
		
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
	
	}
}
	




package org.btm.getApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet
{
	@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
{
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		PrintWriter out=resp.getWriter();
		
		Connection con = null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 String qry="select * from btm.student where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt=con.prepareStatement(qry);
			//set the value for place holder
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();//persistence logic
			if(rs.next())
			{
				String name=rs.getString(2);
				String dept=rs.getString(3);
				
				out.println("<html><body bgcolor='cyan'>"
				                 + "<h1>Student details are "+name+" "+dept+"</h1> "
				                 + "</body></html>");//Presentation Logic
			
			}
			else
			{
				out.println("<html><body bgcolor='cyan'>"
				                 + "<h1>No Data Faound</h1> "
				                 + "</body></html>");//Presentation Logic
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if(rs!=null)
			{
				try {
					rs.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}	
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
		out.flush();
		out.close();
	
	}
}
	





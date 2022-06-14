

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DbConnection dc=new DbConnection();
		Connection con=dc.connect();
		int accountnumber=0;
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String address=request.getParameter("address");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		int mobno=Integer.parseInt(request.getParameter("mobno"));
		int balance=Integer.parseInt(request.getParameter("balance"));
		/*
		
		try
		{
			
			String S ="insert into user values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setInt(1, accountnumber);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			pstmt.setString(4, state);
			pstmt.setInt(5, pincode);
			pstmt.setString(6, address);
			pstmt.setInt(7, mobno);
			pstmt.setInt(8, balance);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("dashboard.html");
			}
			else
			{
				System.out.println("Unfortunately your account is not created due to wrong Information......");
			}
			System.out.println("=============================================================");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		
		
		
		
		
		
		
		
		try
		{
			String S ="insert into user values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setInt(1, accountnumber);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			pstmt.setString(4, state);
			pstmt.setInt(5, pincode);
			pstmt.setString(6, address);
			pstmt.setInt(7, mobno);
			pstmt.setInt(8, balance);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("dashboard.html");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

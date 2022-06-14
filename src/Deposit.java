

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
		int oldbalance=0, amount=0;
		int accountnumber=Integer.parseInt(request.getParameter("accountnumber"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
			String S="select balance from user where accountnumber=?";
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setInt(1, accountnumber);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				oldbalance=rs.getInt(1);
				//System.out.println("Enter the amount to be Deposited");
				//amount=s.nextInt();
				amount=Integer.parseInt(request.getParameter("amount"));
				// 
				
			}
			if(amount>0)
			{
				int newbalance= oldbalance+amount;
				String S1="update user set balance=? where accountnumber=?";
				PreparedStatement pstmt1=con.prepareStatement(S1);
				pstmt1.setInt(1, newbalance);
				pstmt1.setInt(2, accountnumber);
				int i=pstmt1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("dashboard.html");
				}
				else
				{
					System.out.println("Amount is not Deposited ");
					
				}
			}
			else
			{
				response.sendRedirect("404.html");
			}
			System.out.println("=============================================================");
			
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

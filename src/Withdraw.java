

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		int oldbalance=0 , amount=0,withdraw=0,balance=0;
		int accountnumber1=Integer.parseInt(request.getParameter("accountnumber1"));
		int accountnumber2=Integer.parseInt(request.getParameter("accountnumber2"));
		try
		{
			String S="select balance from user where accountnumber=?";
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setInt(1, accountnumber1);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				 oldbalance=rs.getInt(1);
				//System.out.println("Enter the amount to be Withdraw");
				//amount=s.nextInt();
				 amount=Integer.parseInt(request.getParameter("amount"));
				
			}
			if(oldbalance>0)
			{
				if(amount>0)
				{
					int newbalance= oldbalance-amount;
					String S1="update user set balance=? where accountnumber=?";
					PreparedStatement pstmt1=con.prepareStatement(S1);
					pstmt1.setInt(1, newbalance);
					pstmt1.setInt(2, accountnumber1);
					int i=pstmt1.executeUpdate();
					if(i>0)
					{
						response.sendRedirect("dashboard.html");
					}
					else
					{
						System.out.println("Not Withdrawl");
						//response.sendRedirect("404W.html");
					}
				}
				else
				{
					System.out.println("you cant withdraw -ve money");
				}
				
				//int withdrawl =	oldbalance + amount;
				String S2="select Balance from user where accountnumber=?";
				//PreparedStatement pstmt2=con.prepareStatement(S2);
				//pstmt2.setInt(1, withdrawl);
				//pstmt2.setInt(2, acc_num2);
				//int i=pstmt2.executeUpdate();
				PreparedStatement pstmt2=con.prepareStatement(S2);
				pstmt2.setInt(1, accountnumber2);
				ResultSet rs1=pstmt2.executeQuery();
				if(rs1.next())
				{
					oldbalance=rs1.getInt(1);
				
				}
				if(amount>0)
				{
				int newbalance=oldbalance+amount;
				String S3="update user set balance=? where accountnumber=?";
				PreparedStatement pstmt3=con.prepareStatement(S3);
				pstmt3.setInt(1, newbalance);
				pstmt3.setInt(2, accountnumber2);
				int i=pstmt3.executeUpdate();
				if(i>0)
				{
					System.out.println("Deposited Successfully");
				}
				else
				{
					System.out.println(" Not Deposited ");
					//response.sendRedirect("404W.html");
				}
				}
				else
				{
					System.out.println("-ve money cant be deposited");
					//response.sendRedirect("404W.html");
				}
						
				
			}
			else
			{
				//System.out.println("Dear Cheat user please have some amount greater than 0 in your account........");
				response.sendRedirect("404W.html");
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

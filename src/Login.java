

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		try
		{
			String S="select * from login where email=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
					{
						System.out.println("Successfully");
						
						response.sendRedirect("dashboard.html");
					}
			else
			{
				response.sendRedirect("register.html");
			}
			
		}catch(Exception e)
		{
			
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

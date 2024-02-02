

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userregServlet")
public class userregServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String s1=request.getParameter("t4");
		out.println("<html><body>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
	    	  PreparedStatement stat=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
	    	  stat.setString(1, request.getParameter("t4"));
	    	  stat.setString(2, request.getParameter("t5"));
	    	  stat.setString(3, request.getParameter("t6"));
	    	  stat.setString(4, request.getParameter("t1"));
	    	  stat.setString(5, request.getParameter("t2"));
	    	  stat.setString(6, request.getParameter("t3"));
	    	  stat.executeUpdate();
	    	  out.println("<h2>Hello.."+s1+ " Registration Succesfull.!</h2>");
	    	  RequestDispatcher rd=request.getRequestDispatcher("userlogin.html");
	    	  rd.include(request, response);
	    	  con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body></html>");
		out.close();
	}

}

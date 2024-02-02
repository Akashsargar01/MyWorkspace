

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

@WebServlet("/AdminregServlet")
public class AdminregServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
			PreparedStatement stat=con.prepareStatement("insert into adminlogin values(?,?)");
			stat.setString(1,request.getParameter("s1"));
			stat.setString(2, request.getParameter("s2"));
			stat.executeUpdate();
			out.println("<h1>registration successfull</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("adminreg.html");
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

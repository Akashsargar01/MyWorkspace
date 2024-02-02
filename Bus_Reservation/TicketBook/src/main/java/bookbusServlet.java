

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookbusServlet")
public class bookbusServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   PrintWriter out=response.getWriter();
   response.setContentType("text/html");
   out.println("<html><body>");
   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
	   PreparedStatement stat=con.prepareStatement("insert into bookbus values(?,?,?,?,?,?,?,?,?,?)");
	   stat.setInt(1,Integer.parseInt(request.getParameter("m1")));
	   stat.setString(2, request.getParameter("m2"));
	   stat.setString(3, request.getParameter("m3"));
	   stat.setString(4, request.getParameter("m4"));
	   stat.setString(5, request.getParameter("m5"));
	   stat.setString(6, request.getParameter("m6"));
	   stat.setString(7, request.getParameter("m7"));
	   stat.setString(8, request.getParameter("m8"));
	   stat.setString(9, request.getParameter("m9"));
	   stat.setString(10, request.getParameter("m10"));
	   stat.executeUpdate();
	   out.println("<h2>Bus booked Successfully.!</h2>");
 	  RequestDispatcher rd=request.getRequestDispatcher("End.html");
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



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchbusServlet")
public class searchbusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out=response.getWriter();
       response.setContentType("text/html");
       out.println("<body><html>");
       try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
    	   PreparedStatement stat=con.prepareStatement("select*from busrec where frm=? and too=? and date=?");
    	   stat.setString(1,request.getParameter("a1"));
    	   stat.setString(2,request.getParameter("a2"));
    	   stat.setString(3,request.getParameter("a3"));
    	   
    	   ResultSet rs=stat.executeQuery();
    	   if(rs.next())
    	   {
    		   out.println("<body><h1>Hello User!!</h1></body>");
    		   RequestDispatcher rd=request.getRequestDispatcher("ViewShedule.jsp");
    		   rd.include(request, response);
    	   }
    	   else {
    		   out.println("<h1>Sorry..! No Bus Available</h1>");
    		   RequestDispatcher rd=request.getRequestDispatcher("searchbus.html");
    		   rd.include(request, response);
    		   rs.close();
    		   con.close();
    	   }
       }
       catch(Exception e)
       {
    	   out.println(e);
       }
       out.println("</body></html>");
       out.close();
       
	}

}

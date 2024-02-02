import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userloginServlet")
public class userloginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out=response.getWriter();
      response.setContentType("text/html");
      String s1=request.getParameter("t1");
      String s2=request.getParameter("t2");
      out.println("<html><body>");
      try 
      {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
    	  PreparedStatement stat=con.prepareStatement("select*from user where uid=? and pwd=?");
    	  stat.setString(1, s1);
    	  stat.setString(2, s2);
    	  ResultSet rs=stat.executeQuery();
    	  if(rs.next())
    	  
    	  { out.println("<h1>Hello.. "+s1+"!</h1>");
    		  RequestDispatcher rd=request.getRequestDispatcher("searchbus.html");
    		  rd.include(request, response);
    	  }
    	  else
    	  
    	  { out.println("<h2>Invalid userId or Passsword..try again</h2>");
    		  RequestDispatcher rd=request.getRequestDispatcher("userlogin.html");
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



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#BAF3E0;

}
input{
width:200px;

font-family: Tahoma, Geneva, sans-serif;
height:20px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;

}input{
width:200px;

font-family: Tahoma, Geneva, sans-serif;
height:20px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;

}input{
width:200px;

font-family: Tahoma, Geneva, sans-serif;
height:20px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;

}
input.button {
width:100px;

right:20px;
bottom:20px;
background:#09C;
color:#fff;
font-family: Tahoma, Geneva, sans-serif;
height:30px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;
border: 1p solid #999;
}
input.button:hover {
background:#fff;
color:#09C;
}
form    {
background: -webkit-gradient(linear, bottom, left 175px, from(#CCCCCC), to(#EEEEEE));
background: -moz-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);
margin:auto;
width:550px;
height:725px;
font-family: Tahoma, Geneva, sans-serif;
font-size: 14px;
font-style: italic;
line-height: 10px;
font-weight: bold;
color: #000000;
text-decoration: none;
-webkit-border-radius: 5px;
-moz-border-radius: 15px;
border-radius: 15px;
padding:2px;
border: 1px solid #999;
border: inset 1px solid #333;
-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
} 
</style>
</head>
<body>
<%
int busid=(Integer.parseInt(request.getParameter("busid")));
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root");
	PreparedStatement stat=con.prepareStatement("select * from busrec where busid='"+busid+"'");
	//stat=getInt(1,Integer.parseInt(request.getParameter("busid")));
	ResultSet rs=stat.executeQuery();
	while(rs.next())
	{
	%>
		<form method="post" action="bookbusServlet" align="center">
		<legend><h2>Book Bus</h2></legend>
		BusID:<pre><input type="text" name="m1" value="<%=rs.getInt("busid")%>"></pre>
		From:<pre><input type="text" name="m2" value="<%=rs.getString("frm")%>"></pre>
		To:<pre><input type="text" name="m3" value="<%=rs.getString("too")%>"></pre>
		Arival:<pre><input type="text" name="m4" value="<%=rs.getString("Arival")%>"></pre>
		Departure:<pre><input type="text" name="m5" value="<%=rs.getString("departure")%>"></pre>
		Date:<pre><input type="text" name="m6" value="<%=rs.getString("date")%>"></pre>
		Bus Type:<pre><input type="text" name="m7" value="<%=rs.getString("bus_t")%>"></pre>
		Price:<pre><input type="text" name="m8" value="<%=rs.getString("price")%>"></pre>
		userId:<pre><input type="text"name="m9" ></pre>
		payment:<pre><input list="payment" name="m10">
		<datalist id="payment">
		<option value="Net Banking">
		<option value="UPI"></option>
		</option>
		</datalist></pre>
		<input type="submit" value="Book" class="button"><br>
		</form>
		
	<%
	con.close();
	rs.close();
	}
}
catch(Exception e)
{
	out.println(e);
}
%>

</body>
</html>
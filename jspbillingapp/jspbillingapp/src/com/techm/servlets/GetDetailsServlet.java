package com.techm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {}

	public void setCookie(HttpServletResponse response,String userName){
		Cookie lastLogin=new Cookie(userName,new Date().toString());
		response.addCookie(lastLogin);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1000);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String lastLogin="";
		String userName=request.getParameter("userName");
		out.println("<body bgcolor=cyan>");
		out.println("<center><h1>My Billing Application</h1></center>");
		Cookie cookies[]=request.getCookies();
		if(cookies==null){
			lastLogin="<b>You Are Logging In For First Time</b>";
		}else{
			for(Cookie c : cookies){
				if(userName.equals(c.getName())){
					lastLogin="<b>Your Previous Login Time was : "+c.getValue()+"</b>";
					break;
				}else{
					lastLogin="<b>You Are Logging In For First Time</b>";	
				}
			}
		}
		out.println("<center><i>"+lastLogin+"</i></center>");
		out.println("<h3>Welcome <I>"+userName+"</I></h3>");
		out.println("<A href='LogoutServlet'>Logout</A>");
		out.println("<center>");
		out.println("<form method=post action='BillDetailsServlet'>");
		out.println("<table border=2>");
		out.println("<tr><td>Cell No. : </td><td><input type=text name='billedCellNo'></td></tr>");
		out.println("<tr><td>Minutes : </td><td><input type=text name='minutes'></td></tr>");
		out.println("<tr><td><input type=submit value='CALCULATE BILL'></td>");
		out.println("<td><input type=reset value='CLEAR'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		setCookie(response,userName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

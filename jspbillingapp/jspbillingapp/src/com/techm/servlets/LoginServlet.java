package com.techm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.daos.UserDAO;
import com.techm.daos.impl.UserDAOImpl;
import com.techm.models.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	public void init(ServletConfig config) throws ServletException {
		userDao=new UserDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1000);
		System.out.println("SESSION ID :: "+session.getId());
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		boolean isValid=userDao.validateUser(user);
		if(isValid){
			session.setAttribute("sessUser", user);
			RequestDispatcher rd=request.getRequestDispatcher("/getdetails.jsp");
			rd.forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>INVALID USERNAME OR PASSWORD!!!</h2>");
			out.println("<h3>Please Try Logiging in Again...</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.techm.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.daos.UserDAO;
import com.techm.daos.impl.UserDAOImpl;
import com.techm.models.User;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("++++++ init() Invoked ++++++");
		userDao=new UserDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("++++++ doGet() Invoked ++++++");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String cellNo=request.getParameter("cellNo");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		User user=new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCellNo(cellNo);
		user.setEmail(email);
		user.setAge(age);
		boolean isAdded=userDao.addUser(user);
		if(isAdded){
			RequestDispatcher rd=request.getRequestDispatcher("/registrationsuccess.jsp");
			rd.forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("<h2>ERROR DURING REGISTRATION !!!</h2>");
			out.println("<h3>Please Try Registering Again...</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("++++++ doPost() Invoked ++++++");
		doGet(request, response);
	}

}

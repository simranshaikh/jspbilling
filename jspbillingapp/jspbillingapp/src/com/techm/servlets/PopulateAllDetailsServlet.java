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
import javax.servlet.http.HttpSession;

import com.techm.daos.UserDAO;
import com.techm.daos.impl.UserDAOImpl;
import com.techm.models.User;

public class PopulateAllDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	public void init(ServletConfig config) throws ServletException {
		userDao=new UserDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1000);
		User sessUser=(User)session.getAttribute("sessUser");
		User user=userDao.getUser(sessUser.getUserName());
		String options[]=request.getParameterValues("options");
		String choices="";
		if(options!=null){
			for(String s : options){
				choices+=s+" , ";
			}
		}else{
			choices="No Options Selected";
		}
		session.setAttribute("choices", choices);
		session.setAttribute("user",user);
		RequestDispatcher rd=request.getRequestDispatcher("/displayalldetails.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

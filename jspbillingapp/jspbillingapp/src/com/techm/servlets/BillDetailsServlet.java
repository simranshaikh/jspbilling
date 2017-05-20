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

import com.techm.models.User;

public class BillDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1000);
		String billedCellNo=request.getParameter("billedCellNo");
		double minutes=Double.parseDouble(request.getParameter("minutes"));
		double billAmount=calculateBill(minutes);
		session.setAttribute("billedCellNo", billedCellNo);
		session.setAttribute("minutes", minutes);
		session.setAttribute("billAmount", billAmount);
		RequestDispatcher rd=request.getRequestDispatcher("/displaybilldetails.jsp");
		rd.forward(request, response);
	}
	public double calculateBill(double minutes){
		return minutes * 2.5;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.Siva.TodoList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Siva.TodoList.Validation;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Validation valid = new Validation();

	HashMap<String, String> logs = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext context = request.getServletContext();
		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");

		if (save == null) {
			save = new HashMap();
			context.setAttribute("Logs", save);
		}

		PrintWriter out = response.getWriter();

		String userName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String CPassword = request.getParameter("CPassword");

		if (userName.isEmpty())
			out.print("<font color='red'>*Please enter valid user name</font>");

		else if (logs.containsKey(userName)) {
			out.print("<font color='red'>*User name already exists</font>");
		}

		else if (Password.length() < 8)
			out.print("<font color='red'>*Password has not met the criteria</font>");

		else if (!Password.equals(CPassword))
			out.print("<font color='red'>*Password entered is not matching</font>");

		else {
			valid.setUserName(userName);
			valid.setPassword(Password);

			context.setAttribute("Logs", save);
			

			logs.put(userName, Password);
			out.print("<font color='green'>Account Created Successfully</font>");

			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		PrintWriter out = response.getWriter();
//
//		String uName = request.getParameter("UserName");
//		String password = request.getParameter("Password");
//
//		if (logs.containsKey(uName)) {
//			if (password.equals(logs.get(uName))) {
//
////				response.sendRedirect("index.html");
//				HttpSession session = request.getSession();
//				session.setAttribute("UserName", uName);
//				out.print("Login Successful");
//				RequestDispatcher rs = request.getRequestDispatcher("index.html");
//				rs.forward(request, response);
//
//			}
//
//			else {
//				RequestDispatcher rs = request.getRequestDispatcher("ToDoHome.html");
//				rs.forward(request, response);
//				out.print("<font color = 'red'>Invalid Password</font>");
//			}
//		}
//
//		else {
//			RequestDispatcher rs = request.getRequestDispatcher("ToDoHome.html");
//			rs.forward(request, response);
//			out.print("<font color = 'red'>Invalid Username</font>");
//		}
		
		ServletContext context = request.getServletContext();
		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");
		

		if (save == null) {
			save = new HashMap();
			context.setAttribute("Logs", save);
		}

		PrintWriter out = response.getWriter();

		String userName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String CPassword = request.getParameter("CPassword");

		if (userName.isEmpty())
			out.print("<font color='red'>*Please enter valid user name</font>");

		else if (logs.containsKey(userName)) {
			out.print("<font color='red'>*User name already exists</font>");
		}

		else if (Password.length() < 8)
			out.print("<font color='red'>*Password has not met the criteria</font>");

		else if (!Password.equals(CPassword))
			out.print("<font color='red'>*Password entered is not matching</font>");

		else {
			valid.setUserName(userName);
			valid.setPassword(Password);
			save.put(userName, Password);
			context.setAttribute("Logs", save);
			

			logs.put(userName, Password);
			out.print("<font color='green'>Account Created Successfully</font>");

			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.forward(request, response);
		}
	}

}

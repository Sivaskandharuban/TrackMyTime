 package com.Siva.TodoList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




  @WebServlet("/SignIn") 
  
  public class SignIn extends HttpServlet { 
	  private static final long serialVersionUID = 1L;


	

 public SignIn() { super();} // TODO Auto-generated constructor stub }
  
 



protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		ServletContext context = request.getServletContext();
		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");
		
		if (save == null) {
			save = new HashMap();
			context.setAttribute("Logs", save);
		}

		String uName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		try {

		if (save.containsKey(uName)) {
			if (password.equals(save.get(uName))) {

//				response.sendRedirect("index.html");
				HttpSession session = request.getSession();
				session.setAttribute("UserName", uName);
				out.print("Login Successful");
				RequestDispatcher rs = request.getRequestDispatcher("index.html");
				rs.forward(request, response);

			}

			else {
				out.print("<font color = 'red'>Invalid Password</font>");
				RequestDispatcher rs = request.getRequestDispatcher("ToDoHome.html");
				rs.forward(request, response);
				
			}
		}

		else {
			out.print("<font color = 'red'>Invalid Username</font>");
			RequestDispatcher rs = request.getRequestDispatcher("ToDoHome.html");
			rs.forward(request, response);
			out.print("<font color = 'red'>Invalid Username</font>");
		}
	}
		catch(Exception se) {
			out.print("Exception generated");
			se.printStackTrace();
		}
}
}
package com.TrackMyTime;

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

import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		ServletContext context = request.getServletContext();
		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");
		
		if (save == null) {
			save = new HashMap();
			context.setAttribute("Logs", save);
		}

		String mailId = request.getParameter("mailId");
		String password = request.getParameter("Password");
		
		try {
			
			Validation getMail = ObjectifyService.ofy().load().type(Validation.class).filter("mailId", mailId).first().now();
			System.out.println(getMail);
			
			if(getMail == null) 
				out.print("Mail id does not exist");

			else if (getMail.getMailId().equals(mailId)) {
			if (getMail.getPassword().equals(password)) {

//				response.sendRedirect("index.html");
				HttpSession session = request.getSession();
				session.setAttribute("mailId", mailId);
				out.print("Login Successful");
				response.sendRedirect("TMT.html");
				return;

			}
			
			

			else {
				out.print("<font color = 'red'>Invalid Password</font>");
								
			}
		}
		
		
		

		else {
			out.print("<font color = 'red'>Invalid Mail Id </font>");
			}
	}
		catch(Exception se) {
			out.print("Exception generated");
			
		}
	}
}



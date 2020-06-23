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
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			out.println("User already Login");
			response.sendRedirect("/Dashboard");
		}
		

		else {

//		ServletContext context = request.getServletContext();
//		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");
//		
//		if (save == null) {
//			save = new HashMap();
//			context.setAttribute("Logs", save);
//		}

		String mailId = request.getParameter("name");
		String password = request.getParameter("pass");
		

		System.out.println(mailId + " " + password);

		Validation user = ObjectifyService.ofy().load().type(Validation.class).filter("mailId", mailId).first()
				.now();

		System.out.println("Hi " + user);

		if (user == null) {
			response.setStatus(400);
			out.print("Mail id does not exist");
		}

		else if (user.getMailId().equals(mailId)) {
			if (user.getPassword().equals(password)) {

//				response.sendRedirect("index.html");
				session = request.getSession();
				session.setAttribute("mailId", mailId);
				session.setAttribute("lastEntry", user.getLastEntry());
				session.setAttribute("userId",user.getId());
				session.setAttribute("clockin",false);
				out.print("Login Successful");
				response.sendRedirect("/Dashboard");
				return;

			}

			else {
				response.setStatus(400);
				out.print("<font color = 'red'>Invalid Password</font>");

			}
		}

		else {
			response.setStatus(400);
			out.print("<font color = 'red'>Invalid Mail Id </font>");
		}
	}
	}

}

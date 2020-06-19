package com.TrackMyTime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;


/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	HashMap<String, String> logs = new HashMap<String, String>();
	private Pattern pattern;
    private Matcher matcher;
    
    Long Id = 1L;
    
    

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public SignUp()
    {
        pattern = Pattern.compile(EMAIL_REGEX);
    } 
    
    public boolean validate(final String email)
    {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		HashMap<String, String> save = (HashMap<String, String>) context.getAttribute("Logs");
		

		if (save == null) {
			save = new HashMap();
			context.setAttribute("Logs", save);
		}

		PrintWriter out = response.getWriter();

		String userName = request.getParameter("UserName");
		String mailId = request.getParameter("mailId");
		String Password = request.getParameter("Password");
		
		
		
		
		

//		if (userName.isEmpty())
//			out.print("<font color='red'>*Please enter valid user name</font>");
//		
//		else if (validate(mailId)==false) {
//			out.print("<font color='red'>*invalid mail format</font>");			
//		}
		
		Validation duplicate = ObjectifyService.ofy().load().type(Validation.class).filter("mailId", mailId).first().now();
		System.out.println(duplicate);

		 if (duplicate != null) {
			out.print("<font color='red'>*Mail ID already exists</font>");
		}

//		else if (Password.length() < 8)
//			out.print("<font color='red'>*Password has not met the criteria</font>");

		

		else {
			
			
			
			
			Validation valid = new Validation(userName, mailId, Password,Id++);
			
			ObjectifyService.ofy().save().entity(valid);
			
//			context.setAttribute("Logs", save);
			

//			logs.put(userName, Password);
			out.print("<font color='green'>Account Created Successfully</font>");

			RequestDispatcher rs = request.getRequestDispatcher("TMT.html");
			rs.forward(request, response);
		} 
	}

}

package com.TrackMyTime;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class TimeConversion
 */
@WebServlet("/TimeConversion")
public class TimeConversion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Long id;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mailId = request.getParameter("mail");
		System.out.println(mailId);
		Long startTime = Long.parseLong(request.getParameter("startTime"));
		System.out.println(startTime);
		Long endTime = Long.parseLong(request.getParameter("endTime"));
		System.out.println(endTime);
		
		if(endTime==0) {
		
		TimeData td = new TimeData(mailId,startTime,endTime,id++);
		
		ObjectifyService.ofy().save().entity(td);
		}
		else {
			TimeData td = new TimeData(mailId,startTime,endTime,id);
			
			ObjectifyService.ofy().save().entity(td);
		}
	}
	

}

package com.TrackMyTime;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class ClockOut
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ClockOut" })
public class ClockOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		PrintWriter out = response.getWriter();
		
		Long endTime= System.currentTimeMillis();
		HttpSession session = request.getSession(false);
		
	if(session==null){
		response.setStatus(400);
	out.println("session  not existed please login");
	response.sendRedirect("Login.html");
	}
	else{
		Long entryId= (Long)session.getAttribute("entryId");
		Boolean clockdIn=(Boolean)session.getAttribute("clockin");
		
		if(!clockdIn) {
			response.setStatus(400);
			out.println("already clockedout");
		}
		else{
//			fetch entry and store;
			
			String mailId = (String) session.getAttribute("mailId");
			
			Long userId = (Long) session.getAttribute("userId");
			
			UserData user = ObjectifyService.ofy().load().type(UserData.class).id(userId).now();
			TimeData td = ObjectifyService.ofy().load().type(TimeData.class).id(entryId).now();
			
			td.setEndTime(endTime);
			ObjectifyService.ofy().save().entity(td);
			
			user.setLastEntry(0);
			user.setClockin(false);
			session.setAttribute("entryId",null);
			session.setAttribute("clockin",false);
			ObjectifyService.ofy().save().entity(user);
			
			
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	        String utcEndTime =  sdf.format(new Date(endTime));
	        System.out.println(utcEndTime);
	        out.print(utcEndTime);
		}
	}

	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

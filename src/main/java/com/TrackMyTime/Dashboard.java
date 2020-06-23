package com.TrackMyTime;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;


@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;    
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			out.println("Please Login");
			response.sendRedirect("Login.html");
		}
		

		else {
			
			String mailId = session.getAttribute("mailId").toString();
			
			List<TimeData> list = ObjectifyService.ofy().load().type(TimeData.class).filter("mailId", mailId).limit(10).list();
			
			String result2 = "";
			
			if(list!=null) {
			for(TimeData entry : list) {
				result2 +="<tr><td>"+entry.getTaskDescription() + "</td><td>" + entry.getProject() + "</td><td>" + entry.getStartTime() +"</td><td>" + entry.getEndTime()+"</td><td>"+ (entry.getStartTime()-entry.getEndTime()) + "</td><td></tr>";
			}
			}
			
			String result = "<!DOCTYPE html>\r\n" + 
					"\r\n" + 
					"<html lang = 'en-US'>\r\n" + 
					"\r\n" + 
					"<head>\r\n" + 
					"    <link rel=\"stylesheet\" href=\"Style-TMT.css\">\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body class=\"BodyStyle\">\r\n" + 
					"<p id = \"message\" style = \"text-align : center\"></p>\r\n" + 
					"    <div>\r\n" + 
					"<aside class=\"sidenav\">\r\n" + 
					"    <div class=\"side-nav-content\">\r\n" + 
					"        <h2>Track My Time</h2>\r\n" + 
					"        <img src=\"dummy-profile-pic-300x300.jpg\" />\r\n" + 
					"        <p><b id = \"timer\">00:00:00</b></p>\r\n" + 
					"        <label class=\"switch\">\r\n" + 
					"            <input type=\"checkbox\" id = \"check\" onclick=\"set()\" >\r\n" + 
					"            <span class=\"slider round\"></span>\r\n" + 
					"          </label>\r\n" + 
					"          \r\n" + 
					"          <div id = \"Signout\">\r\n" + 
					"<form action=\"\\Signout\">\r\n" + 
					"<input type = \"submit\" value = \"Sign out\">\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"         \r\n" + 
					"        <!-- <div class=\"toggle-btn\"> -->\r\n" + 
					"            <!-- <div class=\"inner-circle\">\r\n" + 
					"              <span>Clockin</span>\r\n" + 
					"            </div> -->\r\n" + 
					"            \r\n" + 
					"        <!-- </div> -->\r\n" + 
					"    </div>\r\n" + 
					"</aside>\r\n" + 
					"\r\n" + 
					" \r\n" + 
					"\r\n" + 
					"<div>\r\n" + 
					"    <h1 class=\"Style\">Welcome to TMT</h1>\r\n" + 
					"    <select name=\"Timezone\" id=\"Timezone\" style= \"float: right; display: block\">\r\n" + 
					"    <option value=\"Time Zone\">Indian Time Zone</option>\r\n" + 
					"    <option value=\"Time Zone\">Detect Time Zone</option>\r\n" + 
					"    </select>\r\n" + 
					"    <label for=\"Timezone\" style =\"color: black; text-align: right; float: right; padding-right: 13px;\">\r\n" + 
					"        Choose Timezone\r\n" + 
					"    </label>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<div class=\"Log\">\r\n" + 
					"<section >\r\n" + 
					"    <table id = \"clockTable\">\r\n" + 
					"        \r\n" + 
					"        <tr> \r\n" + 
					"        <td>            \r\n" + 
					"            <select name=\"Date\" id=\"Date\">\r\n" + 
					"                <option value=\"Current_Week\">Select date</option>\r\n" + 
					"                <option value=\"Last_Week\">Last Week</option>\r\n" + 
					"                </select>  \r\n" + 
					"                </td>\r\n" + 
					"                \r\n" + 
					"                <td>\r\n" + 
					"                <button onclick = \"showEntry()\">\r\n" + 
					"                Show Entries\r\n" + 
					"                </button>\r\n" + 
					"                </td>          \r\n" + 
					"            </tr>\r\n" + 
					"            \r\n" + 
					"            <tr id = \"todayDate\">\r\n" + 
					"            <td>\r\n" + 
					"            Today's date\r\n" + 
					"            </td>\r\n" + 
					"            </tr>\r\n" + 
					"            \r\n" + 
					"\r\n" + 
					"            <tr>\r\n" + 
					"                <td>\r\n" + 
					"                Task description\r\n" + 
					"            </td>\r\n" + 
					"            <td>\r\n" + 
					"                Project Working\r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td>\r\n" + 
					"                Time from \r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td>\r\n" + 
					"                Time to \r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td>\r\n" + 
					"                Total working hours\r\n" + 
					"            </td>\r\n" + 
					"            </tr>\r\n" + 
					"            \r\n" + 
					"             <tr id = \"initial\">\r\n" + 
					"                <td>\r\n" + 
					"                Add task description\r\n" + 
					"            </td>\r\n" + 
					"            <td>\r\n" + 
					"                Project Working\r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td id = \"timeStarted\">\r\n" + 
					"                \r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td id = \"timeEnded\">\r\n" + 
					"                \r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"            <td id = \"totalTime\">\r\n" + 
					"                \r\n" + 
					"            </td>\r\n" + 
					"            </tr>\r\n" + result2 +
					"            \r\n" + 
					"            \r\n" + 
					"    \r\n" + 
					"    </table>\r\n" + 
					"</section>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"<script src=\"Timer.js\"></script>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>";
			response.setContentType("text/html");
			out.write(result);
	}

	

}
}

package com.TrackMyTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class TimeData {
	
	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}
	@Index
	String mailId;
	@Index
	Long startTime;
	Long endTime;
	@com.googlecode.objectify.annotation.Id
	Long id;
	String taskDescription;
	String project;
	
	public TimeData(String mailId, Long startTime, Long endTime) {
		// TODO Auto-generated constructor stub
		 this.mailId = mailId;
		 this.startTime = startTime;
		 this.endTime = endTime;
		 
		 
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TimeData() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}

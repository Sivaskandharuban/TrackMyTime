package com.TrackMyTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class TimeData {
	
	@Index
	String mailId;
	Long startTime;
	Long endTime;
	@com.googlecode.objectify.annotation.Id
	Long id;
	
	public TimeData(String mailId, Long startTime, Long endTime, Long id) {
		// TODO Auto-generated constructor stub
		 this.mailId = mailId;
		 this.startTime = startTime;
		 this.endTime = endTime;
		 
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

package com.TrackMyTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class UserData {
	
	public String userName = null;
	@Index
	public String mailId = null;
	public String password = null;
	@com.googlecode.objectify.annotation.Id
	Long Id;
	
	public long lastEntry;
	public boolean clockin;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public long getLastEntry() {
		return lastEntry;
	}

	public void setLastEntry(long lastEntry) {
		this.lastEntry = lastEntry;
	}

	public boolean isClockin() {
		return clockin;
	}

	public void setClockin(boolean clockin) {
		this.clockin = clockin;
	}
	
	
	public UserData(String userName, String mailId, String password,long Id) {
		this.userName=userName;
		System.out.println(userName);
		this.mailId=mailId;
		System.out.println(mailId);
		this.password=password;
		
	
		this.Id=Id;
	}
	
	public UserData() {
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.TrackMyTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Validation {
	
	public String userName = null;
	@Index
	public String mailId = null;
	public String password = null;
	@com.googlecode.objectify.annotation.Id
	Long Id;
	
	public Validation(String userName, String mailId, String password,long Id) {
		this.userName=userName;
		System.out.println(userName);
		this.mailId=mailId;
		System.out.println(mailId);
		this.password=password;
	
		this.Id=Id;
	}
	
	public Validation() {
		
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

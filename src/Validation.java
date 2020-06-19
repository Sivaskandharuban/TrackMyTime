package com.Siva.TodoList;

import java.io.Serializable;

public class Validation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String UserName = null;
	String Password = null;
	String CPassword = null;
	
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCPassword() {
		return CPassword;
	}
	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}
	
	
	
	

}

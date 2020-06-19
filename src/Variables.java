package com.Siva.TodoList;

import java.io.Serializable;

public class Variables implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Taskname = null;
	public String Description = null;
	public String EndTime = null;
	public String getTaskname() {
		return Taskname;
	}
	public void setTaskname(String taskname) {
		Taskname = taskname;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	
	public String toString() {
		return (Taskname + " " + Description +" " + EndTime);
		
	}

}

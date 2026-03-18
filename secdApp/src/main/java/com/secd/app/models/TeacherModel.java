package com.secd.app.models;

public class TeacherModel {
	long id;
	String name;
	String sectionAssigned;
	String email;
	String pass;
	boolean isBanned;
	

	
	public TeacherModel(long id, String name, String sectionAssigned, String email, String pass) {

		this.id = id;
		this.name = name;
		this.sectionAssigned = sectionAssigned;
		this.email = email;
		this.pass = pass;
		this.isBanned = false;
	}

	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSectionAssigned() {
		return sectionAssigned;
	}
	public void setSectionAssigned(String sectionAssigned) {
		this.sectionAssigned = sectionAssigned;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}

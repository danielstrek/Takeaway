package com.ai.takeaway.model;

public class User {
	private int user_id;
	private int user_role_id;
	private String user_name;
	private String user_lastname;
	private String user_email;
	private String user_pass;
	
	public User(){
		
	}
	public User(int user_id, int user_role_id, String user_name, String user_lastname, String user_email,
			String user_pass) {
		this.user_id = user_id;
		this.user_role_id = user_role_id;
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.user_email = user_email;
		this.user_pass = user_pass;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	
	

}

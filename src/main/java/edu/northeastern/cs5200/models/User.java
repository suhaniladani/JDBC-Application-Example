package edu.northeastern.cs5200.models;

import java.sql.Date;

public class User extends Person{
	
	public User(int id, String firstName, String lastName, String userName, String password, String email, Date dob) {
		super(id, firstName, lastName, userName, password, email, dob);
		// TODO Auto-generated constructor stub
	}
	private String userKey;
	private Boolean userAgreement;
	private int userId;
	
	
	
	public User(int id, String firstName, String lastName, String userName, String password, String email, Date dob,
			String userKey, Boolean userAgreement) {
		super(id, firstName, lastName, userName, password, email, dob);
		this.userKey = userKey;
		this.userAgreement = userAgreement;
		this.userId = id;
	}
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public Boolean getUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	
}

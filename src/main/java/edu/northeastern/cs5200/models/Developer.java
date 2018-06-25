package edu.northeastern.cs5200.models;

import java.sql.Date;

public class Developer extends Person {


	private String developerKey;



	public Developer(int id, String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		super(id, firstName, lastName, userName, password, email, dob);
		// TODO Auto-generated constructor stub
	}


	public Developer(int id, String firstName, String lastName, String userName, String password, String email,
			Date dob, String developerKey) {
		super(id, firstName, lastName, userName, password, email, dob);
		this.developerKey = developerKey;

	}



	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
	@Override
	public String toString() {
		return "developer [developer key=" + developerKey + ", developer Id=" + getId() + "]";
	}
	

}

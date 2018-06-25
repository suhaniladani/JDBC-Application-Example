package edu.northeastern.cs5200.models;

public class Role {
	int id;
	String value;
	public Role(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public Role() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

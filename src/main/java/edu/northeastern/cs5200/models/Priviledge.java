package edu.northeastern.cs5200.models;

public class Priviledge {
	private int id;
	private String value;
	
	public Priviledge(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	
	
	public Priviledge() {
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

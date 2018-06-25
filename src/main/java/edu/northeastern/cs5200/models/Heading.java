package edu.northeastern.cs5200.models;

public class Heading extends Widget{
	
	private int size;

	public Heading(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, Object type, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		// TODO Auto-generated constructor stub
	}
	
	

	public Heading(int size) {
		super();
		this.size = size;
	}





	public Heading(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Object type, Page page, int size) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		this.size = size;
	}



	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	@Override
	public String toString() {
		return "Heading [size=" + size + "]";
	}
	
	

}

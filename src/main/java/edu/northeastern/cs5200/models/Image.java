package edu.northeastern.cs5200.models;

public class Image extends Widget{
	
	private String src;

	public Image(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, Object type, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		// TODO Auto-generated constructor stub
	}
	
	

	public Image(String src) {
		super();
		this.src = src;
	}



	public Image(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Object type, Page page, String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		this.src = src;
	}



	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}



	@Override
	public String toString() {
		return "Image [src=" + src + "]";
	}
	
	
	

}

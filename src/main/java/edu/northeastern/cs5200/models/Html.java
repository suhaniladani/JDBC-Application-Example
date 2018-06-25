package edu.northeastern.cs5200.models;

public class Html extends Widget{
	
	private String html;

	public Html(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, Object type, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public Html(String html) {
		super();
		this.html = html;
	}





	public Html(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Object type, Page page, String html) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		this.html = html;
	}



	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}





	@Override
	public String toString() {
		return "Html [html=" + html + "]";
	}
	
	

}

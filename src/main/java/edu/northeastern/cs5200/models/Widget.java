package edu.northeastern.cs5200.models;

public class Widget {
	
	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private Page page;
	private Object type;
	
		
	
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Object type, Page page) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.type = type;
		this.page=page;
	}


	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String src, String url, Boolean shareable, Boolean expandable, int size, String html, int pageId) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		
		
	}
	
	


	public Widget() {
		super();
	}


	public Object getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Widget [id=" + id + ", name=" + name + ", width=" + width + ", height=" + height + ", cssClass="
				+ cssClass + ", cssStyle=" + cssStyle + ", text=" + text + ", order=" + order +  "]";
	}





}

package edu.northeastern.cs5200.models;

public class Youtube extends Widget{
	
	private String url;
	private Boolean shareable;
	private Boolean expandable;

	public Youtube(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order, Object type, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		// TODO Auto-generated constructor stub
	}
	
	

	public Youtube(String url, Boolean shareable, Boolean expandable) {
		super();
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}



	public Youtube(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Object type, Page page, String url, Boolean shareable, Boolean expandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order, type, page);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean isShareable() {
		return shareable;
	}

	public void setShareable(Boolean shareable) {
		this.shareable = shareable;
	}

	public Boolean isExpandable() {
		return expandable;
	}

	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}



	@Override
	public String toString() {
		return "Youtube [url=" + url + ", shareable=" + shareable + ", expandable=" + expandable + "]";
	}
	
	

}

package edu.northeastern.cs5200;

import edu.northeastern.cs5200.models.Widget;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.Dao.PageDao;
import edu.northeastern.cs5200.Dao.RoleDao;
import edu.northeastern.cs5200.Dao.WidgetDao;
import edu.northeastern.cs5200.models.Page;

public class ImplementUpdates {
	
	PageDao pageDao = PageDao.getInstance();
	WidgetDao widgetDao = WidgetDao.getInstance();
	RoleDao roleDao = RoleDao.getInstance();
	
	public Widget update1(Widget widget) {
		
		
		return null;
	}
	
	public List<Page> AppendCNET(){
		
		List<Page> pages = pageDao.findAllPages();
		List<Page> newPages = new ArrayList<Page>();
		for (Page page : pages) {
			if( page.getTitle().equals("CNET")) {
				
				Page pageAppended = new Page(page.getId(), "CNET"+page.getTitle(), page.getDescription(), page.getCreated(), page.getUpdated(), page.getViews());
				newPages.add(pageAppended);
			}
		   
		}
		return newPages;
	}
	
	public List<Widget> updateOrder(Widget widget) {
		
		List<Widget> widgets = widgetDao.findAllWidget();
		List<Widget> newList = new ArrayList<Widget>();
		//id, name, width, height, cssClass, cssStyle, text, order, src, url, shareable, expandable, size, html, type);
		Widget widgetNew = new Widget(widget.getId(), widget.getName(), widget.getWidth(), widget.getHeight(), widget.getCssClass(), widget.getCssStyle(), widget.getText(), 3, widget.getType(), widget.getPage());
		newList.add(widgetNew);
		for(Widget widget1 : widgets) {
			if(widget1.getPage().equals(widget.getPage())){
				Widget widgetNewRelative = new Widget(widget1.getId(), widget1.getName(), widget1.getWidth(), widget1.getHeight(), widget1.getCssClass(), widget1.getCssStyle(), widget1.getText(), widget1.getOrder()-1, widget1.getType(), widget1.getPage());
				newList.add(widgetNewRelative);
			}
		}
		return newList;
	}
	
	public void swapRoles() {
		
		roleDao.deletePageRole(23, 123, 4);
		roleDao.deletePageRole(34, 123, 5);
		roleDao.assignPageRole(23, 123, 5);
		roleDao.deletePageRole(34, 123, 4);
		
	}

}

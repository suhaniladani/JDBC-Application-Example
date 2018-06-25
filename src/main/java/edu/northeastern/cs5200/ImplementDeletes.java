package edu.northeastern.cs5200;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.cs5200.Dao.PageDao;
import edu.northeastern.cs5200.Dao.WebsiteDao;
import edu.northeastern.cs5200.Dao.WidgetDao;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;


public class ImplementDeletes {

	PageDao pageDao = PageDao.getInstance();
	WidgetDao widgetDao = WidgetDao.getInstance();
	WebsiteDao websiteDao = WebsiteDao.getInstance();

	public void removeLastWidgetForPage(Page page) {

		 Map<Integer,Integer> widgetOrder=new HashMap<Integer,Integer>();  
		int pageId = page.getId();
		List<Widget> w1 = widgetDao.findWidgetForPage(pageId);
		for (Widget widget : w1) {
			System.out.println(widget.getOrder());
			widgetOrder.put(widget.getId(), widget.getOrder());
		}
		
		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : widgetOrder.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		        System.out.println(maxEntry.getValue());
		    }
		}
		
		widgetDao.deleteWidget(maxEntry.getKey());
		

	}
	
	public void removeLastUpdatedPageForWebsite(Website website) {
		int websiteId = website.getId();
		List<Date> dates = new ArrayList<>();
		List<Page> p1 = pageDao.findPagesForWebsite(websiteId);
		for(Page page : p1) {
			dates.add(page.getUpdated());
		}
		Date date1 = Collections.max(dates);
		System.out.println(date1);
		for(Page page : p1) {
			if(page.getUpdated().equals(date1)) {
			pageDao.deletePage(page.getId());
			}
		}
		
	}
	
	public void removeWebsite(Website website) {
		
		websiteDao.deleteWebsite(website.getId());
		
	}
}

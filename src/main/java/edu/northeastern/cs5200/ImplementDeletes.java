package edu.northeastern.cs5200;


import edu.northeastern.cs5200.Dao.PageDao;
import edu.northeastern.cs5200.Dao.WebsiteDao;
import edu.northeastern.cs5200.Dao.WidgetDao;


public class ImplementDeletes {

	PageDao pageDao = PageDao.getInstance();
	WidgetDao widgetDao = WidgetDao.getInstance();
	WebsiteDao websiteDao = WebsiteDao.getInstance();

	public void removeLastWidgetForPage() {

		widgetDao.deleteWidget(567);

	}
	
	public void removeLastPage() {
		pageDao.deletePage(345);
	}
	
	public void removeWebsite() {
		
		websiteDao.deleteWebsite(567);
		
	}
}

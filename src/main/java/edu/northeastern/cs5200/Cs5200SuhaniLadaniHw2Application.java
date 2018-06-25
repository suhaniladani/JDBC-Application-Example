package edu.northeastern.cs5200;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.Dao.DeveloperDao;
import edu.northeastern.cs5200.Dao.PageDao;
import edu.northeastern.cs5200.Dao.RoleDao;
import edu.northeastern.cs5200.Dao.WebsiteDao;
import edu.northeastern.cs5200.Dao.WidgetDao;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Heading;
import edu.northeastern.cs5200.models.Html;
import edu.northeastern.cs5200.models.Image;
import edu.northeastern.cs5200.models.Page;

import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.Youtube;

@SpringBootApplication
public class Cs5200SuhaniLadaniHw2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Cs5200SuhaniLadaniHw2Application.class, args);
		DeveloperDao developerDao = DeveloperDao.getInstance();
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();
		PageDao pageDao = PageDao.getInstance();
		WidgetDao widgetDao = WidgetDao.getInstance();

		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		 String created = "2018-05-08";
		 String updated = "2018-06-24";
		 Date date2=Date.valueOf(created);
		 Date date3 = Date.valueOf(updated);
		 
		
		
		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null, "4321rewq");
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", null, "5432trew");
		Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", null, "6543ytre");
		Developer dan = new Developer(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null, "7654fda");
		Developer ed = new Developer(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null, "5678dfgh");
	
	//	Developer bob2 = new Developer(23, "Bob2", "Marley2", "bob2", "bob2", "bob2@marley2.com", null, "5432trew2");
		
//		developerDao.createDeveloper(alice);
//		developerDao.createDeveloper(bob);
//		developerDao.createDeveloper(charlie);
//		developerDao.createDeveloper(dan);
//		developerDao.createDeveloper(ed);
		
		
		
		Website facebook = new Website(123, "Facebook", "an online social media and social networking service", date, date, 1234234);
		Website twitter = new Website(234, "Twitter", "an online news and social networking service", date, date, 4321543);
		Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", date, date, 3456654);
		Website CNN = new Website(456, "CNN", "an American basic cable and satellite television news channel", date, date, 6543345);
		Website CNET = new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", date, date, 5433455);
		Website gizmodo = new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", date, date, 4322345);
		
//		websiteDao.createWebsiteForDeveloper(12, facebook);
//		websiteDao.createWebsiteForDeveloper(23, twitter);
//		websiteDao.createWebsiteForDeveloper(34, wikipedia);
//		websiteDao.createWebsiteForDeveloper(12, CNN);
//		websiteDao.createWebsiteForDeveloper(23, CNET);
//		websiteDao.createWebsiteForDeveloper(34, gizmodo);
		
//		Website suh = new Website(98, "suh2", "suhsuh22", null, null, 3456789);
		
		Page home = new Page(123, "home", "landing page", date2, date3, 123434);
		Page about = new Page(234, "About", "Website Description", date2, date3, 234545);
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", date2, date3, 345656);
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", date2, date3, 456776);
		Page profile = new Page(567, "Profile", "Users can configure their personal information", date2, date3, 567878);
//		
//		pageDao.createPageForWebsite(456, home);
//		pageDao.createPageForWebsite(567, about);
//		pageDao.createPageForWebsite(345, contact);
//		pageDao.createPageForWebsite(456, preferences);
//		pageDao.createPageForWebsite(567, profile);
//		
//		//id, name, width, height, cssClass, cssStyle, text, order, src, url, shareable, expandable, size, html, type);
		Heading head123 = new Heading(0);
//		Heading head1232 = new Heading(0);
		Html post234 = new Html(null);
		Heading head345 = new Heading(0);
		Html intro456 = new Html(null);
		Image image345 = new Image("/img/567.png");
		Youtube video456 = new Youtube("https://youtu.be/h67VX51QXiQ", false, false);
		
		
		Widget head1 = new Widget(123, "head123", 0, 0, null, null, "Welcome", 0, head123, home);	
//		Widget headxy = new Widget(123, "head1232", 0, 0, null, null, "Welcome2", 0, head1232, home);		
		Widget html1 = new Widget(234, "post234", 0, 0, null, null, "<p>Lorem</p>", 0, post234, about);
		Widget head2 = new Widget(345, "head345", 0, 0, null, null, "Hi", 1, head345, contact);
		Widget html2 = new Widget(456, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2, intro456, contact);
		Widget image1 = new Widget(567, "image345", 0, 0, null, null, null, 3, image345, contact);
		Widget video1 = new Widget(678, "video456", 0, 0, null, null, null, 0, video456, preferences);

//		widgetDao.createWidgetForPage(123, head1);
//		widgetDao.createWidgetForPage(234, html1);
//		widgetDao.createWidgetForPage(345, head2);
//		widgetDao.createWidgetForPage(345, html2);
//		widgetDao.createWidgetForPage(345, image1);
//		widgetDao.createWidgetForPage(456, video1);
		
		
//		
//		
//	//	roleDao.assignWebsiteRole(12, 123, 1);
//	//	pageDao.createPageForWebsite(123, home);
//	
//	//	roleDao.assignPageRole(12, 123, 2);
//		
////		Developer d1 = developerDao.findDeveloperById(12);
////		Developer d2 = developerDao.findDeveloperByUsername("bob");
////		Developer d3 = developerDao.findDeveloperByCredentials("bob", "bob");
		Website w1 = websiteDao.findWebsiteById(123);
		Widget wg1 = widgetDao.findWidgetById(123);
////		developerDao.deleteDeveloper(98);
////		
////		List<Developer> developers = developerDao.findAllDevelopers();
////		List<Website> websites1 = websiteDao.findWebsitesForDeveloper(12);
////		List<Website> websites = websiteDao.findAllWebsites();
////		List<Widget> widgets = widgetDao.findAllWidget();
////		System.out.println(developers);
////		System.out.println(websites);
////		System.out.println("d1="+d1);
////		System.out.println("d2="+d2);
////		System.out.println("d3="+d3);
		System.out.println("w1="+w1);
		System.out.println("wg1="+wg1);
////	//	developerDao.updateDeveloper(23, bob2);
////	//	websiteDao.updateWebsite(98, suh);
//		widgetDao.updateWidget(123, headxy);
////	//	widgetDao.deleteWidget(234);
////		System.out.println(developers);
////		System.out.println(websites1);
////		System.out.println(widgets);
//	
		
		
		
	}
}

package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Utils;

public class Ndtv {
	
	public WebDriver ldriver;
	public Utils utils;
	
	public Ndtv(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		utils = new Utils(rdriver);
		
	}
	@FindBy(xpath="//a[@class='NwsLstPg_ttl-lnk']")
public 	List<WebElement> news;
	
	@FindBy(xpath="//span[@title='News/perhour']")
	public WebElement whts_grp;
	
	@FindBy(xpath="//div[@aria-label='Type a message']")
	public WebElement snd_msg;
	
	
	public List<String> getNews() {
	    utils.waitForElementsVisible(news);
	    List<String> news_info = new ArrayList<>();

	    for (int i = 0; i < news.size(); i++) {
	        String n_title = news.get(i).getText();
	        String n_link = news.get(i).getAttribute("href");

	        String formattedNews = (i+1)+"." + n_title + "\n "  + n_link + "\n";
	        news_info.add(formattedNews);

	        //System.out.println("\n" + formattedNews);
	    }

	    return news_info;
	}
	
	public String convertToString()
	{
		List<String> news_title =getNews();
		
		StringBuilder sb = new StringBuilder();
		for(String n_titles : news_title)
		{
			sb.append(n_titles).append("\n");
		}
		return sb.toString();
		
	}
	
	public void sendMessage(String text) throws InterruptedException
	{
		utils.waitForVisibility(whts_grp);
		utils.click(whts_grp);
		
		String newsMessage = 
			    "Dear Reader,\n\n" +
			    "Stay informed with the latest headlines making waves across the nation and the world. Here's a curated snapshot of today's top stories:\n\n" +
			      "\n\n" +  // ← This should be your formatted list of news titles + links
			     	text +
			  

			    "We believe that staying updated is the first step toward staying empowered.\n\n" +
			    "Warm regards,\n" +
			    "Prasoon Saurav\n\n" +
			    " Disclaimer: News content sourced from NDTV. All rights reserved to the original publisher. This project is intended solely for educational and non-commercial use.";

		
		
		
		utils.sendKeysWithMouse(snd_msg, newsMessage);
		
		
	}

}

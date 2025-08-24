package PageObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Utils;   // ✅ correct package name



public class Bookmyshow {
	public WebDriver ldriver;
	public Utils utils;
	
public Bookmyshow(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	utils = new Utils(rdriver);
	
}
@FindBy(xpath="//a[contains(@href,'/movies') and not(ancestor::div[contains(@class,'premier')])]//img[@alt]")

public List<WebElement> movie;

@FindBy(xpath="//div[@class='sc-7o7nez-0 ddXXCI']")
public List<WebElement> genre;

//@FindBy(xpath="//div[contains(@class,'sc-133848s-11')]//span[contains(text(),'/10')]")
//public List<WebElement> ratings;


@FindBy(xpath ="//span[@title='Prasoon Saurav']")
WebElement myself;

@FindBy(xpath = "//div[@contenteditable='true' and @role='textbox']")


WebElement text_box;

@FindBy(xpath="//input[@type='email']")
WebElement g_email;

@FindBy(xpath="//input[@type='password']")
WebElement g_pwd;

@FindBy(xpath="//span[contains(text(),'Next')]" )
WebElement clck_next;

@FindBy(xpath = "//span[text()='Continue']")
WebElement contin;

@FindBy(xpath= "//div[contains(text(),'Compose')]")
WebElement compose;

@FindBy(xpath="//input[@aria-label='To recipients']")
WebElement to_recpt;

@FindBy(xpath= "//input[@aria-label='Subject']")
WebElement subject;

@FindBy(xpath ="//div[@aria-label='Message Body']")
WebElement msg_body;

@FindBy(xpath= "//div[contains(@aria-label,'Send ‪(Ctrl-Enter)‬')]")
WebElement send_key;



//Method to get movie titles:
public List<String> getMovieTitles()
{
	utils.waitForElementsVisible(movie);
	utils.waitForElementsVisible(genre);
	//utils.waitForElementsVisible(ratings);
	
	
	List<String> movie_info = new ArrayList<>();
	for(int i= 0; i<movie.size();i++)
	{
		String title = movie.get(i).getAttribute("alt");
		//String rate = (i < ratings.size()) ? ratings.get(i).getText() : "Rating not available";
		String gnr = (i < genre.size()) ? genre.get(i).getText() : "Genre not available";
		
		String movieInfo = title + "\n Genre: " + gnr + "\n";
        movie_info.add(movieInfo);
		
	}
	return movie_info;
	
}
//Method to convert titles to single string

public String convertToString()
{
	List<String> movie_title = getMovieTitles();
	
	StringBuilder sb = new StringBuilder();
	for(String titles : movie_title)
	{
		sb.append(titles).append("\n");
	}
	return sb.toString();
	
}


//Method to send email;

public void sendEmail(String body_text, String rcpt_email) throws InterruptedException
{
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm a");
	String formattedTime = now.format(formatter);
	
	utils.sendKeys(g_email,"seleniumtestps@gmail.com");
	utils.click(clck_next);
	utils.sendKeys(g_pwd, "Selenium@123");
	utils.click(clck_next);
	utils.click(compose);
	utils.sendKeys(to_recpt, rcpt_email);
	utils.sendKeys(subject, " TOP 5 Trending movie on Bookmyshow in Bengaluru at  time   "+    formattedTime);
	
	//System.out.println(body_text);
	utils.click(msg_body);
	String message = "Dear Bangaloreans,\n\n" +
		    "From gripping thrillers to heartwarming rom-coms, the silver screens of Namma Bengaluru are buzzing with cinematic energy.\n\n" +
		    " TOP 5 Trending Movies in Bengaluru Cinema Halls:\n\n" +
		    body_text + "\n\n" +
		    "Enjoy your movie time and make it memorable!\n\n" +
		    "Warm regards,\n" +
		    "Prasoon Saurav\n\n" +
		    "Disclaimer: Data sourced from BookMyShow. All rights reserved to the original platform. This project is intended solely for educational and non-commercial use.";
			
			
			
			
	utils.sendKeys(msg_body,message );
	//Thread.sleep(7000);
	utils.waitForVisibility(send_key);
	utils.click(send_key);	
}




}

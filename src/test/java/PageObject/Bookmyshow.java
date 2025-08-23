package PageObject;

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
	List<String> titles = new ArrayList<>();
	for(WebElement m : movie)
	{
		titles.add(m.getAttribute("alt"));
		//System.out.println(titles);
	}
	return titles;
	
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

public void sendEmail(String body_text)
{
	utils.sendKeys(g_email,"seleniumtestps@gmail.com");
	utils.click(clck_next);
	utils.sendKeys(g_pwd, "Selenium@123");
	utils.click(clck_next);
	utils.click(compose);
	utils.sendKeys(to_recpt, "psaurav1396@gmail.com");
	utils.sendKeys(subject, "Trending movie on Bookmyshow in Bengaluru");
	
	System.out.println(body_text);
	utils.click(msg_body);
	utils.sendKeys(msg_body,body_text);
	utils.click(send_key);	
}




}

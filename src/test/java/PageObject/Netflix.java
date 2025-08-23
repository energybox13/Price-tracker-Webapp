package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;

public class Netflix {
	
	public WebDriver ldriver;
	public  Netflix(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css="div[data-uia='nmhp-top-10'] ul li button")
	private List<WebElement> trendingItems;
	
	@FindBy(xpath = "//span[@title='Jio']")
	WebElement self;
	@FindBy(xpath="//span[@class='x7gh8cn']")
	WebElement cross;
	
	@FindBy(xpath = "//div[@aria-label='Type a message' and @contenteditable='true']")
	WebElement text_box;
	
	public int getTrendingCount()
	{
		return trendingItems.size();
	}
	public String getTrendingTitle()
	{
		StringBuilder details = new StringBuilder();
		
	int	rank = 1;
		for(WebElement item : trendingItems)
		{
			String title =item.getText();
			details.append(rank).append(".").append(title).append("\n");
			
			//System.out.println(title);
			rank++;
		}
		return details.toString();
	}
	
	public void sendMessage() throws InterruptedException {
	    Thread.sleep(5000);
	    System.out.println("reached here -1");

	    Thread.sleep(10000);
	    self.click();

	    // get trending titles
	    String trending = getTrendingTitle();
	    System.out.println("Trending:\n" + trending);

	    Thread.sleep(10000);

	    // Use Actions to type
	    Actions actions = new Actions(ldriver);

	    // First click inside text box
	    actions.moveToElement(text_box).click().perform();
	    Thread.sleep(1000);

	    // Type message using Actions
	    actions.sendKeys("Hello").perform();
	    Thread.sleep(2000);

	    // Press Enter to send
	    actions.sendKeys(Keys.ENTER).perform();
	}

	
	

}

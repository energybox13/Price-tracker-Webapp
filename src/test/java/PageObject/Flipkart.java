package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {
	WebDriver ldriver;
public Flipkart( WebDriver rdriver)
{
ldriver = rdriver;	
PageFactory.initElements(rdriver, this);
}	




@FindBy(xpath= "//input[@placeholder='Search for Products, Brands and More']")
WebElement srch_box;

@FindBy(xpath="//div[@class='zg-M3Z _0H7xSG']")
	WebElement relevance;
@FindBy(xpath = "//div[normalize-space()='OnePlus 13 (Black Eclipse, 256 GB)'] ")
	WebElement oneplus13;

@FindBy(xpath= "//div[@class='Nx9bqj CxhGGd']")
WebElement price;

public void enter_product_details(String product)
{
	srch_box.sendKeys(product);
	srch_box.sendKeys(Keys.ENTER);
	
	 // Explicit wait for search results to load
    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zg-M3Z _0H7xSG']")));
	
	
}
public void clck_on_relevance()
{
	relevance.click();
	
}
public void clck_on_product()
{
	oneplus13.click();
}
public String price_value()
{
	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(price));
    return price.getText();
	
}
}

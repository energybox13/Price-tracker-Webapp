package stepdefinition;

import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.Flipkart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Stepdefinition extends BaseClass {
	String log_price;
	@Given("User launch firefox browser")
	public void user_launch_firefox_browser() {
	    
	}

	@Then("User open url {string}")
	public void user_open_url(String url) {
	   driver.get(url);
	   flipkart = new Flipkart (driver);
	}

	@Then("User search for product {string}")
	public void user_search_for_product(String prods) throws InterruptedException {
	    flipkart.enter_product_details(prods);
	    Thread.sleep(10);
	}

	@Then("User click on one plus13 product")
	public void user_click_on_one_plus13_product() throws InterruptedException {
	 flipkart.clck_on_relevance();
	 flipkart.clck_on_product();
	 
	// Wait until a new tab is opened
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	 wait.until(driver -> driver.getWindowHandles().size() > 1);
//	 wait.until(driver -> driver.getTitle().contains("OnePlus"));
	 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);
	 String originalWindow = driver.getWindowHandle();
     //Current window

     for (String handle : driver.getWindowHandles()) {
         if (!handle.equals(originalWindow)) {
             driver.switchTo().window(handle);
             break;
         }
     }
     
     wait.until(driver -> driver.getTitle().contains("OnePlus") || driver.getCurrentUrl().contains("oneplus"));
  // Optional: Add a wait for the product page to load
//     new WebDriverWait(driver, Duration.ofSeconds(10))
//         .until(driver -> driver.getTitle().contains("OnePlus") || driver.getCurrentUrl().contains("oneplus")); 
	 Thread.sleep(5);
	 
	}

	@Then("User get the price of the product")
	public void user_get_the_price_of_the_product() {
	   String priceValue = flipkart.price_value();
	  
	// Get current date and time
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDateTime = now.format(formatter);

	    // Print with timestamp
	    System.out.println("Code reaches here");
	    System.out.println("The price of the OnePlus is " + priceValue + " as of " + formattedDateTime);
	     log_price = "The price of the OnePlus13 is " + priceValue + " as of " + formattedDateTime;
	}
	   
	   

	@Then("User save the price in excel sheet with the time")
	public void user_save_the_price_in_excel_sheet_with_the_time() {
		try { 
		// Append to text file
        FileWriter fw = new FileWriter("ProductPriceLog.txt", true); // 'true' enables append mode
        fw.write(log_price + "\n"); // Add a newline after each entry
        fw.close();

	}
	catch (Exception e) {
    	
        System.out.println("Error while getting the price or writing to file: " + e.getMessage());
    }
	}
		

	@Then("User close the browser")
	public void user_close_the_browser() {
	    System.out.println("Browser is closed");
	}


	
	
	
	

}

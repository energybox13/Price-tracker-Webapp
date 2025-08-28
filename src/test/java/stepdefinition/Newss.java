package stepdefinition;

import PageObject.Ndtv;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Newss extends BaseClass {
	public static String news_ndtv;
	
	@Given("User launch the url {string}")
	public void user_launch_the_url(String string) {
	    driver.get(string);
	    ndtv= new Ndtv(driver);
	    
	}

	@Then("User get the top news of India")
	public void user_get_the_top_news_of_india() {
	    ndtv.getNews();
	     news_ndtv = ndtv.convertToString();
	}

	@Then("User share the news to the group")
	public void user_share_the_news_to_the_group() throws InterruptedException {
	    driver.get("https://web.whatsapp.com/");
	    Thread.sleep(8000);
	    ndtv.sendMessage(news_ndtv);
	    
	    
	}

	
	

}

package stepdefinition;

import PageObject.Netflix;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NetflixTrend extends BaseClass {
	@Given(": User open the {string}")
	public void user_open_the(String string) {
	   driver.get(string);
	   netflix = new Netflix(driver);
	}

	@Then(": User move to trending now")
	public void user_move_to_trending_now() {
	    System.out.println("User has moved to treding section");
	}

	@Then(": User scroll and find the details of trending items")
	public void user_scroll_and_find_the_details_of_trending_items() {
	    netflix.getTrendingTitle();
	}

	@Then(": User send the details on whatsapp to certain users")
	public void user_send_the_details_on_whatsapp_to_certain_users() throws InterruptedException {
	    driver.navigate().to("https://web.whatsapp.com/");
	    Thread.sleep(10000);
	    netflix.sendMessage();
	    
	    
	}

	@Then(": User close the browser.")
	public void user_close_the_browser() {
	    System.out.println("Browser is closed");	
	}
	

}

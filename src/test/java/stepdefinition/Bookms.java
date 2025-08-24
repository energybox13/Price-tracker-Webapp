package stepdefinition;

import java.util.List;

import PageObject.Bookmyshow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Bookms extends BaseClass {
	public static String movie;
	@Given("User launch browser")
	public void user_launch_browser() {
	    System.out.println("Browser is launched");
	}

	@Then("User goes to url {string}")
	public void user_goes_to_url(String string) {
	    driver.get(string);
	    System.out.println(string);
	    bms = new Bookmyshow(driver);
	}

	@Then("User select location of his\\/her choice")
	public void user_select_location_of_his_her_choice() {
	    
	}

	@Then("User will see the details of trending movies")
	public void user_will_see_the_details_of_trending_movies() {
	    List<String > titles = bms.getMovieTitles();
	     movie = bms.convertToString();
	    System.out.println("\n");
	    System.out.println("Current Trending movies on BookmyShow:"+"\n"+ movie);
	}

	@Then("User get the details of it share it to certain whatspp contacts {string}")
	public void user_get_the_details_of_it_share_it_to_certain_whatspp_contacts(String rcpt_email) throws InterruptedException {
	    driver.get("https://mail.google.com/mail/");
	    bms.sendEmail(movie, rcpt_email); // movieList should be a class-level variable
	}

		
		
	    
	}	
	
	

package stepdefinition;

import PageObject.Trendingsong;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Topsongs extends BaseClass{

public static String t_songs;

@Given("User open url {string}")
	public void user_open_url(String url)
	{
	driver.get(url);
		ts = new Trendingsong (driver);
	}



@Then("User get the top songs")
public void user_get_the_top_songs() {
	ts.getSongs();
	t_songs = ts.convertToString();
	
	
    
}

@Then("User send it to whatsapp group")
public void user_send_it_to_whatsapp_group() throws InterruptedException {
	driver.get("https://web.whatsapp.com/");
    Thread.sleep(5000);
    ts.sendToGroup(t_songs);

	
}
}

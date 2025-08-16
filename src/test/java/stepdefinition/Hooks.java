package stepdefinition;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Hooks extends BaseClass {

    @Before
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

   @After
  public void tearDown() throws InterruptedException {
	   Thread.sleep(200);
      driver.quit();
   }
}
	

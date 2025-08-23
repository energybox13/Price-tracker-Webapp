package stepdefinition;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Hooks extends BaseClass {

    @Before
    public void setUp() {
    	//WebDriverManager.firefoxdriver().setup();

        // Point to your daily Firefox profile
        //String profilePath = "C:\\Users\\praso\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\2o94vtnw.default-release";

        //FirefoxProfile profile = new FirefoxProfile(new File(profilePath));

        //FirefoxOptions options = new FirefoxOptions();
        //options.setProfile(profile);

        //driver = new FirefoxDriver(options);
    	//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    	//driver = new ChromeDriver();

    	
        //driver.manage().window().maximize();
    	// Use automation profile (make sure it's not open in normal Chrome)
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
        //String user_profile = "C:\\Users\\praso\\AppData\\Local\\Google\\Chrome\\User Data";
        //options.addArguments("user-data-dir=C:\\\\Users\\\\praso\\\\AppData\\\\Local\\\\Google\\\\Chrome\\\\User Data");
    	//options.addArguments("user-data-dir=C:\\Users\\praso\\AutomationProfile");
        //options.addArguments("profile-directory=");

        //options.addArguments("--disable-extensions");
        //options.addArguments("--disable-gpu");
        //options.addArguments("--disable-software-rasterizer");
        //options.addArguments("--disable-background-networking");
        //options.addArguments("--remote-debugging-port=9222");
    	//Disable notification
    	// Disable "Chrome is being controlled by automated test software"
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

    	// Disable password saving popup
    	options.setExperimentalOption("prefs", Map.of(
    	    "credentials_enable_service", false,
    	    "profile.password_manager_enabled", false
    	));

    	// Optional: start without profile prompt
    	options.addArguments("--no-first-run");
    	options.addArguments("--no-default-browser-check");
    	
    	options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
  
    }

   @After
  public void tearDown() throws InterruptedException {
	   Thread.sleep(8000);
      driver.quit();
   }
}
	

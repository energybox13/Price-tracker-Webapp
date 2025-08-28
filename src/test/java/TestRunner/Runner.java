package TestRunner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {".//Features/News.feature",
    		".//Features/TopSongs.feature"
    },
    glue = "stepdefinition",
    plugin = {
        "pretty",
        "junit:target/cucumber-reports/reports_xml.xml",
        "json:target/cucumber-reports/reports_json.json",
        "html:target/cucumber-reports/reports1.html"
    },
    monochrome = true,
    dryRun = false
)
public class Runner {
}




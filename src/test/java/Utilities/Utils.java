package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // ✅ Constructor
    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.actions = new Actions(driver);
    }

    // ✅ Wait until element is visible
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ✅ Wait until element is visible by locator
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ✅ Wait for multiple elements
    public void waitForElementsVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // ✅ Get text from element
    public String getText(WebElement element) {
        return waitForVisibility(element).getText().trim();
    }

    // ✅ Send text (clear + type)
    public void sendKeys(WebElement element, String text) {
        WebElement el = waitForVisibility(element);
        el.clear();
        el.sendKeys(text);
    }

    // ✅ Append text (without clearing)
    public void appendText(WebElement element, String text) {
        WebElement el = waitForVisibility(element);
        el.sendKeys(text);
    }

    // ✅ Click element safely
    public void click(WebElement element) {
        waitForVisibility(element).click();
    }

    // ✅ Take Screenshot
    public void takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./screenshots/" + filename + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendKeysWithMouse(WebElement element, String text) throws InterruptedException {
        WebElement box = waitForVisibility(element);

        // First click to focus
        actions.moveToElement(box).click().perform();
        Thread.sleep(1000);
        // Type the text
        actions.sendKeys(text).perform();

        // Press Enter
        actions.sendKeys(Keys.ENTER).perform();
    }


}

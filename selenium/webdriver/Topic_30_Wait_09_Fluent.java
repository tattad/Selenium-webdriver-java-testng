package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_30_Wait_09_Fluent {

    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Time - Default Polling Time: 0.5s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Time - Polling Time: 0.3s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    @Test
    public void TC_01() {
        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.xpath("")));

        fluentString = new FluentWait<String>("Hello World");

        //Tổng time
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        //Polling time
    }

    @Test
    public void TC_02() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

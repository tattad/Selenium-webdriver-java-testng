package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Wait_09_Fluent {

    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    FluentWait<String> fluentString;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        fluentDriver = new FluentWait<WebDriver>(driver);

        //Time - Default Polling Time: 0.5s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Time - Polling Time: 0.3s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    public void TC_Example() {
        //KHỞI TẠO
        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.xpath("")));

        fluentString = new FluentWait<String>("Hello World");

        //SETTING
        //Tổng time
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        //Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));

        //Ignore NoSuchElement exception
        fluentDriver.ignoring(NoSuchElementException.class);

        //Ignore Timeout exception
        fluentDriver.ignoring(TimeoutException.class);

        //CONDITION
        fluentDriver.until(new Function<WebDriver, Object>() { //new Function<T, V>

            @Override
            public Object apply(WebDriver webDriver) {
                return null;
            }
        });
    }

    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        //Chờ cho cái HelloWorld text hiển thịt trong vòng 10s
        //Setting
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        //Condition
//        fluentDriver.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
//            }
//        });

        String helloWorld = fluentDriver.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                String text = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
                System.out.println("Get text: " + text);
                return text;
            }
        });
        Assert.assertEquals(helloWorld, "Hello World!");
    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });
    }

    public WebElement waitAndFindElement(By locator) {
        FluentWait<WebDriver> fluentDriver = new FluentWait<WebDriver>(driver);
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
        return null;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

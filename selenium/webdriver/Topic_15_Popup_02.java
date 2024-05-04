package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Popup_02 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Random_Popup_In_DOM_01() {
        driver.get("https://www.javacodegeeks.com/");
        sleepInSecond(10);

        WebElement randomPopup = driver.findElement(By.xpath("//div[@class='lepopup-popup-container']/div[contains(@class,'lepopup-form') and not(contains(@style,'display:none'))]"));

        if (randomPopup.isDisplayed()) {
            driver.findElement(By.xpath("//div[@class='lepopup-popup-container']/div[contains(@class,'lepopup-form') and not(contains(@style,'display:none'))]//a[text()='No Thanks!']")).click();
            sleepInSecond(2);
            driver.findElement(By.id("search-input")).sendKeys("Agile Testing Explained");
            driver.findElement(By.id("search-submit")).click();
            sleepInSecond(5);

            Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
        } else {
            driver.findElement(By.id("search-input")).sendKeys("Agile Testing Explained");
            driver.findElement(By.id("search-submit")).click();
            sleepInSecond(5);

            Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
        }
    }

    @Test
    public void TC_02_Random_Popup_In_DOM_02() {
        driver.get("https://vnk.edu.vn/");

        WebElement randomPopup = driver.findElement(By.xpath("//div[@id='tve-p-scroller']/article"));
    }

    @Test
    public void TC_03_Random_Popup_Not_In_DOM() {
        driver.get("https://dehieu.vn/");

        WebElement randomPopup = driver.findElement(By.xpath(""));
    }

    @Test
    public void TC_04_Shadow_DOM() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

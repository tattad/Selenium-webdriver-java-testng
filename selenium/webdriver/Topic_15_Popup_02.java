package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
        sleepInSecond(20);

        List<WebElement> newsletterPopup = driver.findElements(By.xpath("//div[@class='lepopup-popup-container']/div[contains(@class,'lepopup-form') and not(contains(@style,'display:none'))]"));

        if (newsletterPopup.size() > 0 && newsletterPopup.get(0).isDisplayed()) {
            System.out.println("Co hien thi");
            driver.findElement(By.xpath("//div[@class='lepopup-popup-container']/div[contains(@class,'lepopup-form') and not(contains(@style,'display:none'))]//a[text()='No Thanks!']")).click();
            sleepInSecond(2);
        } else {
            System.out.println("Khong hien thi");
        }

        driver.findElement(By.id("search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.id("search-submit")).click();
        sleepInSecond(5);

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }

    @Test
    public void TC_02_Random_Popup_In_DOM_02() {
        driver.get("https://vnk.edu.vn/");
//        sleepInSecond(30);

//        WebElement marketingPopup = driver.findElement(By.xpath("//div[@class='tve-leads-conversion-object']"));

        findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='title-content']/h1")).getText(), "Lịch Khai Giảng Tháng 05");
    }

    @Test
    public void TC_03_Random_Popup_Not_In_DOM() {
        driver.get("https://dehieu.vn/");

        List<WebElement> registerFormPopup = driver.findElements(By.xpath("//div[contains(@class,'modal-content')]"));

        if (registerFormPopup.size() > 0 && registerFormPopup.get(0).isDisplayed()) {
            int heightBrowser = driver.manage().window().getSize().getHeight();
            if (heightBrowser < 1920) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click;", driver.findElement(By.xpath("//button[@class='close']")));
            } else {
                driver.findElement(By.xpath("//button[@class='close']")).click();
            }

            sleepInSecond(2);
            System.out.println("Co hien thi");
        } else {
            System.out.println("Khong hien thi");
        }
    }

    public WebElement findElement(By locator) {
        if (driver.findElement(By.xpath("//div[@class='tve-leads-conversion-object']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[contains(@class,'tve_ea_thrive_leads_form_close')]")).click();
            sleepInSecond(2);
            System.out.println("Co hien thi");
        }
        return driver.findElement(locator);
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

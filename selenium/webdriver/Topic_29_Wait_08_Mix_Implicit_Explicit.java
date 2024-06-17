package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_29_Wait_08_Mix_Implicit_Explicit {

    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Only_Implicit_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com/");

        //Khi vào tìm element thì nó tìm thấy ngay
        //Không cần chờ hết timeouts
        driver.findElement(By.xpath("//input[@id='email']"));
    }

    @Test
    public void TC_02_Only_Implicit_Not_Found() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com/");

        //Khi vào tìm element không tìm thấy
        //Polling mỗi nữa giây tìm lại 1 lần
        //Khi hết timeouts sẽ đánh fail testcase và throw exception: NoSuchElementException
        //NoSuchElementException: Unable to locate element: //input[@id='automation]
        driver.findElement(By.xpath("//input[@id='automation']"));
    }

    @Test
    public void TC_03_Only_Explicit_Found() {
        driver.get("https://www.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    }

    @Test
    public void TC_04_Only_Explicit_Not_Found() {
        driver.get("https://www.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Khi vào tìm element không tìm thấy
        //Polling mỗi nữa giây tìm lại 1 lần
        //Khi hết timeouts sẽ đánh fail testcase và throw exception: TimeOutException
        //TimeOutException: Expected condition failed: waiting for visibility of element located by By.xpath: //input[@id='automation']
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='automation']")));
    }

    @Test
    public void TC_05_Mix_Implicit_Explicit() {
        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@id='email']"));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Wait_01_Element_Status {

    WebDriver driver;

    WebDriverWait explicitWait;

    By confirmEmailTextbox = By.xpath("//input[@name='reg_email_confirmation__']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Visible() {
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("a@gmail.com");
        sleepInSecond(1);

        //Tại đúng thời điểm này thì  Confirm Email text box đang Visible/Displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmailTextbox));

        Assert.assertTrue(driver.findElement(confirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_In_Dom() {
        //Điều kiện 2 - Element ko xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
        sleepInSecond(2);

        //Tại đúng thời điểm này thì  Confirm Email text box đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(confirmEmailTextbox));

        Assert.assertFalse(driver.findElement(confirmEmailTextbox).isDisplayed());
    }

//    @Test
    public void TC_02_Invisible_Not_In_Dom() {
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(1);

        //Điều kiện 3 - Element ko xuất hiện trên UI và cũng ko có trong cây HTML
//        driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
//        sleepInSecond(2);

        //Tại đúng thời điểm này thì  Confirm Email text box đang invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(confirmEmailTextbox));

        //Không dùng cách này để verify
//        Assert.assertFalse(driver.findElement(confirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_03_Presence() {
//        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
//        sleepInSecond(2);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("a@gmail.com");
        sleepInSecond(1);

        //Điều kiện 1 - Element có xuất hiện trên UI và có trong cây HTML
        //Tại đúng thời điểm này thì  Confirm Email text box đang Visible/Displayed
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(confirmEmailTextbox));

        driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
        sleepInSecond(2);

        //Điều kiện 2 - Element ko xuất hiện trên UI và vẫn có trong cây HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(confirmEmailTextbox));
    }

    @Test
    public void TC_04_Staleness() {
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(1);
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        sleepInSecond(2);

        //Tại thời điểm này element có xuất hiện và mình sẽ findElement
        WebElement confirmEmail = driver.findElement(confirmEmailTextbox);

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSecond(1);

        //Điều kiện 3 - Element ko xuất hiện trên UI và cũng ko có trong cây HTML
        explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));
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

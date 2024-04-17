package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands_02 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Nếu như mong đợi 1 element hiển thị thì verifyTrue
        //Nếu như mong đợi 1 element không hiển thị thì verifyFalse
        if(driver.findElement(By.id("mail")).isDisplayed()){
            driver.findElement(By.id("mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        if(driver.findElement(By.xpath("//label[@for='under_18']")).isDisplayed()){
            driver.findElement(By.xpath("//label[@for='under_18']")).click();
            System.out.println("Under 18 radio button is displayed");
        } else {
            System.out.println("Under 18 radio button is not displayed");
        }

        if(driver.findElement(By.id("edu")).isDisplayed()){
            driver.findElement(By.id("edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");
        }

        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("Name User5 text is displayed");
        } else {
            System.out.println("Name User5 text is not displayed");
        }

        Assert.assertTrue(driver.findElement(By.id("mail")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='under_18']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("edu")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
    }

    @Test
    public void TC_02_Enabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.id("mail")).isEnabled()){
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disable");
        }

        if(driver.findElement(By.xpath("//label[@for='under_18']")).isEnabled()) {
            System.out.println("Under 18 radionbutton is enabled");
        } else {
            System.out.println("Under 18 radionbutton is disabled");
        }

        if(driver.findElement(By.id("edu")).isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }

        if(driver.findElement(By.id("job1")).isEnabled()) {
            System.out.println("Job Role 01 - Single dropdown is enabled");
        } else {
            System.out.println("Job Role 01 - Single dropdown is disabled");
        }

        if(driver.findElement(By.id("job2")).isEnabled()) {
            System.out.println("Job Role 02 - Single dropdown is enabled");
        } else {
            System.out.println("Job Role 02 - Single dropdown is disabled");
        }

        if(driver.findElement(By.xpath("//label[@for='development']")).isEnabled()) {
            System.out.println("Interests (Development) Checkbox is enabled");
        } else {
            System.out.println("Interests (Development) Checkbox is disabled");
        }

        if(driver.findElement(By.id("slider-1")).isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");
        }

        if(driver.findElement(By.id("disable_password")).isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }

        if(driver.findElement(By.id("radio-disabled")).isEnabled()) {
            System.out.println("Age radio button is enabled");
        } else {
            System.out.println("Age radio button is disabled");
        }

        if(driver.findElement(By.id("bio")).isEnabled()) {
            System.out.println("Biography is enabled");
        } else {
            System.out.println("Biography is disabled");
        }

        if(driver.findElement(By.id("job3")).isEnabled()) {
            System.out.println("Job Role 03 - Disable Dropdown is enabled");
        } else {
            System.out.println("Job Role 03 - Disable Dropdown is disabled");
        }

        if(driver.findElement(By.xpath("//label[@for='check-disbaled']")).isEnabled()) {
            System.out.println("Interests Checkbox is enabled");
        } else {
            System.out.println("Interests Checkbox is disabled");
        }

        if(driver.findElement(By.id("slider-2")).isEnabled()) {
            System.out.println("Slider 02 is enabled");
        } else {
            System.out.println("Slider 02 is disabled");
        }
    }

    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.id("under_18")).click();
        driver.findElement(By.id("java")).click();

        Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("java")).isSelected());

        driver.findElement(By.id("java")).click();
        Assert.assertFalse(driver.findElement(By.id("java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

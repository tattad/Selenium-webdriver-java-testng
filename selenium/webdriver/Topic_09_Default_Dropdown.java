package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {

    WebDriver driver;
    String firstName = "Ace",
            lastName = "Sabo",
            emailAddress = getEmailAddress();
    String companyName = "Penguin",
            password = "123456";
    String day = "10",
            month = "October",
            year = "2000";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

//        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//        day.selectByVisibleText("November");
//        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
//        day.selectByVisibleText("1997");

//        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("15");
//        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("November");
//        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1997");

        //Day dropdown
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //Chọn ngày
        dayDropdown.selectByVisibleText(day);
        //Verify dropdown này là Single (không phải multiple)
        Assert.assertFalse(dayDropdown.isMultiple());
        //Verify dropdown này có 32 items
//        List<WebElement> dayOptions = day.getOptions();
//        Assert.assertEquals(dayOptions.size(), 32);
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);

        //Month dropdown
        Select monthDropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        monthDropdown.selectByVisibleText(month);
        Assert.assertFalse(monthDropdown.isMultiple());
        Assert.assertEquals(monthDropdown.getOptions().size(), 13);

        //Year dropdown
        Select yearDropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        yearDropdown.selectByVisibleText(year);
        Assert.assertFalse(yearDropdown.isMultiple());
        Assert.assertEquals(yearDropdown.getOptions().size(), 112);

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }

    @Test
    public void TC_02_Login() {
        //Login
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        sleepInSecond(2);

        //Verify
        driver.findElement(By.className("ico-account")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "penguin" + rand.nextInt(9999999) + "@gmail.com";
    }
}

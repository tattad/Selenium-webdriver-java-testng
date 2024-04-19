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
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Nếu như mong đợi 1 element hiển thị thì verifyTrue
        //Nếu như mong đợi 1 element không hiển thị thì verifyFalse
        if (driver.findElement(By.id("mail")).isDisplayed()) {
            driver.findElement(By.id("mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        if (driver.findElement(By.xpath("//label[@for='under_18']")).isDisplayed()) {
            driver.findElement(By.xpath("//label[@for='under_18']")).click();
            System.out.println("Under 18 radio button is displayed");
        } else {
            System.out.println("Under 18 radio button is not displayed");
        }

        if (driver.findElement(By.id("edu")).isDisplayed()) {
            driver.findElement(By.id("edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
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
    public void TC_02_Enabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.id("mail")).isEnabled()) {
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disable");
        }

        if (driver.findElement(By.xpath("//label[@for='under_18']")).isEnabled()) {
            System.out.println("Under 18 radionbutton is enabled");
        } else {
            System.out.println("Under 18 radionbutton is disabled");
        }

        if (driver.findElement(By.id("edu")).isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }

        if (driver.findElement(By.id("job1")).isEnabled()) {
            System.out.println("Job Role 01 - Single dropdown is enabled");
        } else {
            System.out.println("Job Role 01 - Single dropdown is disabled");
        }

        if (driver.findElement(By.id("job2")).isEnabled()) {
            System.out.println("Job Role 02 - Single dropdown is enabled");
        } else {
            System.out.println("Job Role 02 - Single dropdown is disabled");
        }

        if (driver.findElement(By.xpath("//label[@for='development']")).isEnabled()) {
            System.out.println("Interests (Development) Checkbox is enabled");
        } else {
            System.out.println("Interests (Development) Checkbox is disabled");
        }

        if (driver.findElement(By.id("slider-1")).isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");
        }

        if (driver.findElement(By.id("disable_password")).isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }

        if (driver.findElement(By.id("radio-disabled")).isEnabled()) {
            System.out.println("Age radio button is enabled");
        } else {
            System.out.println("Age radio button is disabled");
        }

        if (driver.findElement(By.id("bio")).isEnabled()) {
            System.out.println("Biography is enabled");
        } else {
            System.out.println("Biography is disabled");
        }

        if (driver.findElement(By.id("job3")).isEnabled()) {
            System.out.println("Job Role 03 - Disable Dropdown is enabled");
        } else {
            System.out.println("Job Role 03 - Disable Dropdown is disabled");
        }

        if (driver.findElement(By.xpath("//label[@for='check-disbaled']")).isEnabled()) {
            System.out.println("Interests Checkbox is enabled");
        } else {
            System.out.println("Interests Checkbox is disabled");
        }

        if (driver.findElement(By.id("slider-2")).isEnabled()) {
            System.out.println("Slider 02 is enabled");
        } else {
            System.out.println("Slider 02 is disabled");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.id("under_18")).click();
        sleepInSecond(3);
        driver.findElement(By.id("java")).click();
        sleepInSecond(3);

        Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("java")).isSelected());

        driver.findElement(By.id("java")).click();
        sleepInSecond(3);
        Assert.assertFalse(driver.findElement(By.id("java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.id("email")).sendKeys("tada@gmail.com");

        //Case 1: Number
        driver.findElement(By.id("new_password")).sendKeys("12345");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 2: LowerCase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("abc");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 3: UpperCase
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("ABC");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 4: Special characters
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("!@#$%");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 5: more than 8 chars
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("123abcdef");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 6: valid
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("new_password")).sendKeys("123Abcd!@#");
        sleepInSecond(2);
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        //Case 7: Empty
        driver.findElement(By.id("new_password")).clear();
        driver.findElement(By.id("create-account-enabled")).click();
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check not-completed']")).isDisplayed());
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
}

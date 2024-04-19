package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_08_Textbox_TextArea {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty_Email_And_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")), "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("123@123.123");
        driver.findElement(By.id("pass")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("tada@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_04_Incorrect_Email_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("tada@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(), "Invalid login or password.");
    }

    @Test
    public void Login_05_Register_A_New_Account() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        //Dky 1 tài khoản
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSecond(2);

        String firstName = "Hom Nay",
               middleName = "An",
               lastName = "Gi",
               emailAddres = getEmailAddress(),
               password = "123456789";
        String fullName = firstName + " " + middleName + " " + lastName;

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("middlename")).sendKeys(middleName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(emailAddres);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']")).getText(),"Hello, "+ fullName + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']//parent::div//following-sibling::div[@class='box-content']")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddres));
        //h3[text()='Contact Information']//parent::div//following-sibling::div/p[@class='box-content']

        driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//a[@title='Log Out']")).click();
        sleepInSecond(5);

        //Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys(emailAddres);
        driver.findElement(By.id("pass")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']")).getText(),"Hello, "+ fullName + "!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']//parent::div//following-sibling::div[@class='box-content']")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddres));

        //Verify ACcount
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSecond(2);

//        driver.findElement(By.xpath("//input[@class='firstname']")).getAttribute("value");
        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("middlename")).getAttribute("value"), middleName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), emailAddres);

        //Case 1: Đăng kí trước bằng tay (manual) 1 tài khoản email ồi dùng nó để login cho case này
        //Khi hệ thống bị reset dữ liệu là phải đăng kí lại
        //DB bị xóa
        //Qua 1 môi trường mới

        //Case 2: Sẽ dùng tính năng Register trước - email cố định không thay đổi
        //Tính năng Register cũng automation luôn
        //Email khi dùng đăng kí lại fix cứng (1 lần)

        //Case 3: Sẽ dùng tính năng Register trước - email không cố định (random)
        //Chạy luôn đúng cho tất cả case
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
        return  "logintest" + rand.nextInt(9999999) + "@gmail.com";
    }
}

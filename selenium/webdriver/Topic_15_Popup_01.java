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
import java.util.concurrent.TimeUnit;

public class Topic_15_Popup_01 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM_01() {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//div[@id='button-login-dialog']//button[text()='Đăng nhập']"))
                .click();

        WebElement loginPopup = driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]/div"));

        Assert.assertTrue(loginPopup.isDisplayed());

        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//input[@id='account-input']"))
                .sendKeys("autmationfc");
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//input[@id='password-input']"))
                .sendKeys("autmationfc");

        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[text()='Đăng nhập']"))
                .click();
        sleepInSecond(1);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//div[@class='row error-login-panel']"))
                .getText(), "Tài khoản không tồn tại!");

        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[@class='close']"))
                .click();

        Assert.assertFalse(loginPopup.isDisplayed());
    }

    @Test
    public void TC_02_Fixed_Popup_In_DOM_02() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        WebElement loginPopup = driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//div[@class='modal-content']"));

        Assert.assertTrue(loginPopup.isDisplayed());

        driver.findElement(By.id("user-login")).sendKeys("a@gmail.com");
        driver.findElement(By.id("user-password")).sendKeys("123456");
        driver.findElement(By.id("btn-submit-login")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='password-form-login-message']")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_DOM_01() {
        driver.get("https://tiki.vn/");

        driver.findElement(By.xpath("//div[@data-view-id='header_header_account_container']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]")).isDisplayed());

        driver.findElement(By.xpath("//p[@class='login-with-email']")).click();

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div/following-sibling::span[1]")).getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(), "Mật khẩu không được để trống");

        driver.findElement(By.xpath("//img[@class='close-img']")).click();
        sleepInSecond(1);

//        Assert.assertFalse(driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]")).isDisplayed());
        Assert.assertEquals(driver.findElements(By.xpath("//div[contains(@class,'ReactModal__Content')]")).size(), 0);
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_DOM_02() {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();

        Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(), 0);
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

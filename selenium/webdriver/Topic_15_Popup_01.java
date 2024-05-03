package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Popup_01 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixe_Popup_In_DOM_01() {
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
    public void TC_02_Fixe_Popup_In_DOM_02() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        WebElement loginPopup = driver.findElement(By.xpath("//div[@id='k-popup-account-login-mb']//div[@class='modal-content']"));

        Assert.assertTrue(loginPopup.isDisplayed());

        driver.findElement(By.id("user-login")).sendKeys("a@gmail.com");
        driver.findElement(By.id("user-password")).sendKeys("123456");
        driver.findElement(By.id("btn-submit-login")).click();

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

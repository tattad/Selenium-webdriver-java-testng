package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_Tab {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Google");

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("BStarSolutions");

        switchToWinDowTabByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Facebook – log in or sign up");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc");

        switchToWinDowTabByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

        driver.findElement(By.xpath("//div[@title='Nhà Sách Tiki']")).click();
    }

    @Test
    public void TC_02_KynaEnglish() {
        driver.get("https://skills.kynaenglish.vn/");

        driver.findElement(By.cssSelector("div.hotline img=[alt='facebook']")).click();
        switchToWinDowTabByTitle("Kyna.vn | Ho Chi Minh | Facebook");

        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("ahihi");

        switchToWinDowTabByTitle("Kyna.vn - Học online cùng chuyên gia");

        driver.findElement(By.cssSelector("div.hotline img=[alt='youtube']")).click();

        switchToWinDowTabByTitle("Kyna.vn - YouTube");

        Assert.assertEquals(driver.findElement(By.cssSelector("div#inner-header-container yt-formatted-string#text")).getText(),"Kyna.vn");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void switchToWinDowTabById(String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWinDowTabByTitle(String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);

            String actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

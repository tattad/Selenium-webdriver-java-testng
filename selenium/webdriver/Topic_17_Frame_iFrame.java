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

public class Topic_17_Frame_iFrame {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        driver.get("https://skills.kynaenglish.vn/");

    }

    @Test
    public void TC_02() {
        //Trang A - domain: formsite.com
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        /*//Chứa iframe - trang B
        //Từ A vào B
        driver.switchTo().frame("frame-one85593366");
        driver.findElement(By.cssSelector("")).click();
        //Từ B vào C
        driver.switchTo().frame("frame-23232");
        driver.findElement(By.cssSelector("")).click();
        //Từ C quay lại B
        driver.switchTo().parentFrame();
        //Đang ở B
        //Từ B quay lại A
        driver.switchTo().defaultContent();*/

        driver.findElement(By.xpath("//div[@id='imageTemplateContainer']/img")).click();
        sleepInSecond(5);

        //Iframe element
        WebElement formIframe = driver.findElement(By.xpath("//div[@id='imageTemplateContainer']/img"));

        Assert.assertTrue(formIframe.isDisplayed());
    }

    @Test
    public void TC_03() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
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

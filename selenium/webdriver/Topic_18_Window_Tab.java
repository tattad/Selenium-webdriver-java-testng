package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        //Lấy ID của tab hiện tại
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(2);

        Set<String> allIDs = driver.getWindowHandles();

        switchToWinDowTabById(parentID);

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("BStarSolutions");
        String ggID = driver.getWindowHandle();

        switchToWinDowTabById(ggID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(2);

//        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
    }

    public void TC_02() {
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

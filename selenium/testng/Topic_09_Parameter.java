package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Parameter {

    WebDriver driver;

    @Parameters({"browser", "version"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVersion) {
        driver = getBrowserDriver(browserName);
        System.out.println("Browser " + browserName + " with version: " + browserVersion);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Parameters("environment")
    @Test
    public void TC_01_Login(String environmentName) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("111111");
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
    }

    private WebDriver getBrowserDriver(String browserName) {
        WebDriver driver;
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equals("ie")) {
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Browser name is invalid");
        }
        return driver;
    }

    private WebDriver getEnvironment(String environmentName) {
        WebDriver driver;
        if (environmentName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (environmentName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (environmentName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (environmentName.equals("ie")) {
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Browser name is invalid");
        }
        return driver;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

package demoPenguin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoPenguin_Mac {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass(){
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("dom.webnotifications.enabled",false);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://penguin.stage-ap.apps.bsci.com/");

        //Click on Non BSCS Account
        driver.findElement(By.xpath("//span[contains(text(),'Non BSC Account')]")).click();
        //Input User name
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("qc_salereptada");
        //Input Password
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("1234567890@dNam");
        //Click Login button
        driver.findElement(By.xpath("//span[contains(text(),' Log in ')]")).click();

//        driver.findElement(By.xpath("//span[text()='ANZ']")).click();
        //Chọn Order menu
        driver.findElement(By.xpath("//span[@title='Order']")).click();

        WebElement element = driver.findElement(By.xpath("//a[@title='Demo (NFHU)']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@title='Demo (NFHU)']")).click();

        driver.findElement(By.xpath("//nz-select-placeholder[contains(text(),'Select Account Name')]")).click();
//
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}

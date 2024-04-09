package demoPenguin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoPenguin_Win {

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

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Click_NonBSCAccout(){
        driver.get("https://penguin.stage-ap.apps.bsci.com/");

        //Action
        driver.findElement(By.xpath("//span[contains(text(),'Non BSC Account')]")).click();
    }

    @Test
    public void Login_02_Submit_A_Order() {
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
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();

//        driver.findElement(By.xpath("//span[text()='ANZ']")).click();
        //Chọn Order menu
        driver.findElement(By.xpath("//span[text()='Order']")).click();

        driver.findElement(By.xpath("//a[@title='Demo (NFHU)']")).click();

//        driver.findElement(By.xpath("//nz-select-placeholder[text()=' Select Account Name ']")).click();
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
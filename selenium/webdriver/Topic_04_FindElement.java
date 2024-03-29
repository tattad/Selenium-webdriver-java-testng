package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_FindElement {

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
    public void TC_01(){
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        //Click vào My Account ở trên Header
        //Khong hien thi de thao tac nen se fail
        //Co che cua Selenium: findElement se luon thao tac voi element dau tien duoc tim thay
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

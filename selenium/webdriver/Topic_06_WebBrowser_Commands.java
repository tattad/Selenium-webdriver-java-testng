
package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    //Các câu lệnh để thao tác vs browser
    //driver.
    WebDriver driver;

    //Chỉ dùng đúng cho trình duyệt đó
    FirefoxDriver ffDriver;
    ChromeDriver chDriver;
    EdgeDriver edgeDriver;

    //Các câu lệnh để thao tác vs element
    //element.
    WebElement element;

    @BeforeClass
    public void beforeClass(){
        //Muốn dùng được phải khởi tạo
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

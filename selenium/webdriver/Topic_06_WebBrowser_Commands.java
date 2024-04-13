
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
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

        //Selenium v3/ v2/ v1
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        //Mở ra 1 page url bất kỳ
        driver.get("https://www.facebook.com/");

        //Nếu như có 1 tab/window thì tính năng tương tự quit
        //Nhiều hơn 1 thì nó sẽ đóng cái đang active
        driver.close();

        //Đóng browser (không care bao nhiêu tab/window)
        driver.quit();

        //2 hàm nãy sẽ bị ảnh hưởng timeout của implicitWait
        //findElement/ findElements

        //Nó sẽ đi tìm với loại By nào và trả về element nếu như được tìm thấy (WebElement)
        //Không được tìm thấy -> Fail tại step này - throw exception: NoSuchElementException
        //Trả về 1 element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy 1 (thao tác với cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        //Nó sẽ đi tìm với loại By nào trả về 1 danh sách element nếu như được tìm thấy (List WebElement)
        //Không được tìm thấy -> không bị fail - trả về 1 list rỗng (0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        driver.findElement(By.cssSelector("button#login")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

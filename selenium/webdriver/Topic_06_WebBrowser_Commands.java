
package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
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
        //** Dùng nhiều
        //* Ít dùng

        //Muốn dùng được phải khởi tạo
        driver = new FirefoxDriver(); //**
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();

        //Selenium v3/ v2/ v1
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() throws MalformedURLException {
        //Mở ra 1 page url bất kỳ
        driver.get("https://www.facebook.com/");//**

        System.out.println("Window/ Tab ID = "+ driver.getWindowHandle());

        //Nếu như có 1 tab/window thì tính năng tương tự quit
        //Nhiều hơn 1 thì nó sẽ đóng cái đang active
        driver.close();//*

        //Đóng browser (không care bao nhiêu tab/window)
        driver.quit();//**

        //2 hàm nãy sẽ bị ảnh hưởng timeout của implicitWait
        //findElement/ findElements

        //Nó sẽ đi tìm với loại By nào và trả về element nếu như được tìm thấy (WebElement)
        //Không được tìm thấy -> Fail tại step này - throw exception: NoSuchElementException
        //Trả về 1 element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy 1 (thao tác với cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));//**

        //Nó sẽ đi tìm với loại By nào trả về 1 danh sách element nếu như được tìm thấy (List WebElement)
        //Không được tìm thấy -> không bị fail - trả về 1 list rỗng (0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));//**

        driver.findElement(By.cssSelector("button#login")).click();

        //Tại sao lại cần phải lấy dữ liệu ra để làm gì?
        //Dùng để lấy ra URL của màn hình/ page hiện tại đang dùng
        String loginPageUrl = driver.getCurrentUrl();//*

        //Lấy ra page source HTML/CSS/JS của page hiện tại
        //Verify 1 cách tương đối
        driver.getPageSource();
        driver.getCurrentUrl().contains("The Apple and Google Play logos are trademarks of their respective owners.");
        Assert.assertTrue(driver.getPageSource().contains("The Apple and Google Play logos are trademarks of their respective owners."));

        //Lấy ra title của page hiện tại
        driver.getTitle();

        //Lấy ra ID của cái cửa sổ/ tab hiện tại
        //Handle Window/ Tab
        driver.getWindowHandle();//*
        driver.getWindowHandles();//*

        //Nếu chỉ dùng 1 lần thì không khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        //Dùng lại nhiều lần
//        Assert.assertEquals(loginPageUrl,"https://www.facebook.com/");

        //Cookies - Framework
        driver.manage().getCookies();//*

        //Get ra những log ở Devtool - Framework
        driver.manage().logs().get(LogType.DRIVER);//*

        //Apply cho việc tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

        //Chờ cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Set trước khi dùng với thư viện JavaScriptExecutor
        //Inject 1 đoạn code JS cào trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Selenium v4 mới có - thường không dùng
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        driver.manage().window().fullscreen(); //Chạy full màn hình
        driver.manage().window().maximize();//**
        driver.manage().window().minimize();

        //Test GUI
        //Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768)); //set resolution cho browser
        driver.manage().window().getSize();

        //Set cho browser ở vị trí nào so với độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        //Điều hướng trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        //Thao tác với history của web page (back/ forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));

        //Alert/ Window (tab)/ Frame (iFrame) //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");

        //Lấy ra ID cửa sổ hiện tại //*
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        //Switch/ Handle frame (iframe) //*
        //Index/ ID (Name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("123425");
        driver.switchTo().frame(driver.findElement(By.id("")));

        //Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        //Từ fram trong đi ra frame ngoài chứa nó
        driver.switchTo().parentFrame();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

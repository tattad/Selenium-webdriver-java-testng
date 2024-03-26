package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

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
        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
    }

//    @Test
//    public void TC_01(){
//        //Selenium 1.x, 2.x, 3.x co 8 loai locator
//        //Selenium locator = HTLM attribute
//        //Id/ Class/ Name =  trùng với 3 attribute cua HTLM
//        //Link text/ Partial LinkText: HTML link (thẻ a)
//        //Tag name: HTML tag name
//        //CSS/ Path
//
//        //Selenium version 4.x
//        //Class - Relative Locator
//        //above/ below/ near/ leftOf/ rightOf
//
//        //UI Testing
//        //FUI: Functional UI
//
//        //GUI: Graphic UI - Visualize Testing
//        //Font/ Size/ Color/ Position/ Location/ Resolution/ Responsive...
//    }

    //TestNG: Order testcase following Alphabet (0-9, A-Z)
    //Firstname textbox - HTML code
    //HTML Element: <tagname attribute_name_1='attribute_value' attribute_name_2='attribute_value'...>
    /*
     *<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
     */

    @Test
    public void TC_01_ID(){
        //Tìm element có id là FirstName
        driver.findElement(By.id("FirstName")).sendKeys("Dat");
//        System.out.println(driver.findElement(By.id("FirstName")));
    }

    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_Tagname(){
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText(){
        //độ chính xác tuyệt đối
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText(){
        //độ chính xác không cao
        driver.findElement(By.partialLinkText("for vendor"));
    }

    @Test
    public void TC_07_Css(){
        //Css với ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //Css với class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css với name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css với tagname
        driver.findElement(By.cssSelector("input"));

        //Css với link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        //Css với partial link
        driver.findElement(By.cssSelector("a[href*='addresses']")); //lấy giữa
//        driver.findElement(By.cssSelector("a[href^='addresses']")); //lấy đầu
//        driver.findElement(By.cssSelector("a[href$='addresses']")); // lấy đuôi
    }

    @Test
    public void TC_08_XPath(){
        //XPath với ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //XPath với class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        //XPath với name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //XPath với tagname
        driver.findElement(By.xpath("//input"));

        //XPath với link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        //XPath với partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}

package webdriver;

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
//        driver.findElement(By.);
    }

    @Test
    public void TC_02_Class(){

    }

    @Test
    public void TC_03_Name(){

    }

    @Test
    public void TC_04_Tagname(){

    }

    @Test
    public void TC_05_LinkText(){

    }

    @Test
    public void TC_06_Partial_LinkText(){

    }

    @Test
    public void TC_07_Css(){

    }

    @Test
    public void TC_08_XPath(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

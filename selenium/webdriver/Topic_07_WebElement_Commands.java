package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //Tương tác với browser
import org.openqa.selenium.WebElement; //Tương tác với element
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element(){
        //Tìm và trả về 1 element nhưng chưa tương tác
        driver.findElement(By.id(""));

        //Tìm và tương tác lên element
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys();

        //Tìm và lưu nó vào 1 biến Element (chưa tương tác)
        //Khi có dùng biến này từ 2 lần trở lên
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("");
        fullNameTextbox.getAttribute("value");

        //Dùng để xoá dữ liệu trong 1 cái field cho phép nhập (editable)
        //Thường được sử dụng trước hàm sendKeys
        driver.findElement(By.id("")).clear();

        //Dùng để nhập liệu
        driver.findElement(By.id("")).sendKeys("");

        //Dùng để click lên element
        driver.findElement(By.id("")).click();

        //Tìm từ node cha vào node con
        driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement(By.id("form-validate")).findElement(By.cssSelector("input"));
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));

        //Trả về 1 element khớp với điều kiện
        WebElement fullNameTextboxx = driver.findElement(By.id(""));
        //Trả về nhiều element khớp với điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));

/*        //Java non-Generic
        ArrayList name = new ArrayList();
        name.add("Automation Test");
        name.add(50);
        name.add('B');
        name.add(true);

        //Java Generic
        ArrayList<String> address = new ArrayList<String>();
        address.add("Automation Test");
        address.add(50);
        address.add('B');
        address.add(true);*/

        //Dùng để verify 1 checkbox/ radio/ dropdown đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dropdown (default/ customr
        Select select = new Select(driver.findElement(By.id("")));

        //Dùng để verify 1 element bất kì có hiển thị hay không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //Dùng để verify 1 element có được thao tác lên hay không (không phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        //HTML Element
        // <input type="text" id="firstname" name="firstname" value=""
        // title="First Name" maxlength="255" class="input-text required-entry">
        driver.findElement(By.id("")).getAttribute("title"); //lấy ra giá trị của title
        driver.findElement(By.id("")).getAttribute("id");

        driver.findElement(By.id("")).getAccessibleName();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdown {

    WebDriver driver;

    //Tường minh: trạng thái cụ thể cho element
    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element hết
        //Cho việc tìm element - findElement
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        //1 - Click vào 1 thẻ để cho nó xổ hết ra các item bên trong dropdown ra
//        driver.findElement(By.id("number-button")).click();
//        sleepInSecond(2);

        //2.1 - Nó sẽ xổ ra chứa hết tất cả các item
        //2.2 - Nó sẽ xổ ra nhưng chỉ chứa 1 phần và đang load thêm

        //Chờ  cho nó xổ ra hết tất cả các item trong dropdown
        //Có case item không visible hết tất cả
//        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("")));

        //Xuất hiện đầy đủ trong HTML
//        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']//div")));

//        List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id='number-menu']//div"));
//        for (WebElement item : allItems) {
//            String textItem = item.getText();
//            if (textItem.equals("8")) {
//                item.click();
//                break;
//            }
//        }
        //3.1 - Nếu như item cần chọn nó hiển thị thì click vào
        //3.2 - Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiển thị lên rồi mới chọn
        //4 - Trước khi click cần kiểm tra nếu như text của item bằng với item cần chọn thì click vào

        //Select a speed
        selectItemsInDropdown("speed-button", "//ul[@id='speed-menu']//div", "Medium");
        sleepInSecond(1);
        //Select a file
        selectItemsInDropdown("files-button", "//ul[@id='files-menu']//div", "jQuery.js");
        sleepInSecond(1);
        //Select a numer
        selectItemsInDropdown("number-button", "//ul[@id='number-menu']//div", "15");
        sleepInSecond(1);
        //Select a title
        selectItemsInDropdown("salutation-button", "//ul[@id='salutation-menu']//div", "Prof.");
        sleepInSecond(1);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),"Medium");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='files-button']//span[@class='ui-selectmenu-text']")).getText(),"jQuery.js");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']//span[@class='ui-selectmenu-text']")).getText(),"Prof.");
    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectItemsInDropdown(String dropdownList, String dropdownItems, String itemTextExpected) {
        driver.findElement(By.id(dropdownList)).click(); //"number-button"
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(dropdownItems)));//"//ul[@id='number-menu']//div"
        List<WebElement> allItems = driver.findElements(By.xpath(dropdownItems)); //"//ul[@id='number-menu']//div"
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}

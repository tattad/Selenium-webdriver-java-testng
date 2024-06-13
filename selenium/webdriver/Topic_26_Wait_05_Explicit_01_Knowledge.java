package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class Topic_26_Wait_05_Explicit_01_Knowledge {

    WebDriver driver;

    WebDriverWait explicitWait; //khai báo chưa khởi tạo

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Khởi tạo 1 explicitWait có tổng thời gian là 10s - polling là 0.5s mặc định
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Khởi tạo 1 explicitWait có tổng thời gian là 10s - polling là 0.3s tự set
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(300));
    }

    @Test
    public void TC_01() {
        //Chờ cho 1 alert presence trong HTML/DOM trước khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        //Chờ cho element không còn ở trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        //Chờ cho element có ở trong DOM (không quan tâm có trên UI không)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        //Chờ cho 1 list element có ở trong DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        explicitWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(""), By.cssSelector("")));

        //Chờ cho 1-n element được hiển thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector("")), driver.findElement(By.cssSelector(""))));

        //Chờ cho element được phép click: link/ button/ checkbox/ radio...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        //Chờ cho cái page hiện tại có title như mong đợi
        explicitWait.until(ExpectedConditions.titleIs("Create New Customer Account"));
        driver.getTitle();

        //Kết hợp nhiều điều kiện - 2 điều kiện đều đúng
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        //Kết hợp nhiều điều kiện - 1 trong 2 điều kiện đều đúng
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        //Chờ cho 1 element có attribute chứa giá trị mong đợi - tương đối
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entire"));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "store here..."));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entire store here..."));

        //Chờ cho 1 element có attribute chứa giá trị mong đợi - tuyệt đối
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector("input#search"), "placeholder", "Search entire store here..."));

        //Chờ cho 1 element có attribute khác null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("input#search")), "placeholder"));

        //
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("input#search")), "namespaceURI", "https://www.w3.org/1999/xhtml"));
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("input#search")), "namespaceURI", "https://www.w3.org/1999/xhtml"));

        //Chờ cho 1 element được selected thành công
        //Checkbox/ Radio/ Dropdown Item (Default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        //Chờ cho 1 element được selected rồi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        //Chờ cho 1 frame/iframe được available và switch qua
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), false));

        //Chờ cho 1 element chưa được selected rồi
        //Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));

        //Index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        //By or Element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));

        //Chờ cho 1 element biến mất (không hiển thị trên UI)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Chờ cho 1 đoạn code JS cần trả về giá trị
        explicitWait.until(ExpectedConditions.jsReturnsValue("return arguments[0].validationMessage;"));

        //Chờ cho 1 đoạn code JS được thực thi không có throw exception
        //Không -> true
        //Có -> False
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;"));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText;")));

        //Chờ cho số lượng element bằng 1 con số cố định
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("select[title='Sort By']>option"), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select[title='Sort By']>option"), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("select[title='Sort By']>option"), 10));

        //Chờ cho Window/ Tab là bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.category-title>h1"), "Mobile"));

        Pattern pattern = Pattern.compile("This is root of mobile", Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector("div.category-description"), pattern));

        //Bắt buộc cái text này trong DOM/HTML
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.category-title>h1"), ""));

        explicitWait.until(ExpectedConditions.urlToBe("http://live.techpanda.org/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlContains("/index.php/mobile.html"));
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));

        //Chờ cho 1 điều kiện mà element này nó bị update trạng thái - load lại HTML
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));
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
}

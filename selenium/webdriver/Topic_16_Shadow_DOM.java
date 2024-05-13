package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_16_Shadow_DOM {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Shadow_DOM() {//Chưa support cho xpath, cần dùng css
        driver.get("https://automationfc.github.io/shadow-dom/");
        sleepInSecond(2);

        //Đi theo đúng cấu trúc của HTML/DOM
        //shadowRootElement = đại diện cho cái shadow DOM 1 bên trong
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        String someText = shadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText, "some text");

        WebElement checboxShadow = shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checboxShadow.isSelected());

        List<WebElement> allInput = shadowRoot.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        //nestedShadowHostElement = đại diện cho cái nested shadow DOM 2 (nằm trong shadow DOM 1)
        WebElement nestedShadowHost = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRoot = nestedShadowHost.getShadowRoot();

        String nestText = nestedShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestText, "nested text");
    }

    @Test
    public void TC_02_Shadow_DOM_Shopee() {
        driver.get("https://shopee.vn");
        sleepInSecond(5);

        WebElement shadowHost = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        //2 TH có thể xảy ra
        //Nếu có popup hiển thị thì close và qua step tiếp theo
        //Nếu không có popup hiển thị thì qua step tiếp theo luôn

        //Verify pop hiển thị
        if (shadowRoot.findElements(By.cssSelector("div.home.home-popup__content")).size() > 0 && shadowRoot.findElements(By.cssSelector("div.home-popup__content")).get(0).isDisplayed()) {
            shadowRoot.findElement(By.cssSelector("div.home-popup__close-button")).click();
            sleepInSecond(2);
        }

        //Không hiển thị/ đã bị đóng rồi qua step Search dữ liệu
        driver.findElement(By.xpath("//input[contains(@class,'shopee-searchbar')]")).sendKeys("Samsung S25 Ultra");
        sleepInSecond(2);

        driver.findElement(By.xpath("//button[contains(@class,'shopee-searchbar__search-button')]")).click();
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

package webdriver;

import org.bouncycastle.asn1.x509.UserNotice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_Tab {

    WebDriver driver;
    WebDriver homeDriver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Basic_Form() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Google");

        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("BStarSolutions");

        switchToWinDowTabByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Facebook – log in or sign up");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc");

        switchToWinDowTabByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

        driver.findElement(By.xpath("//div[@title='Nhà Sách Tiki']")).click();
    }

    @Test
    public void TC_02_KynaEnglish() {
        driver.get("https://skills.kynaenglish.vn/");

        driver.findElement(By.cssSelector("div.hotline img=[alt='facebook']")).click();
        switchToWinDowTabByTitle("Kyna.vn | Ho Chi Minh | Facebook");

        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("ahihi");

        switchToWinDowTabByTitle("Kyna.vn - Học online cùng chuyên gia");

        driver.findElement(By.cssSelector("div.hotline img=[alt='youtube']")).click();

        switchToWinDowTabByTitle("Kyna.vn - YouTube");

        Assert.assertEquals(driver.findElement(By.cssSelector("div#inner-header-container yt-formatted-string#text")).getText(), "Kyna.vn");
    }

    @Test
    public void TC_03_() {
        driver.get("http://live.techpanda.org/");

        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product IPhone has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        sleepInSecond(2);

        switchToWinDowTabByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'page-title')]/h1")).getText(), "COMPARE PRODUCTS");

//        switchToWinDowTabByTitle("Mobile");
        closeAllWindowWithoutParent(parentID);
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Samsung");
        driver.findElement(By.xpath("//button[@title='Search']")).click();
        sleepInSecond(5);
    }

    @Test
    public void TC_04_Selenium_v4() {
        //Driver đang ở trang Home
        driver.get("https://skills.kynaenglish.vn/");
        System.out.println("Driver ID= " + driver.toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //New 1 tab mới/ window mới
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://skills.kynaenglish.vn/phan-tich-ky-thuat-trong-chung-khoan");
        System.out.println("Driver ID= " + driver.toString());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("a.crs-btn-buy")).click();
        sleepInSecond(2);

        //Tại Window này - new Tab mới - driver nhảy qua tab mới đó từ Window trước đó
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/kyna.vn");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("a@gmail.com");
        sleepInSecond(2);

        switchToWinDowTabByTitle("Kyna.vn - Học online cùng chuyên gia");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Java");
        sleepInSecond(2);
        driver.findElement(By.cssSelector("button.search-button")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(), "Lập trình Java trong 4 tuần");
    }

    @Test
    public void TC_05_Cambridge_Dictionary() {
        driver.get("https://dictionary.cambridge.org/vi/");
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();

        switchToWinDowTabByTitle("Login");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//form[@id='gigya-login-form']//input[@name='username']/following-sibling::span")).getText(), "This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//form[@id='gigya-login-form']//input[@name='password']/following-sibling::span")).getText(), "This field is required");

        closeAllWindowWithoutParent(parentID);
        driver.findElement(By.xpath("//input[@id='searchword']")).sendKeys("morning");
        driver.findElement(By.xpath("//form[@id='searchForm']//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page']//div[@class='pr dictionary' and @data-id='cald4']//span[contains(@class,'headword')]/span")).getText(), "morning");
    }

    @Test
    public void TC_06_Havard() {
        driver.get("https://courses.dce.harvard.edu/");

        driver.findElement(By.xpath("//div[@class='banner__auth']//a")).click();

        switchToWinDowTabByTitle("Harvard Division of Continuing Education Login Portal");

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='DCE Login Portal']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void switchToWinDowTabById(String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWinDowTabByTitle(String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);

            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

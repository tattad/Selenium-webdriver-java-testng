package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_14_Actions {

    WebDriver driver;

    Actions actions;

    String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    public void TC_01_Hover_Tooltip() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.id("age"));

        actions.moveToElement(ageTextbox).perform();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.className("ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover() {
        driver.get("https://www.myntra.com/");

        actions.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"))).perform();
        sleepInSecond(2);

        actions.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title-title']")).getText(), "Kids Home Bath");
    }

    @Test
    public void TC_03_Hover() {
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
        sleepInSecond(2);

        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Đồ Chơi Theo Thương Hiệu']"))).perform();
        sleepInSecond(2);

        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Barbie']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong")).getText(), "ĐỒ CHƠI BARBIE");

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Đồ Chơi Barbie']")).isDisplayed());
    }

    @Test
    public void TC_04_Click_And_Hold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> number = driver.findElements(By.xpath("//li[contains(@class,'ui-state-default')]"));

        Assert.assertEquals(number.size(), 20);

        actions.clickAndHold(number.get(0)).moveToElement(number.get(6)).release().perform();

        List<WebElement> selectedNumber = driver.findElements(By.xpath("//li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(selectedNumber.size(), 6);
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

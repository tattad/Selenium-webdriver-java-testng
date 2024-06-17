package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_28_Wait_07_Explicit_03 {

    WebDriver driver;

    WebDriverWait explicitWait;

    String projectPath = System.getProperty("user.dir");

    String croptopName = "croptop.jpg";
    String kemdaName = "kemda.jpg";
    String vaynganName = "vayngan.jpg";

    String croptopFilePath = projectPath + File.separator + "uploadFiles" + File.separator + croptopName;
    String kemdaFilePath = projectPath + File.separator + "uploadFiles" + File.separator + kemdaName;
    String vaynganFilePath = projectPath + File.separator + "uploadFiles" + File.separator + vaynganName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_AjaxLoading() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        By selectedDate = By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']");

        Assert.assertEquals(driver.findElement(selectedDate).getText(), "No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='12']")).click();

        //Chờ cho loading icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'RadCalendar1')]/div[@class='raDiv']")));

        Assert.assertEquals(driver.findElement(selectedDate).getText(), "Wednesday, June 12, 2024");
    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/welcome");

        //Wait + Verify spinner icon biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']"))));

        //Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ajaxLink']/button"))).click();

        //Wait + Verify spinner icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='spinner-border']"))));

        driver.findElement(By.xpath("//input[@id='filesUploadInput']")).sendKeys(croptopFilePath + "\n" + kemdaFilePath + "\n" + vaynganFilePath);

        //Wait + Verify spinner icon biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='spinner-border']"))));

        //Wait + Verify progress bar biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[contains(@class,'progress pos')]"))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'mainUploadSuccessLink')]//a[@class='ajaxLink']"))).click();

        //Wait + Verify button Play có tại từng hình được upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + croptopName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + kemdaName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + vaynganName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());

        //Wait + Verify button Download có tại từng hình được upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + croptopName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + kemdaName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + vaynganName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
    }

    @Test
    public void TC_03_Greater_Than_5_Second() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

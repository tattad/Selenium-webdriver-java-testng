package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_21_Upload_File {

    WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        //Window: \\
//        String filePath = "C:\\Users\\dat.tran\\Desktop\\kemda.jpg";

        //Mac: / Volumn/Users/dat.tran/Desktop/kemda.jpg

        //File này nằm ở đâu -> trong thư mục upload file

        //Nếu máy khác dùng OS khác chạy được không?

        By uploadBy = By.xpath("//input[@type='file']");

        driver.findElement(uploadBy).sendKeys(croptopFilePath);
        sleepInSecond(2);
        driver.findElement(uploadBy).sendKeys(kemdaFilePath);
        sleepInSecond(2);
        driver.findElement(uploadBy).sendKeys(vaynganFilePath);
        sleepInSecond(2);

        //Verify files load success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + croptopName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + kemdaName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vaynganName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.xpath("//td//button[contains(@class,'start')]"));

        //Classic for
        for (int i = 0; i < startButtons.size(); i++) {
            if (startButtons.get(i).isDisplayed()) {
                startButtons.get(i).click();
                sleepInSecond(2);
            }
        }

        //For-each
//        for (WebElement button : startButtons) {
//            button.click();
//            sleepInSecond(2);
//        }

        //Verify upload success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + croptopName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + kemdaName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + vaynganName + "']")).isDisplayed());
    }

    @Test
    public void TC_02_Multi_Files() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.xpath("//input[@type='file']");

        driver.findElement(uploadBy).sendKeys(croptopFilePath + "\n" + kemdaFilePath + "\n" + vaynganFilePath);
        sleepInSecond(2);

        //Verify files load success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + croptopName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + kemdaName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vaynganName + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.xpath("//td//button[contains(@class,'start')]"));

        //Classic for
        for (int i = 0; i < startButtons.size(); i++) {
            if (startButtons.get(i).isDisplayed()) {
                startButtons.get(i).click();
                sleepInSecond(2);
            }
        }

        //Verify upload success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + croptopName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + kemdaName + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + vaynganName + "']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

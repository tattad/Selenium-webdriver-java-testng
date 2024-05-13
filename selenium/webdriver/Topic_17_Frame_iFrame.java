package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Frame_iFrame {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Form_Site() {
        driver.get("https://skills.kynaenglish.vn/");

        //Switch vào iframe chứa fanpage
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));

        //Verify followers number
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(), "169K followers");

        //Switch về trang default/parent chứa iframe
        driver.switchTo().defaultContent();

        //Switch vào iframe weChat
        driver.switchTo().frame("cs_chat_iframe");
        driver.findElement(By.cssSelector("div.button_bar")).click();

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("Hello World");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0923456789");
        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Dky khoá học");

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Java");
        driver.findElement(By.cssSelector("button.search-button ")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(), "Lập trình Java trong 4 tuần");
    }

    @Test
    public void TC_02_KynaEnglish() {
        //Trang A - domain: formsite.com
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        /*//Chứa iframe - trang B
        //Từ A vào B
        driver.switchTo().frame("frame-one85593366");
        driver.findElement(By.cssSelector("")).click();
        //Từ B vào C
        driver.switchTo().frame("frame-23232");
        driver.findElement(By.cssSelector("")).click();
        //Từ C quay lại B
        driver.switchTo().parentFrame();
        //Đang ở B
        //Từ B quay lại A
        driver.switchTo().defaultContent();*/

        driver.findElement(By.xpath("//div[@id='imageTemplateContainer']/img")).click();
        sleepInSecond(5);

        //Iframe element
        WebElement formIframe = driver.findElement(By.xpath("//div[@id='formTemplateContainer']/iframe"));

        Assert.assertTrue(formIframe.isDisplayed());

        //Switch frame/ iframe trước khi thao tác với các element bên trong
//        driver.switchTo().frame(0); //index không chính xác
//        driver.switchTo().frame(""); //có trường hợp frame không có name/ id
        driver.switchTo().frame(formIframe);

        new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-2']"))).selectByVisibleText("Sophomore");
        sleepInSecond(2);

        //switch ra lại trang A
        driver.switchTo().defaultContent();

        //thao tác với 1 element nằm ngoài iframe
        driver.findElement(By.xpath("//nav[contains(@class,'header--desktop-floater')]//a[@title='Log in']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//button[@id='login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='message-error']")).getText(), "Username and password are both required.");
    }

    @Test
    public void TC_03_Frame_HDFC_Bank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("tada1234");

        driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
        sleepInSecond(2);

        driver.switchTo().defaultContent();

        WebElement password = driver.findElement(By.id("keyboard"));
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("123456789");
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

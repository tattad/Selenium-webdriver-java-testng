package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Topic_13_Alert {

    WebDriver driver;
    WebDriverWait explicitWait;

    String projectLocation = System.getProperty("user.dir");

    By resultText = By.xpath("//p[@id='result']");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSecond(1);

        //Cancel alert -> void dismiss();
        //Accept alert -> void accept();
        //Get text trong alert ra -> String getText();
        //Nhập text vào alert -> void sendKeys(String keysToSend)

        //Chờ cho alert xuất hiện
        //Nếu trong thời gian chờ mà xuất hiện thì tự switch vào
        //Nếu hết thời gian chờ mà chưa xuất hiện mới fail
        Alert acceptAlert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSecond(2);

//        Alert jsAlert = driver.switchTo().alert();

        Assert.assertEquals(acceptAlert.getText(), "I am a JS Alert");

        //Khi mình accept/ cancel rồi thì alert sẽ mất luôn
        acceptAlert.accept();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");
    }

    @Test
    public void TC_02_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        sleepInSecond(1);

        Alert confirmAlert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(confirmAlert.getText(), "I am a JS Confirm");
        confirmAlert.dismiss();

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInSecond(1);

        Alert promprAlert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(promprAlert.getText(), "I am a JS prompt");

        String text = "I am Iron man";
        promprAlert.sendKeys(text);
        sleepInSecond(2);

        promprAlert.accept();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: " + text);
    }

    @Test
    public void TC_04_Authentication_AutoIT() throws IOException {
        String username = "admin";
        String password = "admin";

        //Thư viện alert không sử dụng cho Authentication Alert
        //Sử dụng Chrome devtool protocol
        driver.get("http://" + username + ":" + password + "the-internet.herokuapp.com/basic_auth");

        //Cách 1: truyền thẳng user/pass vào URL
//        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        //Cách 2: Chỉ chạy trên window (AutoIT), không dùng cho Mac/Linux
        //Thực thi đoạn code AutoIT để chờ Alert xuất hiện
        Runtime.getRuntime().exec(new String[]{projectLocation + "\\autoIT\\authen_firefox.exe", "admin", "admin@"});
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        sleepInSecond(2);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_05_Authentication_Pass_To_Url() {
        String username = "admin";
        String password = "admin";

        //Từ page A thao tác lên 1 element nó sẽ qua page B (Cần phải thao tác vs Authen Alert trước)
        driver.get("http://the-internet.herokuapp.com/");

        String authenLinkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
//        System.out.println(authenLinkUrl);
//
//        String[] authenArray = authenLinkUrl.split("//");
//        System.out.println(authenArray[0]);
//        System.out.println(authenArray[1]);
//        driver.get(authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]);

        driver.get(getAuthenAlertByUrl(authenLinkUrl, username, password));

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_06_Authentication_Selenium_4x() {
        //Cách 3
        //Thư viện Alert không sử dụng cho Authentication Alert
        //Dùng Chrome Devtool Protocl

        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new FirefoxDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();

        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
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

    public String getAuthenAlertByUrl(String url, String username, String password) {
        String[] authenArray = url.split("//");

        return authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1];
    }
}

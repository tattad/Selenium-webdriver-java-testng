package demoPenguin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoPenguin_Win {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass(){
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Demo_01_Submit_Order() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://penguin.stage-ap.apps.bsci.com/");

        //Click on Non BSCS Account
        driver.findElement(By.xpath("//span[contains(text(),'Non BSC Account')]")).click();
        //Input User name
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("qc_salereptada");
        //Input Password
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("1234567890@dNam");
        //Click Login button
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();

        // Chon country
//        driver.findElement(By.xpath("//span[text()='ANZ']")).click();

        //Chọn Order menu
        driver.findElement(By.xpath("//span[text()='Order']")).click();

        //Cho 3s
        WebElement demoOrder = driver.findElement(By.xpath("//a[@title='Demo (NFHU)']"));
        js.executeScript("arguments[0].scrollIntoView(true);",demoOrder);
        Thread.sleep(3000);
        demoOrder.click();

        //Expand dropdown
        WebElement customerDropdown = driver.findElement(By.xpath("//nz-select-placeholder[contains(text(),'Select Account Name')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(customerDropdown).click().perform();

        //Chon customer
        driver.findElement(By.xpath("//nz-option-item[@title='585434 - ABBIE HANS']")).click();
        Thread.sleep(3000);

        //Click Next button
        driver.findElement(By.xpath("//span[contains(text(),' Next ')]")).click();

        //Chon Division dropdown
        driver.findElement(By.xpath("//label[contains(text(),'Division')]/following-sibling::app-choose-division")).click();

        //Chon Divison IC
        driver.findElement(By.xpath("//div[text()='IC']")).click();

        //Nhap UPN
        driver.findElement(By.xpath("//input[@placeholder='Enter UPN/Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter UPN/Name']")).sendKeys("H74939309020");

        //Click Search button
        driver.findElement(By.xpath("//input[@placeholder='Enter UPN/Name']/parent::nz-input-group/parent::app-search-input-layout/parent::div/following-sibling::button/span[contains(text(),'Search')]"))
                .click();

        //Tang qty
        Thread.sleep(3000);
        driver.findElement(By.className("plus")).click();

        //Add to cart
        WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",addToCart);
        Thread.sleep(3000);
        addToCart.click();

        //Check your cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Check Your Cart')]")).click();

        //Go to Step 3
        driver.findElement(By.xpath("//span[contains(text(),'Go to Order Confirm')]")).click();

        //Input Business Justification
        driver.findElement(By.xpath("//input[@placeholder='Enter Business Justification']")).sendKeys("autoDemo");
        Thread.sleep(3000);

        //Click submit button
        WebElement submitButton = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
        js.executeScript("arguments[0].click();",submitButton);
//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Luu MyOrder No
        WebElement myOrderNo = driver.findElement(By.xpath("//span[contains(text(),'MyOrder No.')]/following-sibling::span"));
        myOrderNo.getText();
        Thread.sleep(3000);

        //Subscribe
        driver.findElement(By.xpath("//button[contains(text(),'Subscribe')]")).click();
        Thread.sleep(2000);

        //Logout
        driver.findElement(By.className("text")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")).click();

        //Login as CC
        driver.findElement(By.xpath("//span[contains(text(),'Non BSC Account')]")).click();
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("qc_cctada");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("1234567890@DnAm");
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();

        //Go to CC check
        driver.findElement(By.xpath("//a[@title='CC Check']")).click();

        js.executeScript("arguments[0].click();",myOrderNo);
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
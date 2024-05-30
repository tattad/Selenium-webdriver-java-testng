package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_20_JavaScriptExecutor {

    WebDriver driver;

    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01() {
//        driver.get("http://live.techpanda.org/");

//        jsExecutor.executeScript("window.location = 'http://live.techpanda.org'");
//        sleepInSecond(2);

//        executeForBrowser("window.location = 'http://live.techpanda.org'");
        navigateToUrlByJS("http://live.techpanda.org");
        sleepInSecond(5);

        //Verify domain
        String techPandaDomain = (String) executeForBrowser("return document.domain");
        Assert.assertEquals(techPandaDomain, "live.techpanda.org");

        //Verify URL
        String homePageUrl = (String) executeForBrowser("return document.URL");
        Assert.assertEquals(homePageUrl, "http://live.techpanda.org/");

        //Open Mobile page
        hightlightElement("//a[text()='Mobile']");
        clickToElementByJS("//a[text()='Mobile']");

        //Add Samsung Galaxy to cart
        hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        //Verify message
        Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

        //Open Customer Service page
        hightlightElement("//a[text()='Customer Service']");
        clickToElementByJS("//a[text()='Customer Service']");

        String customerTitle = (String) executeForBrowser("return document.title;");
        Assert.assertEquals(customerTitle, "Customer Service");

        //Scroll to element Newsletter
        scrollToBottomPage();

        //Input email
        hightlightElement("//input[@id='newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']", getEmailAddress());

        //Click on Subscribe button
        hightlightElement("//button[@title='Subscribe']");
        clickToElementByJS("//button[@title='Subscribe']");

        //Verify text
        Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
        Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));

        //Navigate to other page
        navigateToUrlByJS("https://www.facebook.com/");

        //Verify domain
        Assert.assertEquals(executeForBrowser("return document.domain"), "facebook.com");
    }

    @Test
    public void TC_02() {
        driver.get("https://sieuthimaymocthietbi.com/account/register");

        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='lastName']"), "Please fill in this field.");

        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='firstName']"), "Please fill in this field.");

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Testing");
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill in this field.");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a@bb@c");
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        sleepInSecond(2);

        Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please enter an email address.");
    }

    @Test
    public void TC_03() {

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

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "penguin" + rand.nextInt(9999999) + "@gmail.com";
    }
}

package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_14_Actions {

    WebDriver driver;

    Actions actions;

    String fullName;

    JavascriptExecutor jsExecutor;

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
        jsExecutor = (JavascriptExecutor) driver;
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

        String osName = System.getProperty("os.name");
        Keys keys;

        //Cách 1
//        if (osName.startsWith("Window")) {
//            keys = Keys.CONTROL;
//        } else {
//            keys = Keys.COMMAND;
//        }

        //Cách 2
        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        List<WebElement> number = driver.findElements(By.xpath("//li[contains(@class,'ui-state-default')]"));

        Assert.assertEquals(number.size(), 20);

        actions.clickAndHold(number.get(0)).moveToElement(number.get(7)).release().perform();

        actions.keyDown(cmdCtrl).perform();

        actions.click(number.get(8))
                .click(number.get(9))
                .click(number.get(10))
                .keyUp(cmdCtrl).perform();
        sleepInSecond(3);

//        List<String> expectedNumbers = new ArrayList<String>();
//        expectedNumbers.add("1");
//        expectedNumbers.add("2");
//        expectedNumbers.add("3");
//        expectedNumbers.add("5");
//        expectedNumbers.add("6");
//        expectedNumbers.add("7");

        List<WebElement> selectedNumber = driver.findElements(By.xpath("//li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(selectedNumber.size(), 11);

//        List<String> actualNumbers = new ArrayList<String>();
//
//        for (WebElement element : selectedNumber) {
//            actualNumbers.add(element.getText());
//        }
//
//        Assert.assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void TC_05() {
        driver.get("https://automationfc.github.io/jquery-selectable/");


    }

    @Test
    public void TC_06_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));

//        //Cần scroll tới element rồi mới double click
//        if(driver.toString().contains("chrome")){
//            actions.scrollToElement(doubleClickButton).perform();
//            sleepInSecond(2);
//        }

        if (driver.toString().contains("firefox")) {
            //scrollIntoView(true): kéo mép trên của element lên phía trên của viewport
            //scrollIntoView(false): kéo mép dưới của element xuống phía dưới cùng của viewport
            jsExecutor.executeScript("arguments[0].scrollIntoView(false)", doubleClickButton);
            sleepInSecond(2);
        } else {
            actions.scrollToElement(doubleClickButton).perform();
            sleepInSecond(2);
        }

        actions.doubleClick(doubleClickButton).perform();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.id("demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_07_Right_Click() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement pasteOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-paste')]")),
                cutOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-cut')]")),
                editOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-edit')]")),
                copyOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-copy')]")),
                deleteOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-delete')]")),
                quitOption = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]")),
                rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));

        //Chưa click chuột phải thì nó đang chưa hiển thị (invisible)
        Assert.assertFalse(pasteOption.isDisplayed());

        actions.contextClick(rightClickButton).perform();
        sleepInSecond(2);

        Assert.assertTrue(pasteOption.isDisplayed());
        actions.moveToElement(pasteOption).perform();
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-paste context-menu-hover context-menu-visible')]")).isDisplayed());

        actions.click(pasteOption).perform();
        sleepInSecond(1);
        driver.switchTo().alert().accept();
        sleepInSecond(2);

        Assert.assertFalse(pasteOption.isDisplayed());

        //Edit
        actions.contextClick(rightClickButton).perform();
        sleepInSecond(1);
        Assert.assertTrue(editOption.isDisplayed());
        actions.moveToElement(editOption).perform();
        sleepInSecond(1);
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-edit context-menu-hover context-menu-visible')]")).isDisplayed());
        actions.click(editOption).perform();
        driver.switchTo().alert().accept();
        sleepInSecond(1);
        Assert.assertFalse(editOption.isDisplayed());

        //Cut
        //Copy
        //Delete
        //Quit
    }

    @Test
    public void TC_08_Drag_And_Drop_HTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement smallCircle = driver.findElement(By.id("draggable")),
                bigCircle = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(smallCircle, bigCircle).perform(); //Cách 1
//        actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform(); //Cách 2
        sleepInSecond(1);

        Assert.assertEquals(bigCircle.getText(), "You did great!");

        Assert.assertEquals(Color.fromString(bigCircle.getCssValue("background-color")).asHex().toLowerCase(), "#03a9f4");
    }

    @Test
    public void TC_09_Drag_And_Drop_HTML5_Css() throws IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        WebElement A = driver.findElement(By.cssSelector("div#column-a")),
                B = driver.findElement(By.cssSelector("div#column-b"));

//        actions.dragAndDrop(A,B).perform();
//        actions.clickAndHold(A).moveToElement(B).release().perform();
//        sleepInSecond(2);

        String projectPath = System.getProperty("user.dir");
        String dragAndDropFilePath = projectPath + "/dragAndDrop/drag_and_drop_helper.js";
        String jsContentFile = getContentFile(dragAndDropFilePath);

        jsContentFile = jsContentFile + "$('div#column-a').simulateDragDrop({ dropTarget: 'div#column-b'});";

        jsExecutor.executeScript(jsContentFile);
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
    }

    @Test
    public void TC_09_Drag_And_Drop_HTML5_Xpath() throws AWTException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        dragAndDropHTML5ByXpath("//div[@id='column-a']","//div[@id='column-b']");

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
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

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            stream.close();
        }
    }
}

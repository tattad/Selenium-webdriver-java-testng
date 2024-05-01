package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_11_12_Button_Radio_Checkbox {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_Demo() {
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.id("button2"));

        //Verify button bị disable khi chưa click vào checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.id("chinhSach")).click();
        sleepInSecond(1);

        //Verify button đã được enable sau khi click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        //Lấy ra mã màu nền của button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB: " + registerBackgroundRGB);

        //Convert từ kiểu String (mã RGB) qua kiểu Color
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        //Convert qua kiểu Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("Background color Hexa: " + registerBackgroundHexa);
    }

    @Test
    public void TC_01_Fahasa() {
        driver.get("https://www.fahasa.com/customer/account/create");

        //Chuyển qua tab Đăng nhập
        driver.findElement(By.xpath("//li[@class='popup-login-tab-item popup-login-tab-login']")).click();
        sleepInSecond(2);

        WebElement loginButton = driver.findElement(By.className("fhs-btn-login"));

        //Verify login button is disabled
        Assert.assertFalse(loginButton.isEnabled());

        //Verify login button background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        //Nhập email, password
        driver.findElement(By.id("login_username")).sendKeys("0909090909");
        driver.findElement(By.id("login_password")).sendKeys("123456");

        //Verify login button is disabled
        Assert.assertTrue(loginButton.isEnabled());

        //Verify login button background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");

    }

    @Test
    public void TC_02_Default_Checkbox_Radio_Button() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSecond(3);

        WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input"));
        dualZoneCheckbox.click();
        Assert.assertTrue(dualZoneCheckbox.isSelected());
        sleepInSecond(1);

        dualZoneCheckbox.click();
        Assert.assertFalse(dualZoneCheckbox.isSelected());
        sleepInSecond(1);

        WebElement rainSensorCheckbox = driver.findElement(By.xpath("//label[text()='Rain sensor']/preceding-sibling::span/input"));
        tickChecbox(rainSensorCheckbox);
        Assert.assertTrue(rainSensorCheckbox.isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        sleepInSecond(2);

        WebElement petro147 = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input"));
        tickChecbox(petro147);
        Assert.assertTrue(petro147.isSelected());
    }

    @Test
    public void TC_03_Default_Checkbox_Radio_Button() {
        driver.get("https://material.angular.io/components/radio/examples");
        sleepInSecond(1);

        WebElement summerRadio = driver.findElement(By.id("mat-radio-4-input"));
        tickChecbox(summerRadio);
        Assert.assertTrue(summerRadio.isSelected());

        driver.get("https://material.angular.io/components/checkbox/examples");

        WebElement checkedCheckbox = driver.findElement(By.id("mat-mdc-checkbox-1-input"));
        WebElement indeterminateCheckbox = driver.findElement(By.id("mat-mdc-checkbox-2-input"));

        tickChecbox(checkedCheckbox);
        tickChecbox(indeterminateCheckbox);

        Assert.assertTrue(checkedCheckbox.isSelected());
        Assert.assertTrue(indeterminateCheckbox.isSelected());

        untickCheckbox(checkedCheckbox);
        untickCheckbox(indeterminateCheckbox);

        Assert.assertFalse(checkedCheckbox.isSelected());
        Assert.assertFalse(indeterminateCheckbox.isSelected());
    }

    @Test
    public void TC_04_Select_All_Checkboxes() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));

        //Chọn hết tất cả các checkbox trong màn hình đó
        for (WebElement checkbox : allCheckboxes) {
            tickChecbox(checkbox);
        }

        //Verify hết tất cả các checkbox
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));

        //Chọn 1 checkbox/ radio nào đó trong tất cả các checkbox/radio
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()) {
                checkbox.click();
                sleepInSecond(1);
            }
        }

        //Verify hết tất cả các checkbox
        for (WebElement checbox : allCheckboxes) {
            if (checbox.getAttribute("value").equals("Heart Attack")) {
                Assert.assertTrue(checbox.isSelected());
            } else {
                Assert.assertFalse(checbox.isSelected());
            }
        }
    }

    @Test
    public void TC_06_Custom_Checkbox() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        sleepInSecond(1);

        WebElement canThoRadio = driver.findElement(By.xpath("//span[text()='Cần Thơ']/parent::div/parent::div/preceding-sibling::div/div"));
        Assert.assertTrue(canThoRadio.getAttribute("aria-checked").equals("false"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        canThoRadio.click();
        Assert.assertTrue(canThoRadio.getAttribute("aria-checked").equals("true"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void tickChecbox(WebElement checkElement) {
        if (!checkElement.isSelected()) {
            checkElement.click();
        }
    }

    public void untickCheckbox(WebElement checkElement) {
        if (checkElement.isSelected()) {
            checkElement.click();
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

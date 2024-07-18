package javaTester.javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Switch_Case {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Parameters("browser")
    public void TC_01(String browserName) {
        driver = getBrowserDriver(browserName);

        System.out.println(browserName);
        System.out.println(driver.toString());

        driver.quit();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //BT 01
        /*int a = scanner.nextInt();
        switch (a) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
        }*/

        //BT 03
        /*int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
                break;
            default:
                System.out.println("Tháng " + month + " không tồn tại.");
                break;
        }*/

        //BT 04
        /*int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();
        switch (operator) {
            case "+":
                System.out.println(a + "+" + b + "=" + (a + b));
                break;
            case "-":
                System.out.println(a + "-" + b + "=" + (a - b));
                break;
            case "*":
                System.out.println(a + "x" + b + "=" + (a * b));
                break;
            case "/":
                System.out.println(a + "/" + b + "=" + (a / b));
                break;
            case "%":
                System.out.println(a + "%" + b + "=" + (a % b));
                break;
        }*/
    }

    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
                driver = new EdgeDriver();
                break;
            default:
                new RuntimeException("Please input correct the browser name!");
                break;
        }
        return driver;
    }
}

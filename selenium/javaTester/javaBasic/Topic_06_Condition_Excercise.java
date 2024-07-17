package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

public class Topic_06_Condition_Excercise {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int afterNumber = number % 2;
        System.out.println(afterNumber);

        boolean status = afterNumber == 0;
        System.out.println(status);

        if (status) {
            System.out.println("Số: " + number + " là số chẵn");
        } else {
            System.out.println("Số: " + number + " là số lẻ");
        }
    }
}

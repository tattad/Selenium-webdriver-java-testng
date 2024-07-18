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

        //BT 01
        /*int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Số: " + number + " là số chẵn");
        } else {
            System.out.println("Số: " + number + " là số lẻ");
        }*/

        //BT 02
        /*int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a > b) {
            System.out.println(a + " lớn hơn " + b);
        } else if (a == b) {
            System.out.println(a + " bằng " + b);
        } else {
            System.out.println(a + " nhỏ hơn " + b);
        }*/

        //BT 03
        /*String nameA = scanner.nextLine();
        String nameB = scanner.nextLine();
        if (nameA.equals(nameB)) {
            System.out.println("Hai sinh viên giống tên nhau");
        } else {
            System.out.println("Hai sinh viên khác tên nhau");
        }*/

        //BT 04
        /*int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a > b && a > c) {
            System.out.println("Số lớn nhất là: " + a);
        } else if (b > a && b > c) {
            System.out.println("Số lớn nhất là: " + b);
        } else {
            System.out.println("Số lớn nhất là: " + c);
        }*/

        //BT 05
        /*int a = scanner.nextInt();
        if (10 <= a && a <= 100) {
            System.out.println(a + " nằm trong khoảng 10 tới 100");
        } else {
            System.out.println(a + " nằm ngoài khoảng 10 tới 100");
        }*/

        //BT 06
        /*float a = scanner.nextFloat();
        if (8.5 <= a && a <= 10) {
            System.out.println("Grade A");
        } else if (7.5 <= a && a < 8.5) {
            System.out.println("Grade B");
        } else if (5 <= a && a < 7.5) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade D");
        }*/

        //BT 07
        int month = scanner.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println("Tháng " + month + " có 31 ngày");
        } else if (month == 4 || month == 6 || month == 9 || month == 1) {
            System.out.println("Tháng " + month + " có 30 ngày");
        } else if (month == 2) {
            System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
        } else {
            System.out.println("Tháng " + month + " không tồn tại.");
        }
    }
}

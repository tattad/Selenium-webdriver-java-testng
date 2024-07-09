package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
    //Primitive type/ value type: Kiểu dữ liệu nguyên thuỷ
    byte bNumber = 8;
    short sNumber = 8000;
    int iNumber = 88000;
    long lNumber = 88000;
    float fNumber = 15.99f;
    double dNumber = 15.99d;
    char cChar = '1';
    boolean bStatus = false;

    //Reference type: Kiểu dữ liệu tham chiếu
    //String
    String address = "Ho Chi Minh";
    //Array
    String[] studentAddress = {address, "Ha Noi", "Da Nang"};
    Integer[] studentNumber = {15, 20, 50};
    //Class
    Topic_02_Data_Type topic;
    //Interface
    WebDriver driver;
    //Object
    Object aObject;
    //Collections
    //List/ Set/ Queue/ Map
    List<WebElement> homoePageLinks = driver.findElements(By.tagName("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productName = new ArrayList<String>();

    public void clickToElement() {
        address.trim();
        studentAddress.clone();
        driver.getCurrentUrl();
        aObject.toString();
        homoePageLinks.size();
        allWindows.clear();

        Topic_02_Data_Type topic = new Topic_02_Data_Type();
        topic.address = "Ha Noi";
    }

   /* //Global variable
    static int number;

    String address = "Ho Chi Minh";*/

    public static void main(String[] args) {
       /* //Local variable
        int studentNumber = 0;

        System.out.println(number);

        Topic_02_Data_Type topic = new Topic_02_Data_Type();
        System.out.println(topic.address);

        System.out.println(studentNumber);*/
    }
}

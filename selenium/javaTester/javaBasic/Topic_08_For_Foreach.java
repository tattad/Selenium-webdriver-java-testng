package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_Foreach {
    WebDriver driver;

    @Test
    public void TC_01_For() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

//        List<WebElement> links = driver.findElements(By.id(""));
//        links.size();

        //Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};
        for (int i = 0; i < cityName.length; i++) {
            System.out.println(cityName[i]);
        }
    }
}

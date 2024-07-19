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

    @Test
    public void TC_02_For_Each() {
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};

        List<String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa Pa");

        System.out.println(cityAddress.size());

        for (String city : cityName) {
            cityAddress.add(city);
        }

        System.out.println(cityAddress.size());

        for (String cityAdd : cityAddress) {
            System.out.println(cityAdd);
        }

        List<WebElement> buttons = driver.findElements(By.xpath(""));
        for (WebElement webElement : buttons) {

        }
    }
}

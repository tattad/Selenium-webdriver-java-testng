package javaTester.javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Excercise {

    @Test
    public void TC_01() {
        int a = 6;
        int b = 2;

        System.out.println("Tổng = " + (a + b));
        System.out.println("Hiệu = " + (a - b));
        System.out.println("Tích = " + (a * b));
        System.out.println("Thương = " + (a / b));
    }

    @Test
    public void TC_02() {
        float width = 7.5f;
        float height = 3.8f;

        System.out.println("Diện tích tam giác: " + (width * height));
    }

    @Test
    public void TC_03() {
        String name = "Automation Testing";

        System.out.println("Hello " + name);
    }
}

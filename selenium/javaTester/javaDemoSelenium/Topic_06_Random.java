package javaTester.javaDemoSelenium;

import java.util.Random;

public class Topic_06_Random {
    //Java Buitin (Có sẵn - chỉ cần lấy ra sử dụng)
    //Java Libraries (Do 1 cá nhân/ tổ chức họ tự viết)

    public static void main(String[] args) {
        Random rand = new Random();
        rand.nextInt(999);

        System.out.println("tada" + rand.nextInt(9999999) + "@gmail.com");
        System.out.println("tada" + rand.nextInt(9999999) + "@gmail.com");
        System.out.println("tada" + rand.nextInt(9999999) + "@gmail.com");
        System.out.println("tada" + rand.nextInt(9999999) + "@gmail.com");
    }
}

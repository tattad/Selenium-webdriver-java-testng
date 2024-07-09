package javaTester.javaBasic;

import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Topic_04_Excercise {

    @Test
    public void swapNumber() {
        int a = 5;
        int b = 6;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten: ");
        String hoten = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();

        System.out.printf("After 15 years, age of " + hoten + " will be " + (age + 15));
    }
}

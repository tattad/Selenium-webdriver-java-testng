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

        //BT 01
        /*System.out.print("Nhap ten: ");
        String hoten = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = sc.nextInt();
        System.out.printf("After 15 years, age of " + hoten + " will be " + (age + 15));*/

        //BT02
        /*System.out.print("Nhap a = ");
        Integer a = Integer.valueOf(sc.nextLine());
        System.out.print("Nhap b = ");
        Integer b = Integer.valueOf(sc.nextLine());
        Integer c = 0;
        c = a;
        a = b;
        b = c;
        System.out.println("After swapping then a = " + a + ", b = " + b);*/

        //BT03
        /*System.out.print("Nhap a = ");
        Integer a = Integer.valueOf(sc.nextLine());
        System.out.print("Nhap b = ");
        Integer b = Integer.valueOf(sc.nextLine());
        if (a >= b) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }*/
    }
}

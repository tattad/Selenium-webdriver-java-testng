package javaTester.javaBasic;

public class Topic_04_Operator {

    public static void main(String[] args) {
        int number = 10;

//        number += 5;
//        //number = number + 5;
//        System.out.println(number);
//
//        //15/5 = 3
//        System.out.println(number / 5);
//        //15/7 = 2 dư 3
//        System.out.println(number % 7);

        System.out.println(number++);
        // in number ra trước: 10
        //rồi tăng lên 11

        System.out.println(++number);
        //tăng lên 12 trước
        //rồi mới in

        int firstVariable = 5, secondVariable = 7;
        int result = firstVariable++ + ++secondVariable - 8;
        System.out.println("First variable = " + firstVariable);

        System.out.println("Second variable = " + secondVariable);
        System.out.println("Third variable = " + result);

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }

        String address = "Ho Chi Minh";
        if (address != "Ha Noi" && address != "Da Nang") {
            System.out.println("Address is not the same");
        }

        boolean status = (address == "Ha Noi") ? true : false;
        System.out.println(status);

        int ten = 10, twenty = 20, thirty = 30;
        System.out.println("Lớn hơn = " + (ten > twenty));
        System.out.println("Lớn hơn hoặc bằng = " + (thirty >= twenty));
        System.out.println("Nhỏ hơn = " + (thirty < twenty));
        System.out.println("Nhỏ hơn hoặc bằng = " + (thirty <= twenty));
        System.out.println("Bằng bằng = " + (thirty == ten + twenty));
        System.out.println("Khác bằng = " + (thirty != twenty + ten));

        int first = 10;
        int second = 20;
        int third = 30;
        boolean bValue;
        int iValue;

        bValue = (third == first + second) ? true : false;
        System.out.println("Gia tri = " + bValue);

        iValue = (third == second + first) ? 50 : 100;
        System.out.println("Ket qua = " + iValue);

        iValue = (!(third == second + first)) ? 50 : 100;
        System.out.println("Phu dinh cua ket qua = " + iValue);
    }
}

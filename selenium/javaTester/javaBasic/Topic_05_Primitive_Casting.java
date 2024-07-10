package javaTester.javaBasic;

public class Topic_05_Primitive_Casting {

    public static void main(String[] args) {
        //Ngầm định = không mất dữ liệu
//        byte bNumber = 126;
//        System.out.println(bNumber);
//        short sNumber = bNumber;
//        System.out.println(sNumber);
//        int iNumber = sNumber;
//        System.out.println(iNumber);
//        long lNumber = iNumber;
//        System.out.println(lNumber);
//        float fNumber = lNumber;
//        System.out.println(fNumber);
//        double dNumber = fNumber;
//        System.out.println(dNumber);

        //Tường minh (Cast)
        double dNumbr = 123456789123123d;
        System.out.println(dNumbr);
        float fNumber = (float) dNumbr;
        System.out.println(fNumber);

        long lNumber = (long) fNumber;
        System.out.println(lNumber);
        int iNumber = (int) lNumber;
        System.out.println(iNumber);
    }
}

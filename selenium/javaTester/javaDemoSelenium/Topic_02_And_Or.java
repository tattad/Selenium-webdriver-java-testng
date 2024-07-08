package javaTester.javaDemoSelenium;

public class Topic_02_And_Or {
    public static void main(String[] args) {
        //Member 1
        boolean member01;
        //Member 2
        boolean member02;
        //Result
        boolean result;

        //AND: chi can 1 trong 2 ma sai => Ket qua se sai
        member01 = true;
        member02 = true;
        System.out.println("Result = " + (member01 && member02));

        member01 = true;
        member02 = false;
        System.out.println("Result = " + (member01 && member02));

        //OR: Chi can 1 trong 2 ma dung => Ket qua se dung
        member01 = true;
        member02 = false;
        System.out.println("Result = " + (member01 || member02));

        //Example (http://live.techpanda.org/index.php/customer/account/login/)
        //input=[@id='pass or @id='email']
    }
}

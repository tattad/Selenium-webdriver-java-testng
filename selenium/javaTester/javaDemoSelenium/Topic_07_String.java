package javaTester.javaDemoSelenium;

public class Topic_07_String {

    public static void main(String[] args) {
        String firstName = "Hom nay";
        String lastName = "an gi";

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        fullName = firstName.concat(" ").concat(lastName);
        System.out.printf(fullName);

        String welcomeMsg = "Welcome " +fullName +" to ABC";
        System.out.printf(welcomeMsg);
    }
}

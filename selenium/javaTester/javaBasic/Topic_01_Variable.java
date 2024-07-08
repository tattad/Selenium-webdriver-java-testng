package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {

    public Topic_01_Variable() {
    }

    static int studentNumber;
    static boolean statusValue;
    static final String BROWSER_NAME = "Chrome";

    static int studentPrice;

    protected String studentName = "Automation FC";

    public static void main(String[] args) {
        int studentPrice = 5;

        System.out.println(studentPrice);

        System.out.println(studentNumber);
        System.out.println(statusValue);
        System.out.println(Topic_01_Variable.BROWSER_NAME);
        System.out.println(Topic_01_Variable.statusValue);

        Topic_01_Variable topic_1 = new Topic_01_Variable();
        Topic_01_Variable topic_2 = new Topic_01_Variable();

        System.out.println(topic_1.studentName);
        System.out.println(topic_2.studentName);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.print(name);
    }

    //Getter: getCurrentURL/ getTitle/ getAttribute/ getCssValue/ getLocation...
    public String getStudentName() {
        return this.studentName;
    }

    //Setter: click/ sendkeys/ clear/ select/ back/ forward/ refresh/ get...
    public void setStudentName(String stdName) {
        this.studentName = stdName;
    }
}

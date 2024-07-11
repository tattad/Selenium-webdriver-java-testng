package javaTester.javaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Topic_05_Reference_Casting {
    protected String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void showStudentName() {
        System.out.println("Student name = " + studentName);
    }

    public static void main(String[] args) {
        Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
        Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();

        firstStudent.setStudentName("ABC 123");
        secondStudent.setStudentName("DEF 456");

        firstStudent.showStudentName();
        secondStudent.showStudentName();

        firstStudent = secondStudent;

        firstStudent.showStudentName();
        secondStudent.showStudentName();

        secondStudent.setStudentName("XZY 789");

        firstStudent.showStudentName();
        secondStudent.showStudentName();

        WebDriver driver = null;

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    }
}

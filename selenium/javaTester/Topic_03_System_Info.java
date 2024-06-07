package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

public class Topic_03_System_Info {
    public static void main(String args[]) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        Keys keys;

        //Window
        //Mac OS
        //Unix
        //Linux Ubuntu/ Fedora

        String projectPath = System.getProperty("user.dir");

        String fileName = "kemda.jpg";

        System.out.println(projectPath + "\\uploadFiles\\" + fileName);

        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;
    }
}

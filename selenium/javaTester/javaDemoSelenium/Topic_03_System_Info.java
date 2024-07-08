package javaTester.javaDemoSelenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import java.io.File;

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

//        System.out.println(projectPath + "\\uploadFiles\\" + fileName);

        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;

        //Cách 1
//        String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";

        //Cách 2
//        File.separator;

        String croptopName = "croptop.jpg";
        String kemdaName = "kemda.jpg";
        String vaynganName = "vayngan.jpg";

        String croptopFilePath = projectPath + File.separator + "uploadFiles" + File.separator + croptopName;
        String kemdaFilePath = projectPath + File.separator + "uploadFiles" + File.separator + kemdaName;
        String vaynganFilePath = projectPath + File.separator + "uploadFiles" + File.separator + vaynganName;

        System.out.println(croptopFilePath);
        System.out.println(kemdaFilePath);
        System.out.println(vaynganFilePath);
    }
}

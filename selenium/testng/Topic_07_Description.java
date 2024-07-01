package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Description {

    @BeforeClass
    public void init() {
        System.out.println("Pre-condition for below testcases");
    }

    @Test(description = "Add new user and search")
    //Hiển thị ở trong log/report HTML
    public void Priority_01_SearchWithDate() {
    }

    @Test
    public void Priority_02_SearchWithBilling() {
    }

    @Test
    public void Priority_03_SearchWithProduct() {
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        System.out.println("Post-condition for below testcases");
    }
}

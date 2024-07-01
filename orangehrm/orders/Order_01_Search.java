package orders;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Order_01_Search {

    @BeforeClass(alwaysRun = true)
    public void init() {
        System.out.println("Pre-condition for below testcases");
    }

    @Test(groups = "order")
    public void testSearchWithDate() {
    }

    @Test(groups = "order")
    public void testSearchWithBilling() {
    }

    @Test(groups = "order")
    public void testSearchWithProduct() {
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        System.out.println("Post-condition for below testcases");
    }
}

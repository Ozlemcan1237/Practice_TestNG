package tests.cross;

import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class CrossTest02 extends TestBaseCross {

    @Test
    public void test02() {
        extentTest=extentReports.createTest("2.Deneme Test");
        driver.get("https://techproeducation.com");
        extentTest.info("Techpro adresine gidildi");
        extentTest.pass("Test Passed 2");
    }
}

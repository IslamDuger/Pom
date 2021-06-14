package tests.examples;

import org.testng.annotations.Test;
import pages.TestAdressLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestAdresLoginPage {
    //creating page class
    TestAdressLoginPage testAdressLoginPage;

    @Test
    public void testAdressLoginPage() {

        Driver.getDriver().get(ConfigReader.getProperty("test_adress_url"));
        TestAdressLoginPage testAdressLoginPage = new TestAdressLoginPage();
    }
}
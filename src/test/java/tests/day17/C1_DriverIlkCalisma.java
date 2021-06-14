package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C1_DriverIlkCalisma {
    @Test
    public void test01(){
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
    }
}

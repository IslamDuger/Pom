package examples;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Ex01 {
    @Test
    public void firstDriverTest(){
       Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));





    }

}

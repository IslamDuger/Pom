package JSExectutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class JsExecutor_Test {
    JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();

    @Test
    public void scrollIntoViewTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        Thread.sleep(5000);
        je.executeScript("arguments[0].scrollIntoView(true);",koalaResortPage.recentBlog);
        Thread.sleep(3000);
        Assert.assertEquals(koalaResortPage.recentBlog.getText(),ConfigReader.getProperty("re_blok"));




        }
        @Test
        public void scrollIntoViewUtilities(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        ReusableMethods.jsExecuterAmazon(koalaResortPage.recentBlog);

        }

    @Test
    public void scrollWithCoordinates() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage1=new KoalaResortPage();
        je.executeScript("window.scrollBy(0,3500);");
        Thread.sleep(3000);
        Assert.assertEquals(koalaResortPage1.recentBlog.getText(),ConfigReader.getProperty("re_blok"));



    }

    @Test
    public void clickByJs(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        ReusableMethods.jsExecuterAmazon(koalaResortPage.checkAvailability);
        ReusableMethods.clickElementByJs(koalaResortPage.checkAvailability);

    }

}

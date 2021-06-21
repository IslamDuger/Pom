package examples;

import JSExectutor.JsExecutor_Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Ex9 {

    AmazonPage amazonPage=new AmazonPage();
    JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();

    @Test (groups = "smoke,regretion")
    public void test01(){

//➢ AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
//        hucredeki yaziyi getirecek bir method olusturun
//➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
//➢ Bu class'in altinda bir test method olusturun : hucretesti() ve webtable'da 3. satir
//        2.sutundaki yazinin "Home Services" yazisi icerdigini test edin
//➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
//        bulundugunu test edin

        amazonPage.getamazonPage();
        je.executeScript("arguments[0].scrollIntoView(true);",amazonPage.table);
        String accepthomeService=amazonPage.homeService.getText();
        String exceptedYazi= ConfigReader.getProperty("beklenenhucrebilgisi");

        System.out.println(accepthomeService);
       // Assert.assertEquals(accepthomeService,exceptedYazi);


        Assert.assertFalse(accepthomeService.contains(exceptedYazi));

    }
@Test (groups = "smoke")
    public void test02(){

        //Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
    ////  bulundugunu test edin
        amazonPage.getamazonPage();
        je.executeScript("arguments[0].scrollIntoView(true);",amazonPage.table);
    List<String>arananKelimeler=new ArrayList<>();

        for (WebElement each:amazonPage.tableTamami){
           if(each.getText().contains("Amazon")) {
               arananKelimeler.add(each.getText());
           }

                  }
        System.out.println(arananKelimeler);

        Assert.assertEquals(arananKelimeler.size(),9);





}

}

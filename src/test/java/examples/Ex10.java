package examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Ex10 extends TestBaseRapor {
    AmazonPage amazonPage=new AmazonPage();
    //     Soru 4 :
//D26_AmazonSatirSutunSayisi class'indan satirSayisi() testini ve
//D26_AmazonHucreTesti class'indan hucretesti() testini rapor alacak sekilde hazirlayin
// ve 3.sorudaki xml dosyasi ile calistirip raporu olusturun


    /*
// 1- Test class'ini extends ile TestBaseRapor Class'ina child yapalim
// 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
// 3- Gerekli/istedigimiz satirlara extentTest.info("Aciklama") ekleyelim
// 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
 */
        @Test

        public void  sutunSayisi(){
            //extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");
            extentTest=extentReports.createTest("Smoke","Methodlari yazdir");
            amazonPage.getamazonPage();
            extentTest.info("Amazon sayfasina basarili sekilde giris yapildi");
            amazonPage.altaGitTabloyuBul();
            extentTest.info("Amazon sayfasinadaki taloya basarili sekilde gidildi");
            int actualSutunSayisi= ReusableMethods.getElementsText(amazonPage.birinciSatirtumSutunSayilari).size();
            int expectedSutunSayisi=Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesutunsayisi"));

            Assert.assertEquals(actualSutunSayisi,expectedSutunSayisi);
            extentTest.pass("istenen sutun satilari ile beklenen sutun sayilari esit");
            //Assert.assertEquals(ReusableMethods.getElementsText(amazonPage.tumSutunSayilari).size(),Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesutunsayisi")));
            System.out.println("Tablodaki sutun sayilari========>"+actualSutunSayisi);
            System.out.println("Olmasi gereken sutun sayilari==========>"+expectedSutunSayisi);
        }




    }


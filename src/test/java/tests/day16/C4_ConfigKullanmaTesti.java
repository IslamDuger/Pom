package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C4_ConfigKullanmaTesti extends TestBase {
    /*
     1 ) Bir Class olustur : PositiveTest
     2) Bir test method olustur positiveLoginTest()
             http://qa-environment.koalaresorthotels.com adresine git
             login butonuna bas
         test data username: manager ,
         test data password : Manager1!
         Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
      */
    @Test
    public void test01(){
        //Kodumu tamamen dinamik yapmak icin 3 data ya ihtiyacim var.
        //1-locate===>Bunlari page clasindan obje ureterek alabilirim,
        //2-test datalari===>Bunlar icin obj olustirmama gerek yok.
        //Cunku configreader hersey static oldugu icin sadece class ismi ile herseye ulasabilirim.

        driver.get(ConfigReader.getProperty("kr_url"));
        KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);
        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortLoginPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortLoginPage.loginButonu.click();
    }


    }

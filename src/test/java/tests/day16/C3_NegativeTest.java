package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.TestBase;

public class C3_NegativeTest extends TestBase {

@Test
    public void negativeTest(){
//    1 ) Bir Class olustur : NegativeTest
//    2) Bir test method olustur NegativeLoginTest()
//    http://qa-environment.koalaresorthotels.com adresine git
    driver.get("http://qa-environment.koalaresorthotels.com");
    KoalaResortLoginPage koalaResortLoginPage=new KoalaResortLoginPage(driver);

//    login butonuna bas
       koalaResortLoginPage.ilkLoginLinki.click();
//    test data username: manager1 ,
    koalaResortLoginPage.kullaniciAdiTextBox.sendKeys("manager1");
//    test data password : manager1
    koalaResortLoginPage.passwordTexBox.sendKeys("manager1");
    koalaResortLoginPage.loginButonu.click();
//    Degerleri girildiginde sayfaya girilemedigini test et
}

}

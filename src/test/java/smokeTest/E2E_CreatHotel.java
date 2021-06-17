package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_CreatHotel {
    @Test
    public void createHotel() throws InterruptedException {
//        1. Tests packagenin altına class olusturun: D17_CreateHotel
//        2. Bir metod olusturun: createHotel
//        3. http://qa-environment.koalaresorthotels.com adresine git.
//        4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
//        girin.
//                a. Username : manager
//        b. Password : Manager2!
//                5. Login butonuna tıklayın.
//        6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
//        7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//        8. Save butonuna tıklayın.
//        9. "Hotel was inserted successfully" textinin göründüğünü test edin.
//        10. OK butonuna tıklayın.


        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        //      login butonuna bas
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        //test data username: manager ,
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        //test data password : Manager1!
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        koalaResortPage.loginButonu.click();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelList.click();
        koalaResortPage.addHotel.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        actions.click(koalaResortPage.codeTextBox)
                .sendKeys(ConfigReader.getProperty("kr_code"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_name"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_adress"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_phone"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_email"))
                .perform();
        Thread.sleep(5000);
        Select select=new Select(koalaResortPage.acilirMenu);
        select.selectByVisibleText(ConfigReader.getProperty("kr_dropdown_value"));
        //8. Save butonuna tıklayın.
        Thread.sleep(2000);
        koalaResortPage.saveButonu.click();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(2000);
        Assert.assertEquals(koalaResortPage.sonucYazisiElementi.getText(),ConfigReader.getProperty("kr_otel_olusturuldu_yazisi"));
        //10. OK butonuna tıklayın.
        koalaResortPage.sonOKButonu.click();
        Driver.closeDriver();
    }
}

